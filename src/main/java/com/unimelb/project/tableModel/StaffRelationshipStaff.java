package com.unimelb.project.tableModel;

import java.io.Serializable;

public class StaffRelationshipStaff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Staff and Staff relationship table attributes
	private int staffRelationshipStaffId;
	private int staff1;
	private int paper;
	private int staff2;
	
	// Staff and Staff relationship Constructor
	public StaffRelationshipStaff(int staff1, int paper, int staff2) {
		this.staff1 = staff1;
		this.paper = paper;
		this.staff2 = staff2;
	}

	/**
	 * @return the staff1
	 */
	public int getStaff1() {
		return staff1;
	}

	/**
	 * @param staff1 the staff1 to set
	 */
	public void setStaff1(int staff1) {
		this.staff1 = staff1;
	}

	/**
	 * @return the paper
	 */
	public int getPaper() {
		return paper;
	}

	/**
	 * @param paper the paper to set
	 */
	public void setPaper(int paper) {
		this.paper = paper;
	}

	/**
	 * @return the staff2
	 */
	public int getStaff2() {
		return staff2;
	}

	/**
	 * @param staff2 the staff2 to set
	 */
	public void setStaff2(int staff2) {
		this.staff2 = staff2;
	}

	/**
	 * @return the staffRelationshipStaffId
	 */
	public int getStaffRelationshipStaffId() {
		return staffRelationshipStaffId;
	}
	

}
