package com.promineotech.incidentReport.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;


@Entity
//@Table(name = "employees")
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String deptName;
	
	@JsonIgnore
	private Set<Incident> incidents;
	
	@JsonIgnore
	private Set<Facility> facilities;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	//@Column(name = "id")
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "emp_facility",
			joinColumns = @JoinColumn(name = "employeeId", referencedColumnName = "id"),
			inverseJoinColumns = @JoinColumn(name = "facilityId", referencedColumnName = "id"))
	
	public Set<Facility> getFacilities() {
		return facilities;
	}
	public void setFacilities(Set<Facility> facilities) {
		this.facilities = facilities;
	}	
	@OneToMany (mappedBy= "employee")
	public Set<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(Set<Incident> incidents) {
		this.incidents = incidents;
	}
	
}
