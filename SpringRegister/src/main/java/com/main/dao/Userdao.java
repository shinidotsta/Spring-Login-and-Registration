package com.main.dao;

import com.main.model.Login;
import com.main.model.User;

public interface Userdao 
{
public void Register(User user);

public User ValidateUser(Login login);

}
