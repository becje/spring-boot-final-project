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
	private String facilityName;
	private String facilityAddress;
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
	public String getFacilityName() {
		return facilityName;
	}
	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getFacilityAddress() {
		return facilityAddress;
	}
	public void setFacilityAddress(String facilityAddress) {
		this.facilityAddress = facilityAddress;
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
