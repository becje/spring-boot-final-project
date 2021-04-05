package com.promineotech.incidentReport.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.incidentReport.entity.Incidents;
import com.promineotech.incidentReport.repository.IncidentsRepository;

@Service
public class IncidentsService {
	
	private static final Logger logger = (Logger) LogManager.getLogger(IncidentsService.class);
	
	@Autowired
	private IncidentsRepository repo;
	
	public Incidents getIncidentsById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to retrieve incident: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Incidents> getIncidents() {
		return repo.findAll();
	}
	
	public Incidents createIncidents(Incidents incidents) {
		return repo.save(incidents);
	}
	
	public Incidents updateIncidents(Incidents incidents, Long id) throws Exception {
		try {
			Incidents newIncident = repo.findOne(id);
			newIncident.setIncidentDate(incidents.getIncidentDate());
			newIncident.setIncidentTime(incidents.getIncidentTime());
			newIncident.setIncidentLocation(incidents.getIncidentLocation());
			newIncident.setIncidentDescription(incidents.getIncidentDescription());
			newIncident.setInjuryIllnessDescription(incidents.getInjuryIllnessDescription());
//			newIncident.setIncidentCategory(incidents.getIncidentCategory());
			return repo.save(newIncident);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update incident: " + id, e);
			throw new Exception("Unable to update incident.");
		}
	}
	
	public void deleteIncident(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete incident: " + id, e);
			throw new Exception("unable to delete incident.");
		}
	}
	

}
