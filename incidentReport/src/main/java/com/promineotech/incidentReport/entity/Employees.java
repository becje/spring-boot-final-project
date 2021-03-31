package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Employees {
	
	private Long id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String deptName;
	private Set<Facility> facilities;
	private Set<Incidents> incidents;
	
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
	@OneToMany(mappedBy = "employee")
	public Set<Facility> getFacility() {
		return facilities;
	}
	public void setIncidentCategory(Set<Facility> facilities) {
		this.facilities = facilities;
	}
	@OneToMany(mappedBy = "employee")
	public Set<Incidents> getIncidents() {
		return incidents;
	}
	public void setIncidents(Set<Incidents> incidents) {
		this.incidents = incidents;
	}

}
