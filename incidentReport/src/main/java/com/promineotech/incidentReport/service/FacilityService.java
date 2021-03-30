package com.promineotech.incidentReport.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.incidentReport.entity.Facility;
import com.promineotech.incidentReport.repository.FacilityRepository;

@Service
public class FacilityService {
	
	private static final Logger logger = (Logger) LogManager.getLogger(FacilityService.class);
	
	@Autowired
	private FacilityRepository repo;
	
	public Facility getFacilityById(Long id) throws Exception {
		try {
			return repo.findOne(id);
		} catch (Exception e) {
			logger.error("Exceptioin occurred while trying to retrieve Facility: " + id, e);
			throw e;
		}
	}
	
	public Iterable<Facility> getFacility() {
		return repo.findAll();
	}
	
	public Facility createFacility(Facility facility) {
		return repo.save(facility);
	}
	
	public Facility updateFacility(Facility facility, Long id) throws Exception {
		try {
			Facility newFacility = repo.findOne(id);
			newFacility.setFacilityName(facility.getFacilityName());
			newFacility.setFacilityAddress(facility.getFacilityAddress());
			newFacility.setFacilityCity(facility.getFacilityCity());
			newFacility.setFacilityState(facility.getFacilityState());
			newFacility.setFacilityZip(facility.getFacilityZip());
			return repo.save(newFacility);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to update Facility: " + id, e);
			throw new Exception("Unable to update Facility.");
		}
	}
	
	public void deleteFacility(Long id) throws Exception {
		try {
			repo.delete(id);
		} catch (Exception e) {
			logger.error("Exception occurred while trying to delete Facility: " + id, e);
			throw new Exception("unable to delte Facility.");
		}
	}

}
