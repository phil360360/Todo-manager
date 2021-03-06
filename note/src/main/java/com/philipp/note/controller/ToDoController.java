package com.philipp.note.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.philipp.note.model.ToDo;
import com.philipp.note.model.User;
import com.philipp.note.service.ToDoService;
import com.philipp.note.service.UserService;

/**
 * Controller for Todo
 * 
 * @author Philipp Herbst
 *
 */
@Controller
public class ToDoController {

	@Autowired
	ServletContext servletContext;

	@Autowired
	private ToDoService service;
	
	@Autowired
	private UserService userService;


	@RequestMapping(value = "/edit-note", method = RequestMethod.GET)
	public String showUpdateNote(@RequestParam int id, ModelMap model, HttpSession session) {
		model.addAttribute("todo", service.getNoteForId(id));
		session.setAttribute("user", service.getNoteForId(id).getUser());
		return "updateToDo";
	}

	@RequestMapping(value = "/add-note", method = RequestMethod.GET)
	public String showAddNote(ModelMap model) {
		return "addToDo";
	}

	@RequestMapping(value = "/edit-note", method = RequestMethod.POST)
	public String updateNote(@ModelAttribute ToDo todo, HttpSession session, ModelMap model) {
		todo.setUser((User) session.getAttribute("user")); 
		service.updateTodo(todo);
		model.clear();
		return "redirect:/";
	}
	
	

	@RequestMapping(value = "/add-note", method = RequestMethod.POST)
	public String addTodo(HttpServletRequest request, @RequestParam String name, @RequestParam String executionDate,
			@RequestParam MultipartFile image, ModelMap model) {
		String filePath = "src/main/webapp/resources/images/" + image.getOriginalFilename();
		try {
			image.transferTo(new File(filePath));
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		service.addNote(name, executionDate, "resources/images/" +  image.getOriginalFilename());
	
		model.clear();
		return "redirect:/";
	}

	@RequestMapping(value = "/remove-note", method = RequestMethod.POST)
	public String removeNote(@RequestParam int id, ModelMap model) {
		service.deleteNote(service.getNoteForId(id));
		model.clear();
		return "redirect:/";
	}
}
