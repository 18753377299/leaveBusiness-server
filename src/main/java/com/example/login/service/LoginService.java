package com.example.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.login.dao.LoginDao;

@Service
public class LoginService {
	
	@Autowired
	LoginDao loginDao;
	
	public boolean selectByUserAndPass(String username,String password) {
		boolean isSuccess = loginDao.selectByUserAndPass(username, password);
		return isSuccess;
	}
	
}
