package com.unimelb.project.task;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.Paper;
import com.unimelb.project.tableModel.PaperRelationshipStaff;
import com.unimelb.project.tableModel.StaffRelationshipStaff;

public class RelationshipBuild {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//开始从paper从上次结束开始构建
		
		
		// Read all paper
		List<Paper> paperList;

		try {
			paperList = DAOFactory.getIPaperDAOInstance().findAll();
			if (paperList.size() > 0) {

				for (Paper paper : paperList) {
					int paperId = 0;
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
						for (int i = 0; i < staffIdListSize; i++) {
							for (int j = i + 1; j < staffIdListSize; j++) {
								int staff1 = staffIdList.get(i);
								int staff2 = staffIdList.get(j);
								StaffRelationshipStaff staffRelationshipStaff = new StaffRelationshipStaff(staff1,
										paperId, staff2);
								DAOFactory.getIStaffRelationshipStaffDAOInstance().doCreate(staffRelationshipStaff);
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

}
