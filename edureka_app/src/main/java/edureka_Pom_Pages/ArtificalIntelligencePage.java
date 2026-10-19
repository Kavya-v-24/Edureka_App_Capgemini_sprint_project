package edureka_Pom_Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ArtificalIntelligencePage {
	
	WebDriver driver;
	
	public ArtificalIntelligencePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
		
	}
	
	public void expandCourse(String coursename)
	{
		WebElement course = driver.findElement(By.xpath("//div[@class=\"popularcourses_course_card__2xtnD\"][.//h3[text()='"+coursename+"']]"));
		course.findElement(By.tagName("button")).click();
	
	}
	
	//TC_AI_01
    //verification
    
    @FindBy(xpath="//div[@class=\"popularcourses_popular_courses_container__qbqk6\"][.//a[@data-title]]")
    private List<WebElement> courses;
    
    public void isAllCoursesDisplayed()
    {
    	for(WebElement course:courses)
    	{
    		Assert.assertTrue(course.isDisplayed(),course.getAttribute("data-category") + " is not displayed");
    	}
    }
    
	
    //TC_AI_13
    public void switchWindow()
    {
    	String parentWindow = driver.getWindowHandle();
    	driver.switchTo().window(parentWindow);
    }
			

}
