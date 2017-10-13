package com.philipp.note.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * DTO for a note
 * 
 * @author Philipp Herbst
 *
 */
@Entity
@Table(name = "TODO_TBL")
public class ToDo {

	@Id
	@GeneratedValue
	@Column(name = "UID")
	private int id;

	@Column(name = "NAME")
	@Size(max = 20, min = 3)
	private String name;

	@Column(name = "EXECUTION_DATE")
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date executionDate;

	@Column(name = "IMAGE")
	private String image;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!this.getClass().equals(obj.getClass()))
			return false;

		ToDo obj2 = (ToDo) obj;
		if ((this.id == obj2.getId()) && (this.name.equals(obj2.getName()))) {
			return true;
		}
		return false;
	}

	public int hashCode() {
		int tmp = 0;
		tmp = (id + name).hashCode();
		return tmp;
	}
}
