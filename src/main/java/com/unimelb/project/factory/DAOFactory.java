package com.unimelb.project.factory;

import com.unimelb.project.dao.IApiReturnDAO;
import com.unimelb.project.dao.IDepartmentDAO;
import com.unimelb.project.dao.ILogApiAnalysisDAO;
import com.unimelb.project.dao.ILogPaperAnalysisDAO;
import com.unimelb.project.dao.IPaperDAO;
import com.unimelb.project.dao.IPaperRelationshipStaffDAO;
import com.unimelb.project.dao.IStaffDAO;
import com.unimelb.project.dao.IStaffRelationshipAuthorDAO;
import com.unimelb.project.dao.IStaffRelationshipStaffDAO;
import com.unimelb.project.dao.proxy.IApiReturnDAOProxy;
import com.unimelb.project.dao.proxy.IDepartmentDAOProxy;
import com.unimelb.project.dao.proxy.ILogApiAnalysisDAOProxy;
import com.unimelb.project.dao.proxy.ILogPaperAnalysisDAOProxy;
import com.unimelb.project.dao.proxy.IPaperDAOProxy;
import com.unimelb.project.dao.proxy.IPaperRelationshipStaffDAOProxy;
import com.unimelb.project.dao.proxy.IStaffDAOProxy;
import com.unimelb.project.dao.proxy.IStaffRelationshipAuthorDAOProxy;
import com.unimelb.project.dao.proxy.IStaffRelationshipStaffDAOProxy;

public class DAOFactory {
	
	public static IStaffDAO getIStaffDAOInstance() {
		return new IStaffDAOProxy();
	}
	
	public static IApiReturnDAO getIApiReturnDAOInstance() {
		return new IApiReturnDAOProxy();
	}
	
	public static IDepartmentDAO getIDepartmentDAOInstance() {
		return new IDepartmentDAOProxy();
	}
	
	public static IPaperDAO getIPaperDAOInstance() {
		return new IPaperDAOProxy();
	}
	
	public static IPaperRelationshipStaffDAO getIPaperRelationshipStaffDAOInstance() {
		return new IPaperRelationshipStaffDAOProxy();
	}
	
	public static IStaffRelationshipStaffDAO getIStaffRelationshipStaffDAOInstance() {
		return new IStaffRelationshipStaffDAOProxy();
	}
	
	public static IStaffRelationshipAuthorDAO getIStaffRelationshipAuthorDAOInstance() {
		return new IStaffRelationshipAuthorDAOProxy();
	}
	
	public static ILogApiAnalysisDAO getILogApiAnalysisDAOInstance() {
		return new ILogApiAnalysisDAOProxy();
	}
	
	public static ILogPaperAnalysisDAO getILogPaperAnalysisDAOInstance() {
		return new ILogPaperAnalysisDAOProxy();
	}
	
	
}
