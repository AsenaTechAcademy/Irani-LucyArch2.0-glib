
package org.asena.AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.PageCatWebService;
import org.asena.AAA.ServiceInterface.PageWebService;
import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.exception.gException;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aapage;
import org.asena.AAA.Entity.Aapagecat;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "PageMB")
@SessionScoped

public class PageMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 143982505490022806L;

	public PageMB()
	{
	}

	@Override
	public void init()
	{
		super.init();
		aapageList = pageService.FindAll("aapagecat.orders", JPAOp.Asc, "orders", JPAOp.Asc);
	}


	//base Object (to Add/Edit/Remove)
	private Aapage aapage;
	//base Object List (to Data Table)
	private List<Aapage> aapageList;


	//base Object and List (1-* objects)
	private Aapagecat aapagecat;

	public List<Aapagecat> FindAll_Aapagecat()
	{
		return pagecatService.FindAll();
	}


	@Autowired
	private PageWebService pageService;
	@Autowired
	private PageCatWebService pagecatService;


	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();
		aapage = new Aapage();
		aapagecat = new Aapagecat();
		aapage.setAapagecat(aapagecat);
	}


	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		try
		{

			if (isedit)
				pageService.Edit(aapage);
			else
				pageService.Add(aapage);

			ResetBaseObject();
			aapageList = pageService.FindAll("aapagecat.orders", JPAOp.Asc, "orders", JPAOp.Asc);
			JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}

	//UC: Remove
	public void Remove(Aapage aapage)
	{
		try
		{
			pageService.Remove(aapage);
			aapageList = pageService.FindAll("aapagecat.orders", JPAOp.Asc, "orders", JPAOp.Asc);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    for Data Table 
	public void setSelectedRow(Aapage selectedrow)
	{
		this.aapage = selectedrow; // set selected row to base Object
		isedit = true; // set editable to true
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter

	public Aapage getAapage()
	{
		return aapage;
	}

	public void setAapage(Aapage aapage)
	{
		this.aapage = aapage;
	}

	public List<Aapage> getAapageList()
	{
		return aapageList;
	}

	public void setAapageList(List<Aapage> aapageList)
	{
		this.aapageList = aapageList;
	}

	public Aapagecat getAapagecat()
	{
		return aapagecat;
	}

	public void setAapagecat(Aapagecat aapagecat)
	{
		this.aapagecat = aapagecat;
	}



}
