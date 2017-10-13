package com.philipp.note.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "USER_TBL")
public class User {

	@Id
	@GeneratedValue
	@Column(name = "UID")
	private int id;

	@Column(name = "FIRST_NAME")
	@Size(max = 20, min = 3)
	private String firstName;

	@Column(name = "LAST_NAME")
	@Size(max = 20, min = 3)
	private String lastName;

	@Column(name = "ENABLED")
	private boolean enabled;

	@OneToMany(mappedBy="user")
	private Set<ToDo> todos = new HashSet<>();

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String firstName, String lastName) {
		setFirstName(firstName);
		setLastName(lastName);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<ToDo> getTodos() {
		return todos;
	}

	public void setTodos(Set<ToDo> todos) {
		this.todos = todos;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		User obj2 = (User) obj;
		if ((this.id == obj2.getId()) && (this.firstName.equals(obj2.getFirstName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + firstName).hashCode();
		return tmp;
	}
}
