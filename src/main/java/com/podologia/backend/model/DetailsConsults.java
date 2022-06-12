package com.podologia.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.ForeignKey;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

@Data
@Entity
@Table(name="details_consults")
public class DetailsConsults {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idDetails;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="idConsult", nullable = false, foreignKey = @ForeignKey(name="FK_consults_details"))
	private Consultations consults;
	
	@Column(name="diagnostic", nullable = false,  length = 80)
	private String diagnostic;
	
	@Column(name= "treatment" , nullable= false, length = 80)
	private String treatment;

}
