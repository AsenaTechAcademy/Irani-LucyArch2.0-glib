
package org.asena.AAA.Controller;

import java.io.IOException;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.asena.AAA.ServiceInterface.AAAWebService;
import org.asena.common.SessionManager;
import org.asena.common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean(name = "LoginMB")
@SessionScoped

public class LoginMB extends baseManagedBean implements Serializable
{

	private static final long serialVersionUID = -1992310662054611477L;

	public LoginMB()
	{
	}

	private String Username;
	private String Password;

	@Autowired
	private AAAWebService aaaService;


	public String Login()
	{
		try
		{
			aaaService.Login(Username, Password);
			return "CPanel";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}


		//if username or password is incorrect
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		return "Login";
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Logout	
	public void Logout() throws IOException
	{
		aaaService.Logout();
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect(SessionManager.getRequest().getContextPath() + "/view/Login.xhtml");
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter
	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String username)
	{
		Username = username;
	}

	public String getPassword()
	{
		return Password;
	}

	public void setPassword(String password)
	{
		Password = password;
	}


}
