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

import lombok.Data;

@Entity
@Table(name="users")
public class Users {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer idUser;

	@Column(name = "username", nullable =false, unique= true)
	private String username;
	
	@Column(name= "pwd", nullable=false)
	private String pwd;
	
	@Column(name="status", nullable=false)
	private String status;

	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="usuario_rol", joinColumns= @JoinColumn (name= "id_usuario",referencedColumnName="idUser"),
	inverseJoinColumns =  @JoinColumn(name="id_rol", referencedColumnName ="idRol"))
	private List<Rol> roles;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}


	
	
	
	
}
