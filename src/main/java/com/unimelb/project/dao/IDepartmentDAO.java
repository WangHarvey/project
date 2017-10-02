package com.unimelb.project.dao;

import com.unimelb.project.tableModel.Department;

public interface IDepartmentDAO {
	public boolean doCreate(Department department) throws Exception;

	public boolean doUpdate(Department department) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public Department findById(int id) throws Exception;

}
