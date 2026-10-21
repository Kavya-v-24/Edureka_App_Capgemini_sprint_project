package edureka_app_login;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.testng.Reporter;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseclass_utility.Baseclass;
import edureka_Pom_Pages.HomePage;
import excel_utility.TestDataFromExcel;

public class LoginModule extends Baseclass {

    HomePage hp;
    TestDataFromExcel td;
    String email;
    String pwd;
    
	
	@BeforeMethod(alwaysRun = true)
	public void setUp() throws IOException
	{
		driver.get(getCommonData("url"));
		hp=new HomePage(driver);
		td=new TestDataFromExcel();
		
	}
		
	
	@Test(groups="smoke")
	public void TC_LOGIN_01()
	{
		hp.clickLogin();
		hp.isLoginPageDisplayed();
		hp.closeLoginPage();
		Reporter.log("TC_LOGIN_01: Login form/page is displayed and usable.",true);
	}
	
	@Test(priority = 7,groups="int")
	public void TC_LOGIN_02() throws EncryptedDocumentException, IOException, InterruptedException
	{
		hp.clickLogin();
		email=td.getData("login", 1, 0);
		pwd=td.getData("login", 1, 1);
		hp.filldetails(email, pwd);
		hp.isLoginSuccessful();
		hp.logout();
		Reporter.log("TC_LOGIN_02: User is authenticated and the expected account/home page is displayed.",true);
			
	}
	
	
	@Test(groups="neg")
	public void TC_LOGIN_03() throws EncryptedDocumentException, IOException
	{
		hp.clickLogin();
		email=td.getData("login", 1, 0);
		pwd=td.getData("login", 2, 1);
		hp.filldetails(email, pwd);
		hp.isErrorMsgDisplayed();
		hp.closeLoginPage();
		Reporter.log("TC_LOGIN_03: Login is not completed and an appropriate error/validation message is shown.",true);
	}
	
	
	@Test(groups={"neg","fn"})
	public void TC_LOGIN_04() throws EncryptedDocumentException, IOException
	{
		hp.clickLogin();
		email=td.getData("login", 2, 0);
		pwd=td.getData("login", 2, 1);
		hp.filldetails(email, pwd);
		hp.isErrorMsgDisplayed();
		hp.closeLoginPage();
		Reporter.log("TC_LOGIN_04: User remains unauthenticated and an appropriate error is shown.",true);
		
	}
	
	@Test(groups={"neg","fn"})
	public void TC_LOGIN_05() throws EncryptedDocumentException, IOException
	{
		hp.clickLogin();
		hp.clickLoginButton();
		hp.isErrorMsgDisplayed();
		hp.closeLoginPage();
		Reporter.log("TC_LOGIN_05: Required-field validation is shown and login is not completed.",true);
		
	}
	
	@Test(groups="int")
	public void TC_LOGIN_09() 
	{
		hp.clickLogin();
		hp.clickOnforget();
		hp.isResetpwdopened();
		Reporter.log("TC_LOGIN_09: Password recovery page/form is displayed.",true);
	}
	
	@Test(priority = 8,groups= "sys")
	public void TC_LOGIN_13() throws EncryptedDocumentException, IOException, InterruptedException
	{
		hp.clickLogin();
		email=td.getData("login", 1, 0);
		pwd=td.getData("login", 2, 1);
		hp.filldetails(email, pwd);
		hp.isErrorMsgDisplayed();
		pwd=td.getData("login", 1, 1);
		hp.enterPassword(pwd);
		hp.clickLoginButton();
		hp.isLoginSuccessful();
		hp.logout();
		Reporter.log("TC_LOGIN_13: The user can retry; the valid credentials result in successful login.",true);
		
		
	}
	
	@Test(groups="fn")
	public void TC_LOGIN_15()
	{
		hp.clickLogin();
		hp.verifyLoginFormOnSmallerViewport();
		Reporter.log("TC_LOGIN_15: Login controls remain accessible without overlapping or blocking errors.",true);
	}
	
	
	
}
