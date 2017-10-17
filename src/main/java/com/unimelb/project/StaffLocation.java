package com.unimelb.project;

import java.util.List;

import com.unimelb.project.api.GoogleMapLocation;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.Staff;

public class StaffLocation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			// get all staff
			List<Staff> allStaff = DAOFactory.getIStaffDAOInstance().findByName("");
			
			String address = "";
			for(Staff staff:allStaff){
				// read staff address
				address = staff.getAddress1() + " " + staff.getAddress2() + " " + staff.getAddress3();
				// if address not null request the Coordinates
				if(!address.equals("null null null")){
					GoogleMapLocation location = GoogleMapLocation.getCoordinate(address);
					staff.setLatitude(location.getLatitude());
					staff.setLongitude(location.getLongitude());
					boolean isupdate = DAOFactory.getIStaffDAOInstance().doUpdate(staff);
					if(isupdate == true){
						System.out.println("Staff " + staff.getStaffId()+ " Coordinates Update");
					}
				}
				
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
