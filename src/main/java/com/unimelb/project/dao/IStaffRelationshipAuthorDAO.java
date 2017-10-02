package com.unimelb.project.dao;

import com.unimelb.project.tableModel.StaffRelationshipAuthor;

public interface IStaffRelationshipAuthorDAO {
	public boolean doCreate(StaffRelationshipAuthor staffRelationshipAuthor) throws Exception;

	public boolean doDelete(int id) throws Exception;

}
