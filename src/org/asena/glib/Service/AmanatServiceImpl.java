package org.asena.glib.Service;

import org.asena.glib.ServiceInterface.AmanatUCService;
import org.asena.glib.Entity.Amanat;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class AmanatServiceImpl extends baseUCServiceImpl<Amanat> implements AmanatUCService
{

	@Override
	@Transactional
	public String Add(Amanat entity) throws Exception, gException 
	{

		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Amanat Edit(Amanat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Amanat entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
