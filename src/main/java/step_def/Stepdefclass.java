package step_def;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import picnictest.MyDatabase;

public class Stepdefclass {
	
	public static WebDriver driver;
	
	MyDatabase ob = new MyDatabase();
	
	@Given("^login with credentials$")
	public void login_with_credentials() throws Throwable { 
	   
		System.setProperty("webdriver.chrome.driver", "src/main/java/latestdriver/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index ");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("labuser");
		driver.findElement(By.id("password")).sendKeys("labuser@01");
		driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block']")).click();
	}

	@Then("^clicks add recipient$")
	public void clicks_add_recipient() throws Throwable {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[2]")).click();
		Actions actions = new Actions(driver);
		
		actions.moveToElement(driver.findElement(By.linkText("Add/Edit Recipient"))).click().build().perform();
	    
	}

	
	@When("^user enters the details$")
	public void user_enters_the_details() throws Throwable {
	    
		MyDatabase.getdata(driver);
	}
	

	@Then("^new recipient is added$")
	public void new_recipient_is_added() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	
	@Given("^User log in with valid credentials$")
	public void user_log_in_with_valid_credentials() throws Throwable {
		System.setProperty("webdriver.chrome.driver", "src/main/java/latestdriver/chromedriver.exe");
	    driver = new ChromeDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index ");
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys("labuser");
		driver.findElement(By.id("password")).sendKeys("labuser@01");
		driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block']")).click();
	    
	}

	@Then("^Transfer the amount$")
	public void transfer_the_amount() throws Throwable {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[2]")).click();
		Actions act = new Actions(driver);
		act.moveToElement(driver.findElement(By.linkText("To Someone Else"))).click().build().perform();
		
		Select sel = new Select(driver.findElement(By.xpath("(//*[@class='form-control'])[1]")));
		sel.selectByVisibleText("Vinod1");

		Select sel1 = new Select(driver.findElement(By.xpath("(//*[@class='form-control'])[2]")));
		sel1.selectByVisibleText("Primary");
		
		driver.findElement(By.id("amount")).sendKeys("100");
	    driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block']")).click();
	   
	}

	@Then("^Close$")
	public void close() throws InterruptedException  {
		Thread.sleep(3000);
	    driver.close();
	    
	}
	


}
