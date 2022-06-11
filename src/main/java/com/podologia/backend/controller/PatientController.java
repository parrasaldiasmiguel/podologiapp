package com.podologia.backend.controller;

import java.net.URI;
import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.podologia.backend.exception.ExceptionResponse;
import com.podologia.backend.exception.ModelExceptionHandler;
import com.podologia.backend.model.Patient;
import com.podologia.backend.services.IPatientService;
import com.podologia.backend.util.Constants;

@RestController
@RequestMapping(Constants.ENDPOINT_PATIENT)
//@CrossOrigin
public class PatientController {

	 @Autowired 
	 private IPatientService patientService;
	
	 @GetMapping
	 public ResponseEntity<List<Patient>> listPatient(){
		 List<Patient> list = patientService.listar();
		 return new ResponseEntity<List<Patient>>(list,HttpStatus.OK);
	 }
	 
	 @GetMapping("/{id}")
	 public ResponseEntity<Patient> listById(@PathVariable("id") Integer id){
		 Patient pat = patientService.readtoId(id);
		 System.out.print(pat);
		 if(!(pat.getIdPatient() != null)) {
			 throw new ModelExceptionHandler("Id not found" + id);
		 }
		 return new ResponseEntity<Patient>(pat, HttpStatus.OK);
	 }
	 
	 @PostMapping
	 public ResponseEntity<Patient> registerPatient (@Valid @RequestBody Patient pat){
		Patient obj = patientService.add(pat);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").
				 buildAndExpand(obj.getIdPatient()).toUri();
		ResponseEntity.created(location).build();	 
		 return new ResponseEntity<Patient>(HttpStatus.OK);
	 }
	 
	@PutMapping("/{id}")
	 public ResponseEntity<Patient> updatePatient(@PathVariable("id")Integer id ,@Valid @RequestBody Patient pat){
		 Patient actualPat = patientService.readtoId(id); 
		 if (actualPat.getIdPatient() == null){
			throw new ModelExceptionHandler("Patient not found: " + id);
		 }
		 patientService.update(actualPat);
		 return  new ResponseEntity<Patient>(actualPat, HttpStatus.CREATED);
	 }
	 
	 @DeleteMapping("/{id}")
	 public ResponseEntity<Object> delete(@PathVariable("id") Integer id){
		 Patient pat = patientService.readtoId(id);
		 if (pat.getIdPatient() == null) {
			 throw new ModelExceptionHandler("Id not found " + id);
		 }
		 patientService.delete(id);
		 return new ResponseEntity<Object>(HttpStatus.OK);		 
	 }
}
