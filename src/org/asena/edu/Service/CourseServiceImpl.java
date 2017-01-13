package org.asena.edu.Service;

import org.asena.edu.ServiceInterface.CourseUCService;
import org.asena.edu.Entity.Course;
import org.asena.baseService.baseUCServiceImpl;
import org.asena.common.exception.gException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CourseServiceImpl extends baseUCServiceImpl<Course> implements CourseUCService
{

	@Override
	@Transactional
	public String Add(Course entity) throws Exception, gException 
	{
		//do Business Logic HERE


		return super.Add(entity);
	}



	@Override
	@Transactional
	public Course Edit(Course entity)  throws Exception,gException
	{

		//do Business Logic HERE


		return super.Edit(entity);
	}



	@Override
	@Transactional
	public void Remove(Course entity)  throws Exception,gException
	{

		//do Business Logic HERE


		super.Remove(entity);
	}


}
