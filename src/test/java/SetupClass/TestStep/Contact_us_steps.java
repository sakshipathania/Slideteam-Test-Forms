package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Contact_us_steps extends Setup {
	
	// contact us form
	
	@Given("^user is already on contact us form$")
	public void user_is_already_on_contact_us_form()  throws Throwable {
		driver.get(AppURL);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		log.info("It's opening the website URL");
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("div.links:nth-child(6) > ul:nth-child(2) > li:nth-child(4) > a:nth-child(1)")).click();
		Thread.sleep(1000);
	}

	@Then("^user enter name$")
	public void user_enter_name() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("SlideTeam Testing");
		Thread.sleep(1000);
	    
	}

	@Then("^user enter email$")
	public void user_enter_email()throws Throwable
	{
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}
	
	@Then("^user enter mobile number$")
	public void user_enter_mobile_number()  throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("telephone")).sendKeys("877566756657");
		Thread.sleep(1000);
	}

	@Then("^user enter comment$")
	public void user_enter_comment()throws Throwable  {
		Thread.sleep(1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/contacts"+"\n"+""+""+ 
								"Current Time is:->"+message_write_time);		
		Thread.sleep(2000);
	}

	@Then("^user enter captcha comment$")
	public void user_enter_captcha_comment() throws Throwable {
Thread.sleep(3000);
		
		
		driver.findElement(By.xpath("//input[@id='captcha_contact_us']")).sendKeys("Aj7W2mtf9namwf55");
	    Thread.sleep(1000);
	}
	
	@Then("^user click on submit button$")
	public void user_click_on_submit_button()throws Throwable  {
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("button.btn > span:nth-child(1) > span:nth-child(1)")).click();
		Thread.sleep(1000);
		System.out.print("form is submitted at:->> ");
	    //System.out.println(System.currentTimeMillis()/1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    String Button_Click_Time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
	}
	
}
