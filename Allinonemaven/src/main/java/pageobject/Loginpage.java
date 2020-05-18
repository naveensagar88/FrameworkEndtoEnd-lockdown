package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {

	
public WebDriver driver;
	
	By email= By.cssSelector("[id='user_email']");
	By pwd= By.cssSelector("[type='password']");
	By login=By.cssSelector("[type='submit']");
	
	
	public Loginpage(WebDriver driver2) {
		// TODO Auto-generated constructor stub
		
		this.driver=driver2;
	}

	public WebElement getemail()
	{
		
		return driver.findElement(email);
		
	}
	
	public WebElement getpassword()
	{
		
		 return driver.findElement(pwd);
		
	}
	
	public void getloginbutton()
	{
		
		 driver.findElement(login).submit();
	}
}
