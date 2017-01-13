package org.asena.edu.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the coursetype database table.
 * 
 */
@Entity
@NamedQuery(name="Coursetype.findAll", query="SELECT c FROM Coursetype c")
public class Coursetype implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	//bi-directional many-to-one association to Course
	@OneToMany(mappedBy="coursetype")
	private List<Course> courses;

	public Coursetype() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Course> getCourses() {
		return this.courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}

	public Course addCours(Course cours) {
		getCourses().add(cours);
		cours.setCoursetype(this);

		return cours;
	}

	public Course removeCours(Course cours) {
		getCourses().remove(cours);
		cours.setCoursetype(null);

		return cours;
	}

}