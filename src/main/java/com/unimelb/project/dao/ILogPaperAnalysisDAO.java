package com.unimelb.project.dao;

import com.unimelb.project.tableModel.LogPaperAnalysis;

public interface ILogPaperAnalysisDAO {
	public boolean doCreate(LogPaperAnalysis logPaperAnalysis) throws Exception;

	public LogPaperAnalysis findById(int id) throws Exception;
	
	public LogPaperAnalysis findLast() throws Exception;

}
