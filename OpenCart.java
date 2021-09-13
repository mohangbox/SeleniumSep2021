package week2.dayAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OpenCart {
	// https://www.opencart.com/index.php?route=account/register

	public static void main(String arr[]) {
		
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.get("https://www.opencart.com/index.php?route=account/register");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.id("input-username")).sendKeys("TestLeaf");
		
		driver.findElement(By.id("input-firstname")).sendKeys("Test");
		
		driver.findElement(By.id("input-lastname")).sendKeys("Automation");
		
		driver.findElement(By.id("input-email")).sendKeys("testautomation@gmail.com");
		
		WebElement dr1 = driver.findElement(By.id("input-country"));
		Select select1 = new Select(dr1);
		select1.selectByVisibleText("India");
		
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("Welcome@123");
		
		driver.findElement(By.xpath("//a[@class='active']")).click();
		
		//String text = driver.findElement(By.xpath("//div[@class='bg-success']")).getText();
		//System.out.println(text);
		
		//driver.findElement(By.xpath("(//*[contains(text(), 'Register')][@type='submit'])[2]")).click();
		
	}
}
