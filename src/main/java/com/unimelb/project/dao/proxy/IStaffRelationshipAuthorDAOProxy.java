package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.IStaffRelationshipAuthorDAO;
import com.unimelb.project.dao.impl.IStaffRelationshipAuthorDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.StaffRelationshipAuthor;

public class IStaffRelationshipAuthorDAOProxy implements IStaffRelationshipAuthorDAO {
	
	private DataBaseConnection dbc = null;
	private IStaffRelationshipAuthorDAO dao = null;

	public IStaffRelationshipAuthorDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IStaffRelationshipAuthorDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(StaffRelationshipAuthor staffRelationshipAuthor) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(staffRelationshipAuthor);
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

	public boolean check(int paper, int staff,String author) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.check(paper,staff,author);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
