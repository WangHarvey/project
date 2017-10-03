package com.unimelb.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unimelb.project.api.EuropePMC;
import com.unimelb.project.api.Scopus;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.Paper;
import com.unimelb.project.tableModel.Staff;

public class Test {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		List<Paper> all = new ArrayList<Paper>();
		ApiReturn apiReturn = Scopus.getApiReturnInfo(49, "0000-0001-5998-222X");
		String apiInfo = apiReturn.getReturnInfo();
		
		JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(apiInfo);
        JsonObject jsonObject1 = jsonObject.get("search-results").getAsJsonObject();
        JsonArray jsonArray = jsonObject1.get("entry").getAsJsonArray();
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Paper paper = null;
        for(int i = 0;i<jsonArray.size();i++){
        	String title = jsonArray.get(i).getAsJsonObject().get("dc:title").getAsString();
        	String publishedtime = jsonArray.get(i).getAsJsonObject().get("prism:coverDate").getAsString();
        	Date date = dateFormat.parse(publishedtime);
        	String type = jsonArray.get(i).getAsJsonObject().get("prism:aggregationType").getAsString();
        	String author = "";
        	JsonArray jsonArrayAuthor = jsonArray.get(i).getAsJsonObject().get("author").getAsJsonArray();
        	for(int j = 0;j < jsonArrayAuthor.size();j++){
        		String str = jsonArrayAuthor.get(j).getAsJsonObject().get("authname").getAsString();
        		str += ",";
        		author += str;
        	}
        	paper = new Paper(title, date, type, author, "Scopus");
			all.add(paper);	 
        	
        }
          
	}

}
