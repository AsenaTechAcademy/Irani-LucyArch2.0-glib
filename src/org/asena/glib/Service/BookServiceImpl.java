package org.asena.glib.Service;

import org.asena.glib.ServiceInterface.BookUCService;
import org.asena.glib.Entity.Book;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class BookServiceImpl extends baseUCServiceImpl<Book> implements BookUCService
{

	@Override
	@Transactional
	public String Add(Book entity) throws Exception, gException 
	{

		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Book Edit(Book entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Book entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
