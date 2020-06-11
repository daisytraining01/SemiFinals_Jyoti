package picnictest;

import java.util.LinkedList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class MyDatabase {
	
	public LinkedList<String> name = new LinkedList<String>();
	
	public static void getdata(WebDriver driver) throws FilloException, InterruptedException {
		
		LinkedList<String> name = new LinkedList<String>();
		LinkedList<String> email = new LinkedList<String>();
		LinkedList<String> phone = new LinkedList<String>();
		LinkedList<String> account= new LinkedList<String>();
		LinkedList<String> desc = new LinkedList<String>();
		
		Fillo fillo=new Fillo();
		Connection connection=fillo.getConnection("src\\main\\java\\driver\\Filosheet.xlsx");
		String strQuery="Select * from sheet1";
		Recordset recordset=connection.executeQuery(strQuery);
		 
		while(recordset.next()){
		//System.out.println(recordset.getField("Name"));
			
			name.add(recordset.getField("Name"));
			email.add(recordset.getField("Email"));
			phone.add(recordset.getField("Phone Number"));
			account.add(recordset.getField("Account Number"));
			desc.add(recordset.getField("Description"));
		}
		
		for (int i=0;i<5;i++) {
			
			driver.findElement(By.name("name")).sendKeys(name.get(i));
			driver.findElement(By.name("email")).sendKeys(email.get(i));
			driver.findElement(By.name("phone")).sendKeys(phone.get(i));
			driver.findElement(By.name("accountNumber")).sendKeys(account.get(i));
			driver.findElement(By.id("recipientDescription")).sendKeys(desc.get(i));
			
			Thread.sleep(2000);
			
			driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
			
		}
		
		recordset.close();
		connection.close();
		
		
	}
	
	
	public static void main (String [] args) throws FilloException {
		//getdata();
	}

}
