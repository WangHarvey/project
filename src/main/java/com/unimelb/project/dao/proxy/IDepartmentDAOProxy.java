package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.IDepartmentDAO;
import com.unimelb.project.dao.impl.IDepartmentDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.Department;

public class IDepartmentDAOProxy implements IDepartmentDAO {
	private DataBaseConnection dbc = null;
	private IDepartmentDAO dao = null;

	public IDepartmentDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IDepartmentDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Department department) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(department);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Department department) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doUpdate(department);
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

	public Department findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Department department = null;
		try {
			department = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return department;
	}

}
