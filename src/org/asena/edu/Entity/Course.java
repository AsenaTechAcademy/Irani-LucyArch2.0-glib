package org.asena.edu.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the course database table.
 * 
 */
@Entity
@NamedQuery(name="Course.findAll", query="SELECT c FROM Course c")
public class Course implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	private Integer vahedamali;

	private Integer vahednazari;

	//bi-directional many-to-one association to Coursetype
	@ManyToOne
	@JoinColumn(name="coursetypeid")
	private Coursetype coursetype;

	public Course() {
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

	public Integer getVahedamali() {
		return this.vahedamali;
	}

	public void setVahedamali(Integer vahedamali) {
		this.vahedamali = vahedamali;
	}

	public Integer getVahednazari() {
		return this.vahednazari;
	}

	public void setVahednazari(Integer vahednazari) {
		this.vahednazari = vahednazari;
	}

	public Coursetype getCoursetype() {
		return this.coursetype;
	}

	public void setCoursetype(Coursetype coursetype) {
		this.coursetype = coursetype;
	}

}