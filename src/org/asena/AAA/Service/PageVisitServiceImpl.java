
package org.asena.AAA.Service;

import org.asena.AAA.ServiceInterface.PageVisitWebService;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.gCal;
import org.asena.AAA.Entity.Aapage;
import org.asena.AAA.Entity.Aapagevisit;
import org.asena.AAA.Entity.Aasession;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PageVisitServiceImpl extends baseUCServiceImpl<Aapagevisit> implements PageVisitWebService
{

	@Override
	@Transactional
	public void Add(long PageId, long SessionId)
	{
		Aapage page = em.find(Aapage.class, PageId);
		Aasession session = em.find(Aasession.class, SessionId);

		Aapagevisit aapagevisit = new Aapagevisit();
		aapagevisit.setAapage(page);
		aapagevisit.setAasession(session);
		aapagevisit.setIndate(gCal.getCurrentDateTime());
		em.persist(aapagevisit);
	}

}
