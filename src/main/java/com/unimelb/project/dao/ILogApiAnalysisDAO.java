package com.unimelb.project.dao;

import com.unimelb.project.tableModel.LogApiAnalysis;

public interface ILogApiAnalysisDAO {
	public boolean doCreate(LogApiAnalysis logApiAnalysis) throws Exception;

	public LogApiAnalysis findById(int id) throws Exception;
	
	public LogApiAnalysis findLast() throws Exception;

}
