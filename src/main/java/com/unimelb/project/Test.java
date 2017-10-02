package com.unimelb.project;

import java.util.List;

import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.Staff;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Staff> staffList = DAOFactory.getIStaffDAOInstance().findByName("");
		Staff staff = staffList.get(7);
		String address = staff.getAddress1() + " " + staff.getAddress2() + " " + staff.getAddress3();
		if(!address.equals("null null null"))
			System.out.println(address);
		
		System.out.println("yse");
		

	}

}
