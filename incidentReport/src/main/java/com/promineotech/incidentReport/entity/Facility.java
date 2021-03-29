package com.promineotech.incidentReport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

//import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Facility {
	
	private Long id;
	private Long EmplId;
	private String facilityName;
	private String facilityAddress1;
	private String facilityAddress2;
	private String facilityCity;
	private String facilityState;
	private String facilityZip;
	
	
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
		return EmplId;
	}
	public void setEmplId(Long emplId) {
		EmplId = emplId;
	}
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityAddress1() {
		return facilityAddress1;
	}
	public void setFacilityAddress1(String facilityAddress1) {
		this.facilityAddress1 = facilityAddress1;
	}
	public String getFacilityAddress2() {
		return facilityAddress2;
	}
	public void setFacilityAddress2(String facilityAddress2) {
		this.facilityAddress2 = facilityAddress2;
	}
	public String getFacilityCity() {
		return facilityCity;
	}
	public void setFacilityCity(String facilityCity) {
		this.facilityCity = facilityCity;
	}
	public String getFacilityState() {
		return facilityState;
	}
	public void setFacilityState(String facilityState) {
		this.facilityState = facilityState;
	}
	public String getFacilityZip() {
		return facilityZip;
	}
	public void setFacilityZip(String facilityZip) {
		this.facilityZip = facilityZip;
	}
	

}
