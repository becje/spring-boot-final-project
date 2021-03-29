package com.promineotech.incidentReport.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.incidentReport.entity.Employees;

public interface EmployeesRepository extends CrudRepository<Employees, Long> {

}
