package week2.dayAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DuplicateLead {
	

	/*http://leaftaps.com/opentaps/control/main

	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Email
	9	Enter Email
	10	Click find leads button
	11	Capture name of First Resulting lead
	12	Click First Resulting lead
	13	Click Duplicate Lead
	14	Verify the title as 'Duplicate Lead'
	15	Click Create Lead
	16	Confirm the duplicated lead name is same as captured name
	17	Close the browser (Do not log out)
	
	*/
	
	public static void main(String arr[]) throws InterruptedException
	{
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
		
		// 8 Click on Email
		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		
		// 9 Enter Email
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='emailAddress']")).sendKeys("mohangbox@gmail.com");
		
		// 10 Click Find leads button
		driver.findElement(By.xpath("//button[@class='x-btn-text'][contains(text(),'Find Leads')]")).click();
		
		// 11 Capture name of First Resulting lead
		Thread.sleep(3000);
		String text1 = driver.findElement(By.xpath("(//table/tbody/tr[1]/td[3]/div/a[1])[1]")).getText();
		System.out.println("The First name of the record is: " + text1);
		
		//12  Click First Resulting lead
		driver.findElement(By.xpath("(//table/tbody/tr[1]/td[3]/div/a[1])[1]")).click();
		
		//13	Click Duplicate Lead
		driver.findElement(By.xpath("//a[contains(text(), 'Duplicate Lead')]")).click();
		
		//14	Verify the title as 'Duplicate Lead'
		System.out.println("The title of the page is :" + driver.getTitle());
		
		//15	Click Create Lead
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		//16	Confirm the duplicated lead name is same as captured name
		String text2 = driver.findElement(By.xpath("//input[@type='submit']")).getText();
		if(text1.contains(text2)) {
			System.out.println("The duplicated lead name is same as captured name");
		}
		
		//17	Close the browser (Do not log out)
		driver.close();
	}
}


