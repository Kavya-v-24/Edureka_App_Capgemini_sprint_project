package edureka_Pom_Pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import generic_utility.ExplicitWait;

public class DoctorateCoursePage {
	
	WebDriver driver;
	ExplicitWait wait=new ExplicitWait(driver);
	
	
	public DoctorateCoursePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements( driver,this);
	}
	
	
	
	//TC_ODP_05
	
		@FindBy(xpath="(//span[@class=\"play_icon circle\"])[2]")
		private WebElement videobutton;
		
		public void clickonVideoButton()
		{
			ExplicitWait wait=new ExplicitWait(driver);
			wait.waitForElementToBeClickable(videobutton);
			videobutton.click();
		}	
		
		@FindBy(id = "watchVideoForm")
		private WebElement videoModal;

		@FindBy(xpath = "//div[@data-target='#watchVideoForm']")
		private WebElement videoButtonContainer;

		public void verifyVideoModal() {
			
			wait.waitForElementToBeVisible(videoModal);
		    Assert.assertTrue(videoModal.isDisplayed(),"Video preview modal did not open");

		    Assert.assertTrue(videoModal.getAttribute("class").contains("show"),"Video preview modal is not active" );
		}

		public void verifyVideoUrl() {
		    String videoUrl = videoButtonContainer.getAttribute("data-url");
		    Assert.assertTrue(videoUrl != null && videoUrl.contains("youtube.com/embed/"),"YouTube video URL is missing or incorrect");
		}
		
		
	//TC_ODP_006
	
	@FindBy(xpath="//button[@data-gaselector=\"apply_now_top\"]")
	private WebElement applynowbutton;
	
	public void clickApplyNow()
	{
		applynowbutton.click();
	}
	
	//verification 
	
	@FindBy(xpath="//span[@class=\"title form_header\"]")
	private WebElement applyform;

	public void veifyApplyNow()
	{
		Assert.assertEquals(applyform.getText(),"Apply Now","The appropriate application page or form is not opened for the selected program.");	
	}
	
	//TC_ODP_07
	
			@FindBy(id="certificateZoomModalMain")
			private WebElement zoommodel;
			
			@FindBy(xpath="//div[@class=\"click_to_zoom drm_cta\"]")
			private WebElement zoomcert;
			
			public void clickOnZoomCertificate()
			{
			    wait.waitForElementToBeClickable(zoomcert);
			
				zoomcert.click();
				Assert.assertFalse(zoommodel.getAttribute("class").contains("show"),"Sample certificate zoom modal is not displayed");
			}
	
	
	//TC_ODP_08
		public void clicksectionInContainer(String section)
		{
			WebElement sections = driver.findElement(By.xpath("//li[@class=\"swiper-slide\"][.//span[text()='"+section+"']]"));
			sections.click();	
		}
		
		//verification
		
		@FindBy(id="about")
		private WebElement about;
		
		@FindBy(id="certificate")
		private WebElement certificate;
		
		@FindBy(id="eligibility")
		private WebElement eligibility;
		
		@FindBy(id="curriculum")
		private WebElement curriculam;
		
		@FindBy(id="admiproc")
		private WebElement admissionprocess;
		
		@FindBy(id="fees")
		private WebElement fees;
		
		@FindBy(id="faqs")
		private WebElement FAQS;
		
		
		public void isAllSectionDisplayed() {

			Assert.assertTrue(about.isDisplayed(),"About link in container is not scrolled to the about content");

			Assert.assertTrue(certificate.isDisplayed(),"Certificate link in container is not scrolled to the Certificate content");
		
			Assert.assertTrue(eligibility.isDisplayed(),"Eligibility link in container is not scrolled to the Program eligibility content");
		
			Assert.assertTrue(curriculam.isDisplayed(),"Curriculam link in container is not scrolled to the Curriculam content");
			
			Assert.assertTrue(admissionprocess.isDisplayed(),"Admissionprocess link in container is not scrolled to the admissionprocess content");
			
			Assert.assertTrue(fees.isDisplayed(),"Fees link in container is not scrolled to the fees content");
			
			Assert.assertTrue(FAQS.isDisplayed(),"FAQS link in container is not scrolled to the FAQS content");	
		}
		
		
	//TC_ODP_09
		
		@FindBy(xpath="//ul[@class=\"icon_list\"]")
		private WebElement Accreditations;
		
		public void isAccreditationsDisplayed()
		{
			Assert.assertTrue(Accreditations.isDisplayed(),"Accreditation logos are not visible.");
		}
	
	
		
		//TC_ODP_11
		
		@FindBy(xpath="//button[text()='Get Sample Certificate']")
		private WebElement samplecert;
		
		public void clickOnSampleCertificate()
		{
			samplecert.click();
		}
		
		
		
	//TC_ODP_012
	
	@FindBy(xpath="//button[@data-target=\"#section1module1\"]")
	private WebElement curriculamStage;
	
	public void clickCurriculamStage()
	{
		curriculamStage.click();
	}
	
	//verification
	
	@FindBy(id="section1module1")
	private WebElement stagecontent;
	
	public void checkStageExpand()
	{
		wait.waitForElementToBeVisible(stagecontent);
		Assert.assertTrue(stagecontent.isDisplayed(),"Curriculam stage is not expanded");
	}
	
	public void checkStageCollapse()
	{
		String value = stagecontent.getAttribute("class");
		Assert.assertTrue(value.equals("collapse") || value.equals("collapsing"),"Curriculum stage is expanded");
	}
	
	
	//TC_ODP_13
	
	@FindBy(css="[class='career_opp_pgp']")
	private WebElement careeroppsection;
	
	//verification
	public void checkCareerOppSection()
	{
		Assert.assertTrue(careeroppsection.isDisplayed(),"Career opportunities section is not displayed properly.");
	}
	
	
	
	//TC_ODP_17
	
	@FindBy(id="btn_scholar_apply1")
	private WebElement talktomanager;
	
	public void clickTalkToMgr()
	{
		talktomanager.click();	
	}
	
	
	@FindBy(xpath="//span[text()=' We Will Get Back To ']")
	private WebElement successmsg;
	
	public void checkSuccessMsg()
	{
		ExplicitWait wait=new ExplicitWait(driver);
		wait.waitForElementToBeVisible(successmsg);
		Assert.assertTrue(successmsg.isDisplayed(),"The appropriate enquiry interface is opened.");
	}

	
	//TC_ODP_20 and TC_ODP_19 
	
	@FindBy(xpath="//button[text()='Curriculum - India']")
	private WebElement brochure;
	
	public void clickBrochure()
	{
		brochure.click();
	}
	
	@FindBy(name="name")
	private WebElement nametf;
	
	@FindBy(xpath="(//input[@name=\"email\"])[3]")
	private WebElement emailtf;
	
	@FindBy(xpath="(//input[@name=\"phone_no\"])[3]")
	private WebElement phonenotf;
	
	@FindBy(name="degree")
	private WebElement degreedd;
	
	@FindBy(name="exp")
	private WebElement expdd;
	
	@FindBy(id="apply_form")
	private WebElement downloadbutton;
	
	
	
	public void fillDetails(String name,String email,String Phoneno)
	{
		nametf.clear();
		nametf.sendKeys(name);
		emailtf.clear();
		emailtf.sendKeys(email);
		phonenotf.clear();
		phonenotf.sendKeys(Phoneno);
		degreedd.click();
		Select degree=new Select(degreedd);
		degree.selectByIndex(2);
		Select exp=new Select(expdd);
		exp.selectByIndex(3);
		ExplicitWait wait=new ExplicitWait(driver);
		wait.waitForElementToBeClickable(downloadbutton);
		downloadbutton.click();
		
	}
	
	//TC_ODP_19
	
	public void clickDownloadButton()
	{
		ExplicitWait wait=new ExplicitWait(driver);
		wait.waitForElementToBeVisible(downloadbutton);
		wait.waitForElementToBeClickable(downloadbutton);
		downloadbutton.click();
	}
		public void checkEmptyFieldValidationMsg()
		{
			wait.waitForElementToBeVisible(driver.findElement(By.xpath("//span[text()='Please enter a valid name']")));
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please enter a valid name']")).isDisplayed(),"Name text field validation message is not displayed");
		    //Assert.assertTrue(driver.findElement(By.xpath("(//span[@class=\"errormsg error_email\"])[3]")).isDisplayed(),"Email text field validation message is not displayed");
		    //Assert.assertTrue(driver.findElement(By.xpath("//span[@class=\"errormsg error_phone_no\"]")).isDisplayed(),"Phone no. text field validation message is not displayed");
		    Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please select highest education']")).isDisplayed(),"Degree dropdown validation message is not displayed");
		    Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please select work experience']")).isDisplayed(),"Experience dropdown validation message is not displayed");
			
		}
		
		public void checkInvalidDataValidationMsg()
		{
			Assert.assertTrue(driver.findElement(By.xpath("//span[text()='Please enter a valid name']")).isDisplayed(),"Name text field validation message is not displayed");
		    Assert.assertTrue(driver.findElement(By.xpath("(//span[@class=\"errormsg error_email\"])[3]")).isDisplayed(),"Email text field validation message is not displayed");
		    Assert.assertTrue(driver.findElement(By.xpath("//span[@class=\"errormsg error_phone_no\"]")).isDisplayed(),"Phone no. text field validation message is not displayed");
		    
		}
	
	
	// TC_ODP_20 verification
	public void checkBroucherDownload()
	{
		for (String window : driver.getWindowHandles()) 
		{
		    driver.switchTo().window(window);

		    if (driver.getCurrentUrl().contains(".pdf")) 
		    {
		        Assert.assertTrue(driver.getCurrentUrl().contains(".pdf"),"Brochure PDF did not open");
		        break;
		    }
		}
		
		}

	
	
}
