
package org.asena.AAA.ServiceInterface;

import org.asena.baseService.baseUCService;
import org.asena.common.exception.gException;
import org.asena.AAA.Entity.Aaaccesslist;

public interface AccessListWebService extends baseUCService<Aaaccesslist>
{
	public void Add(long RoleId, long Pages[]) throws gException, Exception;
}
