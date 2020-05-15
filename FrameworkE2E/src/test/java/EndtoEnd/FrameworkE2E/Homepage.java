package EndtoEnd.FrameworkE2E;

import java.io.IOException;


import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pageobject.LandingPageQa;
import Pageobject.LoginPageQa;
import resources.base1;

public class Homepage extends base1 {
	
	 
		@BeforeTest
		public void initialize() throws IOException
		{
		
			 driver =initializeDriver();

		}
		@Test(dataProvider="getData")
		
		public void basePageNavigation(String Username,String Password,String text) throws IOException
		{

			//one is inheritance

			// creating object to that class and invoke methods of it
			driver.get(prop.getProperty("url"));
			LandingPageQa l=new LandingPageQa(driver);
			l.getLogin().click(); //driver.findElement(By.css()
			l.popupnewsletter().click();
			
			LoginPageQa lp=new LoginPageQa(driver);
			lp.getEmail().sendKeys(Username);
			lp.getPassword().sendKeys(Password);

			
			lp.getLogin().click();
			
			}

		@AfterTest
		public void teardown()
		{
			
			driver.close();
			driver=null;
			
		}

		
		@DataProvider
		public Object[][] getData()
		{
			// Row stands for how many different data types test should run
			//coloumn stands for how many values per each test
			
			// Array size is 2
			// 0,1
			Object[][] data=new Object[2][3];
			//0th row
			data[0][0]="nonrestricteduser@qw.com";
			data[0][1]="123456";
			data[0][2]="Restrcited User";
			//1st row
			data[1][0]="restricteduser@qw.com";
			data[1][1]="456788";
			data[1][2]= "Non restricted user";
			
			return data;
			
			
			
			
			
			
		}
		
	}
