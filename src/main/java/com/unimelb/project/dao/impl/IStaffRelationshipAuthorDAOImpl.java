package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.unimelb.project.dao.IStaffRelationshipAuthorDAO;
import com.unimelb.project.tableModel.StaffRelationshipAuthor;

public class IStaffRelationshipAuthorDAOImpl implements IStaffRelationshipAuthorDAO {
	
	private Connection conn = null;

	public IStaffRelationshipAuthorDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(StaffRelationshipAuthor staffRelationshipAuthor) throws Exception {
		// TODO Auto-generated method stub
				boolean flag = false;
				PreparedStatement pstmt = null;
				String sql = "INSERT INTO staffrelationshipauthor(staff,paper,author) VALUES (?,?,?) ";
				try {
					pstmt = this.conn.prepareStatement(sql);
					pstmt.setInt(1, staffRelationshipAuthor.getStaff());
					pstmt.setInt(2, staffRelationshipAuthor.getPaper());
					pstmt.setString(3, staffRelationshipAuthor.getAuthor());

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

	public boolean doDelete(int id) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "DELETE FROM staffrelationshipauthor WHERE id=? ";
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

	public boolean check(int paper, int staff,String author) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM staffrelationshipauthor WHERE paper=? AND staff=? AND author=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, paper);
			pstmt.setInt(2, staff);
			pstmt.setString(3, author);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
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

}
