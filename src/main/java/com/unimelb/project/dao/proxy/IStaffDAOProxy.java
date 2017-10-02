package com.unimelb.project.dao.proxy;

import java.util.List;

import com.unimelb.project.dao.IStaffDAO;
import com.unimelb.project.dao.impl.IStaffDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.Staff;

public class IStaffDAOProxy implements IStaffDAO {
	private DataBaseConnection dbc = null;
	private IStaffDAO dao = null;

	public IStaffDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IStaffDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(staff);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doUpdate(staff);
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

	public Staff findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Staff staff = null;
		try {
			staff = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return staff;
	}

	public List<Staff> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Staff> all = null;
		try {
			all = this.dao.findByName(name);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

}
