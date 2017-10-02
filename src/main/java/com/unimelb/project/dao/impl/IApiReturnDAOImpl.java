package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.unimelb.project.dao.IApiReturnDAO;
import com.unimelb.project.tableModel.ApiReturn;

public class IApiReturnDAOImpl implements IApiReturnDAO {
	private Connection conn = null;

	public IApiReturnDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(ApiReturn apiReturn) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO apireturn(returninfo,source,staff,requesttime) VALUES (?,?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setString(1, apiReturn.getReturnInfo());
			pstmt.setString(2, apiReturn.getSource());
			pstmt.setInt(3, apiReturn.getStaff());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(apiReturn.getRequestTime().getTime());
			pstmt.setTimestamp(4, Timestamp.valueOf(nowTime));
			//pstmt.setDate(4, new java.sql.Date(apiReturn.getRequestTime().getTime()));
			
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
		String sql = "DELETE FROM apireturn WHERE id=? ";
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

	public ApiReturn findById(int id) throws Exception {
		// TODO Auto-generated method stub
		ApiReturn apiReturn = new ApiReturn();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM apireturn WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				apiReturn.setRetrunInfoId(rs.getInt(1));
				apiReturn.setReturnInfo(rs.getString(2));
				apiReturn.setSource(rs.getString(3));
				apiReturn.setStaff(rs.getInt(4));
				apiReturn.setRequestTime(rs.getTimestamp(5));
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
		return apiReturn;
	}

	public ApiReturn findLast() throws Exception {
		// TODO Auto-generated method stub
		ApiReturn apiReturn = new ApiReturn();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM apireturn order by id DESC limit 1";
		
		try {
			pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				apiReturn.setRetrunInfoId(rs.getInt(1));
				apiReturn.setReturnInfo(rs.getString(2));
				apiReturn.setSource(rs.getString(3));
				apiReturn.setStaff(rs.getInt(4));
				apiReturn.setRequestTime(rs.getTimestamp(5));
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
		return apiReturn;
	}

}
