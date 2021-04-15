package com.promineotech.incidentReport.entity;

import java.util.Set;

//import javax.persistence.CascadeType;

//import java.util.List;

//import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
//import javax.persistence.Table;


@Entity
//@Table(name = "employees")
public class Employee {

	private Long id;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String deptName;
	//private Facility facilities;
	//private Incident incidents;
	private Set<Facility> facilities;
	private Set<Incident> incidents;
	
	
//	@ManyToMany(mappedBy = "facility")
//	private List<Facility> facilities;
//	@ManyToMany(mappedBy = "incident")
//	private List<Incident> incidents;
	
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
	//@ManyToMany (mappedBy = "facility")
//	@ManyToMany (cascade = CascadeType.ALL)
//	@JoinColumn(name = "facility_id")
	@OneToMany(mappedBy = "employee")
	public Set<Facility> getFacility() {
		return facilities;
	}
	public void setFacility(Set<Facility> facilities) {
		this.facilities = facilities;
	}
	//@ManyToMany (mappedBy = "incident")
//	@ManyToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "employee_id", referencedColumnName = "id")
	@OneToMany(mappedBy = "employee")
	public Set<Incident> getIncidents() {
		return incidents;
	}
	public void setIncidents(Set<Incident> incidents) {
		this.incidents = incidents;
	}
	
//	@OneToMany(mappedBy = "employee")
//	public Set<Facility> getFacilities() {
//		return facilities;
//	}
//	public void setFacilities(Set<Facility> facilities) {
//		this.facilities = facilities;
//	}
//	
//	@OneToMany(mappedBy = "employee")
//	public Set<Incident> getIncidents() {
//		return incidents;
//	}
//	public void setIncidents(Set<Incident> incidents) {
//		this.incidents = incidents;
//	}
	
	
}
