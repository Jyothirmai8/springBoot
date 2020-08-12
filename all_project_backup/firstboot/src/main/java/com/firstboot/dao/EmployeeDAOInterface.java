package com.firstboot.dao;

import java.util.List;

import com.firstboot.entity.Employee;

public interface EmployeeDAOInterface {

	List<Employee> getdaoall();
	List<Employee> getdaoalljpa();
	void addEmployeejpa(Employee employee);
	void updateEmployeejpa(Employee empl);
	void deleteEmployeejpa(Employee employee);	
}
