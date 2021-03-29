package com.promineotech.incidentReport.entity;

import java.sql.Time;
import java.util.Date;

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
	private Long emplId;
	private Long incidentCategory;
	private Date incidentDate;
	private Time incidentTime;
	private String incidentLocation;
	private String incidentDescription;
	private String injuryIllnessDescription;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@OneToMany(mappedBy = "employees")
	public Long getEmplId() {
		return emplId;
	}
	public void setEmplId(Long emplId) {
		this.emplId = emplId;
	}
	public Long getIncidentCategory() {
		return incidentCategory;
	}
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "incidentCategory_id")
	public void setIncidentCategory(Long incidentCategory) {
		this.incidentCategory = incidentCategory;
	}
	public Date getIncidentDate() {
		return incidentDate;
	}
	public void setIncidentDate(Date incidentDate) {
		this.incidentDate = incidentDate;
	}
	public Time getIncidentTime() {
		return incidentTime;
	}
	public void setIncidentTime(Time incidentTime) {
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

	

}
