package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sun.istack.NotNull;

@Entity
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String deptName;
	
	@JsonIgnore
	private Set<Facility> facilities;
	
	@JsonIgnore
	private Set<Incident> incidents;
	
	@JsonIgnore
	private String hash;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
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
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Column(unique = true)
	@NotNull
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
	public String getDeptName() {
		return deptName;
	}
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "emp_facility", 
	joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "facilityId", referencedColumnName = "id"))
	public Set<Facility> getFacilities() {
		return facilities;
	}
	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}
	
	@ManyToMany(cascade= CascadeType.ALL)
	@JoinTable(name = "emp_incident", 
	joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"),
	inverseJoinColumns = @JoinColumn(name = "incidentId", referencedColumnName = "id"))
	public Set<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(Set<Incident> incidents) {
		this.incidents = incidents;
	}
	public String getHash() {
		return hash;
	}
	public void setHash(String hash) {
		this.hash = hash;
	}
	
	
}
