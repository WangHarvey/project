package com.unimelb.project.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.unimelb.project.tableModel.ApiReturn;
import com.unimelb.project.tableModel.Paper;

public class EuropePMC {
	private static final String SOURCE = "Europe PMC";
	private static final String APIURL = "https://www.ebi.ac.uk/europepmc/webservices/rest/search?query=";

	// get Europe PMC returned info with orcid
	public static ApiReturn getApiReturnInfo(int staffId, String orcid) {
		ApiReturn apiReturn = new ApiReturn();
		apiReturn.setStaff(staffId);
		apiReturn.setSource(SOURCE);
		try {
			// get request time
			Date requestTime = new Date();
			// build search url
			String url = APIURL + orcid;
			URL obj = new URL(url);
			HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("User-Agent", "Mozilla/5.0");

			// check return code
			int responseCode = con.getResponseCode();
//			System.out.println("\nSending 'GET' request to URL : " + url);
			System.out.println("Europe PMC Response Code : " + responseCode);

			// read return data
			BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
			String inputLine;
			StringBuffer response = new StringBuffer();

			while ((inputLine = in.readLine()) != null) {
				response.append(inputLine);
			}
			in.close();

			// XML to string
			String xmlStr = response.toString();

			apiReturn.setRequestTime(requestTime);
			apiReturn.setReturnInfo(xmlStr);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return apiReturn;
	}

	// analysis apireturn data into Paper and the relationship between Paper and
	// Staff
	public static List<Paper> analysisApiReturnInfo(String apiInfo) {
		List<Paper> all = new ArrayList<Paper>();
		try {
			// praser XML
			Document doc = DocumentHelper.parseText(apiInfo);
			Element rootElt = doc.getRootElement();

			// get result list info
			@SuppressWarnings("rawtypes")
			Iterator iterss = rootElt.elementIterator("resultList");
			// parse date
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			// parse paper info
			while (iterss.hasNext()) {
				Element recordEless = (Element) iterss.next();
				@SuppressWarnings("rawtypes")
				Iterator itersElIterator = recordEless.elementIterator("result");
				Paper paper = null;
				while (itersElIterator.hasNext()) {
					Element itemEle = (Element) itersElIterator.next();
					String title = itemEle.elementTextTrim("title");

					String publishedtime = itemEle.elementTextTrim("firstPublicationDate");
					Date date = dateFormat.parse(publishedtime);

					String type = itemEle.elementTextTrim("pubType");
					String author = itemEle.elementTextTrim("authorString");

					paper = new Paper(title, date, type, author, SOURCE);
					all.add(paper);
				}

			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return all;
	}

}
