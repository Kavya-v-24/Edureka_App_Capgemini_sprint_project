package edureka_app_all_course;

import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass_utility.Baseclass;
import edureka_Pom_Pages.AllCoursePage;
import excel_utility.TestDataFromExcel;

public class AllCourseModule extends Baseclass{
	
	AllCoursePage ac;
	TestDataFromExcel td;
	String category;
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		driver.get(getCommonData("all_course_url"));
		ac=new AllCoursePage(driver);
		td=new TestDataFromExcel();
	}
	
	
	@Test(groups="smoke")
	public void TC_AC_03()
	{
		ac.verifyAllCategoriesDisplayed();
		Reporter.log("TC_AC_03: All expected category buttons are visible with correct labels.",true);
	}
	
	
	
	@Test(groups="fn")
	public void TC_AC_07() throws EncryptedDocumentException, IOException
	{
		category=td.getData("category", 5, 0);
		ac.selectCategory(category);
		ac.iscoursesdisplayed();
		Reporter.log("TC_AC_07: The listing reflects the Online MBA category according to the application's configured mapping.",true);	
	}
	
	
	@Test(groups="fn")
	public void TC_AC_12()
	{
		ac.clickOthers();
		ac.checkOtherCourses();
		Reporter.log("TC_AC_12: Relevant courses are displayed, or the designed empty state appears if no courses are available.",true);
	}
	
	
	
	@Test(groups="fn")
	public void TC_AC_13() throws EncryptedDocumentException, IOException
	{
		String category1=td.getData("category", 2, 0);
		ac.selectCategory(category1);
		Assert.assertTrue(ac.isCategorySelected(category1), category1+" is not selected");
		
		category=td.getData("category", 4, 0);
		ac.selectCategory(category);
		Assert.assertTrue(ac.isCategorySelected(category), category+" is not selected");

		Assert.assertFalse(ac.isCategorySelected(category1), category1+" is selected");
		
		Reporter.log("TC_AC_13: The current category is identifiable and its selected state updates correctly according to the page design.",true);
			
	}
	
	
	@Test(groups="int")
	public void TC_AC_21() throws EncryptedDocumentException, IOException
	{
		category=td.getData("category", 3, 0);
		ac.selectCategory(category);
		
		String course1 = ac.getCourseTitle(0);
		ac.openCourse(0);
		ac.verifyCourseDetails(course1);
		
		driver.navigate().back();
		
		String course2 = ac.getCourseTitle(1);
		ac.openCourse(1);
		ac.verifyCourseDetails(course2);
		Reporter.log("TC_AC_21: Each details page displays information for the course selected by the user.",true);
		
		
	}
	
	@Test(groups={"neg","fn","int"})
	public void TC_AC_24()
	{
		ac.clickSearchField();
		ac.enterSearchText("XYZ_NoSuchCourse_98765");
		ac.issearchResultEmpty();
		Reporter.log("TC_AC_24: The application handles the input gracefully and follows its documented no-match behavior.",true);
		
	}
	
	
	@Test(groups= {"int","sys","fn"})
	public void TC_AC_28()
	{
		List<String> page1=ac.getCourseTitles();
		ac.clickNextpage();
		List<String> nextpage=ac.getCourseTitles();
		ac.verifyNoOverlap(page1, nextpage);
		Reporter.log("TC_AC_28: No unintended duplicate cards appear across pages; any legitimate repeated listing follows the defined requirements.");
		
	}

}
