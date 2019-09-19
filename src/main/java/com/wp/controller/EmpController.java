package com.wp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wp.entity.Emp;
import com.wp.model.EmpModel;
import com.wp.service.EmpCRUD;

@Controller
public class EmpController {

	@Autowired
	EmpCRUD empCRUD;
	
	@RequestMapping("/dataentry")
	public String showDataEntryForm() {
		return "EmpEntry.jsp";
	}
	
	@RequestMapping("SaveEmp")
	public ModelAndView saveEmp(@ModelAttribute("empInfo") EmpModel empModel) {
		 
		ModelAndView mv = new ModelAndView("success.jsp");
		Emp emp = new Emp();
		emp.setEno(empModel.getEno());
		emp.setEname(empModel.getEname());
		emp.setDesignation(empModel.getDesignation());
		emp.setSalary(empModel.getSalary());
		emp.setDept(empModel.getDept());
		
		empCRUD.saveEmp(emp);
		return mv;
		
	}
	
	@RequestMapping("datafetch")
	public ModelAndView fetchAllEmp() {
		List<Emp> list = empCRUD.getAllEmp();

		ModelAndView mv = new ModelAndView("DisplayEmp.jsp");
		mv.addObject("empList",list);
		
		return mv;	
	}
	@RequestMapping("datasearch")
	public String fetchEmp() {
		return "SearchEmp.jsp";
	}
	@PostMapping("GetEmp")
	public ModelAndView searchEmp(@RequestParam("eno") int eno) {
		Emp emp = empCRUD.searchEmp(eno);
		ModelAndView mv = new ModelAndView("SearchEmp.jsp");
		mv.addObject("emp", emp);
		return mv;
	}
	
	@GetMapping("update")
	public String updateDelete(@RequestParam Map<String,String> requestParams,ModelMap map) {
		Emp emp = empCRUD.searchEmp(Integer.parseInt(requestParams.get("eno")));
		map.addAttribute("emp",emp);
		return "update.jsp";
	}
	
	@PostMapping("UpdateEmp")
	public ModelAndView updateEmp(@ModelAttribute("empInfo") EmpModel empModel) {
		
		ModelAndView mv = new ModelAndView("success.jsp");
		Emp emp = new Emp();
		emp.setEno(empModel.getEno());
		emp.setEname(empModel.getEname());
		emp.setDesignation(empModel.getDesignation());
		emp.setSalary(empModel.getSalary());
		emp.setDept(empModel.getDept());
		empCRUD.updateEmp(emp);
//		mv.addObject("empInfo",emp);
		return mv;
	}
	
	@RequestMapping("delete")
	public ModelAndView deleteEmp(@RequestParam("eno") int eno) {
		ModelAndView mv = new ModelAndView("success.jsp");
		Emp emp = empCRUD.searchEmp(eno);
		System.out.println(emp.getEno());
		mv.addObject("empInfo",emp);
		empCRUD.deleteEmp(emp);
		
		return mv;
	}
}
