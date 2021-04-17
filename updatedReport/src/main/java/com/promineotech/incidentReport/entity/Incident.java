package com.promineotech.incidentReport.entity;


import javax.persistence.Column;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Incident {

	private Long id;
	private String date;
	private String time;
	private String location;
	private String incidentDescription;
	private String injuryDescription;
	
	private IncidentCategory incidentCategory;

//	@JsonIgnore
	private Set<Employee> employees;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getIncidentDescription() {
		return incidentDescription;
	}
	public void setIncidentDescription(String incidentDescription) {
		this.incidentDescription = incidentDescription;
	}
	public String getInjuryDescription() {
		return injuryDescription;
	}
	public void setInjuryDescription(String injuryDescription) {
		this.injuryDescription = injuryDescription;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	@ManyToMany(mappedBy = "incidents")
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name= "incidentCategory_id", referencedColumnName= "id")
	public IncidentCategory getIncidentCategory() {
		return incidentCategory;
	}
	public void setIncidentCategory(IncidentCategory incidentCategory) {
		this.incidentCategory = incidentCategory;
	}
	

}
