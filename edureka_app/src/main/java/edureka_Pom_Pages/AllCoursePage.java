package edureka_Pom_Pages;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import generic_utility.ExplicitWait;

public class AllCoursePage {
	
	WebDriver driver;
	ExplicitWait wait;
	
	public AllCoursePage(WebDriver driver)
	{
		this.driver=driver;
		this.wait=new ExplicitWait(driver);
		PageFactory.initElements(driver,this);
	}
	

	//TC_AC_03
	
     @FindBy(xpath = "//ul[@class='slide_cat_list']/li[@data-category]")
     private List<WebElement> categories;

     //verification
      public void verifyAllCategoriesDisplayed() 
      {
       for (WebElement category : categories) {
        Assert.assertTrue(category.isDisplayed(),category.getAttribute("data-category") + " is not displayed");
    }
      }  
       
       
      //TC_AC_07 ,TC_AC_13

      public void selectCategory(String categoryName) 
      {
          for (WebElement category : categories)//from tc_03 
          {
              if (category.getAttribute("data-category").equals(categoryName)) 
              {
            	  Actions a=new Actions(driver);
            	  a.scrollToElement(category).perform();
            	  wait.waitForElementToBeVisible(category);
                  category.click();
                  return;
              }
          }

          Assert.fail("Category not found: " + categoryName);
          
    
      }
       
      
    //verification TC_AC_07
       
       @FindAll({@FindBy(xpath="(//div[@class=\"col-lg-4 col-md-6 col-sm-12 col-xs-12 course_card_bx\"])[last()]"),@FindBy(xpath="(//div[@class=\"col-lg-4 col-md-6 col-sm-12 col-xs-12 course_card_bx\"])[1]")})
       private WebElement mbacourses;
       
       
       public void iscoursesdisplayed()
       {
    	   Assert.assertTrue(mbacourses.isDisplayed(),"no course is displayed");
       }

       
       
       //verification TC_AC_13
       public boolean isCategorySelected(String categoryName)
	   {
		    WebElement category = driver.findElement(By.xpath("//ul[@class='slide_cat_list']/li[@data-category='"+ categoryName + "']") );
		    return category.getAttribute("class").contains("active");
		    //Assert.assertTrue(category.getAttribute("class").contains("active"),""+categoryName+" is not selected");
		}
       
       
       
       //TC_AC_12
       @FindBy(xpath="//li[@class=\"other_cat\"]")
       private WebElement othercat;
       
       public void clickOthers()
       {
    	   othercat.click();
       }
       
       //verification
       public void checkOtherCourses()
       {
    	   WebElement othercourses = driver.findElement(By.xpath("//div[@class=\"modal extra_cat_list fade show\"]"));
    	   Assert.assertTrue(othercourses.getAttribute("class").contains("show"),"other course section is empty");
       }
       
       
       
       //TC_AC_21
       @FindBy(xpath="//div[@id='pills-all-course']//div[contains(@class,'course_card_bx')]//a[@data-title]")
       private List<WebElement> courseCards;
       
       public void openCourse(int index) {
   	    courseCards.get(index).click();
   	}
       
       //Verification
       public String getCourseTitle(int index) {
    	    return courseCards.get(index).getAttribute("data-title");
    	}

    	@FindBy(xpath="//h1[@class=\"main_title_pgp\"]")
    	private WebElement coursetitle;
    	
    	public void verifyCourseDetails(String expectedTitle)
    	{
    		String actualTitle = coursetitle.getText();
    	    Assert.assertEquals(actualTitle,expectedTitle,"Course details page title does not match the selected course");
    	}
       

      
	  //TC_AC_24
    	
    	@FindBy(xpath = "//div[contains(@class,'desktop_click_search')]")
    	private WebElement searchCourses;
    	
    	public void clickSearchField()
    	{
    	    searchCourses.click(); 
    	}
    	
    	@FindBy(id="search-input")
    	private WebElement searchinput;
    	
    	public void enterSearchText(String text) {
    		
    		searchinput.clear();
    	    searchinput.sendKeys(text,Keys.ENTER);
    	    
    	}
       
    	//verification
    	
    	public void issearchResultEmpty()
    	{
    		 WebElement response = driver.findElement(By.xpath("//h1[text()='Your search did not match any courses']"));
    		wait.waitForElementToBeVisible(response);
    		Assert.assertTrue(response.isDisplayed(),"Course is avaliable");
    	}
       
      
    	
    	//TC_AC_28
    	@FindBy(xpath = "//div[@id='pills-all-course']//div[contains(@class,'Pagination')]")
        private WebElement pagination;
    	
    	 //storing page 1 courses titles in a list
    	public List<String> getCourseTitles() {

	        List<String> titles = new ArrayList<>();
	
	        for (WebElement course : courseCards) 
	        {
	            titles.add(course.getAttribute("data-title"));
	        }
	
	        return titles;
    	    }
    	
    	public void clickNextpage()
    	{
    		WebElement nextbutton = driver.findElement(By.xpath("//a[text()='Next']"));
    		
    		JavascriptExecutor js = (JavascriptExecutor) driver;
    	    js.executeScript("arguments[0].scrollIntoView({block:'center'});", nextbutton);

    	    wait.waitForElementToBeClickable(nextbutton);
      	    nextbutton.click();
    	}

    	
    	 public void verifyNoOverlap(List<String> page1Titles,List<String> page2Titles) {

	        Set<String> page1Set = new HashSet<>(page1Titles);
	        Set<String> overlappingTitles = new HashSet<>(page2Titles);

	        overlappingTitles.retainAll(page1Set);

	        Assert.assertTrue(overlappingTitles.isEmpty(),"Duplicate course titles found across page 1 and page 2: "+ overlappingTitles);
    	    }

}
