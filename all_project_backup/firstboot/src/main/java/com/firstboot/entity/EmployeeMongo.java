package com.firstboot.entity;



//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

//@Entity
//@Table(name = "employeedata")

@Document(collection = "employeemongo")
public class EmployeeMongo {
	
	//@Id
	
	@Id
	private String name;
	private String password;
	private String email;
	private String address;
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
