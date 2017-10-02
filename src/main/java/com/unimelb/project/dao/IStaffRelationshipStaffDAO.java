package com.unimelb.project.dao;

import com.unimelb.project.tableModel.StaffRelationshipStaff;

public interface IStaffRelationshipStaffDAO {
	public boolean doCreate(StaffRelationshipStaff staffRelationshipStaff) throws Exception;

	public boolean doDelete(int id) throws Exception;

}
