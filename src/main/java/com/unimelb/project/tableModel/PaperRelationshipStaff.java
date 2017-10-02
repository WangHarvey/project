package com.unimelb.project.tableModel;

import java.io.Serializable;

public class PaperRelationshipStaff implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Paper and Staff relationship table attributes
	private int paperRelationshipStaffId;
	private int paper;
	private int staff;
	
	// Paper and Staff relationship Constructor
	public PaperRelationshipStaff(int paper, int staff) {
		this.paper = paper;
		this.staff = staff;
	}

	public PaperRelationshipStaff() {

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
	 * @return the staff
	 */
	public int getStaff() {
		return staff;
	}

	/**
	 * @param staff the staff to set
	 */
	public void setStaff(int staff) {
		this.staff = staff;
	}

	/**
	 * @return the paperRelationshipStaffId
	 */
	public int getPaperRelationshipStaffId() {
		return paperRelationshipStaffId;
	}

	/**
	 * @param paperRelationshipStaffId the paperRelationshipStaffId to set
	 */
	public void setPaperRelationshipStaffId(int paperRelationshipStaffId) {
		this.paperRelationshipStaffId = paperRelationshipStaffId;
	}
	

}
