package com.main.service;

import com.main.model.Login;
import com.main.model.User;

public interface UserService 
{
    void Register(User user);

	User ValidateUser(Login login);
   
}
