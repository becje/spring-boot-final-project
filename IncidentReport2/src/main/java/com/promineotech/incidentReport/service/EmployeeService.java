package com.promineotech.incidentReport.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.incidentReport.entity.Employee;
import com.promineotech.incidentReport.repository.EmployeeRepository;


@Service
public class EmployeeService {
	public static final Logger logger = (Logger) LogManager.getLogger(EmployeeService.class);

	@Autowired
	private EmployeeRepository repo;
	
	public Employee getEmployeeById(Long id) throws Exception{
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve employee: " + id, e);
			throw e;
		} 
	} 
	
	public Iterable<Employee> getEmployees(){
		return repo.findAll();
	}
	
	public Employee createEmployee(Employee employee) {
		return repo.save(employee);
	}
	
	public Employee login(Employee employee) throws Exception {
		Employee employeeLogin = repo.findByUsername(employee.getUsername());
		if(employeeLogin != null && employeeLogin.getPassword().equals(employee.getPassword())) {
			return employeeLogin;
		} else {
			throw new Exception("Invalid username or password.");
		}
	}
	
	public Employee updateEmployee(Employee employee, Long id) throws Exception {
		try {
			Employee addEmployee = repo.findOne(id);
			addEmployee.setUsername(employee.getUsername());
			addEmployee.setPassword(employee.getPassword());
			addEmployee.setFirstName(employee.getFirstName());
			addEmployee.setLastName(employee.getLastName());
			addEmployee.setDeptName(employee.getDeptName());
			return repo.save(addEmployee);
		} catch (Exception e) {
			logger.error("Exception occured while trying to add employee: " +id, e);
			throw new Exception("Unable to add employoee.");
		}
	}
	
	public void deleteEmployee(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occured while trying to delete employee: " + id, e);
			throw new Exception("Unable to delete.");
		}
	}
	
}
