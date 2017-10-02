package com.unimelb.project.tableModel;

import java.io.Serializable;
import java.util.Date;

public class ApiReturn implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Api return information table attributes
	private int retrunInfoId;
	private String returnInfo;
	private String source;
	private int staff;
	private Date requestTime;

	// API return info Constructor
	public ApiReturn() {

	}

	// API return info Constructor
	public ApiReturn(String returnInfo, String source, int staff, Date requestTime) {
		this.returnInfo = returnInfo;
		this.source = source;
		this.staff = staff;
		this.requestTime = requestTime;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @return the staff
	 */
	public int getStaff() {
		return staff;
	}

	/**
	 * @param staff
	 *            the staff to set
	 */
	public void setStaff(int staff) {
		this.staff = staff;
	}

	/**
	 * @return the requestTime
	 */
	public Date getRequestTime() {
		return requestTime;
	}

	/**
	 * @param requestTime
	 *            the requestTime to set
	 */
	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	/**
	 * @param retrunInfoId
	 *            the retrunInfoId to set
	 */
	public void setRetrunInfoId(int retrunInfoId) {
		this.retrunInfoId = retrunInfoId;
	}

	/**
	 * @param returnInfo
	 *            the returnInfo to set
	 */
	public void setReturnInfo(String returnInfo) {
		this.returnInfo = returnInfo;
	}

	/**
	 * @return the retrunInfoId
	 */
	public int getRetrunInfoId() {
		return retrunInfoId;
	}

	/**
	 * @return the returnInfo
	 */
	public String getReturnInfo() {
		return returnInfo;
	}

}
