package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aapage database table.
 * 
 */
@Entity
@NamedQuery(name="Aapage.findAll", query="SELECT a FROM Aapage a")
public class Aapage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String description;

	private String name;

	private Integer orders;

	private String pagename;

	private String url;

	//bi-directional many-to-one association to Aaaccesslist
	@OneToMany(mappedBy="aapage")
	private List<Aaaccesslist> aaaccesslists;

	//bi-directional many-to-one association to Aapagecat
	@ManyToOne
	@JoinColumn(name="pagecatid")
	private Aapagecat aapagecat;

	//bi-directional many-to-one association to Aapagevisit
	@OneToMany(mappedBy="aapage")
	private List<Aapagevisit> aapagevisits;

	public Aapage() {
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

	public Integer getOrders() {
		return this.orders;
	}

	public void setOrders(Integer orders) {
		this.orders = orders;
	}

	public String getPagename() {
		return this.pagename;
	}

	public void setPagename(String pagename) {
		this.pagename = pagename;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public List<Aaaccesslist> getAaaccesslists() {
		return this.aaaccesslists;
	}

	public void setAaaccesslists(List<Aaaccesslist> aaaccesslists) {
		this.aaaccesslists = aaaccesslists;
	}

	public Aaaccesslist addAaaccesslist(Aaaccesslist aaaccesslist) {
		getAaaccesslists().add(aaaccesslist);
		aaaccesslist.setAapage(this);

		return aaaccesslist;
	}

	public Aaaccesslist removeAaaccesslist(Aaaccesslist aaaccesslist) {
		getAaaccesslists().remove(aaaccesslist);
		aaaccesslist.setAapage(null);

		return aaaccesslist;
	}

	public Aapagecat getAapagecat() {
		return this.aapagecat;
	}

	public void setAapagecat(Aapagecat aapagecat) {
		this.aapagecat = aapagecat;
	}

	public List<Aapagevisit> getAapagevisits() {
		return this.aapagevisits;
	}

	public void setAapagevisits(List<Aapagevisit> aapagevisits) {
		this.aapagevisits = aapagevisits;
	}

	public Aapagevisit addAapagevisit(Aapagevisit aapagevisit) {
		getAapagevisits().add(aapagevisit);
		aapagevisit.setAapage(this);

		return aapagevisit;
	}

	public Aapagevisit removeAapagevisit(Aapagevisit aapagevisit) {
		getAapagevisits().remove(aapagevisit);
		aapagevisit.setAapage(null);

		return aapagevisit;
	}

}