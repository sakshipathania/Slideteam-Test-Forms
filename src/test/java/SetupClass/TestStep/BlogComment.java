package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.remote.DesiredCapabilities;  
import org.openqa.selenium.Alert; 
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class BlogComment extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js;
	
	
	@Given("^user is already on blog form$")
	public void user_is_already_on_blog_form() throws Throwable {
		
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
		Thread.sleep(2000);
		driver.get("https://www.slideteam.net/blog/top-25-usa-sales-territory-map-powerpoint-templates-for-hitting-targets/");
		Thread.sleep(3000);
		driver.manage().deleteAllCookies();
		   Thread.sleep(20000);
	          
	}
	@Then("Pop up is going ready to be closed$")
	 public void Pop_up_is_going_ready_to_be_closed() throws InterruptedException 
        {  
  //Generating Alert Using Javascript Executor
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("alert('Pop up is going ready to be closed..');");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
         }
	
	 @Then("^user close the coupon popup$")
    public void user_close_the_coupon_popup() throws Throwable {
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    js=(JavascriptExecutor)driver;
            js.executeScript("jQuery('#blog-detail-popup').magnificPopup('close')");
	    Thread.sleep(10000);
        // driver.findElement(By.cssSelector("#blog-detail-popup > div > div > div.modal-header > button")).click();
	    
          } 
	
	@Then("Pop up is closed$")
	 public void Pop_up_is_closed() throws InterruptedException 
        {  
  //Generating Alert Using Javascript Executor
        JavascriptExecutor javascript = (JavascriptExecutor) driver;
        javascript.executeScript("alert('Pop up is closed now..');");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
	 }
	
	@Then("^user enter comment on blog form$")
	public void user_enter_comment_on_blog_form() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+ ""+""+
								"Page URL is:-> https://www.slideteam.net/blog/using-these-smart-goals-can-increase-your-impact-as-a-marketer/"+"\n"+ ""+""+
								"Current Time is:->"+message_write_time);		
		Thread.sleep(8000);

	}
	
	
	@Then("^user enter captcha on blog form$")
	public void user_enter_captcha_on_blog_form() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement blog_captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_blog_captcha_form")));
	    Thread.sleep(8000);
	    blog_captcha.sendKeys("885");
	    Thread.sleep(8000);
   
	}

	@Then("^user click on Submit button on blog form$")
	public void user_click_on_Submit_button_on_blog_form()throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Leave a comment')]")).click();;
		Thread.sleep(3000);		
		
	}
	
	
}
