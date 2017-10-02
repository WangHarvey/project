package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.unimelb.project.dao.IStaffDAO;
import com.unimelb.project.tableModel.Staff;

public class IStaffDAOImpl implements IStaffDAO {

	private Connection conn = null;

	public IStaffDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO staff(firstname,middlename,lastname,title,position,department"
				+ ",address1,address2,address3,phone,email,orcid) VALUES (?,?,?,?,?,?,?,?,?,?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, staff.getFirstName());
			pstmt.setString(2, staff.getMiddleName());
			pstmt.setString(3, staff.getLastName());
			pstmt.setString(4, staff.getTitle());
			pstmt.setString(5, staff.getPosition());
			pstmt.setInt(6, staff.getDepartment());
			pstmt.setString(7, staff.getAddress1());
			pstmt.setString(8, staff.getAddress2());
			pstmt.setString(9, staff.getAddress3());
			pstmt.setString(10, staff.getPhone());
			pstmt.setString(11, staff.getEmail());
			pstmt.setString(12, staff.getOrcid());

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

	public boolean doUpdate(Staff staff) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "UPDATE staff SET firstname=?,middlename=?,lastname=?,title=?,position=?,department=?"
				+ ",address1=?,address2=?,address3=?,longitude=?,latitude=?,phone=?,email=?,orcid=? WHERE id=?";

		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, staff.getFirstName());
			pstmt.setString(2, staff.getMiddleName());
			pstmt.setString(3, staff.getLastName());
			pstmt.setString(4, staff.getTitle());
			pstmt.setString(5, staff.getPosition());
			pstmt.setInt(6, staff.getDepartment());
			pstmt.setString(7, staff.getAddress1());
			pstmt.setString(8, staff.getAddress2());
			pstmt.setString(9, staff.getAddress3());
			pstmt.setString(10, staff.getLongitude());
			pstmt.setString(11, staff.getLatitude());
			pstmt.setString(12, staff.getPhone());
			pstmt.setString(13, staff.getEmail());
			pstmt.setString(14, staff.getOrcid());
			pstmt.setInt(15, staff.getStaffId());

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
		String sql = "DELETE FROM staff WHERE id=? ";
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

	public Staff findById(int id) throws Exception {
		// TODO Auto-generated method stub
		Staff staff = new Staff();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM staff WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				staff.setStaffId(rs.getInt(1));
				staff.setFirstName(rs.getString(2));
				staff.setMiddleName(rs.getString(3));
				staff.setLastName(rs.getString(4));
				staff.setTitle(rs.getString(5));
				staff.setPosition(rs.getString(6));
				staff.setDepartment(rs.getInt(7));
				staff.setAddress1(rs.getString(8));
				staff.setAddress2(rs.getString(9));
				staff.setAddress3(rs.getString(10));
				staff.setLongitude(rs.getString(11));
				staff.setLatitude(rs.getString(12));
				staff.setPhone(rs.getString(13));
				staff.setEmail(rs.getString(14));
				staff.setOrcid(rs.getString(15));
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
		return staff;
	}

	public List<Staff> findByName(String name) throws Exception {
		// TODO Auto-generated method stub
		List<Staff> all = new ArrayList<Staff>();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM staff WHERE firstname LIKE ? order by id";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, "%" + name + "%");

			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff.setStaffId(rs.getInt(1));
				staff.setFirstName(rs.getString(2));
				staff.setMiddleName(rs.getString(3));
				staff.setLastName(rs.getString(4));
				staff.setTitle(rs.getString(5));
				staff.setPosition(rs.getString(6));
				staff.setDepartment(rs.getInt(7));
				staff.setAddress1(rs.getString(8));
				staff.setAddress2(rs.getString(9));
				staff.setAddress3(rs.getString(10));
				staff.setLongitude(rs.getString(11));
				staff.setLatitude(rs.getString(12));
				staff.setPhone(rs.getString(13));
				staff.setEmail(rs.getString(14));
				staff.setOrcid(rs.getString(15));

				all.add(staff);
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

}
