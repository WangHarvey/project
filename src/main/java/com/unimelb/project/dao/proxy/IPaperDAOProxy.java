package com.unimelb.project.dao.proxy;

import java.util.List;

import com.unimelb.project.dao.IPaperDAO;
import com.unimelb.project.dao.impl.IPaperDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.Paper;

public class IPaperDAOProxy implements IPaperDAO {
	private DataBaseConnection dbc = null;
	private IPaperDAO dao = null;

	public IPaperDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new IPaperDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(Paper paper) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(paper);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public boolean doUpdate(Paper paper) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(paper);
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

	public Paper findByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		Paper paper = null;
		try {
			paper = this.dao.findByTitle(title);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return paper;
	}

	public Paper findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Paper paper = null;
		try {
			paper = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return paper;
	}

	public List<Paper> findAll() throws Exception {
		// TODO Auto-generated method stub
		List<Paper> paperList = null;
		try {
			paperList = this.dao.findAll();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return paperList;
	}

}
