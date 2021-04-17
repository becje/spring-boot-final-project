package com.promineotech.incidentReport.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.incidentReport.entity.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long>{

	public Employee findByUsername (String username);
}
