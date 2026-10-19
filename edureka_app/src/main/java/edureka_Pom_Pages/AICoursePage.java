package edureka_Pom_Pages;






import java.util.Set
;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_utility.ExplicitWait;

public class AICoursePage {

WebDriver driver;
ExplicitWait wait;
	
	public AICoursePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new ExplicitWait(driver);
		PageFactory.initElements( driver,this);
		
	}
	
	
	public void switchToNextWindow()
	{
		Set<String> allids=driver.getWindowHandles();
		for(String id:allids)
		{
			driver.switchTo().window(id);
		}
	}
	
    
    //TC_AI_03
    
    public void isTitleMatched(String coursetitle)
    {
    	String title = driver.findElement(By.xpath("//h1[@class=\"main_title_pgp\"]")).getText();
    	Assert.assertEquals(title, coursetitle,"The selected course and opend course are not same");
    }
    
    //TC_AI_04
    public void isDescriptionDisplayed()
    {
    	WebElement desc = driver.findElement(By.xpath("//span[@class=\"desktop\"]"));
    	Assert.assertTrue(desc.isDisplayed(),"No description");
    	
    }
    
    public void isPageStable(String url1,String url2)
    {
    	Assert.assertEquals(url1,url2,"Error occured after refresh.");
    	
    }
    
    
    //TC_AI-27
    public void clickDownloadBrochure()
	{
		driver.findElement(By.xpath("(//button[@data-gaselector=\"send_pdf_btn\"])[1]")).click();
	}
	
	@FindBy(xpath="(//input[@name=\"name\"])[2]")
	private WebElement nametf;
	
	@FindBy(xpath="(//input[@name=\"email\"])[2]")
	private WebElement emailtf;
	
    @FindBy(xpath="(//input[@name=\"phone_no\"])[2]")
    private WebElement phonenotf;
    
    @FindBy(xpath="//button[text()='Get Brochure Now']")
    private WebElement submit;
  
    
    public void filldetails( String name,String email, String ph)
    {
    	nametf.clear();
    	nametf.sendKeys(name);
    	emailtf.clear();
    	emailtf.sendKeys(email);
    	phonenotf.clear();
    	phonenotf.sendKeys(ph);
    	submit.click();	
    }
    
     
    //verification
    public void isBrochureDowmloaded()
    {
    	
    	WebElement successmsg = driver.findElement(By.xpath("//h4[text()=' We will email you the brochure']"));
    	wait.waitForElementToBeVisible(successmsg);
    	Assert.assertTrue(successmsg.isDisplayed(), "Brochure download failed");
    }

    
    //TC_AI_29
    
    @FindAll({@FindBy(xpath="//div[@class=\"title_share_bx__1KwSE\"]"),@FindBy(xpath="//div[@class=\"topbanner_share__1G3OJ\"]")})
    private WebElement sharebutton;
    
    public void clickShareButton()
    {
    	wait.waitForElementToBeClickable(sharebutton);
    	sharebutton.click();
    }
    
    
    @FindBy(id="email")
    private WebElement emailoption;
    
    public void clickEmailOption()
    {
    	emailoption.click();
    }
    public void isComposemailopened()
    {
    	Assert.assertTrue(driver.getCurrentUrl().contains("mail"),"Share through email is failed.");
    }
}
