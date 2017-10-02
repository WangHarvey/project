package com.unimelb.project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.unimelb.project.factory.DAOFactory;
import com.unimelb.project.tableModel.Staff;

/**
 * Hello world!
 *
 */
public class App {
	
	
	public static void main(String[] args) throws Exception {
		App app = new App();
		app.run();
		
		
	}
	
	public void run() throws Exception  {
		final String URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
		final String APIKEY = "&key=AIzaSyDzHyFflfK8hq3c5mHLjF-bSJDJlNzC3oE";
		
		Staff staff = DAOFactory.getIStaffDAOInstance().findById(8);
		
		String address = staff.getAddress1() + " " + staff.getAddress2() + " " + staff.getAddress3();
		
		String addressStr = address.replace(" ", "+");
		
		String url = URL+ addressStr + APIKEY;
		
		System.out.println(url);

        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();

        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent", "Mozilla/5.0");
        
        // receive return json string
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
        	//System.out.println(inputLine);
            response.append(inputLine);
        }
        in.close();

        // parse json string
        String jsonStr = response.toString();
        
        System.out.println(jsonStr);
        
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonStr);
        JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();  
        JsonObject jsonObjectLocation = jsonArray.get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
        String lat = jsonObjectLocation.get("lat").getAsString();
        String lng = jsonObjectLocation.get("lng").getAsString();
        
        
	}
}
