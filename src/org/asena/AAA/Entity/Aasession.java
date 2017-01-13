
package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/** The persistent class for the aasession database table. */
@Entity
@NamedQueries({ @NamedQuery(name = "Aasession.findAll", query = "SELECT a FROM Aasession a"),
		@NamedQuery(name = "Aasession.findlastlogin", query = "SELECT a FROM Aasession a WHERE a.aauser.id=:userId AND a.id<>:onlinesessionID ORDER BY a.logindate DESC"), })

public class Aasession implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String cilent;

	private Boolean ismanuallylogout;

	private Timestamp logindate;

	private Timestamp logoutdate;

	//bi-directional many-to-one association to Aapagevisit
	@OneToMany(mappedBy = "aasession", cascade = CascadeType.REMOVE)
	private List<Aapagevisit> aapagevisits;

	//bi-directional many-to-one association to Aauser
	@ManyToOne
	@JoinColumn(name = "userid")
	private Aauser aauser;

	public Aasession()
	{
	}

	public Long getId()
	{
		return this.id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCilent()
	{
		return this.cilent;
	}

	public void setCilent(String cilent)
	{
		this.cilent = cilent;
	}

	public Boolean getIsmanuallylogout()
	{
		return this.ismanuallylogout;
	}

	public void setIsmanuallylogout(Boolean ismanuallylogout)
	{
		this.ismanuallylogout = ismanuallylogout;
	}

	public Timestamp getLogindate()
	{
		return this.logindate;
	}

	public void setLogindate(Timestamp logindate)
	{
		this.logindate = logindate;
	}

	public Timestamp getLogoutdate()
	{
		return this.logoutdate;
	}

	public void setLogoutdate(Timestamp logoutdate)
	{
		this.logoutdate = logoutdate;
	}

	public List<Aapagevisit> getAapagevisits()
	{
		return this.aapagevisits;
	}

	public void setAapagevisits(List<Aapagevisit> aapagevisits)
	{
		this.aapagevisits = aapagevisits;
	}

	public Aapagevisit addAapagevisit(Aapagevisit aapagevisit)
	{
		getAapagevisits().add(aapagevisit);
		aapagevisit.setAasession(this);

		return aapagevisit;
	}

	public Aapagevisit removeAapagevisit(Aapagevisit aapagevisit)
	{
		getAapagevisits().remove(aapagevisit);
		aapagevisit.setAasession(null);

		return aapagevisit;
	}

	public Aauser getAauser()
	{
		return this.aauser;
	}

	public void setAauser(Aauser aauser)
	{
		this.aauser = aauser;
	}

}
