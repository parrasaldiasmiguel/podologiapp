package com.podologia.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.podologia.backend.model.Patient;
import com.podologia.backend.services.IPatientService;
import com.podologia.backend.util.Constants;

@RestController
@RequestMapping(Constants.ENDPOINT_PATIENT)
@CrossOrigin
public class PatientController {

	 @Autowired 
	 private IPatientService patientService;
	
	 @GetMapping
	 public ResponseEntity<List<Patient>> listarPatient(){
		 List<Patient> list = patientService.listar();
		 return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	 }
}
