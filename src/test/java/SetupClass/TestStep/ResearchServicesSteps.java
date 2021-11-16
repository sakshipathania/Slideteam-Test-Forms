package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.interactions.Actions;
import java.awt.Robot; 
import java.awt.event.KeyEvent;
import org.junit.Assert;
import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class ResearchServicesSteps extends Setup {
	
        WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	@Given("^chat popup$")
        public void chat_pop_up() throws InterruptedException
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
	@Then("^user is already on Submit Your Business Research Requirements form$")
	public void user_is_already_on_Submit_Your_Business_Research_Requirements_form() throws Throwable  {
	
		Thread.sleep(3000);
		try {
			driver.get("https://www.slideteam.net/");

		WebElement reserch_services = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//a[@class='menu-link'][normalize-space()='Research Services']")));
		reserch_services.click();

		WebElement submit_btn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(
				"//div[@class='research_btns']//button[@name='button'][normalize-space()='Submit Your Request']")));
		submit_btn.click();
			Thread.sleep(3000);	
	 }
          catch (NoSuchElementException popup) {
	  }
		
	}
	@Then("^user enter name on rs form$")
	public void user_enter_name_on_rs_form()  throws Throwable {
		Thread.sleep(3000);
		try {
		WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='name']")));
		name.sendKeys("SlideTeam Testing");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter email on rs form$")
	public void user_enter_email_on_rs_form() throws Throwable {
		Thread.sleep(3000);
		try {
		WebElement email = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='form_email']")));
		email.sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter mobile number on rs form$")
	public void user_enter_mobile_number_on_rs_form()throws Throwable  {
		Thread.sleep(3000);
		try {
		Select select = new Select(wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='country']"))));
		select.selectByValue("91");
		driver.findElement(By.id("telephone")).sendKeys("5678912345");
		Thread.sleep(3000);
	} catch  (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter comment on rs form$")
	public void user_enter_comment_on_rs_form()  throws Throwable{
		Thread.sleep(3000);
		try {
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+ 
								"Current Time is:->"+message_write_time);	
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user enter captcha on rs form$")
	public void user_enter_captcha_on_rs_form() throws Throwable {
		Thread.sleep(3000);
		try {
		driver.findElement(By.id("captcha_business_research_services_captcha")).sendKeys("Aj7W2mtf9namwf55");
		Thread.sleep(3000);
	} catch (NoSuchElementException popup) {
	  }
		
	}

	@Then("^user click on submit button on rs form$")
	public void user_click_on_submit_button_on_rs_form() throws Throwable {
		
		Thread.sleep(3000);
		driver.findElement(By.xpath("//label[@for='upload']")).click();
		
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
		
		try {
		driver.findElement(By.id("finalSubmit")).submit();
		Thread.sleep(3000);
			
		String verifySuccessfullMessage = wait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//p[contains(text(),'Thank You for submitting your request to SlideTeam')]"))).getText();
		System.out.println("message = " + verifySuccessfullMessage);
			
		Assert.assertTrue("Research form is not submitted successfully", verifySuccessfullMessage
				.contentEquals("Thank You for submitting your request to SlideTeam Research Services."));
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
