
package org.asena.AAA.Controller;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.asena.AAA.ServiceInterface.PageVisitWebService;
import org.asena.common.SessionManager;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aaaccesslist;
import org.primefaces.model.menu.DefaultMenuItem;
import org.primefaces.model.menu.DefaultMenuModel;
import org.primefaces.model.menu.DefaultSubMenu;
import org.primefaces.model.menu.MenuModel;
import org.springframework.beans.factory.annotation.Autowired;


@ManagedBean(name = "LoadPageMB")
@SessionScoped
public class LoadPageMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -2246969729185570937L;

	@Autowired
	PageVisitWebService pageVisitService;

	public LoadPageMB()
	{
	}

	public void checkPageAccess() throws IOException
	{
		// check validity of Session (isLogined)
		if (!SessionManager.sessionExist())
		{
			SessionManager.Invalidate();
			FacesContext.getCurrentInstance().getExternalContext()
						.redirect(SessionManager.getRequest().getContextPath() + "/view/Login.xhtml");
			return;
		}

		String url = FacesContext.getCurrentInstance().getViewRoot().getViewId();

		// check user access to url
		List<Aaaccesslist> roleAccessList = SessionManager.getAccessList();
		for (Aaaccesslist aa : roleAccessList)
		{
			if (aa.getAapage().getUrl().equals(url))
			{
				SessionManager.setPageId(aa.getAapage().getId());

				// set page visit
				pageVisitService.Add(aa.getAapage().getId(), SessionManager.getSessionId());

				return;
			}
		}

		// user does not access
		SessionManager.Invalidate();
		FacesContext.getCurrentInstance().getExternalContext()
					.redirect(SessionManager.getRequest().getContextPath() + "/view/Login.xhtml");
		return;
	}


	private MenuModel model = CreateMenu();

	private MenuModel CreateMenu()
	{
		if (!SessionManager.sessionExist())
			return null;

		model = new DefaultMenuModel();
		List<Aaaccesslist> roleAccessList = SessionManager.getAccessList();
		List<String> printedCats = new ArrayList<String>();

		DefaultSubMenu submenu = null;
		for (Aaaccesslist aa : roleAccessList)
		{
			String catName = aa.getAapage().getAapagecat().getName();
			if (!printedCats.contains(catName))
			{
				printedCats.add(catName);
				if (!(null == submenu))
					model.addElement(submenu);
				submenu = new DefaultSubMenu(catName);
			}
			DefaultMenuItem item = new DefaultMenuItem(aa.getAapage().getName());
			//item.setIcon("ui-icon-home");
			item.setOutcome(aa.getAapage().getUrl());
			item.setAjax(false);
			item.setStyleClass("LeftMenumenuitem");
			submenu.addElement(item);
		}
		if (!(null == submenu))
		{
			DefaultMenuItem item = new DefaultMenuItem("خروج از سیستم");
			//item.setIcon("ui-icon-home");
			item.setCommand("#{LoginMB.Logout}");
			item.setAjax(false);
			item.setStyleClass("LeftMenumenuitem");
			submenu.addElement(item);
			model.addElement(submenu);
		}


		return model;
	}

	public MenuModel getUserMenu()
	{
		return model;
	}


}
