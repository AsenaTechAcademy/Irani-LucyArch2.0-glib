
package org.asena.AAA.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.common.ProfileUIModel;
import org.asena.AAA.ServiceInterface.AAAWebService;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBean;
import org.springframework.beans.factory.annotation.Autowired;



@ManagedBean(name = "ChangeProfileMB")
@SessionScoped

public class ChangeProfileMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 6493993523431265625L;

	@Autowired
	private AAAWebService aaaService;

	private ProfileUIModel profileUIModel;

	public void init()
	{
		super.init();
		profileUIModel = aaaService.getProfile();
	}

	public String ChangeProfile()
	{
		try
		{
			aaaService.ChangeProfile(profileUIModel);
			JSFHelper.addInfoMessage("اطلاعات کاربری شما با موفقیت تغییر یافت.");
			return "ChangeProfile";
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

		return "ChangeProfile";
	}


	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter
	public ProfileUIModel getProfileUIModel()
	{
		return profileUIModel;
	}

	public void setProfileUIModel(ProfileUIModel profileUIModel)
	{
		this.profileUIModel = profileUIModel;
	}



}
