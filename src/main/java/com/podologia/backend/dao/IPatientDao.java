package com.podologia.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.podologia.backend.model.Patient;

public interface IPatientDao extends JpaRepository<Patient, Integer> {

}
