
package org.asena.AAA.Service;

import java.util.List;

import org.asena.AAA.common.AAATools;
import org.asena.AAA.common.ProfileUIModel;
import org.asena.AAA.ServiceInterface.AAAWebService;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.gCal;
import org.asena.common.gSMSProvider;
import org.asena.common.SessionManager;
import org.asena.common.exception.gException;
import org.asena.AAA.Entity.Aaaccesslist;
import org.asena.AAA.Entity.Aasession;
import org.asena.AAA.Entity.Aauser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AAAServiceImpl extends baseUCServiceImpl<Aauser> implements AAAWebService
{



	//UC : Login
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void Login(String Username, String Password) throws Exception, gException
	{
		//Syntax Check
		if (Username.length() <= 0 || Username.length() > 100 || Password.length() <= 0 || Password.length() > 100)
			throw new gException("ابتدا نام کاربری یا کلمه عبور را وارد نمایید.");

		//Validation 
		String newHPassword = AAATools.getHashed(Password);
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUserPassDeactives").setParameter("Username", Username)
					.setParameter("Password", newHPassword).getResultList();
		if (users.size() <= 0)
			throw new gException("نام کاربری یا رمز عبور درست نیست.");


		// Login is OK
		Aauser user = users.get(0);


		//get User Access List to Session		
		List<Aaaccesslist> roleAccessList = (List<Aaaccesslist>) em.createNamedQuery("Aaaccesslist.findRoleAccessList")
					.setParameter("RoleId", user.getAarole().getId()).getResultList();
		SessionManager.setAccessList(roleAccessList);


		// go to CPanel
		Aasession aasession = new Aasession();
		aasession.setAauser(user);
		aasession.setLogindate(gCal.getCurrentDateTime());
		aasession.setCilent(SessionManager.getClientInfo());
		aasession.setIsmanuallylogout(false);

		em.merge(user);
		em.persist(aasession);
		em.flush();

		//session info for each user
		SessionManager.setSessionId(aasession.getId());

	}// end of Login




	//UC : Logout
	@Override
	@Transactional
	public void Logout()
	{
		if (!SessionManager.sessionExist())
		{
			SessionManager.Invalidate();
			return;
		}
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		aasession.setLogoutdate(gCal.getCurrentDateTime());
		aasession.setIsmanuallylogout(true);

		SessionManager.Invalidate();
	}




	//UC : ChangePassword
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public void ChangePassword(String Username, String oldPassword, String newPassword) throws gException
	{
		try
		{
			Thread.sleep(1000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		//Syntax Check
		if (Username.length() <= 0 || Username.length() > 100 || oldPassword.length() <= 0 || oldPassword.length() > 100
					|| newPassword.length() <= 0 || newPassword.length() > 100)
			throw new gException("ابتدا نام کاربری یا کلمه عبور قبلی و جدید را کامل وارد نمایید.");


		//Username of user itself
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		if (!aasession.getAauser().getUsername().equals(Username))
			throw new gException("لطفا نام کاربری خودتان را وارد نمایید.");


		//Validation of Username and Password 
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUserPass").setParameter("Username", Username)
					.setParameter("Password", AAATools.getHashed(oldPassword)).getResultList();
		if (users.size() <= 0)
			throw new gException("نام کاربری یا رمز عبور درست نیست.");



		//everything is OK
		aasession.getAauser().setHpassword(AAATools.getHashed(newPassword));
	}




	//UC : ChangeProfile
	@Override
	@Transactional
	public void ChangeProfile(ProfileUIModel profileUIModel)
	{
		//Syntax Check
		//it is done with Bean Validation

		//everything is OK
		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		aasession.getAauser().setEmail(profileUIModel.getEmail());
		aasession.getAauser().setMobile(profileUIModel.getMobile());
		aasession.getAauser().setQuestion(profileUIModel.getQuestion());
		aasession.getAauser().setHanswer(profileUIModel.getHanswer());
	}




	//UC : getProfile
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public ProfileUIModel getProfile()
	{
		ProfileUIModel profileUIModel = new ProfileUIModel();

		Aasession aasession = em.find(Aasession.class, SessionManager.getSessionId());
		profileUIModel.setEmail(aasession.getAauser().getEmail());
		profileUIModel.setMobile(aasession.getAauser().getMobile());
		profileUIModel.setQuestion(aasession.getAauser().getQuestion());
		profileUIModel.setHanswer(aasession.getAauser().getHanswer());
		profileUIModel.setUsername(aasession.getAauser().getUsername());
		profileUIModel.setNickname(aasession.getAauser().getNickname());
		profileUIModel.setRole(aasession.getAauser().getAarole().getName() + "--" + aasession.getAauser().getAarole().getEnname());
		profileUIModel.setLogindate(aasession.getLogindate().toString());

		List<Aasession> sessions = (List<Aasession>) em.createNamedQuery("Aasession.findlastlogin")
					.setParameter("userId", aasession.getAauser().getId()).setParameter("onlinesessionID", aasession.getId())
					.getResultList();

		profileUIModel.setLogincount(sessions.size() + "");
		if (sessions.size() > 0 && sessions.get(0).getLogoutdate() != null)
			profileUIModel.setLastlogindate(
						sessions.get(0).getLogindate().toString() + " @@ " + sessions.get(0).getLogoutdate().toString());
		if (sessions.size() > 0 && sessions.get(0).getLogoutdate() == null)
			profileUIModel.setLastlogindate(sessions.get(0).getLogindate().toString());

		return profileUIModel;
	}




	//UC : LostPassword
	@Override
	@Transactional
	public void LostPassword(String username, String mobile) throws gException
	{
		try
		{
			Thread.sleep(3000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}

		//Syntax Check
		if (username.length() <= 0 || username.length() > 100 || mobile.length() != 11)
			throw new gException("ابتدا نام کاربری و شماره موبایل و پست الکترونیک خود را کامل وارد نمایید.");


		//Validation of Username and Mobile
		@SuppressWarnings("unchecked")
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUserMobile").setParameter("Username", username)
					.setParameter("Mobile", mobile).getResultList();
		if (users.size() <= 0)
			throw new gException("نام کاربری یا شماره موبایل یا پست الکترونیک شما درست نیست.");


		//everything is OK
		try
		{
			String newPassword = AAATools.getRandomPassword();
			String newHPassword = AAATools.getHashed(newPassword);
			Aauser aauser = users.get(0);

			//send SMS
			gSMSProvider.SendSMS_ResetPassword(mobile, newPassword);
			aauser.setHpassword(newHPassword);

		}
		catch (Exception ex)
		{
			throw new gException("با عرض پوزش، ارسال پیامک با مشکل مواجه شد، لطفا بعدا تلاش نمائید.");
		}
	}




}


