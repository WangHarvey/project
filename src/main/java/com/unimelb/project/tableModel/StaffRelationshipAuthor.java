package com.unimelb.project.tableModel;

import java.io.Serializable;

public class StaffRelationshipAuthor implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Staff and author relationship table attributes
	private int staffRelationshipauthorId;
	private int staff;
	private int paper;
	private int author;
	
	public StaffRelationshipAuthor(int staff, int paper, int author) {
		this.staff = staff;
		this.paper = paper;
		this.author = author;
	}

	/**
	 * @return the staffRelationshipauthorId
	 */
	public int getStaffRelationshipauthorId() {
		return staffRelationshipauthorId;
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
	 * @return the author
	 */
	public int getAuthor() {
		return author;
	}

	/**
	 * @param author the author to set
	 */
	public void setAuthor(int author) {
		this.author = author;
	}
	
	

}
