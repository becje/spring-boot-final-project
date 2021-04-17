package com.promineotech.incidentReport.service;

import javax.naming.AuthenticationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.bcrypt.BCrypt;

import com.promineotech.incidentReport.entity.Employee;
import com.promineotech.incidentReport.repository.EmployeeRepository;

public class AuthService {

	private EmployeeRepository employeeRepository;
	
	public Employee register(Employee cred) throws AuthenticationException {
		Employee employee = new Employee();
		employee.setUsername(cred.getUsername());
		employee.setHash(BCrypt.hashpw(cred.getPassword(), BCrypt.gensalt()));
		try {
			employeeRepository.save(employee);
			return employee;
		} catch (DataIntegrityViolationException e) {
			throw new AuthenticationException("Username not available.");
		}
	}
	
	public Employee login(Employee cred) throws AuthenticationException{
		Employee foundEmp = employeeRepository.findByUsername(cred.getUsername());
		if (foundEmp != null && BCrypt.checkpw(cred.getPassword(), foundEmp.getHash())) {
			return foundEmp;
		}
		throw new AuthenticationException ("Incorrect username or password");
	}
}