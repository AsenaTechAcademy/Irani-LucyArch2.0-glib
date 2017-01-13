
package org.asena.AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.RoleWebService;
import org.asena.common.JSFHelper;
import org.asena.common.exception.gException;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aarole;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "RoleMB")
@SessionScoped

public class RoleMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 46451716598739286L;

	public RoleMB()
	{
	}

	@Override
	public void init()
	{
		super.init();
		roleList = roleService.FindAll();
	}


	//base Object (to Add/Edit/Remove)
	private Aarole role;
	//base Object List (to Data Table)
	private List<Aarole> roleList;


	@Autowired
	private RoleWebService roleService;


	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();
		role = new Aarole();
	}


	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		try
		{
			if (isedit)
				roleService.Edit(role);
			else
				roleService.Add(role);

			ResetBaseObject();
			roleList = roleService.FindAll();
			JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}

	//UC: Remove
	public void Remove(Aarole role)
	{
		try
		{
			roleService.Remove(role);
			roleList = roleService.FindAll();
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    for Data Table 
	public void setSelectedRow(Aarole selectedrow)
	{
		this.role = selectedrow; // set selected row to base Object
		isedit = true; // set editable to true
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter
	public Aarole getRole()
	{
		return role;
	}

	public void setRole(Aarole role)
	{
		this.role = role;
	}

	public List<Aarole> getRoleList()
	{
		return roleList;
	}

	public void setRoleList(List<Aarole> roleList)
	{
		this.roleList = roleList;
	}



}
