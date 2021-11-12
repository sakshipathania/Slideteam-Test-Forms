package SetupClass.TestStep;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import java.awt.Robot; 
import java.awt.event.KeyEvent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;


public class DesignServicesFormSteps extends Setup{

	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js;
	
	@Given("^user is already on design services page$")
	public void user_is_already_on_design_services_page() throws Throwable {
	    Thread.sleep(1000);
	   // driver.get("https://www.slideteam.net/powerpoint_presentation_design_services");
		try {
			WebElement presentationServices = wait
					.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Presentation Services']")));
			js.executeScript("arguments[0].scrollIntoView();", presentationServices);

			presentationServices.click();

		} catch (NoSuchElementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		try {
		driver.findElement(By.xpath("//*[@id='mulitplefileuploader']/div[1]/div/label/span")).click();
		Thread.sleep(2000);
		}
		catch (NoSuchElementException e) { }
		
		//attach.click();
		Robot r = new Robot(); 
		r.keyPress(KeyEvent.VK_ESCAPE); 
		r.keyRelease(KeyEvent.VK_ESCAPE);
	    	}

	@Then("^user enter captcha on DS form$")
	public void user_enter_captcha_on_DS_form() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement blog_captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_custom_design_service_captcha")));
	    Thread.sleep(8000);
	    blog_captcha.sendKeys("Aj7W2mtf9namwf55");
	    Thread.sleep(8000);
   
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
		
		//verify the successfull meaasge
	    String verifySuccessfullMessage = wait.until(ExpectedConditions.elementToBeClickable(
					By.xpath("//p[contains(text(),'Thank You for submitting your request to SlideTeam')]"))).getText();
			Assert.assertTrue("contact us form is not submitted successfully", verifySuccessfullMessage.contentEquals("Thank You for contacting SlideTeam.net"));
			System.out.println("contact us form submitted successfully");	
		
	}


}
