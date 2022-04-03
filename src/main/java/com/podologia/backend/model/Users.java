package com.podologia.backend.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idUser;

	@Column(name = "alias", nullable =false, unique= true)
	private String alias;
	
	@Column(name= "clave", nullable=false)
	private String pwd;
	
	@Column(name="status", nullable=false)
	private String status;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_rol", joinColumns= @JoinColumn (name= "id_usuario",referencedColumnName="idUser"),
	inverseJoinColumns =  @JoinColumn(name="id_rol", referencedColumnName ="idRol"))
	private List<Rol> roles;
	
	
}
