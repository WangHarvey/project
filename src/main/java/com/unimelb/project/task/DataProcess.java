package com.unimelb.project.task;

import java.util.Date;
import java.util.List;

import com.unimelb.project.api.EuropePMC;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.LogApiAnalysis;
import com.unimelb.project.tableModel.Paper;
import com.unimelb.project.tableModel.PaperRelationshipStaff;

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

		System.out.println(startPoint);
		System.out.println(stopPoint);
		for (int i = startPoint; i <= stopPoint; i++) {
			ApiReturn apiReturn;
			int staffId;
			String apiSource;
			List<Paper> paperList = null;
			try {
				apiReturn = DAOFactory.getIApiReturnDAOInstance().findById(i);
				if (apiReturn.getReturnInfo() != null) {
					// get staff id
					staffId = apiReturn.getStaff();
					// request different api depends on the source
					apiSource = apiReturn.getSource();
					if (apiSource.equals("Europe PMC")) {
						paperList = EuropePMC.analysisApiReturnInfo(apiReturn.getReturnInfo());
					} else if (true) {
						

					}
					System.out.println(apiReturn.getStaff() + "published paper" + paperList.size());

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
								}
							}
						}

						// update PaperRelationshipStaff table
						PaperRelationshipStaff paperRelationshipStaff;
						for (Paper paper : paperList) {
							if (paper != null) {
								paperId = DAOFactory.getIPaperDAOInstance().findByTitle(paper.getTitle()).getPaperId();
								paperRelationshipStaff = new PaperRelationshipStaff(paperId, staffId);
								DAOFactory.getIPaperRelationshipStaffDAOInstance().doCreate(paperRelationshipStaff);
							}
						}
						
						// update StaffRelationshipAuthor table
						// 检索paper的作者信息，构建员工和作者之间的关系

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
