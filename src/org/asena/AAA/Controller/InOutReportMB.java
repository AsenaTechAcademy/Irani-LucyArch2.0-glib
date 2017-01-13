
package org.asena.AAA.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.asena.AAA.ServiceInterface.SessionWebService;
import org.asena.common.baseManagedBean;
import org.asena.AAA.Entity.Aasession;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "InOutReportMB")
@SessionScoped

public class InOutReportMB extends baseManagedBean implements Serializable
{
	private static final long serialVersionUID = -2378009417143775751L;

	public InOutReportMB()
	{
	}

	//Services
	@Autowired
	private SessionWebService sessionService;

	private List<Aasession> sessionList;

	@Override
	public void init()
	{
		super.init();
		sessionList = sessionService.FindAllSessions();
	}


	//UC: report user sessions
	public List<Aasession> FindAllSessions()
	{
		return sessionList;
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters


}
