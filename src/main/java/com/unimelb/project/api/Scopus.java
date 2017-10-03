package com.unimelb.project.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
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
import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.Paper;

public class Scopus {
	private static final String SOURCE = "Scopus";
	// &apiKey=e72c6ce59174cdcb29b641a9fc12ae16
	private static final String APIKEY = "e72c6ce59174cdcb29b641a9fc12ae16";
	private static final String APIURLID = "http://api.elsevier.com/content/search/author?query=ORCID(XXXX-XXXX-XXXX-XXXX)&httpAccept=application/xml&field=dc:identifier";
	private static final String APIURLAUTHOR = "http://api.elsevier.com/content/search/scopus?query=AU-ID(XXXXXXXXXX)&httpAccept=application/json&field=title,coverDate,aggregationType,author&count=200";

	// get Scopus returned info with orcid and scopus_id
	public static ApiReturn getApiReturnInfo(int staffId, String orcid) {
		ApiReturn apiReturn = new ApiReturn();
		apiReturn.setStaff(staffId);
		apiReturn.setSource(SOURCE);
		try {
			// get author id from orcid in scopus
			// get request time
			Date requestTime = new Date();
			// build search url
			String url = APIURLID.replace("XXXX-XXXX-XXXX-XXXX", orcid) + "&apiKey=" + APIKEY;
			URL obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			// read return data
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// xml to string
			String xmlStr = response.toString();
			Document doc = DocumentHelper.parseText(xmlStr);
			Element rootElt = doc.getRootElement();

			@SuppressWarnings("rawtypes")
			Iterator iterss = rootElt.elementIterator("entry");
			Element recordEless = (Element) iterss.next();

			// get author_id
			String author_id = "";
			String str = recordEless.elementTextTrim("identifier");
			if (str != null) {
				author_id = str.substring(10);
			}

			// use author_id in scoups search paper info
			if (author_id.length() > 0) {
				url = APIURLAUTHOR.replace("XXXXXXXXXX", author_id) + "&apiKey=" + APIKEY;
				obj = new URL(url);
				con = (HttpURLConnection) obj.openConnection();

				// check return code
				int responseCode = con.getResponseCode();
				// System.out.println("\nSending 'GET' request to URL : " +
				// url);
				System.out.println("Scopus Response Code : " + responseCode);

				in = new BufferedReader(new InputStreamReader(con.getInputStream()));
				response = new StringBuffer();
				while ((inputLine = in.readLine()) != null) {
					response.append(inputLine);
				}
				in.close();
				String jsonStr = response.toString();

				apiReturn.setRequestTime(requestTime);
				apiReturn.setReturnInfo(jsonStr);

			} else {
				apiReturn.setRequestTime(requestTime);
				apiReturn.setReturnInfo("");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiReturn;
	}

	public static List<Paper> analysisApiReturnInfo(String apiInfo) {
		List<Paper> all = new ArrayList<Paper>();
		
		if(apiInfo.length()<10)
			return all;
		try {
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
	        	paper = new Paper(title, date, type, author, SOURCE);
				all.add(paper);	 
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
      
		return all;
	}

}
