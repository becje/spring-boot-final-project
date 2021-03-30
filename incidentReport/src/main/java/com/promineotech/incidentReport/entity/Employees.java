package com.promineotech.incidentReport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Employees {
	
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String deptName;
	
	@JsonIgnore
	private Facility facility;
	private Incidents incidents;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLast_name(String lastName) {
		this.lastName = lastName;
	}
	public String getDeptName() {
		return deptName;
	}
	public void setDept_name(String deptName) {
		this.deptName = deptName;
	}
	
	public Facility getFacility() {
		return facility;
	}
	
	public void setFacility(Facility facility) {
		this.facility = facility;
	}
	
	public Incidents getIncidents() {
		return incidents;
	}
	
	public void setIncidents(Incidents incidents) {
		this.incidents = incidents;
	}
	
	

}
