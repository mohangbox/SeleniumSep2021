package week2.dayAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateContact {
	
	/*
	 * //Pseudo Code
	 * 1. Launch URL "http://leaftaps.com/opentaps/control/login" 
	 * 2. Enter UserName and Password Using Id Locator 
	 * 3. Click on Login Button using Class Locator 
	 * 4. Click on CRM/SFA Link 
	 * 5. Click on contacts Button
	 * 6. Click on Create Contact
	 * 7. Enter FirstName Field Using id Locator
	 * 8. Enter LastName Field Using id Locator
	 * 9. Enter FirstName(Local) Field Using id Locator
	 * 10. Enter LastName(Local) Field Using id Locator
	 * 11. Enter Department Field Using any Locator of Your Choice
	 * 12. Enter Description Field Using any Locator of your choice
	 * 13. Enter your email in the E-mail address Field using the locator of your choice
	 * 14. Select State/Province as NewYork Using Visible Text
	 * 15. Click on Create Contact
	 * 16. Click on edit button
	 * 17. Clear the Description Field using .clear
	 * 18. Fill ImportantNote Field with Any text
	 * 19. Click on update button using Xpath locator
	 * 20. Get the Title of Resulting Page.
	 */

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//1. Launch URL "http://leaftaps.com/opentaps/control/login" 
		driver.get("http://leaftaps.com/opentaps/control/login");
		
		//2. Enter UserName and Password Using Id Locator 
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link
		driver.findElement(By.xpath("//*[contains(text(),'CRM/SFA')]")).click();
		
		//5. Click on contacts Button		
		driver.findElement(By.xpath("(//div[@class='x-panel-header']//child::a[1])[3]")).click();
		
		//6. Click on Create Contact
		driver.findElement(By.xpath("//ul[@class='shortcuts']//child::li[2]")).click();
		
		//7. Enter FirstName Field Using id Locator
		driver.findElement(By.id("firstNameField")).sendKeys("Mohan");
		
		//8. Enter FirstName Field Using id Locator
		driver.findElement(By.id("lastNameField")).sendKeys("Seerangan");
		
		 //9. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_firstNameLocal")).sendKeys("Mohan");
		
		 //10. Enter LastName(Local) Field Using id Locator
		driver.findElement(By.id("createContactForm_lastNameLocal")).sendKeys("Seerangan");
		
		 //11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.xpath("//input[@name='departmentName']")).sendKeys("IT");
		
		 //12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("This is a description!!!");
		
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createContactForm_primaryEmail")).sendKeys("testAutomation@gmail.com");
		
		//14. Select State/Province as NewYork Using Visible Text
		WebElement dr1 = driver.findElement(By.xpath("//select[@name='generalStateProvinceGeoId']"));
		Select select1 = new Select(dr1);
		select1.selectByVisibleText("New York");
		
		//15. Click on Create Contact
		driver.findElement(By.xpath("//input[@name='submitButton']")).click();
		
		//16. Click on edit button
		driver.findElement(By.xpath("//*[contains(text(),'Edit')][@class='subMenuButton']")).click();
		
		//17. Clear the Description Field using .clear
		driver.findElement(By.xpath("//textarea[@name='description']")).clear();
		
		//18. Fill ImportantNote Field with Any text
		driver.findElement(By.xpath("//textarea[@name='importantNote']")).sendKeys("This Important Note message");
		
		//19. Click on update button using Xpath locator
		driver.findElement(By.xpath("(//input[@class='smallSubmit'])[1]")).click();
		
		//20. Get the Title of Resulting Page.
		System.out.println("The Page title is :" +driver.getTitle());
	}
}

