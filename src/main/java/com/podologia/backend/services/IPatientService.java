package com.podologia.backend.services;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.podologia.backend.model.Patient;

public interface IPatientService extends ICRUD<Patient> {
	
	Page<Patient> listarPatient(Pageable pag);

}
