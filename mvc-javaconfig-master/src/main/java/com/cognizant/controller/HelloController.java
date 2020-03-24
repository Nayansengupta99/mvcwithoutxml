package com.cognizant.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cognizant.service.StudentServiceImpl;

@Controller
public class HelloController {

	@Autowired
	private StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String sayHello() {
		return "hello";
	}

	@RequestMapping(value = "hi", method = RequestMethod.GET)
	public String sayHelloByName(HttpServletRequest request) {

		String name = request.getParameter("name");

		System.out.print("Name: " + name);

		request.setAttribute("name", name);

		return "hi";
	}
	/*
	 * @RequestMapping(value = "getAll", method = RequestMethod.GET) public
	 * String getAll() {
	 * 
	 * List<Student> list = studentService.getAll();
	 * 
	 * System.out.println("list " + list);
	 * 
	 * return "display"; }
	 */

}
