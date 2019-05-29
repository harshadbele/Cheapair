package com.qa.Cheapair.Test_Cases;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.Cheapair.Pages.AirTrip_Page;
import com.qa.Cheapair.TestBase.Test_Base;

public class AirTrip_Page_Test extends Test_Base{

	public AirTrip_Page airtrip;

	public AirTrip_Page_Test() throws IOException {
		super();
	}


	@BeforeMethod
	public void setup()
	{
		initialization();
		airtrip=new AirTrip_Page();

	}


	@Test
	public void city_search_test() throws InterruptedException
	{
		airtrip.city_search();
/*
		String Actual_Departure="Mon - May 27th, 2019";
		String expected_Departure=airtrip.verify_Date();		
		Assert.assertEquals(Actual_Departure,expected_Departure);

		String Actual_Arrival="Tue - Jun 11th, 2019";
		String Expected_Arrival=airtrip.verify_Date_Arrival();

		Assert.assertEquals(Actual_Arrival, Expected_Arrival);
		//Thread.sleep(3000);
*/
	}

	@AfterMethod
	public void teardown()
	{
		driver.close();	
	}
}
