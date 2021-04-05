package com.promineotech.incidentReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.incidentReport.entity.Facility;
import com.promineotech.incidentReport.service.FacilityService;

@RestController
@RequestMapping("/facilities")
public class FacilityController {

	@Autowired
	private FacilityService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getFacility(@PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.getFacilityById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getFacilities(){
		return new ResponseEntity<Object>(service.getFacilities(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createFacility(@RequestBody Facility facility){
		return new ResponseEntity<Object>(service.createFacility(facility), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateFacility(@RequestBody Facility facility, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateFacility(facility, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteFacility(@PathVariable Long id){
		try {
			service.deleteFacility(id);
			return new ResponseEntity<Object>("Successfully deleted facility by id; " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
