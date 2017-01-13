
package org.asena.glib.Controller;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBeanController;
import org.asena.common.exception.gException;
import org.asena.glib.Entity.Book;
import org.asena.glib.ServiceInterface.BookUCService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "BookMB")
@ViewScoped

public class BookMB extends baseManagedBeanController<Book> implements Serializable
{
	private static final long serialVersionUID = 7175342628505956385L;

	public BookMB()
	{
	}


	//Services Deceleration
	@Autowired
	private BookUCService bookService;



	//base Object, relations Lists (1-* objects)




	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Book();

		// new other Objects and set them into Base object



		// refresh Lists
		baseEntityList = bookService.FindAll("id", JPAOp.Asc);
	}




	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		String result = "";
		try
		{
			if (isedit)
				bookService.Edit(baseEntity);
			else
				result = bookService.Add(baseEntity);

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
	public void Remove(Book baseEntity)
	{
		try
		{
			bookService.Remove(baseEntity);
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
