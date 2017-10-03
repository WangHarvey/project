package com.unimelb.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.unimelb.project.api.EuropePMC;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;

public class DBTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		boolean flag = DAOFactory.getIStaffRelationshipAuthorDAOInstance().check(5281, 10,"Pang PC");
		System.out.println(flag);
	}

}
