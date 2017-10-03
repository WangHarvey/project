package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unimelb.project.dao.IPaperDAO;
import com.unimelb.project.tableModel.Paper;

public class IPaperDAOImpl implements IPaperDAO {
	private Connection conn = null;

	public IPaperDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(Paper paper) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO paper(title,publishedtime,type,author,source) VALUES (?,?,?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, paper.getTitle());
			pstmt.setDate(2, new java.sql.Date(paper.getPublishedTime().getTime()));
			pstmt.setString(3, paper.getType());
			pstmt.setString(4, paper.getAuthor());
			pstmt.setString(5, paper.getSource());

			// check if the creation is successful
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return flag;
	}

	public boolean doUpdate(Paper paper) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE paper SET title=?,publishedtime=?,type=?,author=?,source=? WHERE id=?";

		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, paper.getTitle());
			pstmt.setDate(2, new java.sql.Date(paper.getPublishedTime().getTime()));
			pstmt.setString(3, paper.getType());
			pstmt.setString(4, paper.getAuthor());
			pstmt.setString(5, paper.getSource());
			pstmt.setInt(5, paper.getPaperId());

			// check if the update is successful
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return flag;
	}

	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM paper WHERE id=? ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			if (pstmt.executeUpdate() > 0) {
				flag = true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return flag;
	}

	public Paper findByTitle(String title) throws Exception {
		// TODO Auto-generated method stub
		Paper paper = new Paper();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paper WHERE title=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, title);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				paper.setPaperId(rs.getInt(1));
				paper.setTitle(rs.getString(2));
				paper.setPublishedTime(rs.getDate(3));
				paper.setType(rs.getString(4));
				paper.setAuthor(rs.getString(5));
				paper.setSource(rs.getString(6));
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return paper;
	}

	public Paper findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Paper paper = new Paper();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paper WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				paper.setPaperId(rs.getInt(1));
				paper.setTitle(rs.getString(2));
				paper.setPublishedTime(rs.getDate(3));
				paper.setType(rs.getString(4));
				paper.setAuthor(rs.getString(5));
				paper.setSource(rs.getString(6));
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return paper;
	}

	public List<Paper> findAll() throws Exception {
		List<Paper> all = new ArrayList<Paper>();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paper";
		try {
			pstmt = this.conn.prepareStatement(sql);

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Paper paper = new Paper();
				paper.setPaperId(rs.getInt(1));
				paper.setTitle(rs.getString(2));
				paper.setPublishedTime(rs.getDate(3));
				paper.setType(rs.getString(4));
				paper.setAuthor(rs.getString(5));
				paper.setSource(rs.getString(6));

				all.add(paper);
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return all;
	}

	public Paper findLast() throws Exception {
		// TODO Auto-generated method stub
		Paper paper = new Paper();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paper order by id DESC limit 1";
		
		try {
			pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				paper.setPaperId(rs.getInt(1));
				paper.setTitle(rs.getString(2));
				paper.setPublishedTime(rs.getDate(3));
				paper.setType(rs.getString(4));
				paper.setAuthor(rs.getString(5));
				paper.setSource(rs.getString(6));
			}
			rs.close();
		} catch (Exception e) {
			throw e;
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (Exception e1) {

				}
			}
		}
		return paper;
	}

}
