package com.unimelb.project;

import java.util.Date;
import java.util.List;

import com.unimelb.project.api.EuropePMC;
import com.unimelb.project.api.Scopus;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.LogApiAnalysis;
import com.unimelb.project.tableModel.Paper;
import com.unimelb.project.tableModel.PaperRelationshipStaff;
import com.unimelb.project.tableModel.StaffRelationshipAuthor;

public class DataProcess {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// process data from the latest
		int startPoint = 0;
		int stopPoint = 0;
		Date processTimeStart = new Date();
		Date processTimeStop;
		try {
			LogApiAnalysis logApiAnalysis = DAOFactory.getILogApiAnalysisDAOInstance().findLast();
			ApiReturn apiReturn = DAOFactory.getIApiReturnDAOInstance().findLast();
			// start point is the last point in logfile
			startPoint = logApiAnalysis.getApiReturnstop();
			// stop point it the last info in api return table
			stopPoint = apiReturn.getRetrunInfoId();

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
		for (int i = startPoint; i <= stopPoint; i++) {
			ApiReturn apiReturn;
			int staffId;
			String apiSource;
			List<Paper> paperList = null;
			//List<Paper> addList = new ArrayList<Paper>();
			try {
				apiReturn = DAOFactory.getIApiReturnDAOInstance().findById(i);
				if (apiReturn.getReturnInfo() != null) {
					// get staff id
					staffId = apiReturn.getStaff();
					// request different api depends on the source
					apiSource = apiReturn.getSource();
					if (apiSource.equals("Europe PMC")) {
						paperList = EuropePMC.analysisApiReturnInfo(apiReturn.getReturnInfo());
						System.out.println(apiReturn.getStaff() + " published in Europe PMC " + paperList.size());
					} else if (apiSource.equals("Scopus")) {
						paperList = Scopus.analysisApiReturnInfo(apiReturn.getReturnInfo());
						System.out.println(apiReturn.getStaff() + " published in Scopus " + paperList.size());
					}

					// add paper info and PaperRelationshipStaff info in to
					// database
					int paperId;
					// avoid the paper list is empty
					if (paperList.size() > 0) {
						// update paper table
						for (Paper paper : paperList) {
							if (paper != null) {
								paperId = DAOFactory.getIPaperDAOInstance().findByTitle(paper.getTitle()).getPaperId();
								// if paperId = 0, means this paper is not in
								// the databese
								if (paperId == 0) {
									DAOFactory.getIPaperDAOInstance().doCreate(paper);
									// if paper not in database we need bulid the relationship
								}
							}
						}

						// update PaperRelationshipStaff table
						PaperRelationshipStaff paperRelationshipStaff;
						for (Paper paper : paperList) {
							if (paper != null) {
								paperId = DAOFactory.getIPaperDAOInstance().findByTitle(paper.getTitle()).getPaperId();
								paperRelationshipStaff = new PaperRelationshipStaff(paperId, staffId);
								// check if it is already in database
								boolean isExist = DAOFactory.getIPaperRelationshipStaffDAOInstance().check(paperId, staffId);
								// if not exist doCreate
								if(!isExist){
									DAOFactory.getIPaperRelationshipStaffDAOInstance().doCreate(paperRelationshipStaff);
								}
								
							}
						}
						
						// update StaffRelationshipAuthor table
						StaffRelationshipAuthor staffRelationshipAuthor;
						for (Paper paper : paperList) {
							if (paper != null) {
								paperId = DAOFactory.getIPaperDAOInstance().findByTitle(paper.getTitle()).getPaperId();
								String[] authors = paper.getAuthor().split(",");
								for(String author:authors){
									staffRelationshipAuthor = new StaffRelationshipAuthor(staffId,paperId, author);
									// check if it is already in database
									boolean isExist = DAOFactory.getIStaffRelationshipAuthorDAOInstance().check(paperId, staffId,author);
									// if not exist doCreate
									if(!isExist){
										DAOFactory.getIStaffRelationshipAuthorDAOInstance().doCreate(staffRelationshipAuthor);
									}
									
								}
							}
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
		LogApiAnalysis addLogApiAnalysis = new LogApiAnalysis(startPoint, stopPoint, processTimeStart, processTimeStop);
		try {
			DAOFactory.getILogApiAnalysisDAOInstance().doCreate(addLogApiAnalysis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
