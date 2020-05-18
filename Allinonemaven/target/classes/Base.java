package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initialization() throws IOException {
		// TODO Auto-generated method stub

				
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\naveen.n\\eclipse-workspace-sagar\\Allinonemaven\\src\\main\\java\\Resources\\info.properties");
		prop.load(fis);
		String browsername=prop.getProperty("browser");
		System.out.println(browsername);
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("Webdriver.chrome.driver", "C:\\Users\\naveen.n\\Downloads\\chromedriver.exe");
			 driver = new ChromeDriver();
			 //By signin= By.xpath("//a[@href='http://qaclickacademy.usefedora.com/sign_in']");
			
		}
		
		else if(browsername.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver","C:\\Users\\naveen.n\\Downloads\\geckodriver.exe");
			WebDriver driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			
			
		}
		
		else

			if(browsername.equals("IE"))
			{
				System.setProperty("webdriver.ie.driver","C:\\Users\\naveen.n\\Downloads\\IEDriverServer_Win32_3.5.0\\IEDriverServer.exe");
				WebDriver driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				
			}
		
		
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		return driver;
		
		
		
	}
	public void getScreenshot(String result) throws IOException  {
		// TODO Auto-generated method stub
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src,new File("C://test//"+result+"screenshot.png") );
		
		
	}

}
