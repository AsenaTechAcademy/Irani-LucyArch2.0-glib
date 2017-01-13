
package org.asena.baseService;

import java.util.List;

import org.asena.common.exception.gException;


public interface baseUCService<T>
{
	public String Add(T entity) throws Exception, gException;

	public T Edit(T entity) throws Exception, gException;

	public void Remove(T entity) throws Exception, gException;

	public List<T> FindAll();

	public List<T> FindAll(String oderField, String AscDesc);

	List<T> FindAll(String orderField, String AscDesc, String orderField2, String AscDesc2);

	public List<T> FindAll(int pageNumber, int pageSize);

	public T FindbyId(long Id);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String orderField, String AscDesc);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String orderField, String AscDesc,
				String orderField2, String AscDesc2);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2, String orderField, String AscDesc);

	public List<T> FindbyFields(String fieldName, String operation, Object fieldValue, String fieldName2, String operation2,
				Object fieldValue2, String orderField, String AscDesc, String orderField2, String AscDesc2);


}
