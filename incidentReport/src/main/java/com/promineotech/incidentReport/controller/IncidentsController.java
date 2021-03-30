package com.promineotech.incidentReport.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.incidentReport.entity.Incidents;
import com.promineotech.incidentReport.service.IncidentsService;

@RestController
@RequestMapping("/incidents")
public class IncidentsController {
	
	@Autowired
	private IncidentsService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Object> getIncidents(@PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.getIncidentsById(id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity<Object> getIncidents() {
		return new ResponseEntity<Object>(service.getIncidents(), HttpStatus.OK);
	}
	
	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Object> createIncidents(@RequestBody Incidents incidents) {
		return new ResponseEntity<Object>(service.createIncidents(incidents), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateIncidents(@RequestBody Incidents incidents, @PathVariable Long id) {
		try {
			return new ResponseEntity<Object>(service.updateIncidents(incidents, id), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(value="{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteIncidents(@PathVariable Long id) {
		try {
			service.deleteIncident(id);
			return new ResponseEntity<Object>("Successfully deleted Incident with id: " + id, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Object>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}

}
