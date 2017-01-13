
package org.asena.common;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;

import org.asena.common.exception.gException;
import org.primefaces.context.RequestContext;
import org.springframework.web.jsf.FacesContextUtils;

public abstract class baseManagedBeanController<BE>
{


	protected String msg = "";
	protected boolean isedit = false;

	protected BE baseEntity;
	protected List<BE> baseEntityList;


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
		{
			gLogger.Log("handled", gLogger.getStackTrace(ex));
			JSFHelper.addErrorMessage(ex.getMessage());
		}
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


	public void setSelectedRow(BE selectedrow)
	{
		this.baseEntity = selectedrow; // set selected row to base Object
		isedit = true; // set editable to true
	}



	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}


	public BE getbaseEntity()
	{
		return baseEntity;
	}


	public void setbaseEntity(BE baseEntity)
	{
		this.baseEntity = baseEntity;
	}

	public List<BE> getBaseEntityList()
	{
		return baseEntityList;
	}



}
