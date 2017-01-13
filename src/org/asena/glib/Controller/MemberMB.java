
package org.asena.glib.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBeanController;
import org.asena.common.exception.gException;
import org.asena.glib.Entity.Member;
import org.asena.glib.Entity.Membertype;
import org.asena.glib.ServiceInterface.MemberUCService;
import org.asena.glib.ServiceInterface.MembertypeUCService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "MemberMB")
@ViewScoped

public class MemberMB extends baseManagedBeanController<Member> implements Serializable
{
	private static final long serialVersionUID = 7175342648505956385L;

	public MemberMB()
	{
	}


	//Services Deceleration
	@Autowired
	private MemberUCService memberService;

	@Autowired
	private MembertypeUCService membertypeService;




	//base Object, relations Lists (1-* objects)
	public List<Membertype> FindAll_Membertype()
	{
		return membertypeService.FindAll("id", JPAOp.Asc);
	}



	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Member();

		// new other Objects and set them into Base object
		if (null == baseEntity.getMembertype())
			baseEntity.setMembertype(new Membertype());


		// refresh Lists
		baseEntityList = memberService.FindAll("membertype", JPAOp.Asc, "id", JPAOp.Asc);
	}




	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		String result = "";
		try
		{
			if (isedit)
				memberService.Edit(baseEntity);
			else
				result = memberService.Add(baseEntity);

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
	public void Remove(Member baseEntity)
	{
		try
		{
			memberService.Remove(baseEntity);
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
