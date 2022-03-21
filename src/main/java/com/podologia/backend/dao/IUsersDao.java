package com.podologia.backend.dao;

import org.springframework.data.repository.CrudRepository;

import com.podologia.backend.model.Users;

public interface IUsersDao extends CrudRepository<Users, Integer> {

}
