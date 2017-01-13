package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the aapagecat database table.
 * 
 */
@Entity
@NamedQuery(name="Aapagecat.findAll", query="SELECT a FROM Aapagecat a")
public class Aapagecat implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String name;

	private Integer orders;

	//bi-directional many-to-one association to Aapage
	@OneToMany(mappedBy="aapagecat")
	private List<Aapage> aapages;

	public Aapagecat() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public List<Aapage> getAapages() {
		return this.aapages;
	}

	public void setAapages(List<Aapage> aapages) {
		this.aapages = aapages;
	}

	public Aapage addAapage(Aapage aapage) {
		getAapages().add(aapage);
		aapage.setAapagecat(this);

		return aapage;
	}

	public Aapage removeAapage(Aapage aapage) {
		getAapages().remove(aapage);
		aapage.setAapagecat(null);

		return aapage;
	}

}