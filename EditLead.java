package week2.dayAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {
	/*
	 * http://leaftaps.com/opentaps/control/main 
	 * 1 Launch the browser 
	 * 2 Enter the username 
	 * 3 Enter the password 
	 * 4 Click Login 
	 * 5 Click crm/sfa link 
	 * 6 Click Leads link 
	 * 7 Click Find leads 
	 * 8 Enter first name 
	 * 9 Click Find leads button 
	 * 10 Click on first resulting lead 
	 * 11 Verify title of the page 
	 * 12 Click Edit 
	 * 13 Change the company name 
	 * 14 Click Update 
	 * 15 Confirm the changed name appears
	 * 16 Close the browser (Do not log out)
	 */

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1 Launch the browser - http://leaftaps.com/opentaps/control/main
		driver.get("http://leaftaps.com/opentaps/control/main");

		// 2 Enter the username
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		
		// 3 Enter the password
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		// 4 Click Login
		driver.findElement(By.className("decorativeSubmit")).click();
		
		// 5 Click crm/sfa link
		driver.findElement(By.xpath("//*[contains(text(), 'CRM/SFA')]")).click();
		
		// 6 Click Leads link
		driver.findElement(By.xpath("//*[text()='Leads']")).click();
		
		// 7 Click Find leads
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]")).click();
		
		// 8 Enter first name
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[1])[14]")).sendKeys("Mohan");
		
		driver.findElement(By.xpath("(//div[@class='x-form-element']/input[1])[15]")).sendKeys("Seerangan");
		
		// 9 Click Find leads button
		driver.findElement(By.xpath("//button[@class='x-btn-text'][contains(text(),'Find Leads')]")).click();
		
		// 10 Click on first resulting lead
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//table/tbody/tr[1]/td[3]/div/a[1])[1]")).click();
		
		// 11 Verify title of the page
		String title = driver.getTitle();
		if(title.contains("View Lead"))
		{
			System.out.println("The tile of the page is : " +  title);
		}
		
		// 12 Click Edit
		driver.findElement(By.xpath("//a[@class='subMenuButtonDangerous']/preceding::a[1]")).click();
		
		// 13 Change the company name
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys("Test Leaf1");
		
		// 14 Click Update
		driver.findElement(By.xpath("//input[@name='submitButton'][@value='Update']")).click();
		
		// 15 Confirm the changed name appears
		String text1 = driver.findElement(By.xpath("//span[@id='viewLead_companyName_sp']")).getText();
		if(text1.contains("Test Leaf1")) {
			System.out.println("The company name is updated");
		}
		
		// 16 Close the browser (Do not log out)
		Thread.sleep(5000);
		driver.close();
	}

}