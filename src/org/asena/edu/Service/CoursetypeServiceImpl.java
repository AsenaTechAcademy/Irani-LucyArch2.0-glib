package org.asena.edu.Service;

import org.asena.edu.ServiceInterface.CoursetypeUCService;
import org.asena.edu.Entity.Coursetype;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CoursetypeServiceImpl extends baseUCServiceImpl<Coursetype> implements CoursetypeUCService
{

	@Override
	@Transactional
	public String Add(Coursetype entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Coursetype Edit(Coursetype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Coursetype entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
