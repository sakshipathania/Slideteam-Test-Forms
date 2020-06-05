package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;

import org.apache.commons.collections.SetUtils;
import org.openqa.selenium.By;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class Contact_Us_To_Get_Started extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	
	@Given("^user is already on contact us to get started form$")
	public void user_is_already_on_contact_us_to_get_started_form()  throws Throwable{
		Thread.sleep(1000);
		driver.get("https://www.slideteam.net/powerpoint_presentation_design_services/hire-a-designer");
		Thread.sleep(1000);
		WebElement contact_us_footer= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title=' Contact Us'][contains(.,'Contact Us')]")));
		clear_cache();
		Thread.sleep(3000);
		js.executeScript("arguments[0].scrollIntoView();",contact_us_footer);
		contact_us_footer.click();
		log.info("FOOTER --> CONTACT US");
		Thread.sleep(3000);
		//chat_pop_up();
		//err_page();
	}

	@Then("^user enter name on gs form$")
	public void user_enter_name_on_gs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("name")).sendKeys("SlideTeam Testing");
		Thread.sleep(1000);
	}

	@Then("^user enter email on gs form$")
	public void user_enter_email_on_gs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("email")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);
	}

	@Then("^user enter phone number on gs form$")
	public void user_enter_phone_number_on_gs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.id("telephone")).sendKeys("8295782957");
		Thread.sleep(1000);
	    
	}

	@Then("^user enter message on gs form$")
	public void user_enter_message_on_gs_form()  throws Throwable{
		Thread.sleep(1000);
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/contacts"+"\n"+""+""+ 
								"Current Time is:->"+message_write_time);		
		Thread.sleep(1000);
	}

	@Then("^user click on submit button on gs form$")
	public void user_click_on_submit_button_on_gs_form() throws Throwable {
		Thread.sleep(1000);
		driver.findElement(By.className("text-center")).submit();
		Thread.sleep(1000);
	}


}
