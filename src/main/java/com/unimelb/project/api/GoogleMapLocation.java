package com.unimelb.project.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class GoogleMapLocation {
	private static final String URL = "https://maps.googleapis.com/maps/api/geocode/json?address=";
	private static final String APIKEY = "&key=AIzaSyDzHyFflfK8hq3c5mHLjF-bSJDJlNzC3oE";
	
	private String latitude;
	private String longitude;
	
	public GoogleMapLocation(String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}
	
	
	/**
	 * @return the latitude
	 */
	public String getLatitude() {
		return latitude;
	}



	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}



	/**
	 * @return the longitude
	 */
	public String getLongitude() {
		return longitude;
	}



	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}



	public static GoogleMapLocation getCoordinate(String address){
		String addressStr = address.replace(" ", "+");
		String url = URL + addressStr + APIKEY;
		String lat = "";
		String lng = "";
		try {
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
	        
	        JsonParser jsonParser = new JsonParser();
	        JsonObject jsonObject = (JsonObject)jsonParser.parse(jsonStr);
	        JsonArray jsonArray = jsonObject.get("results").getAsJsonArray();  
	        JsonObject jsonObjectLocation = jsonArray.get(0).getAsJsonObject().get("geometry").getAsJsonObject().get("location").getAsJsonObject();
	        lat = jsonObjectLocation.get("lat").getAsString();
	        lng = jsonObjectLocation.get("lng").getAsString();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		GoogleMapLocation location = new GoogleMapLocation(lat,lng);
		return location;
	}
	

}
