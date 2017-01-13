package org.asena.glib.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the book database table.
 * 
 */
@Entity
@NamedQuery(name="Book.findAll", query="SELECT b FROM Book b")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String author;

	private String bno;

	private Timestamp createdate;

	private Timestamp deletedate;

	private String isbn;

	private Boolean isreference;

	private Long pages;

	private String title;

	//bi-directional many-to-one association to Amanat
	@OneToMany(mappedBy="book")
	private List<Amanat> amanats;

	public Book() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getBno() {
		return this.bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public Timestamp getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Timestamp createdate) {
		this.createdate = createdate;
	}

	public Timestamp getDeletedate() {
		return this.deletedate;
	}

	public void setDeletedate(Timestamp deletedate) {
		this.deletedate = deletedate;
	}

	public String getIsbn() {
		return this.isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Boolean getIsreference() {
		return this.isreference;
	}

	public void setIsreference(Boolean isreference) {
		this.isreference = isreference;
	}

	public Long getPages() {
		return this.pages;
	}

	public void setPages(Long pages) {
		this.pages = pages;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<Amanat> getAmanats() {
		return this.amanats;
	}

	public void setAmanats(List<Amanat> amanats) {
		this.amanats = amanats;
	}

	public Amanat addAmanat(Amanat amanat) {
		getAmanats().add(amanat);
		amanat.setBook(this);

		return amanat;
	}

	public Amanat removeAmanat(Amanat amanat) {
		getAmanats().remove(amanat);
		amanat.setBook(null);

		return amanat;
	}

}