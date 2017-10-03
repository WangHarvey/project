package com.unimelb.project.task;

import java.util.ArrayList;
import java.util.List;

import com.unimelb.project.api.EuropePMC;
import com.unimelb.project.api.Scopus;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.Staff;

public class APIRequest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Save API info into map
		List<String> apiList = new ArrayList<String>();
		// Europe PubMed Central API
		String apiName1 = "Europe PMC";
		String apiName2 = "Scopus";
		apiList.add(apiName1);
		apiList.add(apiName2);
		// Other API info
		
		try {
			// get all staff list
			List<Staff> staffList = DAOFactory.getIStaffDAOInstance().findByName("");
			for (Staff staff : staffList) {
				// ensure staff have a ORCID
				if (staff.getOrcid() != null && staff.getOrcid().length() == 19) {
					ApiReturn apiReturn = new ApiReturn();
					int staffId = staff.getStaffId();
					String orcid = staff.getOrcid();
					// request all API
					for(String apiName: apiList){
						if(apiName.equals("Europe PMC")){
							// request info from Europe PMC
							apiReturn = EuropePMC.getApiReturnInfo(staffId, orcid);
							DAOFactory.getIApiReturnDAOInstance().doCreate(apiReturn);
						}else if(apiName.equals("Scopus")){
							// request info from Scopuss
							apiReturn = Scopus.getApiReturnInfo(staffId, orcid);
							DAOFactory.getIApiReturnDAOInstance().doCreate(apiReturn);
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
