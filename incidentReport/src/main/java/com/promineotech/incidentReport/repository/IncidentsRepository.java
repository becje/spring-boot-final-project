package com.promineotech.incidentReport.repository;

import org.springframework.data.repository.CrudRepository;

import com.promineotech.incidentReport.entity.Incidents;

public interface IncidentsRepository extends CrudRepository<Incidents, Long>{

}
