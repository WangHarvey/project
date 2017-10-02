package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.unimelb.project.dao.ILogApiAnalysisDAO;
import com.unimelb.project.tableModel.LogApiAnalysis;

public class ILogApiAnalysisDAOImpl implements ILogApiAnalysisDAO {
	
	private Connection conn = null;
	

	public ILogApiAnalysisDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(LogApiAnalysis logApiAnalysis) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO log_apianalysis(apiretrunstart,apireturnstop,processtimestart,processtimestop) VALUES (?,?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, logApiAnalysis.getApiReturnStart());
			pstmt.setInt(2, logApiAnalysis.getApiReturnstop());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logApiAnalysis.getProcessTimeStart().getTime());
			pstmt.setTimestamp(3, Timestamp.valueOf(nowTime));
			nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logApiAnalysis.getProcessTimeStop().getTime());
			pstmt.setTimestamp(4, Timestamp.valueOf(nowTime));
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

	public LogApiAnalysis findById(int id) throws Exception {
		// TODO Auto-generated method stub
		LogApiAnalysis logApiAnalysis = new LogApiAnalysis();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM log_apianalysis WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				logApiAnalysis.setLogid(rs.getInt(1));
				logApiAnalysis.setApiReturnStart(rs.getInt(2));
				logApiAnalysis.setApiReturnstop(rs.getInt(3));
				logApiAnalysis.setProcessTimeStart(rs.getDate(4));
				logApiAnalysis.setProcessTimeStop(rs.getDate(5));
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
		return logApiAnalysis;
	}

	public LogApiAnalysis findLast() throws Exception {
		// TODO Auto-generated method stub
		LogApiAnalysis logApiAnalysis = new LogApiAnalysis();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM log_apianalysis order by id DESC limit 1";
		try {
			pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				logApiAnalysis.setLogid(rs.getInt(1));
				logApiAnalysis.setApiReturnStart(rs.getInt(2));
				logApiAnalysis.setApiReturnstop(rs.getInt(3));
				logApiAnalysis.setProcessTimeStart(rs.getTimestamp(4));
				logApiAnalysis.setProcessTimeStop(rs.getTimestamp(5));
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
		return logApiAnalysis;
	}

}
