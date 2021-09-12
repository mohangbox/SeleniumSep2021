package week2.dayAssignment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookLogin {

	public static void main(String[] args) {
		
		String email="autoemail";
		email=email+Math.random()+"@gmail.com";
		
		// Step 1: Download and set the path 
		// Step 2: Launch the chrome browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		// Step 3: Load the URL https://en-gb.facebook.com/
		driver.get("https://en-gb.facebook.com/");
		
		// Step 4: Maximize the window
		driver.manage().window().maximize();
		
		// Step 5: Add implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		// Step 6: Click on Create New Account button
		driver.findElement(By.xpath("//a[@role='button'][@data-testid='open-registration-form-button']")).click();
		//driver.findElement(By.xpath("//a[text()='Forgotten password?']//following::a")).click();
		
		// Step 7: Enter the first name
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("Automation");
		
		// Step 8: Enter the last name
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("Test");
		
		// Step 9: Enter the mobile number
		driver.findElement(By.xpath("//input[starts-with(@name,'reg_email')]")).sendKeys(email);
		//driver.findElement(By.xpath("//div[@id='fullname_error_msg']//following::input[1]")).sendKeys("test@gmail.com");
		
		driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(email);
		//driver.findElement(By.xpath("//div[text()='Re-enter email address']//following-sibling::input")).sendKeys("test@gmail.com");
		
		// Step 10: Enter the password
		driver.findElement(By.xpath("//input[@type='password'][@data-type='password']")).sendKeys("Password@123");
		
		// Step 11: Handle all the three drop downs
		WebElement dropdown1 = driver.findElement(By.xpath("//select[@name='birthday_day'][@title='Day']"));
		Select select1 = new Select(dropdown1);
		select1.selectByValue("4");
		
		WebElement dropdown2 = driver.findElement(By.xpath("//select[@name='birthday_month'][@title='Month']"));
		Select select2 = new Select(dropdown2);
		select2.selectByValue("5");
		
		WebElement dropdown3 = driver.findElement(By.xpath("//select[@name='birthday_year'][@title='Year']"));
		Select select3 = new Select(dropdown3);
		select3.selectByValue("1994");
		
		// Step 12: Select the radio button "Female" ( A normal click will do for this step) 
		driver.findElement(By.xpath("(//input[@type='radio'][@name='sex'])[1]")).click();
		//driver.findElement(By.xpath("//label[text()='Female']//following-sibling::input")).click();
		
		//driver.findElement(By.name("//button[@name='websubmit']")).click();
		
		driver.close();
	}
}