package com.podologia.backend.services;

import java.util.List;

public interface ICRUD<T>  {

	T add(T obj);
	T update (T obj);
	List<T> listar();
	T readtoId(Integer id);
	boolean delete (T obj);
}
