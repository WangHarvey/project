package com.unimelb.project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.LogPaperAnalysis;
import com.unimelb.project.tableModel.Paper;
import com.unimelb.project.tableModel.PaperRelationshipStaff;
import com.unimelb.project.tableModel.StaffRelationshipStaff;

public class RelationshipBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//开始从paper从上次结束开始构建
		int startPoint = 0;
		int stopPoint = 0;
		Date processTimeStart = new Date();
		Date processTimeStop;
		
		try {
			LogPaperAnalysis logPaperAnalysis = DAOFactory.getILogPaperAnalysisDAOInstance().findLast();
			Paper paper = DAOFactory.getIPaperDAOInstance().findLast();
			// start point is the last point in logfile
			startPoint = logPaperAnalysis.getPaperstop();
			// stop point it the last info in api return table
			stopPoint = paper.getPaperId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		if(startPoint < stopPoint){
			startPoint += 1;
		}
		
		// if start point equals to stop point, donot need process data
		if(startPoint == stopPoint){
			startPoint += 1;
		}
		
		System.out.println(startPoint);
		System.out.println(stopPoint);
		
		// bulid relationship between staff in unimelb
		for (int i = startPoint; i <= stopPoint; i++) {
			try {
				int paperId = 0;
				Paper paper = DAOFactory.getIPaperDAOInstance().findById(i);
				List<Integer> staffIdList = new ArrayList<Integer>();
				List<PaperRelationshipStaff> paperRelationshipStaffList = DAOFactory
						.getIPaperRelationshipStaffDAOInstance().findByPaper(paper.getPaperId());
				// find all staff contributed to the paper
				if (paperRelationshipStaffList.size() > 0) {
					for (PaperRelationshipStaff paperRelationshipStaff : paperRelationshipStaffList) {
						paperId = paperRelationshipStaff.getPaper();
						staffIdList.add(paperRelationshipStaff.getStaff());
					}
				}
				
				// save all corresponding relationship
				if (staffIdList.size() > 0) {
					int staffIdListSize = staffIdList.size();
					for (int j = 0; j < staffIdListSize; j++) {
						for (int k = j + 1; k < staffIdListSize; k++) {
							int staff1 = staffIdList.get(j);
							int staff2 = staffIdList.get(k);
							StaffRelationshipStaff staffRelationshipStaff = new StaffRelationshipStaff(staff1,
									paperId, staff2);
							DAOFactory.getIStaffRelationshipStaffDAOInstance().doCreate(staffRelationshipStaff);
						}
					}

				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// process all the info save the task into log
		processTimeStop = new Date();
		LogPaperAnalysis addLogPaperAnalysis = new LogPaperAnalysis(startPoint, stopPoint, processTimeStart, processTimeStop);
		try {
			DAOFactory.getILogPaperAnalysisDAOInstance().doCreate(addLogPaperAnalysis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
