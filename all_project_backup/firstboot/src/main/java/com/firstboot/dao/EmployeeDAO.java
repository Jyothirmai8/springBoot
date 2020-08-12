package com.firstboot.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.firstboot.entity.Employee;

@Repository
public class EmployeeDAO implements EmployeeDAOInterface{
	
	@Autowired
	private DataSource ds;
	
	@Autowired
	private JdbcTemplate jtemp;
	
	@Autowired
	private EntityManagerFactory emf;

	@Override
	public List<Employee> getdaoall() {
		
		List<Employee> el1=jtemp.query("select * from employee", (rs,rowNum)->new Employee(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
		
			
		List<Employee> el=new ArrayList<Employee>();
		try {
			Connection con=ds.getConnection();
			PreparedStatement ps=con.prepareStatement("select * from employee");
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Employee e=new Employee();
				e.setName(rs.getString(1));
				e.setPassword(rs.getString(2));
				e.setEmail(rs.getString(3));
				e.setAddress(rs.getString(4));
				el.add(e);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		return el1;
	}
	
	@Override
	public List<Employee> getdaoalljpa() {
		EntityManager em=emf.createEntityManager();
		Query q=em.createQuery("from com.firstboot.entity.Employee e");
		
		return q.getResultList();
	}	

	@Override
	public void updateEmployeejpa(Employee empl) {
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.merge(empl);
		et.commit();
	}

	@Override
	public void deleteEmployeejpa(Employee employee) {

		EntityManager em=emf.createEntityManager();
		  Employee employee1 = em.find(Employee.class, employee.getId());
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		System.out.println(employee.getId());
		//em.
		//em.detach(employee);
		em.remove(employee1);
		et.commit();
	}

	@Override
	public void addEmployeejpa(Employee emp) {
		System.out.println("hi"+emp.getId());
		EntityManager em=emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(emp);
		et.commit();
		//Query q=em.createQuery("from com.firstboot.entity.Employee e");
		
	}

}
