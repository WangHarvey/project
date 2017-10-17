package com.unimelb.project.tableModel;

import java.io.Serializable;
import java.util.Date;

public class Paper implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Paper info table attributes
	private int paperId;
	private String title;
	private Date publishedTime;
	private String type;
	private String author;
	private String source;
	private int citedcount;
	private String field;

	// Paper Constructor with paper info
	public Paper(String title, Date publishedTime, String type, String author, String source, int citedcount, String field) {
		this.title = title;
		this.publishedTime = publishedTime;
		this.type = type;
		this.author = author;
		this.source = source;
		this.citedcount = citedcount;
		this.field = field;
	}

	/**
	 * @return the citedcount
	 */
	public int getCitedcount() {
		return citedcount;
	}

	/**
	 * @param citedcount the citedcount to set
	 */
	public void setCitedcount(int citedcount) {
		this.citedcount = citedcount;
	}

	/**
	 * @return the field
	 */
	public String getField() {
		return field;
	}

	/**
	 * @param field the field to set
	 */
	public void setField(String field) {
		this.field = field;
	}

	public Paper() {

	}

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @return the publishedTime
	 */
	public Date getPublishedTime() {
		return publishedTime;
	}

	/**
	 * @param publishedTime
	 *            the publishedTime to set
	 */
	public void setPublishedTime(Date publishedTime) {
		this.publishedTime = publishedTime;
	}

	/**
	 * @return the field
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param field
	 *            the field to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
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
	 * @return the paperId
	 */
	public int getPaperId() {
		return paperId;
	}

	/**
	 * @param paperId
	 *            the paperId to set
	 */
	public void setPaperId(int paperId) {
		this.paperId = paperId;
	}
}
