package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.ILogApiAnalysisDAO;
import com.unimelb.project.dao.impl.ILogApiAnalysisDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.LogApiAnalysis;

public class ILogApiAnalysisDAOProxy implements ILogApiAnalysisDAO {
	private DataBaseConnection dbc = null;
	private ILogApiAnalysisDAO dao = null;
	
	public ILogApiAnalysisDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new ILogApiAnalysisDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(LogApiAnalysis logApiAnalysis) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(logApiAnalysis);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public LogApiAnalysis findById(int id) throws Exception {
		// TODO Auto-generated method stub
		LogApiAnalysis logApiAnalysis = null;
		try {
			logApiAnalysis = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return logApiAnalysis;
	}

	public LogApiAnalysis findLast() throws Exception {
		// TODO Auto-generated method stub
		LogApiAnalysis logApiAnalysis = null;
		try {
			logApiAnalysis = this.dao.findLast();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return logApiAnalysis;
	}

}
