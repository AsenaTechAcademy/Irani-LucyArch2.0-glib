
package org.asena.baseService;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.asena.common.exception.gException;
import org.springframework.transaction.annotation.Transactional;


public class baseUCServiceImpl<T> implements baseUCService<T>
{
	@PersistenceContext
	protected EntityManager em;


	private Class<T> Classtype;
	private String ClassName;

	@SuppressWarnings("unchecked")
	public baseUCServiceImpl()
	{
		Type t = getClass().getGenericSuperclass();
		ParameterizedType pt = null;
		if (getClass().toString().indexOf(t.toString()) != 0)
		{
			pt = (ParameterizedType) t;
			Classtype = (Class<T>) pt.getActualTypeArguments()[0];
			ClassName = Classtype.getSimpleName();
		}
	}



	@Override
	@Transactional
	public String Add(T entity) throws Exception, gException
	{
		em.persist(entity);
		return "";
	}


	@Override
	@Transactional
	public T Edit(T entity) throws Exception, gException
	{
		return em.merge(entity);
	}


	@Override
	@Transactional
	public void Remove(T entity) throws Exception, gException
	{
		//em.remove(entity);   //for eclipselink
		em.remove(em.contains(entity) ? entity : em.merge(entity)); // for Hibernate
	}



	//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@ Finders 
	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation + ":FieldValue");
		query.setParameter("FieldValue", fieldValue);
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation + ":FieldValue"
					+ " AND e." + fieldName2 + operation2 + ":FieldValue2");
		query.setParameter("FieldValue", fieldValue);
		query.setParameter("FieldValue2", fieldValue2);
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2, String orderField, String AscDesc)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation + ":FieldValue"
					+ " AND e." + fieldName2 + operation2 + ":FieldValue2" + " ORDER BY e." + orderField + AscDesc);
		query.setParameter("FieldValue", fieldValue);
		query.setParameter("FieldValue2", fieldValue2);
		return (List<T>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2, String orderField, String AscDesc, String orderField2, String AscDesc2)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation + ":FieldValue"
					+ " AND e." + fieldName2 + operation2 + ":FieldValue2" + " ORDER BY e." + orderField + AscDesc + ","
					+ orderField2 + AscDesc2);
		query.setParameter("FieldValue", fieldValue);
		query.setParameter("FieldValue2", fieldValue2);
		return (List<T>) query.getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String orderField, String AscDesc)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation
					+ ":FieldValue ORDER BY e." + orderField + AscDesc);
		query.setParameter("FieldValue", fieldValue);
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String orderField, String AscDesc,
				String orderField2, String AscDesc2)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e." + fieldName + operation
					+ ":FieldValue ORDER BY e." + orderField + AscDesc + "," + orderField2 + AscDesc2);
		query.setParameter("FieldValue", fieldValue);
		return (List<T>) query.getResultList();
	}



	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T FindbyId(long Id)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e WHERE e.id=:id");
		query.setParameter("id", Id);
		return (T) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindAll(String orderField, String AscDesc)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e ORDER BY e." + orderField + AscDesc);
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindAll(String orderField, String AscDesc, String orderField2, String AscDesc2)
	{
		Query query = em.createQuery(
					"SELECT e FROM " + ClassName + " e ORDER BY e." + orderField + AscDesc + ",e." + orderField2 + AscDesc2);
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindAll()
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e");
		return (List<T>) query.getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public List<T> FindAll(int pageNumber, int pageSize)
	{
		Query query = em.createQuery("SELECT e FROM " + ClassName + " e");
		query.setFirstResult((pageNumber - 1) * pageSize);
		query.setMaxResults(pageSize);
		return (List<T>) query.getResultList();
	}




}
