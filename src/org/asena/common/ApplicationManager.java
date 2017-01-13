
package org.asena.common;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;


public class ApplicationManager
{
	public static ServletContext getApplication()
	{
		return (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
	}



}
