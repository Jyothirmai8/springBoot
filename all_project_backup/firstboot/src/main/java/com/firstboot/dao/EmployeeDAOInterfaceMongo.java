package com.firstboot.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.firstboot.entity.Employee;
import com.firstboot.entity.EmployeeMongo;

@Repository
public interface EmployeeDAOInterfaceMongo extends MongoRepository<EmployeeMongo, String> {

	
	
}
