package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot; 
import java.awt.event.KeyEvent;
import org.openqa.selenium.JavascriptExecutor;
import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait

public class ResumeServices extends Setup {
 
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^chat popup1$")
        public void chat_pop_up1() throws InterruptedException
        {
        try {
            WebElement iframe = driver.findElement(By.id("livechat-full-view"));
            if(iframe.isDisplayed()) {
                driver.switchTo().frame(iframe);   
                 Actions act = new Actions(driver);
                 act.moveToElement(driver.findElement(By.cssSelector("#title .icon-minimize"))).build().perform();
                 Thread.sleep(2000);
                    WebElement chat1=driver.findElement(By.cssSelector("#title .icon-minimize"));
                     Thread.sleep(1000);
                        chat1.click();
                         Thread.sleep(1000);
                         driver.switchTo().defaultContent();
                         Thread.sleep(1000);
                         driver.switchTo().parentFrame();
                     Thread.sleep(1000);
            }
            else {
                    System.out.println("chat window does not open");
                 }
        }
                catch(NoSuchElementException NCP) {
                    
                }
    }
	@Then("^user is already on Submit your Resume Request form$")
	public void user_is_already_on_Submit_your_Resume_Request_form() throws Throwable  {
	
		Thread.sleep(3000);
		try {
			//driver.get("https://www.slideteam.net/resume_service");
		//driver.findElement(By.cssSelector("div.links:nth-child(6) > ul:nth-child(2) > li:nth-child(10) > a:nth-child(1)"));
			//driver.findElement(By.xpath("/html/body/div[5]/div/div[2]/div/div/div/div/div[2]/div/a")).click();
		
		//*Submit.click();
			//Thread.sleep(10000);	
			//driver.get("https://www.slideteam.net/resume_service");
		WebElement resume_services = wait
				.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Resume Services']")));
		js.executeScript("arguments[0].scrollIntoView();", resume_services);

		resume_services.click();
	 }
          catch (NoSuchElementException popup) {
	  }
		
	}
	@Then("^user enter name on Resume form$")
	public void user_enter_name_on_Resume_form()  throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.cssSelector("#customresumeservice_form1 > div.clearfix.form-top-block > div:nth-child(1) > div > input")).sendKeys("SlideTeam Testing");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter email on resume form$")
	public void user_enter_email_on_resume_form() throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.cssSelector("#customresumeservice_form1 > div.clearfix.form-top-block > div:nth-child(2) > div.input-box > input")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter comment on resume form$")
	public void user_enter_comment_on_resume_form()  throws Throwable{
		Thread.sleep(3000);
		try {
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.cssSelector("#customresumeservice_form1 > div.clearfix.form-top-block > div:nth-child(4) > div > input[type=text]")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");	
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter captcha on resume form$")
	public void user_enter_captcha_on_resume_form() throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("captcha_resume_service_captcha1")).sendKeys("Aj7W2mtf9namwf55");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}
	
	@Then("^User click on Upload Resume button")
	public void User_click_on_Upload_Resume_button() throws Throwable {
		Thread.sleep(6000);
	        WebElement Upload= driver.findElement(By.cssSelector("#mulitplefileuploader1 > div.ajax-upload-dragdrop.input-text > div > label"));
		Thread.sleep(2000);
		Upload.click();
		Thread.sleep(10000);
		//Upload.click();
		//Thread.sleep(3000);
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
	}
	

	@Then("^user click on submit button on resume form$")
	public void user_click_on_submit_button_on_resume_form() throws Throwable {
		
		try {
			Thread.sleep(3000);
		driver.findElement(By.cssSelector("#customresumeservice_form1 > div.clearfix.inner-attach > div.col.submit_file > div > input[type=submit]")).submit();
		Thread.sleep(3000);
		
		String verifySuccessfullMessage = wait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//p[contains(text(),'Thank You for submitting your request to SlideTeam')]")))
				.getText();
		System.out.println("message = " + verifySuccessfullMessage);
		Assert.assertTrue("Research form is not submitted successfully", verifySuccessfullMessage
				.contentEquals("Thank You for submitting your request to SlideTeam Design Services."));
		System.out.println("Research form is submitted successfully");
		
	} catch (NoSuchElementException popup) {
	  }
		
	}
		/*
		 * System.out.print("form is submitted at:->> ");
		 * //System.out.println(System.currentTimeMillis()/1000); SimpleDateFormat
		 * formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); Date date =
		 * new Date(System.currentTimeMillis()); String
		 * Button_Click_Time=formatter.format(date);
		 * System.out.println(Button_Click_Time);
		 */  
	    
	   


}
