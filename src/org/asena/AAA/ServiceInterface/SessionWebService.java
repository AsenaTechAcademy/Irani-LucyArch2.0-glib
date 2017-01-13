
package org.asena.AAA.ServiceInterface;

import java.util.List;

import org.asena.baseService.baseUCService;
import org.asena.common.exception.gException;
import org.asena.AAA.Entity.Aasession;

public interface SessionWebService extends baseUCService<Aasession>
{
	public List<Aasession> FindAllSessions();

	public List<Aasession> FindAllSessions(String username) throws gException, Exception;
}

