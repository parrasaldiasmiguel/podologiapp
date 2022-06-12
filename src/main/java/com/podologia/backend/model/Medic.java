package com.podologia.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "especialist")
public class Medic {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer specialistId;
	
	@Column(name ="fullname", nullable = false, length = 120)
	private String fullname;
	
	@Column(name="credencial", nullable=false ,length = 15)
	private String credencials;
	
	@Column(name="photo_url", nullable = true)
	private String photoUrl;
	
}
