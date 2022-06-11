package com.podologia.backend.services;

import java.util.List;

import com.podologia.backend.model.Patient;


public interface ICRUD<T>  {

	T add(T obj);
	T update (T obj);
	List<T> listar();
	T readtoId(Integer id);
	boolean delete (Integer id);

}
