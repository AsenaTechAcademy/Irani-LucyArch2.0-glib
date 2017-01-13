
package org.asena.AAA.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.*;


/** The persistent class for the aapagevisit database table. */
@Entity
@NamedQuery(name = "Aapagevisit.findAll", query = "SELECT a FROM Aapagevisit a")
public class Aapagevisit implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Aapage
	@ManyToOne
	@JoinColumn(name = "pagefkid")
	private Aapage aapage;

	//bi-directional many-to-one association to Aasession
	@ManyToOne
	@JoinColumn(name = "sessionfkid")
	private Aasession aasession;

	public Aapagevisit()
	{
	}

	private Timestamp indate;


	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Aapage getAapage()
	{
		return this.aapage;
	}

	public void setAapage(Aapage aapage)
	{
		this.aapage = aapage;
	}

	public Aasession getAasession()
	{
		return this.aasession;
	}

	public void setAasession(Aasession aasession)
	{
		this.aasession = aasession;
	}

	public Timestamp getIndate()
	{
		return indate;
	}

	public void setIndate(Timestamp indate)
	{
		this.indate = indate;
	}

}
