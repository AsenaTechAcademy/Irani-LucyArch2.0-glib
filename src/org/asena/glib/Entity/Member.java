package org.asena.glib.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the member database table.
 * 
 */
@Entity
@NamedQuery(name="Member.findAll", query="SELECT m FROM Member m")
public class Member implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String address;

	private Integer allpenalty;

	private String email;

	private String family;

	private Long mellicode;

	private String mno;

	private String mobile;

	private String name;

	private String phone;

	private Timestamp tasviyedate;

	//bi-directional many-to-one association to Amanat
	@OneToMany(mappedBy="member")
	private List<Amanat> amanats;

	//bi-directional many-to-one association to Membertype
	@ManyToOne
	@JoinColumn(name="membertypeid")
	private Membertype membertype;

	public Member() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getAllpenalty() {
		return this.allpenalty;
	}

	public void setAllpenalty(Integer allpenalty) {
		this.allpenalty = allpenalty;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFamily() {
		return this.family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public Long getMellicode() {
		return this.mellicode;
	}

	public void setMellicode(Long mellicode) {
		this.mellicode = mellicode;
	}

	public String getMno() {
		return this.mno;
	}

	public void setMno(String mno) {
		this.mno = mno;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getTasviyedate() {
		return this.tasviyedate;
	}

	public void setTasviyedate(Timestamp tasviyedate) {
		this.tasviyedate = tasviyedate;
	}

	public List<Amanat> getAmanats() {
		return this.amanats;
	}

	public void setAmanats(List<Amanat> amanats) {
		this.amanats = amanats;
	}

	public Amanat addAmanat(Amanat amanat) {
		getAmanats().add(amanat);
		amanat.setMember(this);

		return amanat;
	}

	public Amanat removeAmanat(Amanat amanat) {
		getAmanats().remove(amanat);
		amanat.setMember(null);

		return amanat;
	}

	public Membertype getMembertype() {
		return this.membertype;
	}

	public void setMembertype(Membertype membertype) {
		this.membertype = membertype;
	}

}