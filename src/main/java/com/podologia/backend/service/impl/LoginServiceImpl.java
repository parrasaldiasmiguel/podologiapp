package com.podologia.backend.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.podologia.backend.dao.ILoginDao;
import com.podologia.backend.model.Users;
import com.podologia.backend.services.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {

	@Autowired
	private ILoginDao repo;

	@Override
	public Users verifyrUser(String usuario) throws Exception {
		Users user = null;
		try {
			user = repo.verifyUser(usuario);
			user = user != null ? user : new Users();
		} catch (Exception e) {

		}
		return user;
	}

	@Override
	public int changePassword(String password, String nombre) throws Exception {
		int response = 0;

		try {
			repo.changePassword(password, nombre);
			response++;

		} catch (Exception ex) {
			response = 0;
		}

		return response;
	}
	

}
