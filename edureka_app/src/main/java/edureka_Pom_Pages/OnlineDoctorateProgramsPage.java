package edureka_Pom_Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class OnlineDoctorateProgramsPage {
	WebDriver driver;
	
	public OnlineDoctorateProgramsPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	
	// Verify TC_ODP_01
	
	@FindBy(xpath="//h1[text()='Online Doctorate Programs']")
	private WebElement doctorateprgtitle;
	
	public void isDoctoratePageDisplayed()
	{
		Assert.assertTrue(doctorateprgtitle.isDisplayed(),"Online Doctorate page is not displayed");
	}
	

	//TC_ODP_02
	public void checkPrgCardInformation(String coursetitle)
	{
		WebElement courses = driver.findElement(By.xpath("//a[@class=\"pgpcard_main giTrackElementHeader\"][.//h3[text()='"+coursetitle+"']]"));
		WebElement highlights = courses.findElement(By.xpath("//ul[@class=\"highlights hidden-xs\"]"));
		Assert.assertTrue(highlights.isDisplayed()," Program card not displaying  the correct information for its corresponding course.");
	}
	
	
	//TC_ODP_03
	
	public void expandCourse(String coursetitle)
	{
		WebElement course = driver.findElement(By.xpath("//a[@class=\"pgpcard_main giTrackElementHeader\"][.//h3[text()='"+coursetitle+"']]"));
		course.findElement(By.tagName("span")).click();	
	}

	//verification
	
	@FindBy(xpath="//h1[@class=\"main_title_pgp\"]")
	private WebElement coursename;
	
	public void iscourseOpened(String course)
	{
		Assert.assertTrue(coursename.getText().contains(course),"Correct details page is not  opened for the selected course ");
	}
	
	
		
	

}
