package com.podologia.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.podologia.backend.model.Users;

public interface IUsersDao extends JpaRepository<Users, Integer> {

}
