package com.unimelb.project.dao;

import java.util.List;

import com.unimelb.project.tableModel.Staff;

public interface IStaffDAO {

	public boolean doCreate(Staff staff) throws Exception;

	public boolean doUpdate(Staff staff) throws Exception;

	public boolean doDelete(int id) throws Exception;

	public Staff findById(int id) throws Exception;

	public List<Staff> findByName(String name) throws Exception;

}
