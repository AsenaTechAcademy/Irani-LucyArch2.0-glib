
package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;


/** The persistent class for the aaaccesslist database table. */
@Entity
@NamedQueries({ @NamedQuery(name = "Aaaccesslist.findAll", query = "SELECT a FROM Aaaccesslist a"),
		@NamedQuery(name = "Aaaccesslist.findRoleAccessList", query = "SELECT a FROM Aaaccesslist a WHERE a.aarole.id=:RoleId ORDER BY a.aapage.aapagecat.orders asc,a.aapage.orders asc"), })

public class Aaaccesslist implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	//bi-directional many-to-one association to Aapage
	@ManyToOne
	@JoinColumn(name = "pagefkid")
	private Aapage aapage;

	//bi-directional many-to-one association to Aarole
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Aarole aarole;

	public Aaaccesslist()
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

	public Aapage getAapage()
	{
		return this.aapage;
	}

	public void setAapage(Aapage aapage)
	{
		this.aapage = aapage;
	}

	public Aarole getAarole()
	{
		return this.aarole;
	}

	public void setAarole(Aarole aarole)
	{
		this.aarole = aarole;
	}

}
