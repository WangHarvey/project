package com.unimelb.project.dbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {
	// Database connection seeting
	private static final String DBDRIVER = "com.mysql.jdbc.Driver" ;
	private static final String DBURL = "jdbc:mysql://localhost:3306/projecttest?" +
			"autoReconnect=true&useSSL=false&useUnicode=true&characterEncoding=UTF-8" ;
	private static final String DBUSER = "root" ;
	private static final String DBPASS = "admin" ;
	private Connection conn = null ;
	
	// Database connection Constructor
	public DataBaseConnection(){
		try {
			Class.forName(DBDRIVER) ;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASS) ;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// return database connection
	public Connection getConnection(){
		return this.conn ;
	}
	
	// close database connection
	public void close(){
		if(this.conn!=null){
			try {
				this.conn.close() ;
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	

}
