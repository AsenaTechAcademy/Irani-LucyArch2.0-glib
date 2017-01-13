
package org.asena.AAA.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.AAAWebService;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean(name = "ChangePasswordMB")
@SessionScoped

public class ChangePasswordMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -5096927309125285915L;

	private String Username = "";
	private String oldPassword = "";
	private String newPassword = "";
	private String newPassword2 = "";

	@Autowired
	private AAAWebService aaaService;


	public String ChangePassword()
	{
		try
		{
			if (!newPassword.equals(newPassword2))
				JSFHelper.addErrorMessage("رمز عبور با تکرار رمز عبور تطابقت ندارد.");
			else
			{
				aaaService.ChangePassword(Username, oldPassword, newPassword);
				JSFHelper.addInfoMessage("رمز عبور شما با موفقیت تغییر یافت.");
			}
			return "ChangePassword";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}


		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		return "ChangePassword";
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter

	public String getUsername()
	{
		return Username;
	}

	public void setUsername(String username)
	{
		Username = username;
	}

	public String getOldPassword()
	{
		return oldPassword;
	}

	public void setOldPassword(String oldPassword)
	{
		this.oldPassword = oldPassword;
	}

	public String getNewPassword()
	{
		return newPassword;
	}

	public void setNewPassword(String newPassword)
	{
		this.newPassword = newPassword;
	}



	public String getNewPassword2()
	{
		return newPassword2;
	}



	public void setNewPassword2(String newPassword2)
	{
		this.newPassword2 = newPassword2;
	}


}
