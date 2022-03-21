package com.podologia.backend.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class Users {
	
	@Id
	private Integer idUser;

	@Column(name = "alias", nullable =false, unique= true)
	private String alias;
	
	@Column(name= "clave", nullable=false)
	private String pwd;
	
	@Column(name="status", nullable=false)
	private String status;

	public Integer getIdUser() {
		return idUser;
	}

	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}

	public String getName() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
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
	
	
	
}
