
package org.asena.AAA.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/** The persistent class for the aauser database table. */
@Entity
@NamedQueries({ @NamedQuery(name = "Aauser.findAll", query = "SELECT a FROM Aauser a"),
		@NamedQuery(name = "Aauser.findbyUsername", query = "SELECT a FROM Aauser a WHERE (a.username=:Username)"),
		@NamedQuery(name = "Aauser.findbyUserPass", query = "SELECT a FROM Aauser a WHERE (a.username=:Username AND a.hpassword=:Password)"),
		@NamedQuery(name = "Aauser.findbyUserMobile", query = "SELECT a FROM Aauser a WHERE (a.username=:Username AND a.mobile=:Mobile)"),
		@NamedQuery(name = "Aauser.findbyUserPassDeactives", query = "SELECT a FROM Aauser a WHERE (a.username=:Username AND a.hpassword=:Password)"),

})

public class Aauser implements Serializable
{
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String email;

	private String hanswer;

	private String hpassword;

	private Timestamp lastpasswordchangedate;

	private String mobile;

	private String nickname;

	private String question;

	private String username;

	//bi-directional many-to-one association to Aasession
	@OneToMany(mappedBy = "aauser", cascade = CascadeType.REMOVE)
	private List<Aasession> aasessions;

	//bi-directional many-to-one association to Aarole
	@ManyToOne
	@JoinColumn(name = "roleid")
	private Aarole aarole;

	public Aauser()
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

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getHanswer()
	{
		return this.hanswer;
	}

	public void setHanswer(String hanswer)
	{
		this.hanswer = hanswer;
	}

	public String getHpassword()
	{
		return this.hpassword;
	}

	public void setHpassword(String hpassword)
	{
		this.hpassword = hpassword;
	}

	public Timestamp getLastpasswordchangedate()
	{
		return this.lastpasswordchangedate;
	}

	public void setLastpasswordchangedate(Timestamp lastpasswordchangedate)
	{
		this.lastpasswordchangedate = lastpasswordchangedate;
	}

	public String getMobile()
	{
		return this.mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getNickname()
	{
		return this.nickname;
	}

	public void setNickname(String nickname)
	{
		this.nickname = nickname;
	}

	public String getQuestion()
	{
		return this.question;
	}

	public void setQuestion(String question)
	{
		this.question = question;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public List<Aasession> getAasessions()
	{
		return this.aasessions;
	}

	public void setAasessions(List<Aasession> aasessions)
	{
		this.aasessions = aasessions;
	}

	public Aasession addAasession(Aasession aasession)
	{
		getAasessions().add(aasession);
		aasession.setAauser(this);

		return aasession;
	}

	public Aasession removeAasession(Aasession aasession)
	{
		getAasessions().remove(aasession);
		aasession.setAauser(null);

		return aasession;
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
