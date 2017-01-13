
package org.asena.edu.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBeanController;
import org.asena.common.exception.gException;
import org.asena.edu.Entity.Coursetype;
import org.asena.edu.ServiceInterface.CoursetypeUCService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "CoursetypeMB")
@ViewScoped

public class CoursetypeMB extends baseManagedBeanController<Coursetype> implements Serializable
{
	private static final long serialVersionUID = 7175212628505956385L;

	public CoursetypeMB()
	{
	}


	//Services Deceleration
	@Autowired
	private CoursetypeUCService coursetypeService;




	//base Object, relations Lists (1-* objects)




	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Coursetype();

		// new other Objects and set them into Base object



		// refresh Lists
		baseEntityList = coursetypeService.FindAll("id", JPAOp.Asc);
	}




	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		String result = "";
		try
		{
			if (isedit)
				coursetypeService.Edit(baseEntity);
			else
				result = coursetypeService.Add(baseEntity);

			ResetBaseObject();


			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");

		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}




	//UC: Remove
	public void Remove(Coursetype baseEntity)
	{
		try
		{
			coursetypeService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}




	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters




}
