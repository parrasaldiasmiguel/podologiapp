package com.podologia.backend.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.podologia.backend.model.Users;

public interface ILoginDao extends JpaRepository<Users, Integer> {
	
	@Query("FROM Users us where us.username = :usuario")
	Users verifyUser(@Param("usuario") String usuario) throws Exception;
	//Usuario findOneByUsername(String usuario)
	
	@Transactional
	@Modifying
	@Query("UPDATE Users us SET us.pwd = :clave WHERE us.username = :nombre")
	void changePassword(@Param("clave") String clave, @Param("nombre") String nombre) throws Exception;
}
