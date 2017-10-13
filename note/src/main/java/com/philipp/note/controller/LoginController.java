package com.philipp.note.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.philipp.note.service.ToDoService;

@Controller
@SessionAttributes("username")
public class LoginController {

	@Autowired
	private ToDoService service;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model) {
				
		model.addAttribute("todos", service.retrieveTodosForUser());
		return "home";
	}
}