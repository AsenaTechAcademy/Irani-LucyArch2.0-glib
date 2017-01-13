
package org.asena.AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.RoleWebService;
import org.asena.AAA.ServiceInterface.UserWebService;
import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.exception.gException;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aarole;
import org.asena.AAA.Entity.Aauser;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "UserMB")
@SessionScoped

public class UserMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = 123434643565L;

	public UserMB()
	{
	}

	@Override
	public void init()
	{
		super.init();
		userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
	}


	//base Object (to Add/Edit/Remove)
	private Aauser user;
	//base Object List (to Data Table)
	private List<Aauser> userList;


	//base Object and List (1-* objects)
	private Aarole role;

	public List<Aarole> FindAll_Aarole()
	{
		return roleService.FindAll();
	}


	@Autowired
	private UserWebService userService;
	@Autowired
	private RoleWebService roleService;


	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();
		user = new Aauser();
		role = new Aarole();
		user.setAarole(role);
	}


	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		String s = "";
		try
		{
			if (isedit)
				userService.Edit(user);
			else
				s = userService.Add(user);

			ResetBaseObject();
			userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
			if (s.length() >= 1)
				JSFHelper.addInfoMessage(s);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}

	//UC: Remove
	public void Remove(Aauser user)
	{
		try
		{
			userService.Remove(user);
			userList = userService.FindAll("aarole.name", JPAOp.Asc, "username", JPAOp.Asc);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    for Data Table 
	public void setSelectedRow(Aauser selectedrow)
	{
		this.user = selectedrow; // set selected row to base Object
		isedit = true; // set editable to true
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ setter & getter

	public Aauser getUser()
	{
		return user;
	}

	public void setUser(Aauser user)
	{
		this.user = user;
	}

	public List<Aauser> getUserList()
	{
		return userList;
	}

	public void setUserList(List<Aauser> userList)
	{
		this.userList = userList;
	}

	public Aarole getRole()
	{
		return role;
	}

	public void setRole(Aarole role)
	{
		this.role = role;
	}



}
