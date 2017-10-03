package com.unimelb.project.dao.proxy;

import java.util.List;

import com.unimelb.project.dao.IPaperRelationshipStaffDAO;
import com.unimelb.project.dao.impl.IPaperRelationshipStaffDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.PaperRelationshipStaff;

public class IPaperRelationshipStaffDAOProxy implements IPaperRelationshipStaffDAO {
	private DataBaseConnection dbc = null;
	private IPaperRelationshipStaffDAO dao = null;

	public IPaperRelationshipStaffDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IPaperRelationshipStaffDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(PaperRelationshipStaff paperRelationshipStaff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(paperRelationshipStaff);
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

	public List<PaperRelationshipStaff> findByPaper(int paper) throws Exception {
		// TODO Auto-generated method stub
		List<PaperRelationshipStaff> all = null;
		try {
			all = this.dao.findByPaper(paper);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return all;
	}

	public boolean check(int paper, int staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.check(paper,staff);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

}
