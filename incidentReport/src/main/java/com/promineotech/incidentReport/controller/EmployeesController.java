package com.promineotech.incidentReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.incidentReport.entity.Employees;
import com.promineotech.incidentReport.service.EmployeesService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {
	
	@Autowired
	private EmployeesService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployee(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getEmployeesById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getEmployee() {
		return new ResponseEntity<Object>(service.getEmployee(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createEmployee(@RequestBody Employees employee) {
		return new ResponseEntity<Object>(service.createEmployee(employee), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateEmployee(@RequestBody Employees employee, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateEmployee(employee, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteEmployee(@PathVariable Long id) {
		try {
			service.deleteEmployee(id);
			return new ResponseEntity<Object>("Successfully deleted employee with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
