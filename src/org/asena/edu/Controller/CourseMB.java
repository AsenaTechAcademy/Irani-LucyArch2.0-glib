
package org.asena.edu.Controller;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.asena.baseService.JPAOp;
import org.asena.common.JSFHelper;
import org.asena.common.baseManagedBeanController;
import org.asena.common.exception.gException;
import org.asena.edu.Entity.Course;
import org.asena.edu.Entity.Coursetype;
import org.asena.edu.ServiceInterface.CourseUCService;
import org.asena.edu.ServiceInterface.CoursetypeUCService;
import org.springframework.beans.factory.annotation.Autowired;

@ManagedBean(name = "CourseMB")
@ViewScoped

public class CourseMB extends baseManagedBeanController<Course> implements Serializable
{
	private static final long serialVersionUID = 7175342648505956385L;

	public CourseMB()
	{
	}


	//Services Deceleration
	@Autowired
	private CourseUCService courseService;

	@Autowired
	private CoursetypeUCService coursetypeService;




	//base Object, relations Lists (1-* objects)
	public List<Coursetype> FindAll_Coursetype()
	{
		return coursetypeService.FindAll("id", JPAOp.Asc);
	}



	@Override
	protected void ResetBaseObject()
	{
		super.ResetBaseObject();

		// new Base Object 
		baseEntity = new Course();

		// new other Objects and set them into Base object
		if (null == baseEntity.getCoursetype())
			baseEntity.setCoursetype(new Coursetype());


		// refresh Lists
		baseEntityList = courseService.FindAll("coursetype", JPAOp.Asc, "id", JPAOp.Asc);
	}




	//UC: Add/Edit
	public void AddEdit() throws gException
	{
		String result = "";
		try
		{
			if (isedit)
				courseService.Edit(baseEntity);
			else
				result = courseService.Add(baseEntity);

			ResetBaseObject();


			if (result.length() >= 1)
				JSFHelper.addInfoMessage(result);
			else
				JSFHelper.addInfoMessage("عملیات ثبت / ویرایش اطلاعات با موفقیت انجام شد");

		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}

	}




	//UC: Remove
	public void Remove(Course baseEntity)
	{
		try
		{
			courseService.Remove(baseEntity);
			ResetBaseObject();
			JSFHelper.addInfoMessage("عملیات حذف اطلاعات با موفقیت انجام شد.");
		}
		catch (Exception ex)
		{
			CallCatch(ex);
		}
	}




	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters
	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@    Setters & Getters




}
