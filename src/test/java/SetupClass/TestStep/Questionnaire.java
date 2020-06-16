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
import org.openqa.selenium.Alert;
import java.awt.AWTException; 
import java.awt.Robot; 
import java.awt.event.KeyEvent; 

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class Questionnaire extends Setup {

	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on questionnaire form page$")
	public void user_is_already_on_questionnaire_form_page() throws Throwable {
		Thread.sleep(1000);
		driver.get("https://www.slideteam.net/questionnaire/");
		Thread.sleep(1000);
	}

	@Then("^user enter name on questionnaire form$")
	public void user_enter_name_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.name("name")).sendKeys("SlideTeam Testing");
		Thread.sleep(1000);
	}

	@Then("^user enter email on questionnaire form$")
	public void user_enter_email_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.name("email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}

	@Then("^user enter phone on questionnaire form$")
	public void user_enter_phone_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.name("phone")).sendKeys("852364598");
		Thread.sleep(1000);
	}

	@Then("^user enter number of slides on questionnaire form$")
	public void user_enter_number_of_slides_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.name("number_of_slides")).sendKeys("8");
		Thread.sleep(1000);
	}

	@Then("^user enter  Style Requirement on questionnaire form$")
	public void user_enter_Style_Requirement_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
	    //driver.findElement(By.cssSelector("div.user-detail:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > textarea:nth-child(2)")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore. ");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.cssSelector("div.user-detail:nth-child(4) > ul:nth-child(2) > li:nth-child(2) > textarea:nth-child(2)")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+""+""+
								"Current Time is:->"+message_write_time);	
		Thread.sleep(1000);
	}
	
	@Then("^User click on Upload button")
	public void User_click_on_Upload_button() throws Throwable {
		Thread.sleep(1000);
		WebElement Upload= driver.findElement(By.xpath("//a[contains(text(),'Upload')]"));;
		js.executeScript("arguments[0].scrollIntoView();",Upload);	
		Thread.sleep(1000);
		Upload.click();
		Thread.sleep(1000);
		try { 

          Robot robot = new Robot(); 
          robot.keyPress(KeyEvent.VK_ESCAPE); 
         } 
          catch (AWTException e) { 
           e.printStackTrace(); 
         } 
	}

	@Then("^user click on submit on questionnaire form$")
	public void user_click_on_submit_on_questionnaire_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("finalSubmit")).submit();
		Thread.sleep(1000);
		System.out.print("form is submitted at:->> ");
	    //System.out.println(System.currentTimeMillis()/1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    String Button_Click_Time=formatter.format(date);
	    System.out.println(Button_Click_Time);   
	}

	
}
