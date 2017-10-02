package com.unimelb.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.unimelb.project.dao.ILogPaperAnalysisDAO;
import com.unimelb.project.tableModel.LogPaperAnalysis;

public class ILogPaperAnalysisDAOImpl implements ILogPaperAnalysisDAO {
	
	private Connection conn = null;
	

	public ILogPaperAnalysisDAOImpl(Connection conn) {
		this.conn = conn;
	}

	public boolean doCreate(LogPaperAnalysis logPaperAnalysis) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = false;
		PreparedStatement pstmt = null;
		String sql = "INSERT INTO log_paperanalysis(paperstart,paperstop,processtimestart,processtimestop) VALUES (?,?,?,?) ";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, logPaperAnalysis.getPaperStart());
			pstmt.setInt(2, logPaperAnalysis.getPaperstop());
			String nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logPaperAnalysis.getProcessTimeStart().getTime());
			pstmt.setTimestamp(3, Timestamp.valueOf(nowTime));
			nowTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(logPaperAnalysis.getProcessTimeStop().getTime());
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

	public LogPaperAnalysis findById(int id) throws Exception {
		// TODO Auto-generated method stub
		LogPaperAnalysis logPaperAnalysis = new LogPaperAnalysis();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM log_paperanalysis WHERE id=?";
		try {
			pstmt = this.conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				logPaperAnalysis.setLogid(rs.getInt(1));
				logPaperAnalysis.setPaperStart(rs.getInt(2));
				logPaperAnalysis.setPaperstop(rs.getInt(3));
				logPaperAnalysis.setProcessTimeStart(rs.getDate(4));
				logPaperAnalysis.setProcessTimeStop(rs.getDate(5));
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
		return logPaperAnalysis;
	}

	public LogPaperAnalysis findLast() throws Exception {
		// TODO Auto-generated method stub
		LogPaperAnalysis logPaperAnalysis = new LogPaperAnalysis();
		PreparedStatement pstmt = null;
		String sql = "SELECT * FROM log_paperanalysis order by id DESC limit 1";
		try {
			pstmt = this.conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				logPaperAnalysis.setLogid(rs.getInt(1));
				logPaperAnalysis.setPaperStart(rs.getInt(2));
				logPaperAnalysis.setPaperstop(rs.getInt(3));
				logPaperAnalysis.setProcessTimeStart(rs.getTimestamp(4));
				logPaperAnalysis.setProcessTimeStop(rs.getTimestamp(5));
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
		return logPaperAnalysis;
	}

}
