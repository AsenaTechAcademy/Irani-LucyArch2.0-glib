
package org.asena.glib.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBeanController;
import org.asena.common.exception.gException;
import org.asena.glib.Entity.Amanat;
import org.asena.glib.Entity.Book;
import org.asena.glib.Entity.Member;
import org.asena.glib.ServiceInterface.AmanatUCService;
import org.asena.glib.ServiceInterface.BookUCService;
import org.asena.glib.ServiceInterface.MemberUCService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "AmanatMB")
@ViewScoped

public class AmanatMB extends baseManagedBeanController<Amanat> implements Serializable
{
	private static final long serialVersionUID = 7175342648505956385L;

	public AmanatMB()
	{
	}


	//Services Deceleration
	@Autowired
	private AmanatUCService amanatService;

	@Autowired
	private MemberUCService memberService;

	@Autowired
	private BookUCService bookService;




	//base Object, relations Lists (1-* objects)
	public List<Book> FindAll_canbeAmanatBooks()
	{
		return bookService.FindAllcanbeAmanat();
	}

	public List<Member> FindAll_Members()
	{
		return memberService.FindAll("bno", JPAOp.Asc);
	}


	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Amanat();

		// new other Objects and set them into Base object
		if (null == baseEntity.getMember())
			baseEntity.setMember(new Member());
		if (null == baseEntity.getBook())
			baseEntity.setBook(new Book());

	}




	//UC: Add
	public void Add() throws gException
	{
		String result = "";
		try
		{
			result = amanatService.Add(baseEntity);

			ResetBaseObject();


			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت امانت کتاب با موفقیت انجام شد");

		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}




	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters




}
