package com.unimelb.project.dao;

import java.util.List;

import com.unimelb.project.tableModel.PaperRelationshipStaff;

public interface IPaperRelationshipStaffDAO {
	public boolean doCreate(PaperRelationshipStaff paperRelationshipStaff) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public List<PaperRelationshipStaff> findByPaper(int paper) throws Exception;
	
	public boolean check(int paper,int staff) throws Exception;

}
