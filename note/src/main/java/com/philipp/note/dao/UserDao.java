package com.philipp.note.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.philipp.note.model.User;

/**
 * Dao for User
 * 
 * @author Philipp Herbst
 *
 */
@Repository
public class UserDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void save(User user) {
		sessionFactory.getCurrentSession().save(user);
	}

	public List<User> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User");
		return query.getResultList();
	}

	public User getUserForName(String firstName) {
		return (User) sessionFactory.getCurrentSession().createQuery("from User where firstName =:firstname")
				.setParameter("firstname", firstName).uniqueResult();
	}

	public void update(User user) {
		sessionFactory.getCurrentSession().update(user);
	}

	public void delete(User user) {
		sessionFactory.getCurrentSession().remove(user);
	}
}
