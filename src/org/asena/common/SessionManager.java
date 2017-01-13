
package org.asena.common;

import java.util.List;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.asena.AAA.Entity.Aaaccesslist;

public class SessionManager
{
	public static HttpSession getSession()
	{
		return (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
	}

	public static HttpServletRequest getRequest()
	{
		return (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
	}


	public static String getClientInfo()
	{
		String s = "";
		s += getRequest().getRemoteAddr() + "---";
		s += getRequest().getHeader("User-Agent").toString();
		return s;
	}


	// for external use in Business and Controller layer
	public static boolean sessionExist()
	{
		if (null == getSession())
			return false;

		if (null == getSession().getAttribute("SessionId") || getSession().getAttribute("SessionId").equals(-1)
					|| getSession().getAttribute("SessionId").equals(0))
			return false;
		return true;
	}


	public static void Invalidate()
	{
		if (!(null == getSession()))
			getSession().invalidate();
	}


	// SessionId
	public static void setSessionId(long SessionId)
	{
		if (!(null == getSession()))
			getSession().setAttribute("SessionId", SessionId);
	}

	public static long getSessionId()
	{
		if (sessionExist())
			return (long) getSession().getAttribute("SessionId");
		return -1;
	}



	// PageId
	public static void setPageId(long PageId)
	{
		if (!(null == getSession()))
			getSession().setAttribute("PageId", PageId);
	}

	public static long getPageId()
	{
		if (sessionExist())
		{
			try
			{
				return (long) getSession().getAttribute("PageId");
			}
			catch (Exception e)
			{
				return -1;
			}
		}
		return -1;
	}


	// Access List
	public static void setAccessList(List<Aaaccesslist> accessList)
	{
		if (!(null == getSession()))
			getSession().setAttribute("AccessList", accessList);
	}

	@SuppressWarnings("unchecked")
	public static List<Aaaccesslist> getAccessList()
	{
		if (sessionExist())
		{
			try
			{
				return (List<Aaaccesslist>) getSession().getAttribute("AccessList");
			}
			catch (Exception e)
			{
				return null;
			}
		}
		return null;
	}


}
