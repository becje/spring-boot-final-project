package com.promineotech.incidentReport.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.incidentReport.entity.Employees;
import com.promineotech.incidentReport.repository.EmployeesRepository;

@Service
public class EmployeesService {
	
	private static final Logger logger = LogManager.getLogger(EmployeesService.class);
	
	@Autowired
	private EmployeesRepository repo;
	
	public Employees getEmployeesById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve employee: " + id, e);
			throw e;
		}
	}
	
	public Iterable <Employees> getEmployee() {
		return repo.findAll();
	}
	
	public Employees createEmployee(Employees employee) {
		return repo.save(employee);
	}
	
	public Employees updateEmployee(Employees employee, Long id) throws Exception {
		try {
			Employees addEmployee = repo.findOne(id);
			addEmployee.setUsername(employee.getUsername());
			addEmployee.setPassword(employee.getPassword());
			addEmployee.setFirstName(employee.getFirstName());
			addEmployee.setLast_name(employee.getLastName());
			addEmployee.setLast_name(employee.getDeptName());
			return repo.save(addEmployee);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update employees: " + id, e);
			throw new Exception("unable to update employee.");
		}
	}
	
	public void deleteEmployee(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete employees: " + id, e);
			throw new Exception("unable to delete employee.");
		}
	}

	
}
