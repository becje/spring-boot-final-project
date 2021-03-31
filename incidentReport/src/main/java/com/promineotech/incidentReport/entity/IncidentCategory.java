package com.promineotech.incidentReport.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class IncidentCategory {
	
	private Long id;
	private String observation;
	private String nearMiss;
	private String firstAid;
	private String medicalTreatment;
	private String illness;
	private String hospital24Hrs;
	private String amputation;
	private String eyeLoss;
	private String Death;
	
	@JsonIgnore
	private Incidents incidents;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@OneToOne(mappedBy = "Incidents")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getObservation() {
		return observation;
	}
	public void setObservation(String observation) {
		this.observation = observation;
	}
	public String getNearMiss() {
		return nearMiss;
	}
	public void setNearMiss(String nearMiss) {
		this.nearMiss = nearMiss;
	}
	public String getFirstAid() {
		return firstAid;
	}
	public void setFirstAid(String firstAid) {
		this.firstAid = firstAid;
	}
	public String getMedicalTreatment() {
		return medicalTreatment;
	}
	public void setMedicalTreatment(String medicalTreatment) {
		this.medicalTreatment = medicalTreatment;
	}
	public String getIllness() {
		return illness;
	}
	public void setIllness(String illness) {
		this.illness = illness;
	}
	public String getHospital24Hrs() {
		return hospital24Hrs;
	}
	public void setHospital24Hrs(String hospital24Hrs) {
		this.hospital24Hrs = hospital24Hrs;
	}
	public String getAmputation() {
		return amputation;
	}
	public void setAmputation(String amputation) {
		this.amputation = amputation;
	}
	public String getEyeLoss() {
		return eyeLoss;
	}
	public void setEyeLoss(String eyeLoss) {
		this.eyeLoss = eyeLoss;
	}
	public String getDeath() {
		return Death;
	}
	public void setDeath(String death) {
		Death = death;
	}
	public Incidents getIncidents() {
		return incidents;
	}
	public void setIncidents(Incidents incidents) {
		this.incidents = incidents;
	}

}
