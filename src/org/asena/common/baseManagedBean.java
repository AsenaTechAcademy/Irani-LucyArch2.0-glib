
package org.asena.common;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.asena.common.exception.gException;
import org.primefaces.context.RequestContext;
import org.springframework.web.jsf.FacesContextUtils;

public abstract class baseManagedBean
{


	protected String msg = "";
	protected boolean isedit = false;



	@PostConstruct
	protected void init()
	{
		FacesContextUtils.getRequiredWebApplicationContext(FacesContext.getCurrentInstance()).getAutowireCapableBeanFactory()
					.autowireBean(this);

		msg = "";
		isedit = false;
		ResetBaseObject();
	} // end of init()


	public void setNewRecord()
	{
		ResetBaseObject();
	}


	public boolean getisEdit()
	{
		return isedit;
	}



	protected void ResetBaseObject()
	{
		isedit = false;
		msg = "";
	}



	@SuppressWarnings("unused")
	protected void CallCatch(Exception ex)
	{
		if ((ex instanceof gException) || (!gProjectConfig.isProjectReleased))
			JSFHelper.addErrorMessage(ex.getMessage());
		else
		{
			gLogger.Log("Unhandled", gLogger.getStackTrace(ex));
			JSFHelper.addErrorMessage("خطا در سیستم، لطفا به مدیر سیستم مراجعه کنید");
			ResetBaseObject();
		}
	}



	public void setCancel()
	{
		ResetBaseObject();
		RequestContext.getCurrentInstance().reset("frmNewEdit:panelgridNewEdit");
	}




	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}



}
