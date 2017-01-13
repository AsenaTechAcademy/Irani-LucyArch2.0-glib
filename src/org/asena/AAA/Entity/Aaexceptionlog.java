package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the aaexceptionlogs database table.
 * 
 */
@Entity
@Table(name="aaexceptionlogs")
@NamedQuery(name="Aaexceptionlog.findAll", query="SELECT a FROM Aaexceptionlog a")
public class Aaexceptionlog implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private Timestamp cdate;

	private String exceptionclassname;

	private String message;

	public Aaexceptionlog() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Timestamp getCdate() {
		return this.cdate;
	}

	public void setCdate(Timestamp cdate) {
		this.cdate = cdate;
	}

	public String getExceptionclassname() {
		return this.exceptionclassname;
	}

	public void setExceptionclassname(String exceptionclassname) {
		this.exceptionclassname = exceptionclassname;
	}

	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}