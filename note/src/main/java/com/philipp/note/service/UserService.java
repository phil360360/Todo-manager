package com.philipp.note.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.philipp.note.dao.UserDao;
import com.philipp.note.model.User;

/**
 * Service for User
 * 
 * @author Philipp Herbst
 *
 */
@Service
public class UserService {

	@Autowired
	private UserDao userDao;

	@Transactional(readOnly = true)
	public List<User> retrieveUsers() {
		return userDao.list();
	}
	
	@Transactional
	public void createUser(String firstName, String lastName) {
		User user = new User(firstName, lastName);
		userDao.save(user);
	}

	@Transactional
	public void updateUser(User user) {
		userDao.update(user);
	}

	@Transactional
	public User getUserForFirstName(String firstName) {
		return userDao.getUserForName(firstName);
	}

	@Transactional
	public void deleteUser(User user) {
		userDao.delete(user);
	}
}
