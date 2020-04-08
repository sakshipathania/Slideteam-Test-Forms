package SetupClass.TestStep;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SetupClass.Set;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Sign_in_existing_paid_user extends Set {
	
	WebDriverWait wait = new WebDriverWait(driver,50);


@Given("^user is already on sign in page epu$")
public void user_is_already_on_sign_in_page_epu() throws InterruptedException  {
    
	driver.get(AppURL);
	driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	log.info("It's opening the website URL");
	Thread.sleep(1000);
	driver.get("https://www.slideteam.net");
	Thread.sleep(2000);
	driver.get("https://www.slideteam.net");
	Thread.sleep(2000);
    driver.manage().deleteAllCookies();
    Thread.sleep(2000);
	try {
		driver.findElement(By.cssSelector(".authorization-link > a:nth-child(1)")).click();
		Thread.sleep(2000);
		log.info("It's opening the website URL");
	   } 
	    catch (NoSuchElementException popup) {
	 }
  }

      @Then("^user enter email and password epu$")
      public void user_enter_email_and_password_epu() throws InterruptedException  {
    
	    WebElement old_paid_email = wait.until(ExpectedConditions.elementToBeClickable(By.id("email")));
      old_paid_email.sendKeys("himanshi.sharma@slidetech.in");
    
      WebElement old_paid_pass = wait.until(ExpectedConditions.elementToBeClickable(By.id("pass")));
      old_paid_pass.sendKeys("123456");
      }

       @Then("^user click on login button epu$")
       public void user_click_on_login_button_epu() throws InterruptedException  {
   
	     WebElement old_paid_login_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button.login > span:nth-child(1)")));
	     old_paid_login_btn.click();
       }

        @Then("^user navigate to complete deck from account dashboard page$")
        public void user_navigate_to_complete_deck_from_account_dashboard_page() throws InterruptedException  {
    
	      driver.get("https://www.slideteam.net/complete-powerpoint-decks-presentations/all-powerpoint-complete-decks.html");
	      Thread.sleep(3000);
	 
	       WebElement select_product=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("li.product:nth-child(1) > div:nth-child(1) > div:nth-child(2) > strong:nth-child(1) > span:nth-child(1) > a:nth-child(1)")));
	       Thread.sleep(2000);   
	       select_product.click();
	        Thread.sleep(2000);
	    
       }

        @Then("^user download any product$") 
         public void user_download_any_product() throws InterruptedException  {
    
	       WebElement download_btn=wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#clicking")));
         Thread.sleep(2000);
         download_btn.click();
         Thread.sleep(2000);
         driver.navigate().refresh();
    
         }

         @Then("^User Logout\\.$")
         public void user_Logout() throws Throwable {
	       Thread.sleep(3000);
	   
	       driver.findElement(By.xpath("//a[contains(.,'Sign Out')]")).click();
	       Thread.sleep(3000);
	 
	 
	 
         }

	
    }
