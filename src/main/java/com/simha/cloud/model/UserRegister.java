package com.simha.cloud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "User_Profiles")
public class UserRegister {
	
	@Id
	@Column(name = "User_Id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "First_Name")
	private String firstName;

	@Column(name = "Last_Name")
	private String lastName;

	@Column(name = "Address")
	private String address;

	@Column(name = "Contact")
	private Long contact;

	@Column(name = "Company_Name")
	private String companyName;

	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstName;
	}

	public void setFirstname(String firstname) {
		this.firstName = firstname;
	}

	public String getLastname() {
		return lastName;
	}

	public void setLastname(String lastname) {
		this.lastName = lastname;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public UserRegister() {
		super();
	}

	public UserRegister(String firstName, String lastName, String address, Long contact, String companyName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.companyName = companyName;
	}

	public UserRegister(int id, String firstName, String lastName, String address, Long contact, String companyName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.contact = contact;
		this.companyName = companyName;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getCompanyname() {
		return companyName;
	}

	public void setCompanyname(String companyname) {
		this.companyName = companyname;
	}

	

}
