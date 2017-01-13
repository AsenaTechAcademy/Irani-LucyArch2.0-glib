package org.asena.AAA.common;

import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

public class ProfileUIModel 
{
	private String username;
	private String role;
	private String nickname;
	private String lastlogindate;
	private String logindate;
	private String logincount;
	
	@Email (message="مقدار ایمیل را درست وارد نمایید")
	private String email;
	
	@Pattern(regexp="(^$|[0-9]{11})")
	private String mobile;
	
	@NotEmpty (message="مقدار فیلد سوال نمیتواند خالی باشد")
	private String question;
	
	@NotEmpty (message="مقدار فیلد جواب نمیتواند خالی باشد")
	private String hanswer;
	
	
	
	
	
	public String getLogincount() {
		return logincount;
	}
	public void setLogincount(String logincount) {
		this.logincount = logincount;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getLastlogindate() {
		return lastlogindate;
	}
	public void setLastlogindate(String lastlogindate) {
		this.lastlogindate = lastlogindate;
	}
	public String getLogindate() {
		return logindate;
	}
	public void setLogindate(String logindate) {
		this.logindate = logindate;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getHanswer() {
		return hanswer;
	}
	public void setHanswer(String hanswer) {
		this.hanswer = hanswer;
	}
	
	
	
	
}
