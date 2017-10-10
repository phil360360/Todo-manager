package com.philipp.note.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philipp.note.dao.ToDoDao;
import com.philipp.note.model.ToDo;

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

	SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");

	@Transactional(readOnly = true)
	public List<ToDo> retrieveNotes() {
		return toDoDao.list();
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
