package com.philipp.note.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philipp.note.dao.ToDoDao;
import com.philipp.note.dao.UserDao;
import com.philipp.note.model.ToDo;
import com.philipp.note.model.User;

/**
 * Service for Todo
 * 
 * @author Philipp Herbst
 *
 */
@Service
public class ToDoService {

	@Autowired
	private ToDoDao toDoDao;

	@Autowired
	private UserDao userDao;

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	@Transactional(readOnly = true)
	public List<ToDo> retrieveNotes() {
		return toDoDao.list();
	}

	@Transactional(readOnly = true)
	public List<ToDo> retrieveTodosForUser() {

		UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.getUserForName(currentUser.getName());

		return toDoDao.getTodosByUser(user.getId());
	}

	@Transactional
	public void addNote(String name, String executionDate, String filePath) {
		ToDo newToDo = new ToDo();
		newToDo.setName(name);

		try {
			newToDo.setExecutionDate(dateFormat.parse(executionDate));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		newToDo.setImage(filePath);

		UserDetails currentUser = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User user = userDao.getUserForName(currentUser.getName());

		newToDo.setUser(user);
		toDoDao.save(newToDo);
	}

	@Transactional
	public void updateTodo(ToDo toDo) {
		toDoDao.update(toDo);
	}

	@Transactional
	public ToDo getNoteForId(int id) {
		return toDoDao.getToDo(id);
	}

	@Transactional
	public void deleteNote(ToDo toDo) {
		toDoDao.delete(toDo);
	}
}
