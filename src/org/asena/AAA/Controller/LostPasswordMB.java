
package org.asena.AAA.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import org.asena.AAA.ServiceInterface.AAAWebService;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;



@ManagedBean(name = "LostPasswordMB")
@RequestScoped

public class LostPasswordMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -4211268661573721974L;

	private String mobile;
	private String username;

	@Autowired
	private AAAWebService aaaService;


	public String LostPassword()
	{
		try
		{
			aaaService.LostPassword(username, mobile);
			JSFHelper.addInfoMessage("رمز جدید شما با موفقیت به تلفن همراه شما ارسال شد.");
			return "LostPassword";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
		return "LostPassword";
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter

	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}


}
