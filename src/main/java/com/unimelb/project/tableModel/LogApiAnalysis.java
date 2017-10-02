package com.unimelb.project.tableModel;

import java.io.Serializable;
import java.util.Date;

public class LogApiAnalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int logid;
	private int apiReturnStart;
	private int apiReturnstop;
	private Date processTimeStart;
	private Date processTimeStop;
	
	public LogApiAnalysis() {
		
	}

	public LogApiAnalysis(int apiReturnStart, int apiReturnstop, Date processTimeStart, Date processTimeStop) {
		this.apiReturnStart = apiReturnStart;
		this.apiReturnstop = apiReturnstop;
		this.processTimeStart = processTimeStart;
		this.processTimeStop = processTimeStop;
	}

	/**
	 * @return the logid
	 */
	public int getLogid() {
		return logid;
	}

	/**
	 * @param logid the logid to set
	 */
	public void setLogid(int logid) {
		this.logid = logid;
	}

	/**
	 * @return the apiReturnStart
	 */
	public int getApiReturnStart() {
		return apiReturnStart;
	}

	/**
	 * @param apiReturnStart the apiReturnStart to set
	 */
	public void setApiReturnStart(int apiReturnStart) {
		this.apiReturnStart = apiReturnStart;
	}

	/**
	 * @return the apiReturnstop
	 */
	public int getApiReturnstop() {
		return apiReturnstop;
	}

	/**
	 * @param apiReturnstop the apiReturnstop to set
	 */
	public void setApiReturnstop(int apiReturnstop) {
		this.apiReturnstop = apiReturnstop;
	}

	/**
	 * @return the processTimeStart
	 */
	public Date getProcessTimeStart() {
		return processTimeStart;
	}

	/**
	 * @param processTimeStart the processTimeStart to set
	 */
	public void setProcessTimeStart(Date processTimeStart) {
		this.processTimeStart = processTimeStart;
	}

	/**
	 * @return the processTimeStop
	 */
	public Date getProcessTimeStop() {
		return processTimeStop;
	}

	/**
	 * @param processTimeStop the processTimeStop to set
	 */
	public void setProcessTimeStop(Date processTimeStop) {
		this.processTimeStop = processTimeStop;
	}

}
