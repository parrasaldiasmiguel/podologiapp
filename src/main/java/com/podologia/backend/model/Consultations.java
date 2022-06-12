package com.podologia.backend.model;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="consults")
public class Consultations {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idConsult;
	
	@ManyToOne
	@JoinColumn(name="id_Patient", nullable = false, foreignKey = @ForeignKey(name="FK_consulta_paciente"))
	private Patient patient;
	
	@ManyToOne
	@JoinColumn(name="idSpecialty", nullable =false, foreignKey = @ForeignKey(name="FK_consults_specialist"))
	private Specialty specialities;
	
	
	
}
