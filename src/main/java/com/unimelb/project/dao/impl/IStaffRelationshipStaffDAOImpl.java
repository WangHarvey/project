package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.unimelb.project.dao.IStaffRelationshipStaffDAO;
import com.unimelb.project.tableModel.StaffRelationshipStaff;

public class IStaffRelationshipStaffDAOImpl implements IStaffRelationshipStaffDAO {
	private Connection conn = null;

	public IStaffRelationshipStaffDAOImpl(Connection conn) {
		this.conn = conn;
	}


	public boolean doCreate(StaffRelationshipStaff staffRelationshipStaff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO staffrelationshipstaff(staff1,paper,staff2) VALUES (?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, staffRelationshipStaff.getStaff1());
			pstmt.setInt(2, staffRelationshipStaff.getPaper());
			pstmt.setInt(3, staffRelationshipStaff.getStaff2());

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
		String sql = "DELETE FROM staffrelationshipstaff WHERE id=? ";
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

}
