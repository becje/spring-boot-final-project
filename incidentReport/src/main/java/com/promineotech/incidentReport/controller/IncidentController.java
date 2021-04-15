package com.promineotech.incidentReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.incidentReport.entity.Incident;
import com.promineotech.incidentReport.service.IncidentService;

@RestController
@RequestMapping("/incidents")
public class IncidentController {

	@Autowired
	private IncidentService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getIncident(@PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.getIncidentById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getIncidents(){
		return new ResponseEntity<Object>(service.getIncident(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createIncident(@RequestBody Incident incident){
		return new ResponseEntity<Object>(service.createIncident(incident), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateIncident(@RequestBody Incident incident, @PathVariable Long id){
		try {
			return new ResponseEntity<Object>(service.updateIncident(incident, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteIncident(@PathVariable Long id){
		try {
			service.deleteIncident(id);
			return new ResponseEntity<Object>("Successfully deleted incident with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
