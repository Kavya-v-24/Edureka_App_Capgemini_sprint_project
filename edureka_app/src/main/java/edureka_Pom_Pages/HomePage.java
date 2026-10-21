package edureka_Pom_Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_utility.ExplicitWait;

public class HomePage {
	WebDriver driver;
	ExplicitWait wait;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new ExplicitWait(driver);
		PageFactory.initElements( driver,this);
	}
	
	@FindBy(xpath="//button[text()='Log in']")
	private WebElement login;
	
	public void clickLogin() 
	{
		 
		wait.waitForElementToBeVisible(login);
		wait.waitForElementToBeClickable(login);
		
	        login.click();
	    
	}
	
	public void closeLoginPage()
	{
		driver.findElement(By.xpath("//div[@class=\"loginsignup_close_btn__1nnMB\"]")).click();
	}
	
	@FindBy(id="dropdown-user_drop")
	private WebElement userdd;
	
	
	//logout
	@FindBy(xpath="//a[text()='Log Out']")
	private WebElement logoutbutton;
	
	public void logout() throws InterruptedException
	{
		
//		WebElement popup = driver.findElement(By.id("duqFormTextarea"));
//		WebElement closepopup = driver.findElement(By.xpath("//span[@class=\"duq_chevron_icon__3KJrO duq_closed__1CYAa\"]"));
//		if(popup.isDisplayed())
//		{
//			closepopup.click();
//		}
		userdd.click();
		wait.waitForElementToBeVisible(logoutbutton);
		logoutbutton.click();
		Thread.sleep(3000);
		
	}
	
	@FindBy(id="loginFormEmail")
	private WebElement emailtf;
	
	@FindBy(id="loginPassword")
	private WebElement pwdtf;
	
	@FindBy(xpath="//button[text()='LOG IN']")
	private WebElement loginbutton;
	
	public void enterEmail(String email)
	{
	  emailtf.clear();
      emailtf.sendKeys(email);
	}
	
	public void enterPassword(String password)
	{
		pwdtf.clear();
		pwdtf.sendKeys(password);
	}

	public void clickLoginButton()
	{
		loginbutton.click();
	}
	
	
	
	//TC_LOGIN_01 Verification
	public void isLoginPageDisplayed()
	{
		WebElement loginpage = driver.findElement(By.xpath("//div[@class=\"loginsignup_modal_body__3toBz modal-body\"]"));
		Assert.assertTrue(loginpage.isDisplayed(),"Unabled to load the login page");
	}
	
	
	//TC_LOGIN_02
	
	public void filldetails(String email,String pwd)
	{
		emailtf.clear();
		pwdtf.clear();
		emailtf.sendKeys(email,Keys.TAB,pwd);
		loginbutton.click();
	}
	
	
	
	
	//verification
	public void isLoginSuccessful()
	{
		wait.waitForElementToBeVisible(userdd);
		Assert.assertTrue(userdd.isEnabled()||userdd.isDisplayed(),"Login Failed");
		
	}
	
	
	//TC_LOGIN_03
	public void isErrorMsgDisplayed()
	{
		WebElement errormsg = driver.findElement(By.xpath("//p[@class=\"form_auth_error__ggGTW\"]"));
		Assert.assertTrue(errormsg.isDisplayed());
	}
	
	
	//TC_LOGIN_09
	public void clickOnforget()
	{
		driver.findElement(By.xpath("//span[@class=\"form_forgot_password__1ucmn\"]")).click();
	}
	
	//Verification
	public void isResetpwdopened()
	{
		WebElement resetpage = driver.findElement(By.xpath("//div[@class=\"modal-content resetpassword_modal_content__3EAm6\"]"));
		wait.waitForElementToBeVisible(resetpage);
		Assert.assertTrue(resetpage.isDisplayed(),"verification of forget password is failed.");
	}
	

	//TC_LOGIN_15
	
	public void verifyLoginFormOnSmallerViewport() 
	{
	    driver.manage().window().setSize(new Dimension(1000, 700));

	    wait.waitForElementToBeVisible(emailtf);
	    wait.waitForElementToBeVisible(pwdtf);
	    wait.waitForElementToBeVisible(loginbutton);

	    Assert.assertTrue(emailtf.isDisplayed(),"Email field is not visible");

	    Assert.assertTrue(pwdtf.isDisplayed(),"Password field is not visible");

	    Assert.assertTrue(loginbutton.isDisplayed() && loginbutton.isEnabled(),"Login button is not visible or enabled");
	    driver.manage().window().maximize();
	}
	

	
	
	

}
