package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.unimelb.project.dao.IDepartmentDAO;
import com.unimelb.project.tableModel.Department;

public class IDepartmentDAOImpl implements IDepartmentDAO {
	private Connection conn = null;

	public IDepartmentDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(Department department) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO department(departmentname,departmentinfo) VALUES (?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, department.getDepartmentName());
			pstmt.setString(2, department.getDepartmentInfo());

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

	public boolean doUpdate(Department department) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE department SET departmentname=?,departmentinfo=? WHERE id=?";

		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, department.getDepartmentName());
			pstmt.setString(2, department.getDepartmentInfo());
			pstmt.setInt(3, department.getDepartmentid());

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
		String sql = "DELETE FROM department WHERE id=? ";
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

	public Department findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Department department = new Department();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM staff WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				department.setDepartmentid(rs.getInt(1));
				department.setDepartmentName(rs.getString(2));
				department.setDepartmentInfo(rs.getString(3));
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
		return department;
	}

}
