
package org.asena.AAA.Service;

import java.util.List;

import org.asena.AAA.common.AAATools;
import org.asena.AAA.ServiceInterface.UserWebService;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.asena.AAA.Entity.Aauser;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl extends baseUCServiceImpl<Aauser> implements UserWebService
{


	@Override
	@Transactional
	public String Add(Aauser user) throws Exception, gException
	{
		// check the unique of username
		@SuppressWarnings("unchecked")
		List<Aauser> users = (List<Aauser>) em.createNamedQuery("Aauser.findbyUsername")
					.setParameter("Username", user.getUsername()).getResultList();
		if (users.size() > 0)
			throw new gException("نام کاربری قبلا در سیستم ثبت شده است، لطفا از نام کاربری دیگری استفاده کنید.");



		// everything is ok		
		// Generate password and hpassword
		String newPassword = AAATools.getRandomPassword();
		String newHPassword = AAATools.getHashed(newPassword);
		user.setHpassword(newHPassword);
		super.Add(user);

		//send SMS
		String s = "";
		/*		try
				{
					gSMSProvider.SendSMS_NewUser(user.getMobile(), user.getUsername(), newPassword);
				}
				catch (Exception ex)
				{
					s = "ارسال پیامک رمز کاربر با مشکل مواجه شد، لطفا رمز خود را یادداشت کنید: " + newPassword;
				}
		*/
		s = "ارسال پیامک رمز کاربر با مشکل مواجه شد، لطفا رمز خود را یادداشت کنید: " + newPassword;

		return s;
	}

	@Override
	@Transactional
	public Aauser Edit(Aauser user) throws Exception, gException
	{
		// check the unique of username
		Aauser tempUser = em.find(Aauser.class, user.getId());
		user.setUsername(tempUser.getUsername());

		super.Edit(user);
		return null;
	}


}
