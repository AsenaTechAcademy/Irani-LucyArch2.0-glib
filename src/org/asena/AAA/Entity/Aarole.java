
package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/** The persistent class for the aarole database table. */
@Entity
@NamedQuery(name = "Aarole.findAll", query = "SELECT a FROM Aarole a")
public class Aarole implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String enname;

	private Integer maxuser;

	private String name;

	//bi-directional many-to-one association to Aaaccesslist
	@OneToMany(mappedBy = "aarole", cascade = CascadeType.REMOVE)
	private List<Aaaccesslist> aaaccesslists;

	//bi-directional many-to-one association to Aauser
	@OneToMany(mappedBy = "aarole", cascade = CascadeType.REMOVE)
	private List<Aauser> aausers;

	public Aarole()
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

	public String getDescription()
	{
		return this.description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public String getEnname()
	{
		return this.enname;
	}

	public void setEnname(String enname)
	{
		this.enname = enname;
	}

	public Integer getMaxuser()
	{
		return this.maxuser;
	}

	public void setMaxuser(Integer maxuser)
	{
		this.maxuser = maxuser;
	}

	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public List<Aaaccesslist> getAaaccesslists()
	{
		return this.aaaccesslists;
	}

	public void setAaaccesslists(List<Aaaccesslist> aaaccesslists)
	{
		this.aaaccesslists = aaaccesslists;
	}

	public Aaaccesslist addAaaccesslist(Aaaccesslist aaaccesslist)
	{
		getAaaccesslists().add(aaaccesslist);
		aaaccesslist.setAarole(this);

		return aaaccesslist;
	}

	public Aaaccesslist removeAaaccesslist(Aaaccesslist aaaccesslist)
	{
		getAaaccesslists().remove(aaaccesslist);
		aaaccesslist.setAarole(null);

		return aaaccesslist;
	}

	public List<Aauser> getAausers()
	{
		return this.aausers;
	}

	public void setAausers(List<Aauser> aausers)
	{
		this.aausers = aausers;
	}

	public Aauser addAauser(Aauser aauser)
	{
		getAausers().add(aauser);
		aauser.setAarole(this);

		return aauser;
	}

	public Aauser removeAauser(Aauser aauser)
	{
		getAausers().remove(aauser);
		aauser.setAarole(null);

		return aauser;
	}

}
