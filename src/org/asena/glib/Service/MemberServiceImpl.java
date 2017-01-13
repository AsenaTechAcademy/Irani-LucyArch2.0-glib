package org.asena.glib.Service;

import org.asena.glib.ServiceInterface.MemberUCService;
import org.asena.glib.Entity.Member;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MemberServiceImpl extends baseUCServiceImpl<Member> implements MemberUCService
{

	@Override
	@Transactional
	public String Add(Member entity) throws Exception, gException 
	{

		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Member Edit(Member entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Member entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
