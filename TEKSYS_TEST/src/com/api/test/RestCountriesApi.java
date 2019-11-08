package com.api.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.JSONObject;

public class RestCountriesApi {
	
	class Country
	{
		String name = "";
		String capital = "";
		
		Country(String name , String capital)
		{
			this.name = name;
			this.capital = capital;
		}
	}
	
	public Country getCountryDetailsByCode(String countryCode) throws Exception
	{
		
		Country country = null;
		
		if(countryCode == null || countryCode.isEmpty() || countryCode.equals(""))
		{
			 return null;
		}
		
		String url = "https://restcountries.eu/rest/v2/alpha/"+countryCode;
	    URL obj = new URL(url);
	    HttpURLConnection con = (HttpURLConnection) obj.openConnection();
	    // optional default is GET
	    con.setRequestMethod("GET");
	    //add request header
	    con.setRequestProperty("User-Agent", "Mozilla/5.0");
	    int responseCode = con.getResponseCode();
	    //System.out.println("\nSending 'GET' request to URL : " + url);
	    System.out.println("\nResponse Code : " + responseCode);
	    
	    if(responseCode == 200)
	    {
	    	BufferedReader in = new BufferedReader(
		             new InputStreamReader(con.getInputStream()));
		     String inputLine;
		     StringBuffer response = new StringBuffer();
		     while ((inputLine = in.readLine()) != null) {
		     	response.append(inputLine);
		     }
		     in.close();
		     		     
		     //Read JSON response
		     JSONObject myResponse = new JSONObject(response.toString());
		     
		     String name = myResponse.getString("name");
		     String capital = myResponse.getString("capital");
		     country = new Country(name,capital);
	    }
	     
		
		return country;
	}

}

