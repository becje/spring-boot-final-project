package com.promineotech.incidentReport.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.incidentReport.entity.Incident;

public interface IncidentRepository extends CrudRepository<Incident, Long>{

}
