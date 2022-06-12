package com.podologia.backend.dao;

import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import com.podologia.backend.model.Menu;

public interface IMenuDao extends JpaRepositoryImplementation<Menu, Integer>{

}
