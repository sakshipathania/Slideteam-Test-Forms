package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.awt.Robot; 
import java.awt.event.KeyEvent;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DesignServicesFormSteps extends Setup{

	@Given("^user is already on design services page$")
	public void user_is_already_on_design_services_page() throws Throwable {
	    Thread.sleep(1000);
	    driver.get("https://www.slideteam.net/powerpoint_presentation_design_services");
	    Thread.sleep(1000);
	}

	@Then("^user enter name on design services form$")
	public void user_enter_name_on_design_services_form() throws Throwable {
	    Thread.sleep(1000);
	    driver.findElement(By.id("name")).sendKeys("SlideTeam Testing");
	    Thread.sleep(1000);
	}

	@Then("^user enter email on design services form$")
	public void user_enter_email_on_design_services_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}

	@Then("^user enter project description on design services form$")
	public void user_enter_project_description_on_design_services_form() throws Throwable {
		Thread.sleep(1000);
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+
								"Page URL is:-> https://www.slideteam.net/powerpoint_presentation_design_services"+"\n"+ 
								"Current Time is:->"+message_write_time);	
	    Thread.sleep(1000);
	}

	@Then("^user attach a file on design services form$")
	public void user_attach_a_file_on_design_services_form() throws Throwable {
		Thread.sleep(1000);
		WebElement attach= driver.findElement(By.cssSelector("#mulitplefileuploader > label > span"));
		attach.click();
		Thread.sleep(3000);
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
	    	}

	@Then("^user submit the design services form$")
	public void user_submit_the_design_services_form() throws Throwable {
	    Thread.sleep(1000);
	    driver.findElement(By.id("finalSubmit")).click();
	    Thread.sleep(1000);
	    System.out.print("form is submitted at:->> ");
	    //System.out.println(System.currentTimeMillis()/1000);
	    SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    String Button_Click_Time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
	}


}
