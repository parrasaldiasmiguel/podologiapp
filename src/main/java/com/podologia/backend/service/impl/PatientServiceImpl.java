package com.podologia.backend.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.podologia.backend.dao.IPatientDao;
import com.podologia.backend.model.Patient;
import com.podologia.backend.services.IPatientService;

@Service
public class PatientServiceImpl implements IPatientService{

	@Autowired
	private IPatientDao dao;

	@Override
	public Patient add(Patient pac) {
		return dao.save(pac);
	}

	@Override
	public Patient update(Patient pac) {
		return dao.save(pac);
	}

	@Override
	public List<Patient> listar() {
		return dao.findAll();
	}


	@Override
	public Page<Patient> listarPatient(Pageable pag) {
		return dao.findAll(pag);
	}

	@Override
	public Patient readtoId(Integer id) {
		Optional<Patient> pac = dao.findById(id);
		
		return pac.isPresent() ? pac.get():new Patient();
	}

	@Override
	public boolean delete(Integer id) {
		dao.deleteById(id);
		return true;
	}
	
	
}
