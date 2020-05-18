package pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landpage {

	public WebDriver driver;
	
	By signin= By.cssSelector("a[href*='sign_in']");
	By Text= By.xpath("//h2[contains(text(),'Featured Courses')]");
	By Nav= By.xpath("//div[@class='navbar navbar-default navbar-static-top']");
	
	
	public Landpage(WebDriver driver1) {
		// TODO Auto-generated constructor stub
		this.driver=driver1;
	}


	public WebElement login()
	{
		
		 return driver.findElement(signin);
	}
	
	
	public WebElement Looktext()
	{
		
		 return driver.findElement(Text);
	}
	
	public WebElement Navigate()
	{
		
		 return driver.findElement(Nav);
	}
}
