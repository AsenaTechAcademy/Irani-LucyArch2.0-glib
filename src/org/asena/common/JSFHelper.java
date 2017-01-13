
package org.asena.common;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;

public class JSFHelper
{
	public static void addErrorMessage(String message)
	{
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_ERROR, message, "");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMsg);
	}

	public static void addInfoMessage(String message)
	{
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_INFO, message, "");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMsg);
	}

	public static void addWarningMessage(String message)
	{
		FacesMessage facesMsg = new FacesMessage(FacesMessage.SEVERITY_WARN, message, "");
		FacesContext context = FacesContext.getCurrentInstance();
		context.addMessage(null, facesMsg);
	}

	public static void addCallBackParam(String param, Object value)
	{
		RequestContext.getCurrentInstance().addCallbackParam(param, value);
	}

	public static void resetMessages()
	{
		FacesContext context = FacesContext.getCurrentInstance();

		@SuppressWarnings("rawtypes")
		Iterator iter = context.getMessages();
		while (iter.hasNext())
		{
			iter.next();
			iter.remove();
		}
	}
}
