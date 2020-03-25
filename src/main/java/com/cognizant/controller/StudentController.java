package com.cognizant.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.model.Student;
import com.cognizant.service.StudentServiceImpl;

@Controller
public class StudentController {

	@Autowired
	private StudentServiceImpl studentService;

	public void setStudentService(StudentServiceImpl studentService) {
		this.studentService = studentService;
	}

	@RequestMapping(value = "insert", method = RequestMethod.GET)
	public ModelAndView insertPage() {

		ModelAndView mv = new ModelAndView("insert");

		Student student = new Student();

		mv.addObject("student", student);

		return mv;

	}

	@RequestMapping(value = "insert", method = RequestMethod.POST)
	public ModelAndView insert(@ModelAttribute("student") Student student) {
		// Read the request parameter
		System.out.println("Model Attribute:" + student);
		// insert student to db

		String res = studentService.insert(student);

		ModelAndView mv = new ModelAndView("insert");

		if (res.equals("SUCCESS"))
			mv.addObject("msg", "Record Inserted");
		else
			mv.addObject("msg", "Record Not Inserted");

		return mv;
	}

	@RequestMapping(value = "update", method = RequestMethod.GET)
	public String update() {
		return "update";
	}

	@RequestMapping(value = "delete", method = RequestMethod.GET)
	public String delete() {
		return "delete";
	}

	@RequestMapping(value = "getAll", method = RequestMethod.GET)
	public ModelAndView getAll() {
		List<Student> list = studentService.getAll();
		System.out.println(list);
		ModelAndView mv=new ModelAndView("display");
		mv.addObject("list", list);
		return mv;
	}

}
