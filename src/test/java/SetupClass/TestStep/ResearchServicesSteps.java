package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class ResearchServicesSteps extends Setup {

	
	@Given("^user is already on Submit Your Business Research Requirements form$")
	public void user_is_already_on_Submit_Your_Business_Research_Requirements_form() throws Throwable  {
		Thread.sleep(3000);
		driver.findElement(By.cssSelector("div.links:nth-child(6) > ul:nth-child(2) > li:nth-child(10) > a:nth-child(1)")).click();
		Thread.sleep(2000);	
	}

	@Then("^user enter name on rs form$")
	public void user_enter_name_on_rs_form()  throws Throwable{
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("SlideTeam Testing");
		Thread.sleep(1000);
	}

	@Then("^user enter email on rs form$")
	public void user_enter_email_on_rs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("form_email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}

	@Then("^user enter mobile number on rs form$")
	public void user_enter_mobile_number_on_rs_form()throws Throwable  {
		Thread.sleep(1000);
		driver.findElement(By.id("telephone")).sendKeys("5678912345");
		Thread.sleep(1000);
	}

	@Then("^user enter comment on rs form$")
	public void user_enter_comment_on_rs_form()  throws Throwable{
		Thread.sleep(1000);
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+ 
								"Current Time is:->"+message_write_time);	
		Thread.sleep(1000);
	}

	@Then("^user enter captcha on rs form$")
	public void user_enter_captcha_on_rs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("captcha_business_research_services_captcha")).sendKeys("Aj7W2mtf9namwf55");
		Thread.sleep(1000);
	}

	@Then("^user click on submit button on rs form$")
	public void user_click_on_submit_button_on_rs_form() throws Throwable {
		
		Thread.sleep(1000);
		driver.findElement(By.id("finalSubmit")).submit();
		Thread.sleep(1000);
		
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
