package com.firstboot.controller;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.firstboot.dao.EmployeeDAOInterface;
import com.firstboot.dao.EmployeeDAOInterfaceMongo;
import com.firstboot.entity.Employee;
import com.firstboot.entity.EmployeeMongo;
import com.firstboot.utility.Sender;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class EmplyeeController {
	
	@Autowired
	private EmployeeDAOInterface empdao;
	
	@RequestMapping("allEmployee")
	public List<Employee> displayAllEmployee(){
		List<Employee> el=new ArrayList<Employee>();
		Employee e1=new Employee();
		e1.setName("Rajesh");
		e1.setPassword("abcd");
		e1.setEmail("abc@yahoo.com");
		e1.setAddress("Bangalore");
		
		el.add(e1);
		return el;
	}
	
	@RequestMapping("allEmployeejdbc")
	@HystrixCommand(fallbackMethod = "userDefinedMethod")
	public List<Employee> displayAllEmployeejdbc(){
		List<Employee> el=empdao.getdaoall();
		if(el.size()>0) {
			throw new ArithmeticException();
		}
		return el;
	}
	
		public List<Employee> userDefinedMethod(){
		List<Employee> el=new ArrayList<Employee>();
		Employee e1=new Employee();
		e1.setName("dafault");
		e1.setPassword("default");
		e1.setEmail("default@yahoo.com");
		e1.setAddress("Bangalore");
		
		el.add(e1);
		return el;
	}
	
	@RequestMapping("allEmployeejpa")
	public List<Employee> displayAllEmployeejpa(){
		List<Employee> el=empdao.getdaoalljpa();
		
		return el;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/addEmployeejpa")
	public void addEmployeejpa(@RequestBody Employee employee){
		System.out.println(employee.getId());
		System.out.println(employee.getName());
		empdao.addEmployeejpa(employee);			
	}
	
	@RequestMapping(method=RequestMethod.PUT,value="/updateEmployeejpa")
	public void updateEmployeejpa(@RequestBody Employee employee){
		empdao.updateEmployeejpa(employee);			
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/deleteEmployeejpa")
	public void deleteEmployeejpa(@RequestBody Employee employee){
		empdao.deleteEmployeejpa(employee);			
	}
	
	@Autowired
	private EmployeeDAOInterfaceMongo empmongo;
	
	@RequestMapping("allEmployeemongo")
	public List<EmployeeMongo> displayAllEmployeemongo(){
		List<EmployeeMongo> el=empmongo.findAll();
		
		return el;
	}
	
	@Autowired
	private Sender ss;
	
	@RequestMapping("sendmessage")
	public String sendmessage(){
		ss.sendmessage("mytopic", "hello i am message comming from employeeservice");
		
		return "message sent successfully";
	}

}
