package com.codinground.pageObjects.clearTripPage;
import com.codinground.testBase.TestBase;
import com.codinground.uiActions.CommonUIActions;
import com.codinground.waitHelper.WaitHelper;
import com.sun.javafx.PlatformUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignInTest extends TestBase   {

   WebDriver driver;
   
   @FindBy(how=How.XPATH ,using=".//*[@class='signInBlock']//input[@id='SignIn']")
   WebElement SignIn;
   @FindBy(how=How.XPATH,using=".//*[@id='userAccountLink']/span[contains(text(),'Your trips')]")
   WebElement Your_trips;
   @FindBy(how=How.ID,using="signInButton")
   WebElement signInButton;
   @FindBy(how=How.XPATH,using=".//h1[contains(text(),'Sign in to Cleartrip')]")
   WebElement SignIn_header;
   @FindBy(how=How.XPATH,using=".//input[@id='email']")
   WebElement user_email;
   @FindBy(how=How.XPATH,using=".//input[@id='password']")
   WebElement user_passWord;
   @FindBy(how=How.XPATH,using=".//*[@class='errors' and @id='errors1']")
   public WebElement errors_onInvalidSignin;
   
   
   
     public SignInTest(WebDriver driver) {
    	 this.driver=driver;
    	 PageFactory.initElements(driver,this);
		// TODO Auto-generated constructor stub
	}
     
     WaitHelper helpWithWait = new WaitHelper(driver);
     
     
     public void signINClearTrip(String userName,String password)
     {
    	 try{
    	 Your_trips.click();
    	 SignIn.click();
    	 CommonUIActions act = new CommonUIActions(driver);
    	 act.iHandleFrame("modal_window");
    	 //helpWithWait.waitForElement(SignIn_header);
    	 user_email.clear();
    	 user_email.sendKeys(userName);
    	 user_passWord.sendKeys(password);
    	 signInButton.click();
    	 }
    	 catch (Exception e) {
			e.printStackTrace();
		}
     }
     
     public void signOut()
     {
    	 Your_trips.click();
    	 helpWithWait.waitForElement(user_email);
    	 
    	 
    	 
     }
     
     public boolean verifyerrors(WebElement element)
     {
    	 CommonUIActions act = new CommonUIActions(driver);
    	 return act.isElementDisplayed(element);
    	 
     }
     
     
     

    //@Test
//    public void shouldThrowAnErrorIfSignInDetailsAreMissing() {
//
//        setDriverPath();
//    	 WebDriver driver = new ChromeDriver();
//
//        driver.get("https://www.cleartrip.com/");
//        waitFor(2000);
//
//        driver.findElement(By.linkText("Your trips")).click();
//        driver.findElement(By.id("SignIn")).click();
//
//        driver.findElement(By.id("signInButton")).click();
//
//        String errors1 = driver.findElement(By.id("errors1")).getText();
//        Assert.assertTrue(errors1.contains("There were errors in your submission"));
//        driver.quit();
//    }
    
    /*
     * I have written all this method in Base class or one class
     *  Wait related functions are present in one waitHelper class
     */

//    private void waitFor(int durationInMilliSeconds) {
//        try {
//            Thread.sleep(durationInMilliSeconds);
//        } catch (InterruptedException e) {
//            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
//        }
    

//    private void setDriverPath() {
//        if (PlatformUtil.isMac()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver");
//        }
//        if (PlatformUtil.isWindows()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
//        }
//        if (PlatformUtil.isLinux()) {
//            System.setProperty("webdriver.chrome.driver", "chromedriver_linux");
//        }
    }



