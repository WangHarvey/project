package com.unimelb.project.dao.proxy;

import com.unimelb.project.dao.ILogPaperAnalysisDAO;
import com.unimelb.project.dao.impl.ILogPaperAnalysisDAOImpl;
import com.unimelb.project.dbc.DataBaseConnection;
import com.unimelb.project.tableModel.LogPaperAnalysis;

public class ILogPaperAnalysisDAOProxy implements ILogPaperAnalysisDAO {
	private DataBaseConnection dbc = null;
	private ILogPaperAnalysisDAO dao = null;
	
	public ILogPaperAnalysisDAOProxy() {
		this.dbc = new DataBaseConnection();
		this.dao = new ILogPaperAnalysisDAOImpl(this.dbc.getConnection());
	}

	public boolean doCreate(LogPaperAnalysis logPaperAnalysis) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = true;
		try {
			flag = this.dao.doCreate(logPaperAnalysis);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return flag;
	}

	public LogPaperAnalysis findById(int id) throws Exception {
		// TODO Auto-generated method stub
		LogPaperAnalysis logPaperAnalysis = null;
		try {
			logPaperAnalysis = this.dao.findById(id);
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return logPaperAnalysis;
	}

	public LogPaperAnalysis findLast() throws Exception {
		// TODO Auto-generated method stub
		LogPaperAnalysis logPaperAnalysis = null;
		try {
			logPaperAnalysis = this.dao.findLast();
		} catch (Exception e) {
			throw e;
		} finally {
			this.dbc.close();
		}
		return logPaperAnalysis;
	}

}
