package com.unimelb.project.tableModel;

import java.io.Serializable;

public class Department implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// // Department table attributes
	private int departmentid;
	private String departmentName;
	private String departmentInfo;
	
	// Department Constructor with department info
	public Department(String departmentName, String departmentInfo) {
		this.departmentName = departmentName;
		this.departmentInfo = departmentInfo;
	}

	public Department() {
		
	}

	/**
	 * @param departmentid the departmentid to set
	 */
	public void setDepartmentid(int departmentid) {
		this.departmentid = departmentid;
	}

	/**
	 * @return the departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}

	/**
	 * @param departmentName the departmentName to set
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	/**
	 * @return the departmentInfo
	 */
	public String getDepartmentInfo() {
		return departmentInfo;
	}

	/**
	 * @param departmentInfo the departmentInfo to set
	 */
	public void setDepartmentInfo(String departmentInfo) {
		this.departmentInfo = departmentInfo;
	}

	/**
	 * @return the departmentid
	 */
	public int getDepartmentid() {
		return departmentid;
	}
	
	

}
