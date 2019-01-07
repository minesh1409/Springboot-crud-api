package com.simha.cloud.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simha.cloud.dao.UserDao;
import com.simha.cloud.model.UserRegister;

@Service
public class UserServicesImpl implements UserServices {
	
	@Autowired
	UserDao userDao;

	@Override
	public void save(UserRegister u) {
		// TODO Auto-generated method stub
		userDao.save(u);
		
	}

	@Override
	public List<UserRegister> findAll() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public UserRegister deleteById(int id) {
		// TODO Auto-generated method stub
		return userDao.deleteById(id);
	}
	

	@Override
	public UserRegister findById(int id) {
		// TODO Auto-generated method stub
		return userDao.findById(id);
	}

	@Override
	public void updateUser(UserRegister userRegister) {
		// TODO Auto-generated method stub
		System.out.println("\n\n : : :SERVICE: : :\n\n");
		userDao.updateUser(userRegister);
	}
	
	public void updateUserById(int id) {
		userDao.updateUserById(id);
		
	}

	@Override
	public void changeUser(UserRegister userRegister) {
		// TODO Auto-generated method stub
		userDao.changeUser(userRegister);
	}

}
