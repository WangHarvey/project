package com.unimelb.project.tableModel;

import java.io.Serializable;
import java.util.Date;

public class LogPaperAnalysis implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int logid;
	private int paperStart;
	private int paperstop;
	private Date processTimeStart;
	private Date processTimeStop;
	
	public LogPaperAnalysis() {
		
	}
	
	public LogPaperAnalysis(int paperStart, int paperstop, Date processTimeStart, Date processTimeStop) {
		this.paperStart = paperStart;
		this.paperstop = paperstop;
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
	 * @return the paperStart
	 */
	public int getPaperStart() {
		return paperStart;
	}

	/**
	 * @param paperStart the paperStart to set
	 */
	public void setPaperStart(int paperStart) {
		this.paperStart = paperStart;
	}

	/**
	 * @return the paperstop
	 */
	public int getPaperstop() {
		return paperstop;
	}

	/**
	 * @param paperstop the paperstop to set
	 */
	public void setPaperstop(int paperstop) {
		this.paperstop = paperstop;
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
