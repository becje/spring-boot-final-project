package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Incidents {
	
	private Long id;
	private String incidentDate;
	private String incidentTime;  
	private String incidentLocation;
	private String incidentDescription;
	private String injuryIllnessDescription;
	private Set<IncidentCategory> incidentCategory;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(String incidentDate) {
		this.incidentDate = incidentDate;
	}
	public String getIncidentTime() {
		return incidentTime;
	}
	public void setIncidentTime(String incidentTime) {
		this.incidentTime = incidentTime;
	}
	public String getIncidentLocation() {
		return incidentLocation;
	}
	public void setIncidentLocation(String incidentLocation) {
		this.incidentLocation = incidentLocation;
	}
	public String getIncidentDescription() {
		return incidentDescription;
	}
	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}
	public String getInjuryIllnessDescription() {
		return injuryIllnessDescription;
	}
	public void setInjuryIllnessDescription(String injuryIllnessDescription) {
		this.injuryIllnessDescription = injuryIllnessDescription;
	}
	@OneToOne(mappedBy = "IncidentCategory")
	public Set<IncidentCategory> getIncidentCategory() {
		return incidentCategory;
	}
	public void setIncidentCategory(Set<IncidentCategory> incidentCategory) {
		this.incidentCategory = incidentCategory;
	}
}
