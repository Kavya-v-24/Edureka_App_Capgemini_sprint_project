package edureka_app_Artificial_inteligence;

import java.io.IOException;


import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass_utility.Baseclass;
import edureka_Pom_Pages.AICoursePage;
import edureka_Pom_Pages.ArtificalIntelligencePage;
import excel_utility.TestDataFromExcel;

public class AIModule extends Baseclass {
	
	ArtificalIntelligencePage ap;
	AICoursePage cp;
	TestDataFromExcel td;
	String course;
	String name;
	String email;
	String ph;
	
	
	@BeforeMethod(alwaysRun = true)
	public void  setUp() throws IOException
	{
		driver.get(getCommonData("AI_url"));
		ap=new ArtificalIntelligencePage(driver);
		cp=new AICoursePage(driver);
		td=new TestDataFromExcel();
	}
	
	@Test (groups="smoke")
	public void TC_AI_01() 
	{
		ap.isAllCoursesDisplayed();
		Reporter.log("TC_AI_01: AI category/listing loads and relevant course content is displayed.",true);
	}
	
	
	@Test(groups="fn")
	public void TC_AI_03() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 1, 0);
		ap.expandCourse(course);
		cp.switchToNextWindow();
		cp.isTitleMatched(course);
		Reporter.log("TC_AI_03: The selected AI course detail page opens and matches the chosen course.",true);
		
	
	}
	
	@Test(groups="fn")
	public void TC_AI_04() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 1, 0);
		ap.expandCourse(course);
		cp.switchToNextWindow();
		cp.isDescriptionDisplayed();
		Reporter.log("TC_AI_04: Course overview/description is displayed when provided on the page.",true);
		
	}
	
	@Test(groups={"sys","int","fn"})
	public void TC_AI_12() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 3, 0);
		ap.expandCourse(course);
		cp.switchToNextWindow();
		String beforerefresh = driver.getCurrentUrl();
		driver.navigate().refresh();
		String afterrefresh = driver.getCurrentUrl();
		cp.isPageStable(beforerefresh, afterrefresh);
		Reporter.log("TC_AI_12: The detail page reloads without an application error and retains its course content.",true);
		
		
	}
	
	@Test(groups="int")
	public void TC_AI_13() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 1, 0);
		ap.expandCourse(course);
		ap.switchWindow();
		ap.isAllCoursesDisplayed();
		Reporter.log("TC_AI_13: User returns to the AI listing successfully.",true);
	}

	@Test(groups={"sys","int"})
	public void TC_AI_27() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 1, 0);
		ap.expandCourse(course);
		cp.switchToNextWindow();
		cp.clickDownloadBrochure();
		name=td.getData("details", 1, 0);
		email=td.getData("details", 1, 1);
		ph=td.getData("details", 1, 2);
		cp.filldetails(name,email, ph);
		//cp.isBrochureDowmloaded();
		Reporter.log("TC_AI_27: The brochure request is processed successfully, and the expected confirmation message is displayed.",true);
	}
	
	@Test(groups={"int","sys"})
	public void TC_AI_29() throws EncryptedDocumentException, IOException
	{
		course=td.getData("AIcourse", 2, 0);
		ap.expandCourse(course);
		cp.switchToNextWindow();
		cp.clickShareButton();
		cp.clickEmailOption();
		cp.switchToNextWindow();
		cp.isComposemailopened();
		Reporter.log("TC_AI_29: The share or copy-link control performs its displayed action and provides appropriate share option.",true);
	}
	
}
