package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.IStaffRelationshipStaffDAO;
import com.unimelb.project.dao.impl.IStaffRelationshipStaffDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.StaffRelationshipStaff;

public class IStaffRelationshipStaffDAOProxy implements IStaffRelationshipStaffDAO {
	private DataBaseConnection dbc = null;
	private IStaffRelationshipStaffDAO dao = null;

	public IStaffRelationshipStaffDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IStaffRelationshipStaffDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(StaffRelationshipStaff staffRelationshipStaff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(staffRelationshipStaff);
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

}
