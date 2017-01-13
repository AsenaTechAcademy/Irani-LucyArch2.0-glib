package org.asena.glib.Service;

import org.asena.glib.ServiceInterface.MembertypeUCService;
import org.asena.glib.Entity.Membertype;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MembertypeServiceImpl extends baseUCServiceImpl<Membertype> implements MembertypeUCService
{

	@Override
	@Transactional
	public String Add(Membertype entity) throws Exception, gException 
	{

		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Membertype Edit(Membertype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Membertype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
