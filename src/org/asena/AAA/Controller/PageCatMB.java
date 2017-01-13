
package org.asena.AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.PageCatWebService;
import org.asena.common.JSFHelper;
import org.asena.common.exception.gException;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aapagecat;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "PageCatMB")
@SessionScoped

public class PageCatMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -3522164485946980304L;

	public PageCatMB()
	{
	}

	@Override
	public void init()
	{
		super.init();
		aapagecatList = pageCatService.FindAll();
	}


	//base Object (to Add/Edit/Remove)
	private Aapagecat aapagecat;
	//base Object List (to Data Table)
	private List<Aapagecat> aapagecatList;


	@Autowired
	private PageCatWebService pageCatService;


	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();
		aapagecat = new Aapagecat();
	}


	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		try
		{

			if (isedit)
				pageCatService.Edit(aapagecat);
			else
				pageCatService.Add(aapagecat);

			ResetBaseObject();
			aapagecatList = pageCatService.FindAll();
			JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}

	//UC: Remove
	public void Remove(Aapagecat aapagecat)
	{
		try
		{
			pageCatService.Remove(aapagecat);
			aapagecatList = pageCatService.FindAll();
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    for Data Table 
	public void setSelectedRow(Aapagecat selectedrow)
	{
		this.aapagecat = selectedrow; // set selected row to base Object
		isedit = true; // set editable to true
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter
	public Aapagecat getAapagecat()
	{
		return aapagecat;
	}

	public void setAapagecat(Aapagecat aapagecat)
	{
		this.aapagecat = aapagecat;
	}

	public List<Aapagecat> getAapagecatList()
	{
		return aapagecatList;
	}

	public void setAapagecatList(List<Aapagecat> aapagecatList)
	{
		this.aapagecatList = aapagecatList;
	}



}
