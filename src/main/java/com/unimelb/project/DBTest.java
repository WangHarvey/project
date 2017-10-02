package com.unimelb.project;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.ApiReturn;

public class DBTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			ApiReturn apiReturn = DAOFactory.getIApiReturnDAOInstance().findById(126);
			System.out.println(apiReturn.getReturnInfo());
			// praser XML
	        Document doc = DocumentHelper.parseText(apiReturn.getReturnInfo());
	        Element rootElt = doc.getRootElement();
	        
	        System.out.println("Root：" + rootElt.getName());
	        
	        // get request info
	        Iterator iter = rootElt.elementIterator("request");
	        while (iter.hasNext()) {
	        	Element recordEle = (Element) iter.next();
	        	String query = recordEle.elementTextTrim("query"); 
	        	System.out.println("query:" + query);
	        	String pageSize = recordEle.elementTextTrim("pageSize"); 
	        	System.out.println("pageSize:" + pageSize);
	        }
	        
	        // get result list info
	        Iterator iterss = rootElt.elementIterator("resultList");
	        // parse date
	        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	        // parse paper info
	        while (iterss.hasNext()) {
	        	Element recordEless = (Element) iterss.next();
	        	Iterator itersElIterator = recordEless.elementIterator("result");
	        	while (itersElIterator.hasNext()) {
	        		 Element itemEle = (Element) itersElIterator.next(); 
	        		 String title = itemEle.elementTextTrim("title");
	        		 String authorString = itemEle.elementTextTrim("authorString");
	        		 String firstPublicationDate = itemEle.elementTextTrim("firstPublicationDate");
	        		 Date date = dateFormat.parse(firstPublicationDate);
	        		 String pubType = itemEle.elementTextTrim("pubType");
	        		 System.out.println("title:" + title);
	        		 System.out.println("authorString:" + authorString);
	        		 System.out.println("firstPublicationDate:" + date.toString());
	        		 System.out.println("pubType:" + pubType);
	        		 System.out.println("Source:Europe PMC");
	        		 
	        	}
	        }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
