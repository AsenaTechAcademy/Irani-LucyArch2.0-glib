
package org.asena.AAA.ServiceInterface;

import org.asena.baseService.baseUCService;
import org.asena.AAA.Entity.Aapagevisit;

public interface PageVisitWebService extends baseUCService<Aapagevisit>
{
	public void Add(long PageId, long SessionId);
}
