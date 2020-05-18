package E2EAutomation.Allinonemaven;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.logging.log4j.Logger;

import Resources.Base;
import pageobject.Landpage;
import pageobject.Loginpage;

public class Home extends Base {


	public static Logger Log=LogManager.getLogger(Home.class.getName());
	//public static Logger log = Logger.getLogger(Home.class);
	
	@BeforeMethod
	
	public void init() throws IOException
	{
		driver=initialization();
		driver.get(prop.getProperty("url"));
		Log.info("Browser initialize and url activated for home page");
		
	}
	
	@Test(dataProvider="datainfo")
	
	public void basepagenavigation(String username,String password) throws IOException
	{
		
		
		
		Landpage lp = new Landpage(driver);
		lp.login().click();
		Loginpage lg = new Loginpage(driver);
		lg.getemail().sendKeys(username);
		Log.info("username success");
		lg.getpassword().sendKeys(password);
		Log.info("password success");
		lg.getloginbutton();
		//Log.info("login success");
		
		
		
	}
	
	@AfterMethod()
	
	public void teardown()
	{
		
		driver.close();
		driver=null;
	}
	
	@DataProvider
	
	public Object[][] datainfo()
	{
		Object[][] data= new Object[2][2];
		
		data[0][0]= "nonrestrictedusers";
		data[0][1]= "123456";
		
		data[1][0]= "restrictedusers";
		data[1][1]= "156";
		
		return data;
		

	}
	
	
}
