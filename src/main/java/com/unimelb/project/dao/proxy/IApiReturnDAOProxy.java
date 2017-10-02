package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.IApiReturnDAO;
import com.unimelb.project.dao.impl.IApiReturnDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.ApiReturn;

public class IApiReturnDAOProxy implements IApiReturnDAO {
	private DataBaseConnection dbc = null;
	private IApiReturnDAO dao = null;

	public IApiReturnDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IApiReturnDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(ApiReturn apiReturn) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(apiReturn);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doDelete(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public ApiReturn findById(int id) throws Exception {
		// TODO Auto-generated method stub
		ApiReturn apiReturn = null;
		try {
			apiReturn = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return apiReturn;
	}

	public ApiReturn findLast() throws Exception {
		// TODO Auto-generated method stub
		ApiReturn apiReturn = null;
		try {
			apiReturn = this.dao.findLast();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return apiReturn;
	}

}
