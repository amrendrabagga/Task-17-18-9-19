package com.wp.dao;

import java.util.List;

import javax.servlet.ServletContext;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.wp.entity.Emp;
import com.wp.util.Util;

@Component
public class EmpDAO implements DAO,ServletContextAware{

//	@Autowired ->this will null pointer exception as it get executed in setter property phase
	//and we try to use initiate session in constructor
	ServletContext context;
	private Session session;
	private Transaction tr;
	public EmpDAO() {
			//session = (Session)context.getAttribute("hSession");
	}
	@Override
	public List<Emp> getAllEmp() {
		List<Emp> listEmp = session.createNamedQuery("GET_ALL_EMP").list();
		return listEmp;
	}

	@Override
	public void save(Emp emp) {
		tr = session.beginTransaction();
		session.save(emp);
		tr.commit();
		System.out.println("emp saved");
	}

	@Override
	public void update(Emp emp) {
		tr = session.beginTransaction();
		session.update(emp);
		tr.commit();
	}

	@Override
	public void delete(Emp emp) {
		tr = session.beginTransaction();
		session.delete(emp);
		tr.commit();
		System.out.println("emp deleted");
	}

	@Override
	public Emp search(int eno) {
		Emp emp = session.get(Emp.class, eno);
		session.clear();
		return emp;
	}
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.context = servletContext;
		session = ((Session)context.getAttribute("hSession"));
		
	}

	
}
