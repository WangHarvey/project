package com.unimelb.project.dao;

import com.unimelb.project.tableModel.ApiReturn;

public interface IApiReturnDAO {
	public boolean doCreate(ApiReturn apiReturn) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public ApiReturn findById(int id) throws Exception;
	
	public ApiReturn findLast() throws Exception;

}
