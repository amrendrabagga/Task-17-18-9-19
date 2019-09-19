package com.wp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.wp.dao.DAO;
import com.wp.dao.EmpDAO;
import com.wp.entity.Emp;

@Service
public class EmpCRUD {

	@Autowired
//	@Qualifier("myDAO") //it we have only bean(component of type dao then no need)
	DAO empDAO;
	
	public void saveEmp(Emp emp) {
		empDAO.save(emp);
	}
	
	public List<Emp> getAllEmp(){
		List<Emp> list = empDAO.getAllEmp();
		return list;	
	}
	
	public Emp searchEmp(int eno) {
		Emp emp = empDAO.search(eno);
		return emp;
	}
	
	public void updateEmp(Emp emp) {
		empDAO.update(emp);
	}
	
	public void deleteEmp(Emp emp) {
		empDAO.delete(emp);
	}
 }
