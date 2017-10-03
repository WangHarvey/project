package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unimelb.project.dao.IPaperRelationshipStaffDAO;
import com.unimelb.project.tableModel.PaperRelationshipStaff;

public class IPaperRelationshipStaffDAOImpl implements IPaperRelationshipStaffDAO {
	private Connection conn = null;

	public IPaperRelationshipStaffDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(PaperRelationshipStaff paperRelationshipStaff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO paperrelationshipstaff(paper,staff) VALUES (?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, paperRelationshipStaff.getPaper());
			pstmt.setInt(2, paperRelationshipStaff.getStaff());

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
		String sql = "DELETE FROM paperrelationshipstaff WHERE id=? ";
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

	public List<PaperRelationshipStaff> findByPaper(int paper) throws Exception {
		// TODO Auto-generated method stub
		List<PaperRelationshipStaff> all = new ArrayList<PaperRelationshipStaff>();
		
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paperrelationshipstaff WHERE paper=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, paper);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()){
				PaperRelationshipStaff paperRelationshipStaff = new PaperRelationshipStaff();
				paperRelationshipStaff.setPaperRelationshipStaffId(rs.getInt(1));
				paperRelationshipStaff.setPaper(rs.getInt(2));
				paperRelationshipStaff.setStaff(rs.getInt(3));
				
				all.add(paperRelationshipStaff);
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

	public boolean check(int paper, int staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM paperrelationshipstaff WHERE paper=? AND staff=? ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, paper);
			pstmt.setInt(2, staff);
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
