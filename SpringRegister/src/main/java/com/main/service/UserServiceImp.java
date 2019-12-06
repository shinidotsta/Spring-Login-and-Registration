package com.main.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.dao.Userdao;
import com.main.model.Login;
import com.main.model.User;

public class UserServiceImp  implements UserService
{
@Autowired
Userdao userDao;

	public void Register(User user)
	{
		userDao.Register(user);	
	}

	public User ValidateUser(Login login)
	{
		
		return userDao.ValidateUser(login);
	}



	
}
