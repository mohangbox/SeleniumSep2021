package week2.dayAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForce {

	public static void main(String arr[]) throws InterruptedException {

		// Step 1: Download and set the path
		// Step 2: Launch the chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		// Step 3: Load the URL
		driver.get("https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk");
		// https://www.salesforce.com/in/form/signup/freetrial-sales/?d=70130000000Enyk

		// Step 4: Maximize the window
		driver.manage().window().maximize();

		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		// Step 6: Fill in all the text boxes
		driver.findElement(By.xpath("//input[@name='UserFirstName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='UserLastName']")).sendKeys("Automation");
		driver.findElement(By.xpath("//input[@name='UserEmail']")).sendKeys("automationtesting@gmail.com");
		driver.findElement(By.xpath("//input[@name='CompanyName']")).sendKeys("TestLeaf");
		driver.findElement(By.xpath("//input[@name='UserPhone']")).sendKeys("8866440033");

		// Step 7: Handle all the dropdowns
		WebElement dr1 = driver.findElement(By.xpath("//select[@name='UserTitle']"));
		Select S1 = new Select(dr1);
		S1.selectByIndex(5);
		
		WebElement dr2 = driver.findElement(By.xpath("//select[@name='CompanyEmployees']"));
		Select S2 = new Select(dr2);
		S2.selectByIndex(2);

		WebElement dr3 = driver.findElement(By.xpath("//select[@name='CompanyCountry']"));
		Select S3 = new Select(dr3);
		S3.selectByVisibleText("India");

		//WebElement dr4 = driver.findElement(By.xpath(""));
		//Select S4 = new Select(dr4);
		//S4.selectByVisibleText("Tamil Nadu");

		// Step 8: Click the check box // *Note: No need click Start my free Trial */
		driver.findElement(By.xpath("(//div[@class='checkbox-ui'])[1]")).click();

		// Step 9: Close the browser
		Thread.sleep(5000);

		driver.close();
	}
}