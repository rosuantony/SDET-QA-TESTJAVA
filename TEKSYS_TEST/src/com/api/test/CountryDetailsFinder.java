package com.api.test;



import java.util.Scanner;
import org.json.JSONObject;

import com.api.test.RestCountriesApi.Country;
public class CountryDetailsFinder {
	public static void main(String[] args) {
     try {
  
    	 Scanner sc = new Scanner(System.in);
		 while(true) 
		 {	 System.out.println("****************************************");
			 System.out.println("Input the ISO2 or ISO3 country code(Type 'STOP' to exit)");
	
			 String countryCode = sc.nextLine();
			 if(countryCode.equalsIgnoreCase("stop"))
			        break;
			 if(countryCode == null || countryCode.isEmpty() || countryCode.equals(""))
			 {
				 System.out.println("Please input a COUNTRY CODE or input 'STOP'");
			 }
			 else
			 {
				 Country country = new RestCountriesApi().getCountryDetailsByCode(countryCode);
				 if(country != null)
				 {	System.out.println("Country is "+country .name);
					System.out.println("Capital is "+country.capital);
				 }
				 else
				 {
					 System.out.println("Please input a valid country code!!!!");
				 }
			     
			 }
		 
		 }
        }
      catch (Exception e)
        {
         e.printStackTrace();
        }
     }
	   
	}
