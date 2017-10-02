package com.unimelb.project.dao;

import java.util.List;

import com.unimelb.project.tableModel.Paper;

public interface IPaperDAO {
	public boolean doCreate(Paper paper) throws Exception;

	public boolean doUpdate(Paper paper) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public Paper findByTitle(String title) throws Exception;
	
	public Paper findById(int id) throws Exception;
	
	public List<Paper> findAll() throws Exception;

}
