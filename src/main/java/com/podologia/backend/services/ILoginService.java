package com.podologia.backend.services;

import com.podologia.backend.model.Users;

public interface ILoginService {

	Users verifyrUser(String usuario) throws Exception;
	int changePassword(String password, String nombre) throws Exception;
}
