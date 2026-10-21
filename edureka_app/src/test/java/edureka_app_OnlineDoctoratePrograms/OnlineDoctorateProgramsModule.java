package edureka_app_OnlineDoctoratePrograms;


import java.io.IOException;



import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass_utility.Baseclass;
import edureka_Pom_Pages.DoctorateCoursePage;
import edureka_Pom_Pages.OnlineDoctorateProgramsPage;
import excel_utility.TestDataFromExcel;



public class OnlineDoctorateProgramsModule extends Baseclass {
	
	
	OnlineDoctorateProgramsPage odp;
	TestDataFromExcel td;
	DoctorateCoursePage cp;
	String course;
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void setupPageObjects() throws IOException
	{
		 driver.get(getCommonData("odp_url"));
		 odp=new OnlineDoctorateProgramsPage(driver);
		 cp=new DoctorateCoursePage(driver);
		 td=new TestDataFromExcel();
	}
	
	
	
	@Test(groups="smoke")
	public void TC_ODP_01() throws IOException
	{
		odp.isDoctoratePageDisplayed();
	    Reporter.log("TC_ODP_01: The Online Doctorate Programs page loads successfully, and the heading and available program cards are displayed.",true);	
	}
	
	@Test(groups="fn")
	public void TC_ODP_02() throws EncryptedDocumentException, IOException
	{
		
		
		course = td.getData("course", 1, 0);
		odp.checkPrgCardInformation(course);
		
		course=td.getData("course", 2, 0);
		odp.checkPrgCardInformation(course);
		
		course = td.getData("course", 3, 0);
		odp.checkPrgCardInformation(course);
		
		course = td.getData("course", 5, 0);
		odp.checkPrgCardInformation(course);
		
		course = td.getData("course", 6, 0);
		odp.checkPrgCardInformation(course);
		
		course = td.getData("course", 7, 0);
		odp.checkPrgCardInformation(course);
		
		Reporter.log("TC_ODP_02: The Online Doctorate Program's each program card displays the correct information for its corresponding course.",true);
	}
	
	
	
	@Test(groups="int")
	public void TC_ODP_03() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		course = td.getData("course", 1, 0);
		odp.expandCourse(course);
		odp.iscourseOpened(course); 
		Reporter.log("TC_ODP_03: The correct details page opens for the selected Online Doctorate Program course without navigating to an unrelated program.",true);
		
	}
	
	
	//TC_ODP_05
	@Test(groups= {"fn","int"})
	public void TC_ODP_05() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course",1, 0);
		odp.expandCourse(course);
		cp.clickonVideoButton();
		cp.verifyVideoModal();
		cp.verifyVideoUrl();
		Reporter.log("TC_ODP_05:The correct Online Doctorate Program course video opens.",true);

}

	@Test(groups="sys")
	public void TC_ODP_06() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 5, 0);
		odp.expandCourse(course);
		cp.clickApplyNow();
		String name = td.getData("details", 1, 0);
		String email = td.getData("details", 1, 1);
		String phone = td.getData("details", 1, 2);
		cp.fillDetails(name,email,phone);
		cp.checkSuccessMsg();
		Reporter.log("TC_ODP_06: The appropriate success message is displayed when applied for a selected course in Online Doctorate Program .",true);
	}
	
	@Test(groups="fn")
	public void TC_ODP_07() throws EncryptedDocumentException, IOException
	{
		course=td.getData("course", 2, 0);
	    odp.expandCourse(course);
	    String section = td.getData("section", 2, 0);
	    cp.clicksectionInContainer(section);
	    cp.clickOnZoomCertificate();
	    Reporter.log("TC_ODP_07: The certificate is displayed in an enlarged view after clicking the zoom option, allowing the user to view the certificate clearly.",true);
	   		
	}
	
	
	@Test(groups="fn")
	public void TC_ODP_08() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 3, 0);
		odp.expandCourse(course);
		
		String about = td.getData("section", 1, 0);
		cp.clicksectionInContainer(about);
		
		String cert=td.getData("section", 2, 0);
		cp.clicksectionInContainer(cert);
		
		String eligiblity=td.getData("section", 3, 0);
		cp.clicksectionInContainer(eligiblity);
		
		String Curriculum=td.getData("section", 4, 0);
		cp.clicksectionInContainer(Curriculum);
		
		String admprocess=td.getData("section", 5, 0);
		cp.clicksectionInContainer(admprocess);
		
		String fees=td.getData("section", 6, 0);
		cp.clicksectionInContainer(fees);
		
		String faqs=td.getData("section", 7, 0);
		cp.clicksectionInContainer(faqs);
		
		cp.isAllSectionDisplayed();
		
		Reporter.log("TC_ODP_08: Each navigation link in Online Doctorate Program's course page directs the user to the correct section without opening an unrelated section.",true);
	
	}
	
	@Test(groups="fn")
	public void TC_ODP_09() throws EncryptedDocumentException, IOException
	{
		course=td.getData("course", 7, 0);
		odp.expandCourse(course);
		cp.isAccreditationsDisplayed();	
		Reporter.log("TC_ODP_09: The available accreditation logos  are displayed correctly without broken images or layout issues.",true);
	}
	
	@Test(groups="sys")
	public void TC_ODP_11() throws EncryptedDocumentException, IOException
	{
		course=td.getData("course", 6, 0);
		odp.expandCourse(course);
		cp.clickOnSampleCertificate();
		String name = td.getData("details", 1, 0);
		String email = td.getData("details", 1, 1);
		String phone = td.getData("details", 1, 2);
		cp.fillDetails(name,email,phone);
		cp.checkSuccessMsg();

	}
	
	
	
	
	@Test(groups="int")
	public void TC_ODP_12() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 2, 0);
		odp.expandCourse(course);
		cp.clickCurriculamStage();
		cp.checkStageExpand();
		cp.clickCurriculamStage();
		cp.checkStageCollapse();
		Reporter.log("TC_ODP_12: In Online Doctorate Program's course page each stage expands and collapses correctly, displaying or hiding its associated details.",true);	
	}
	
	
	@Test(groups={"fn","int"})
	public void TC_ODP_13() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 3, 0);
		odp.expandCourse(course);
		cp.checkCareerOppSection();
		Reporter.log("TC_ODP_13: In Online Doctorate Program's course page, The career information is displayed correctly, and the section layout remains readable without overlapping content.",true);
	}
	

	@Test(groups={"int","sys"})
	public void TC_ODP_17() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 6, 0);
		odp.expandCourse(course);
		
		cp.clickTalkToMgr();
		String name = td.getData("details", 1, 0);
		String email = td.getData("details", 1, 1);
		String phone = td.getData("details", 1, 2);
		cp.fillDetails(name,email,phone);
		
		cp.checkSuccessMsg();
		Reporter.log("TC_ODP_17: In Online Doctorate Program's course page, The appropriate enquiry interface opens and displays the expected contact or enquiry information.",true);
		
	}
	
	
	@Test(groups= {"int","neg"})
	public void TC_ODP_19() throws EncryptedDocumentException, IOException, InterruptedException
	{
		
		course=td.getData("course", 7, 0);
		odp.expandCourse(course);
		
		cp.clickBrochure();
		cp.clickDownloadButton();
		Thread.sleep(5000);
		cp.checkEmptyFieldValidationMsg();//empty fields
		
		
		String name = td.getData("details", 2, 0);
		String email = td.getData("details", 2, 1);
		String phone = td.getData("details", 2, 2);
		cp.fillDetails(name,email,phone);
		cp.checkInvalidDataValidationMsg();//invalid data
		Reporter.log("TC_ODP_19: The form prevents submission and displays appropriate validation messages for missing or invalid values.",true);
		
	}
	
	@Test(groups= {"int","sys"})
	public void TC_ODP_20() throws EncryptedDocumentException, IOException
	{
		
		course=td.getData("course", 2, 0);
		odp.expandCourse(course);
		cp.clickBrochure();
		String name = td.getData("details", 1, 0);
		String email = td.getData("details", 1, 1);
		String phone = td.getData("details", 1, 2);
		
		cp.fillDetails(name,email,phone);
        cp.checkBroucherDownload();	
        Reporter.log("TC_ODP_20 :The form accepts valid information and initiates the configured brochure download or delivery process successfully.",true);
	}
	
}
