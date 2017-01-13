
package org.asena.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.Charset;

public class gSMSProvider
{
	private static final boolean isSendSMS_Login = false;
	private static final boolean isSendSMS_ChangePassword = true;

	private static final String serviceURL = "http://onlinepanel.ir//post/sendsms.ashx";
	private static final String serviceNumber = "10003904";
	private static final String serviceUsername = "9143225187";
	private static final String servicePassword = "123";

	public static String SendSMS_Login(String mobile)
	{
		if (isSendSMS_Login)
		{

		}
		return "";
	}

	public static String SendSMS_ChangePassword(String mobile, String newPassword)
	{
		if (isSendSMS_ChangePassword)
		{

		}
		return "";
	}

	public static String SendSMS_ResetPassword(String mobile, String newPassword)
	{
		String S = "با سلام" + "\n" + "رمز عبور جدید شما" + "\n" + newPassword + "\n" + "دانشگاه بناب";
		return SendSMS(mobile, S);
	}

	public static String SendSMS_NewUser(String mobile, String Username, String newPassword)
	{
		String S = "با سلام" + "\n" + "ثبت نام اولیه شما در سیستم  ترم تابستان دانشگاه بناب انجام شد." + "\n" + "نام کاربری شما:"
					+ "\n" + Username + "\n" + "رمز عبور شما:" + "\n" + newPassword + "\n" + "دانشگاه بناب";
		return SendSMS(mobile, S);
	}


	public static String SendSMS(String mobile, String msg)
	{
		String outfromURL = "";
		try
		{
			msg = URLEncoder.encode(msg, "UTF-8");
		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
		outfromURL = callURL(serviceURL + "?from=" + serviceNumber + "&to=" + mobile + "&text=" + msg + "&password="
					+ servicePassword + "&username=" + serviceUsername);
		return outfromURL;
	}


	private static String callURL(String myURL)
	{
		StringBuilder sb = new StringBuilder();
		URLConnection urlConn = null;
		InputStreamReader in = null;
		try
		{
			URL url = new URL(myURL);
			urlConn = url.openConnection();
			if (urlConn != null)
				urlConn.setReadTimeout(60 * 1000);
			if (urlConn != null && urlConn.getInputStream() != null)
			{
				in = new InputStreamReader(urlConn.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(in);
				if (bufferedReader != null)
				{
					int cp;
					while ((cp = bufferedReader.read()) != -1)
					{
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			in.close();
		}
		catch (Exception e)
		{
			throw new RuntimeException("Exception while calling URL:" + myURL, e);
		}
		return sb.toString();
	}// End of method:  callURL



}
