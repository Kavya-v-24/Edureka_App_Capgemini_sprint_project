package baseclass_utility;



import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;



import generic_utility.CommonDataFromPropertyFile;

public class Baseclass extends CommonDataFromPropertyFile {

	 protected WebDriver driver;
	 
	
	@Parameters("browser")
	@BeforeClass(alwaysRun = true)
	
	public void launchBrowser(@Optional("chrome")String browser) throws IOException
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		else
		{
			throw new IllegalArgumentException("Unsupported browser:"+browser);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.get(getCommonData("url"));
	}
	

	
	@AfterClass(alwaysRun = true)
	public void closeBrowser()
	{
		driver.quit();
	}
}
