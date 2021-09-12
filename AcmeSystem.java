package week2.dayAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AcmeSystem {
	// 1. Load url "https://acme-test.uipath.com/login"
	// 2. Enter email as "kumar.testleaf@gmail.com"
	// 3. Enter Password as "leaf@12"
	// 4. Click login button
	// 5. Get the title of the page and print
	// 6. Click on Log Out
	// 7. Close the browser (use -driver.close())

	public static void main(String arr[]) throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		// 1. Load url "https://acme-test.uipath.com/login"
		driver.get("https://acme-test.uipath.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// 2. Enter email as "kumar.testleaf@gmail.com"
		driver.findElement(By.id("email")).sendKeys("kumar.testleaf@gmail.com");

		// 3. Enter Password as "leaf@12"
		driver.findElement(By.id("password")).sendKeys("leaf@12");

		// 4. Click login button
		driver.findElement(By.xpath("//*[contains(text(), 'Login')][@type='submit']")).click();

		// 5. Get the title of the page and print
		String title = driver.getTitle();
		System.out.println("The page title is " + " '" + title + "'");

		// 6. Click on Log Out
		driver.findElement(By.xpath("//*[contains(text(), 'Log Out')]")).click();

		// 7. Close the browser (use -driver.close())
		Thread.sleep(3000);
		driver.close();
	}
}
