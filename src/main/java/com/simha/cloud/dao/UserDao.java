package com.simha.cloud.dao;

import java.util.List;

import com.simha.cloud.model.UserRegister;

public interface UserDao
{
	void save(UserRegister u);
	void updateUser(UserRegister userRegister);
	List<UserRegister> findAll();
	UserRegister findById(int id);
	UserRegister deleteById(int id);
	public void updateUserById(int id);
	public void changeUser(UserRegister userRegister);

}
