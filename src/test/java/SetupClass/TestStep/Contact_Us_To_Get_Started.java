package SetupClass.TestStep;
import java.util.Iterator;
import java.util.Set;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.apache.commons.collections.SetUtils;
import org.openqa.selenium.By;

import SetupClass.Setup;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import gherkin.lexer.Th;

public class Contact_Us_To_Get_Started extends Setup {
	
	WebDriverWait wait = new WebDriverWait(driver,50);
	JavascriptExecutor js = (JavascriptExecutor) driver;
	

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
	
	@Given("^user is already on contact us to get started form$")
	public void user_is_already_on_contact_us_to_get_started_form()  throws Throwable{
		Thread.sleep(1000);
		driver.get("https://www.slideteam.net/");
		try {
				WebElement presentationServices = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Presentation Services']")));

				presentationServices.click();

				Thread.sleep(1000);
				WebElement knowMore = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@title='Know More']")));
				js.executeScript("arguments[0].scrollIntoView();", knowMore);

				knowMore.click();
			
			String mainWindow = driver.getWindowHandle();

		System.out.println("user is on mainWindow ------" + mainWindow);
		// It returns no. of windows opened by WebDriver and will return Set of Strings
		Thread.sleep(4000);
		Set<String> set = driver.getWindowHandles();

		// Using Iterator to iterate with in windows
		Iterator<String> itr = set.iterator();
		while (itr.hasNext()) {
			String childWindow = itr.next();
			// Compare whether the main windows is not equal to child window. If not equal,
			// we will close.

			System.out.println("set size = " + set.size());
			if (!mainWindow.equals(childWindow)) {

				driver.switchTo().window(childWindow);
				System.out.println("user is on childwindow  ------" + childWindow);
				//enter data in fields 
				WebElement Name = driver.findElement(By.xpath("//*[@id='name']"));
				js.executeScript("arguments[0].scrollIntoView();", Name);
				Thread.sleep(1000);
				Name.sendKeys("SlideTeam Testing");

				driver.findElement(By.xpath("//*[@id='email']")).sendKeys("slidetech.qa@gmail.com");
				Thread.sleep(1000);

				WebElement telephone = wait
						.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='telephone']")));
				telephone.sendKeys("8295782957");

				Thread.sleep(1000);
				
				Thread.sleep(1000);
		                //driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		                SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	                        Date date = new Date(System.currentTimeMillis());  
	                        message_write_time=formatter.format(date);
	                        System.out.println(Button_Click_Time);  
		               driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/contacts"+"\n"+""+""+ 
								"Current Time is:->"+message_write_time);		
		               Thread.sleep(1000);

				
                                //enter captcha
				WebElement blog_captcha = wait
						.until(ExpectedConditions.elementToBeClickable(By.id("captcha_hire_a_designer_captcha")));
				Thread.sleep(8000);
				blog_captcha.sendKeys("Aj7W2mtf9namwf55");

				driver.findElement(By.className("text-center")).submit();

				// verift the successfull message
				String verifySuccessfullMessage = wait
						.until(ExpectedConditions.elementToBeClickable(
								By.xpath("//p[contains(text(),'Thank You for submitting your request to SlideTeam')]")))
						.getText();
				Assert.assertTrue("contact us form is not submitted successfully", verifySuccessfullMessage
						.contentEquals("Thank You for submitting your request to SlideTeam Design Services."));
				System.out.println("form submitted successfully");
				Thread.sleep(1000);

			}
		}
		// This is to switch to the main window
		driver.switchTo().window(mainWindow);

			} catch (NoSuchElementException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		Thread.sleep(4000);
		
	}

	@Then("^user enter name on gs form$")
	public void user_enter_name_on_gs_form() throws Throwable {
		
		/*Thread.sleep(1000);
		WebElement Name= driver.findElement(By.xpath("//*[@id='name']"));
		js.executeScript("arguments[0].scrollIntoView();",Name);
		Thread.sleep(1000);
		Name.sendKeys("SlideTeam Testing");
		Thread.sleep(1000);*/
	}

	@Then("^user enter email on gs form$")
	public void user_enter_email_on_gs_form() throws Throwable {
		/*Thread.sleep(1000);
		driver.findElement(By.xpath("//*[@id='email']")).sendKeys("slidetech.qa@gmail.com");
		Thread.sleep(1000);*/
	}

	@Then("^user enter phone number on gs form$")
	public void user_enter_phone_number_on_gs_form() throws Throwable {
		/*Thread.sleep(1000);
		WebElement telephone = wait.until(
						ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='telephone']")));
		telephone.sendKeys("8295782957");
		//driver.findElement(By.xpath("//input[@id='telephone']")).sendKeys("8295782957");
		Thread.sleep(1000);*/
	    
	}

	@Then("^user enter message on gs form$")
	public void user_enter_message_on_gs_form()  throws Throwable{
		/*Thread.sleep(1000);
		//driver.findElement(By.id("comment")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore.");
		SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm:ss z"); 
	    Date date = new Date(System.currentTimeMillis());  
	    message_write_time=formatter.format(date);
	    System.out.println(Button_Click_Time);  
		driver.findElement(By.xpath("//*[@id='comment']")).sendKeys("This is a text message for QA purposes sent by an automated program. Please ignore."+ "\n"+""+""+
								"Page URL is:-> https://www.slideteam.net/contacts"+"\n"+""+""+ 
								"Current Time is:->"+message_write_time);		
		Thread.sleep(1000);*/
	}

	@Then("^user enter captcha on cs form$")
	public void user_enter_captcha_on_cs_form() throws Throwable {
		/*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		WebElement blog_captcha = wait.until(ExpectedConditions.elementToBeClickable(By.id("captcha_hire_a_designer_captcha")));
	    Thread.sleep(8000);
	    blog_captcha.sendKeys("Aj7W2mtf9namwf55");
	    Thread.sleep(8000);*/
   
	}
	
	@Then("^user click on submit button on gs form$")
	public void user_click_on_submit_button_on_gs_form() throws Throwable {
		/*Thread.sleep(1000);
		driver.findElement(By.className("text-center")).submit();
		Thread.sleep(1000);
		//verift the successfull message
		String verifySuccessfullMessage = wait
				.until(ExpectedConditions.elementToBeClickable(
						By.xpath("//p[contains(text(),'Thank You for submitting your request to SlideTeam')]")))
				.getText();
		Assert.assertTrue("contact us form is not submitted successfully",
				verifySuccessfullMessage.contentEquals("Thank You for submitting your request to SlideTeam Design Services."));
		System.out.println("form submitted successfully");*/
	}


}
