package com.simha.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.simha.cloud.model.UserRegister;
import com.simha.cloud.services.UserServices;

@RestController
public class UserController {
	
	@Autowired
	UserServices userServices;

	@GetMapping("/")
	String home() {
		return "Api Started";
	}
	
	@PostMapping("/adduser")
	public ResponseEntity<String> register(@RequestBody UserRegister user, UriComponentsBuilder builder) {
		userServices.save(user);
		return new ResponseEntity<String>("User Successfull Registered",HttpStatus.OK);
	}
	
	@GetMapping("/getusers")
	public ResponseEntity<List<UserRegister>> findAll() 
	{
		List<UserRegister> user=userServices.findAll();
		return new ResponseEntity<List<UserRegister>>(user,HttpStatus.OK);
	}
	
	
	@GetMapping("/getuser/{id}")
	public ResponseEntity<UserRegister> findById(@PathVariable("id") Integer id)
	{
		UserRegister user=userServices.findById(id);
		return new ResponseEntity<UserRegister>(user,HttpStatus.OK);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<UserRegister> updateUser(@PathVariable("id") Integer id, @RequestBody UserRegister userRegister)
	{
		System.out.println("\n\n : : :CONTROLLER: : :\n\n");
		UserRegister user = userServices.findById(id);
		userServices.updateUser(user);
		return new ResponseEntity<UserRegister>(user,HttpStatus.OK);
	}
	@PutMapping("/changeuser")
	public ResponseEntity<UserRegister> changeuser(@RequestBody UserRegister userRegister)
	{
		System.out.println("\n\n : : :CONTROLLER: : :\n\n");
		
		userServices.changeUser(userRegister);
		return new ResponseEntity<UserRegister>(userRegister,HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Integer id){
		userServices.deleteById(id);
		return new ResponseEntity<String>("User Deleted",HttpStatus.OK);
		
	}

}
