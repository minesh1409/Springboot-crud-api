package com.simha.cloud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.simha.cloud.model.UserRegister;

@Transactional
@Repository
public class UserDaoImpl implements UserDao
{
	@Autowired
	EntityManager em;
	
	@Override
	public void save(UserRegister u) {
		// TODO Auto-generated method stub
		
		em.persist(u);		
	}

	@Override
	public List<UserRegister> findAll() {
		// TODO Auto-generated method stub
		return em.createQuery("FROM UserRegister").getResultList();
	
	}
	
	@Override
	public UserRegister findById(int id) {
		return  em.find(UserRegister.class, id);
		
	}
	
	@Override
	public UserRegister deleteById(int id) {
		// TODO Auto-generated method stub
		UserRegister user=findById(id);
		em.remove(user);
		return user;
	}

	@Override
	public void updateUser(UserRegister userRegister) {
	
		System.out.println("\n\n : : :DAO: : :\n\n");
		System.out.println("::::id::::  "+ userRegister.getId());
		System.out.println("::::add::::  "+ userRegister.getAddress());
		System.out.println("::::name::::  "+ userRegister.getFirstname()+userRegister.getLastname());
		System.out.println("::::contact::::  "+ userRegister.getContact());
		
		userRegister.setFirstname("Mitesh");
		userRegister.setLastname("Purohit");
		userRegister.setCompanyname("Simha Online");
		userRegister.setAddress(userRegister.getAddress());
		userRegister.setContact(userRegister.getContact());
		em.merge(userRegister);
		
		/*UserRegister user = findById(userRegister.getId());
		user.setFirstname("Nayan");
		user.setLastname("Marwadi");
		user.setCompanyname("Simha Online");
		user.setAddress(user.getAddress());
		user.setCompanyname(user.getCompanyname());
		user.setContact(user.getContact());
		em.merge(userRegister);*/
		
	}
	
	public void updateUserById(int id) {
		UserRegister userRegister=findById(id);;
		System.out.println("::::id::::  "+ userRegister.getId());
	}

	@Override
	public void changeUser(UserRegister userRegister) {
		// TODO Auto-generated method stub
		UserRegister user=findById(userRegister.getId());
		user.setFirstname(userRegister.getFirstname());
		user.setLastname(userRegister.getLastname());
		user.setCompanyname(userRegister.getCompanyname());
		user.setAddress(userRegister.getAddress());
		user.setContact(userRegister.getContact());
		em.flush();
	}

}
