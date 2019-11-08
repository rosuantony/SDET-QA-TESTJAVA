package com.api.test;

import java.util.Scanner;

import com.api.test.RestCountriesApi.Country;

public class RestCountriesApiUnitTester {
	public static void main(String[] args) {
	     	 try 
	     	 {
	     	 Scanner sc = new Scanner(System.in);
			 while(true) 
			 {
				 System.out.println("\nEnter 1: For Test Valid Country Code \n" +
				 		"2: Test Invalid country code  \n" +
				 		"3: Test Null value input");
			     System.out.println("Type STOP to exit");
		
				 String testCaseSelected = sc.nextLine();
				 if(testCaseSelected.equalsIgnoreCase("stop"))
				        break;
				 
				 if(testCaseSelected == null || testCaseSelected.isEmpty() || testCaseSelected.equals(""))
				 {
					 System.out.println("Enter a valid country code");
				 }
				 else if(testCaseSelected.equals("1"))
				 {
					 try
					 {
						 Country country = new RestCountriesApi().getCountryDetailsByCode("ind");
						 if(country != null && country.name.equalsIgnoreCase("India") && country.capital.equalsIgnoreCase("New Delhi"))
						 {
							 System.out.println("Test case succeeded.");
						 }
						 else
						 {
							 System.out.println("Test case failed.");
						 }
						 }
					 catch (Exception e)
				     {
						 System.out.println("Test case failed.");
				     }
				     
				 }
				 else if(testCaseSelected.equals("2"))
				 {
					 try
					 {
						 Country country = new RestCountriesApi().getCountryDetailsByCode("---");
						 if(country == null )
						 {
							 System.out.println("Test case succeeded.");
						 }
						
					 }
					 catch (Exception e)
				     {
						 System.out.println("Test case failed.");
				     }
					
				     
				 }
				 else if(testCaseSelected.equals("3"))
				 {
					 try
					 {
						 Country country = new RestCountriesApi().getCountryDetailsByCode(null);
						 if(country == null )
						 {
							 System.out.println("Test case succeeded.");
						 }
						
					 }
					 catch (Exception e)
				     {
						 System.out.println("Test case failed.");
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

