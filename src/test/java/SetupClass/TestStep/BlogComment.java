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

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class BlogComment extends Setup {
	
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

       
	@Then("^user is already on blog form$")
	public void user_is_already_on_blog_form() throws Throwable {
		Thread.sleep(2000);
		driver.get("https://www.slideteam.net/blog/using-images-in-presentations-11-dos-and-donts/");
		Thread.sleep(3000);
		   driver.manage().deleteAllCookies();
		   Thread.sleep(2000);
	}
	
	@Then("^user close the coupon popup$")
	public void user_close_the_coupon_popup() throws Throwable {
		Thread(2000);
		driver.findElement(By.xpath("//*[@id='blog-detail-popup']/div/div/div[1]/button")).click();
		Thread(1000);
	}

	@Then("^user enter name on blog form$") 
	public void user_enter_name_on_blog_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("author")).sendKeys("SlideTeam Testing");
		Thread.sleep(1000);
	}

	@Then("^user enter email on blog form$")
	public void user_enter_email_on_blog_form() throws Throwable{
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("himanshi.sharma@slidetech.in");
		Thread.sleep(1000);
	}
	
	@Then("^user enter comment on blog form$")
	public void user_enter_comment_on_blog_form()throws Throwable {
		Thread.sleep(1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+ ""+""+
								"Page URL is:-> https://www.slideteam.net/blog/using-these-smart-goals-can-increase-your-impact-as-a-marketer/"+"\n"+ ""+""+
								"Current Time is:->"+message_write_time);		
		Thread.sleep(1000);
		
	}
	
	@Then("^user enter captcha on blog form$")
	public void user_enter_captcha_on_blog_form() throws Throwable {
		
		WebElement blog_captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_blog_captcha_form")));
	    Thread.sleep(2000);
	    blog_captcha.sendKeys("Aj7W2mtf9namwf55");
	    Thread.sleep(3000);

	    
	    
	}

	@Then("^user click on Submit button on blog form$")
	public void user_click_on_Submit_button_on_blog_form()throws Throwable {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[contains(.,'Leave a comment')]")).click();;
		Thread.sleep(3000);
		
		
	}
	
	
}
