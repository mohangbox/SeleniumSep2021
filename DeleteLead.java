package week2.dayAssignment;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {
	
	/*http://leaftaps.com/opentaps/control/main
	 
	Delete Lead:
	1	Launch the browser
	2	Enter the username
	3	Enter the password
	4	Click Login
	5	Click crm/sfa link
	6	Click Leads link
	7	Click Find leads
	8	Click on Phone
	9	Enter phone number
	10	Click find leads button
	11	Capture lead ID of First Resulting lead
	12	Click First Resulting lead
	13	Click Delete
	14	Click Find leads
	15	Enter captured lead ID
	16	Click find leads button
	17	Verify message "No records to display" in the Lead List. This message confirms the successful deletion
	18	Close the browser (Do not log out)
*/
	public static void main(String arr[]) throws InterruptedException {
		
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
		
		// 8 Click on Phone
		driver.findElement(By.xpath("//span[contains(text(), 'Phone')]")).click();
		
		// 9 Enter phone numer
		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys("9940174141");
		
		// 10 Click Find leads button
		driver.findElement(By.xpath("//button[@class='x-btn-text'][contains(text(),'Find Leads')]")).click();
		
		// 11 Capture lead ID of First Resulting lead
		Thread.sleep(3000);
		String text1 = driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a[1]")).getText();
		System.out.println("The lead id of the record is: " + text1);
		
		//12  Click First Resulting lead
		driver.findElement(By.xpath("//table/tbody/tr[1]/td[1]/div/a[1]")).click();
		
		//13	Click Delete
		driver.findElement(By.className("subMenuButtonDangerous")).click();
		
		//14	Click Find leads
		driver.findElement(By.xpath("//ul[@class='shortcuts']/li[3]")).click();
		System.out.println("The title of the page is :" + driver.getTitle());
		
		//15	Enter captured lead ID
		driver.findElement(By.xpath("//input[@name='id']")).sendKeys(text1);
		
		//16	Click find leads button
		driver.findElement(By.xpath("//button[@class='x-btn-text'][contains(text(),'Find Leads')]")).click();
		
		Thread.sleep(3000);
		//Verify message "No records to display" in the Lead List. This message confirms the successful deletion
		String text2 = driver.findElement(By.xpath("//div[contains(text(), 'No records to display')]")).getText();
		if(text2.contains("No records to display")) {
			System.out.println("The lead id is sucessfully deleted from the table!!!");
		}
		
		//18	Close the browser (Do not log out)
		driver.close();
	}
}