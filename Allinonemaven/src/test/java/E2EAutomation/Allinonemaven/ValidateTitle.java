package E2EAutomation.Allinonemaven;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


import Resources.Base;
import pageobject.Landpage;

public class ValidateTitle extends Base {

	public static Logger Log=LogManager.getLogger(ValidateTitle.class.getName());
	//public static Logger log = Logger.getLogger(ValidateTitle.class);
	
	@BeforeTest
	
	public void init() throws IOException
	{
		driver=initialization();
		driver.get(prop.getProperty("url"));
		Log.info("Browser initialize and url activated");
	}
	
	@Test
	
	public void basepagenavigation() throws IOException
	{
		
		
		Landpage lp = new Landpage(driver);
		System.out.println(lp.Looktext().getText());
		AssertJUnit.assertEquals(lp.Looktext().getText(), "FEATURED COURSES");
		AssertJUnit.assertTrue(lp.Navigate().isDisplayed());
		//Assert.assertFalse(lp.Navigate().isDisplayed());
		Log.info("Text match success");
		
	}
	
	@AfterTest
	
	public void teardown()
	{
		driver.close();
		driver=null;
	}
	
	
}
