package com.wp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TestController {

	@RequestMapping("showForm")
	public String showForm() {
		return "details.jsp";//this will return view name to front controller
	}
//	@RequestMapping(name="Calculate",method=RequestMethod.GET) //these 2 ways are also correct
//	@GetMapping("Calculate")
	@RequestMapping("Calculate")
	public void process(HttpServletRequest request,HttpServletResponse response) {
		 
		int amount = Integer.parseInt(request.getParameter("amount"));
		int time = Integer.parseInt(request.getParameter("time"));
		int interest = (amount*time*10)/100;
		try {
			PrintWriter out = response.getWriter();
			out.println("amount "+amount);
			out.println("time "+time);
			out.println("interest "+interest);
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@RequestMapping("Calculate2")
	public void process(@RequestParam("amount") int amount,@RequestParam("time") int time,HttpServletResponse response) {
		 
//		int amount = Integer.parseInt(request.getParameter("amount"));
//		int time = Integer.parseInt(request.getParameter("time"));
		int interest = (amount*time*10)/100;
		try {
			PrintWriter out = response.getWriter();
			out.println("amount "+amount);
			out.println("time "+time);
			out.println("interest "+interest);
			out.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@RequestMapping("Calculate3")
	public String calculateInterest(@RequestParam("amount") int amount,@RequestParam("time") int time,HttpServletResponse response) {
		 
//		int amount = Integer.parseInt(request.getParameter("amount"));
//		int time = Integer.parseInt(request.getParameter("time"));
		int interest = (amount*time*10)/100;
//		try {
//			PrintWriter out = response.getWriter();
//			out.println("amount "+amount);
//			out.println("time "+time);
//			out.println("interest "+interest);
//			out.close();
//			
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "result.jsp";
	}
	@RequestMapping("Calculate4")
	public ModelAndView calculateInterest(@RequestParam("amount") int amount,@RequestParam("time") int time) {
		 

		int interest = (amount*time*10)/100;
		ModelAndView mv = new ModelAndView("result.jsp");
		mv.addObject("amount", amount);
		mv.addObject("time", time);
		mv.addObject("interest", interest);
		return mv;
	}
	
	@RequestMapping("Calculate5")
	public ModelAndView calculateInterest(@ModelAttribute("info") InterestModel model) {//it binds the parameter to java object ie model
		//@ModelAttribute("info") InterestModel model ->(Equivalent to) mv.setAttribute("info",model)
		
		
		int interest = (model.getAmount()*model.getTime()*10)/100;
		model.setInterest(interest);
		ModelAndView mv = new ModelAndView("result.jsp");
		
		return mv;

	}
}
