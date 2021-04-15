package com.promineotech.incidentReport.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
//import javax.persistence.ManyToMany;
//import javax.persistence.Table;
//import javax.persistence.ManyToOne;
//import javax.persistence.OneToMany;
//
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
//@Table(name = "facilities")
public class Facility {

	private Long id;
	private String name;
	private String address;
	private String state;
	private String city; 
	private String zip;
	
//	@ManyToMany
//	private List<Employee> employee;
	
	@JsonIgnore
	private Employee employee;
	
//	@ManyToMany
//	private Employee employees;
	
	//private Set<EmployeeAtFacility> employeeAtFacilities;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	@ManyToOne
	@JoinColumn(name = "employeeId")
	public Employee getEmployee() {
		return employee;
	}
	public void setEmployee(Employee employees) {
		this.employee = employees;
	}
	
//	@OneToMany(mappedBy = "EmployeeAtFacility")
//	public Set<EmployeeAtFacility> getEmployeeAtFacilities() {
//		return employeeAtFacilities;
//	}
//	public void setEmployeeAtFacilities(Set<EmployeeAtFacility> employeeAtFacilities) {
//		this.employeeAtFacilities = employeeAtFacilities;
//	}
}
