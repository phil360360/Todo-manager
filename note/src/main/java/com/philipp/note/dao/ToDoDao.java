package com.philipp.note.dao;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.philipp.note.model.ToDo;

/**
 * Dao for Todo
 * 
 * @author Philipp Herbst
 *
 */
@Repository
public class ToDoDao {

	@Autowired
	private SessionFactory sessionFactory;

	
	public void save(ToDo todo) {
		sessionFactory.getCurrentSession().save(todo);
	}

	public List<ToDo> list() {
		@SuppressWarnings("unchecked")
		TypedQuery<ToDo> query = sessionFactory.getCurrentSession().createQuery("FROM ToDo");
		return query.getResultList();
	}
	

	public List<ToDo> getTodosByUser(int id) {
		CriteriaBuilder builder = sessionFactory.getCurrentSession().getCriteriaBuilder();
		CriteriaQuery<ToDo> cq = sessionFactory.getCurrentSession().getCriteriaBuilder().createQuery(ToDo.class);
		Root<ToDo> toDoRoot = cq.from(ToDo.class);
		cq.where(builder.equal(toDoRoot.get("user"), id));
		return sessionFactory.createEntityManager().createQuery(cq).getResultList();
	}

	public ToDo getToDo(int id) {
		return sessionFactory.getCurrentSession().get(ToDo.class, id);
	}

	public void update(ToDo todo) {
		sessionFactory.getCurrentSession().update(todo);
	}
	
	public void delete(ToDo todo) {
		sessionFactory.getCurrentSession().remove(todo);
	}
}
