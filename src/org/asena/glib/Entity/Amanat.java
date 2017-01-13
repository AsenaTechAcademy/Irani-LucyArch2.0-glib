package org.asena.glib.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the amanat database table.
 * 
 */
@Entity
@NamedQuery(name="Amanat.findAll", query="SELECT a FROM Amanat a")
public class Amanat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp amanatdate;

	private Timestamp bazgashtdate;

	private Integer penalty;

	private Timestamp realbazgashtdate;

	//bi-directional many-to-one association to Book
	@ManyToOne
	@JoinColumn(name="bookid")
	private Book book;

	//bi-directional many-to-one association to Member
	@ManyToOne
	@JoinColumn(name="memberid")
	private Member member;

	public Amanat() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getAmanatdate() {
		return this.amanatdate;
	}

	public void setAmanatdate(Timestamp amanatdate) {
		this.amanatdate = amanatdate;
	}

	public Timestamp getBazgashtdate() {
		return this.bazgashtdate;
	}

	public void setBazgashtdate(Timestamp bazgashtdate) {
		this.bazgashtdate = bazgashtdate;
	}

	public Integer getPenalty() {
		return this.penalty;
	}

	public void setPenalty(Integer penalty) {
		this.penalty = penalty;
	}

	public Timestamp getRealbazgashtdate() {
		return this.realbazgashtdate;
	}

	public void setRealbazgashtdate(Timestamp realbazgashtdate) {
		this.realbazgashtdate = realbazgashtdate;
	}

	public Book getBook() {
		return this.book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}