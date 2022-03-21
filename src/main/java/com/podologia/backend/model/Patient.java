package com.podologia.backend.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Information to the patient")
@Entity
@Table(name="patient")
public class Patient {
	
	@Id
	private Integer idPatient;
	
	@ApiModelProperty(notes = "Names must be a min 3 char")
	@Column(name="names", nullable=false, length=70)
	private String names;
	
	
	@ApiModelProperty(notes = "RUT  must be  8 char")
	@Size(min = 8, max = 8, message = "RUT  must be  8 char")
	@Column(name = "dni", nullable = false, length = 8)
	private String rut;
	
	@ApiModelProperty(notes = "Surname must be a min 3 char")
	@Size(min=3, max=70, message="surnames must be between 3 and 70")
	@Column(name="surnames", nullable= false, length=70)
	private String surnames;
	
	@ApiModelProperty(notes = "Residency must be min to 3 char")
	@Size(min = 3, max = 150, message = "Dirección debe tener minimo 3 caracteres")
	private String residency;
	
	private LocalDateTime birthDay;
	@ApiModelProperty(notes = "phone must be 9 char")
	@Size(min = 9, max = 9, message = "phone must be 9 char")
	private String phone;
	
	public Integer getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(Integer idPatient) {
		this.idPatient = idPatient;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getSurnames() {
		return surnames;
	}

	public void setSurnames(String surnames) {
		this.surnames = surnames;
	}

	public String getResidency() {
		return residency;
	}

	public void setResidency(String residency) {
		this.residency = residency;
	}

	public LocalDateTime getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(LocalDateTime birthDay) {
		this.birthDay = birthDay;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}

	@Email
	@Column(name="email",nullable=true, length=50)
	private String email;
	
	@Column(name="activity", nullable=true)
	private String activity;
}

