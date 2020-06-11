package picnictest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class TechFish_Bank {
	
	
	public static void main (String [] args) {
		
		System.setProperty("webdriver.chrome.driver", "J:\\Projects\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://elastic.rapidtestpro.com:8086/index ");
		driver.findElement(By.id("username")).sendKeys("labuser");
		driver.findElement(By.id("password")).sendKeys("labuser@01");
		driver.findElement(By.xpath("//*[@class='btn btn-lg btn-primary btn-block']")).click();
		driver.findElement(By.xpath("(//*[@class='dropdown-toggle'])[2]")).click();
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.linkText("Add/Edit Recipient"))).click().build().perform();
		
		//driver.findElement(By.id("recipientName")).sendKeys("vinod");
		
	}
	
	
	

}
