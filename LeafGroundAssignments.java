package week2.dayAssignment;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGroundAssignments {

//		http://leafground.com/pages/Edit.html
//		http://leafground.com/pages/Button.html
//		http://leafground.com/pages/Link.html
//		http://leafground.com/pages/Image.html
//		http://leafground.com/pages/Dropdown.html
//		http://leafground.com/pages/radio.html
//		http://leafground.com/pages/checkbox.html

	public static void main(String arr[]) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("http://leafground.com/home.html");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

// ********************HOME PAGE********************************************************************************
		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());
		if (driver.getTitle().contains("TestLeaf"))
			System.out.println("Confirmed");
		else
			System.out.println("The title doesn't contain TestLeaf");
		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		// Get home page source
		//System.out.println("The page source is: " + driver.getPageSource());

// ********************EDIT PAGE********************************************************************************
		// Navigate to Edit page
		driver.findElement(By.xpath("//img[@alt='Edit / Text Fields']")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());

		// Enter the email
		driver.findElement(By.id("email")).sendKeys("testemail@gmail.com");
		
		//Append the text and Press keyboard tab
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(" Adding the text here");
		driver.findElement(By.xpath("//input[@value='Append ']")).sendKeys(Keys.TAB);

		// Get Element attributes
		System.out.println("Attribute value is :" + driver.findElement(By.name("username")).getAttribute("value"));

		// Compare the text from attribute
		if (driver.findElement(By.name("username")).getAttribute("value").contains("TestLeaf"))
			System.out.println("The attribute value is 'TestLeaf'");
		else
			System.out.println("The attribute value is not 'TestLeaf' ");

		// Clear Text in the input box
		driver.findElement(By.xpath("(//input[@name='username'])[2]")).clear();
		
		//The element is enabled or not?
		if(driver.findElement(By.xpath("(//input[@type='text'])[5]")).isEnabled()==true)
			System.out.println("The text box is enabled to enter");
		else
			System.out.println("The text box is NOT enabled to enter");
		
		// Navigate to home page
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();

// ********************BUTTON PAGE********************************************************************************
		// navigate to Button page
		driver.findElement(By.xpath("//img[@alt='Buttons']")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		// Get location (X, Y) on the page
		System.out.println("The Location of the text box (X, Y): "+driver.findElement(By.id("position")).getLocation());

		// Get location (X) on the page
		System.out.println("The Location of the text box (X): "+ driver.findElement(By.id("position")).getLocation().getX());

		// Get location (Y) on the page
		System.out.println("The Location of the text box (Y): "+ driver.findElement(By.id("position")).getLocation().getY());
		
		// Get element text
		System.out.println("The Location of the text box Text is: "+driver.findElement(By.id("position")).getText());
		
		// Find the color of the text
		System.out.println("The color of the text box: "+driver.findElement(By.id("color")).getCssValue("background-color"));

		// Get element text
		System.out.println("The color of the text box Text is: "+driver.findElement(By.id("color")).getText());

		// Get size of the text box
		System.out.println("The Size of the text box (H, W): "+ driver.findElement(By.id("size")).getSize());
		
		// Get Width of the text box
		System.out.println("The Size of the text box (W): "+driver.findElement(By.id("size")).getSize().getWidth());
		
		// Get height of the text box
		System.out.println("The Size of the text box (H): "+driver.findElement(By.id("size")).getSize().getHeight());
		
		// Click button to travel home page
		driver.findElement(By.xpath("//button[contains(text(), 'Go to Home Page')]")).click();

// ********************HYBERLINK PAGE********************************************************************************
		// Navigate to Hyberlink page
		driver.findElement(By.xpath("(//*[contains(text(), 'HyperLink')])/following-sibling::img[1]")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		//Click the first link and navigate to backward
		driver.findElement(By.xpath("(//a[contains(text(),'Go to Home Page')])[1]")).click();
		driver.navigate().back();

		// Get the link from the page
		System.out.println("Link from this page: "+driver.findElement(By.linkText("Find where am supposed to go without clicking me?"))
				.getAttribute("href"));	
		
		//Verify whether the link is broken or not
		if(driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).getAttribute("href").contains("error.html"))
			System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).getAttribute("href") + " -The link is broken!!");
		else 
			System.out.println(driver.findElement(By.xpath("//a[contains(text(),'Verify am I broken?')]")).getAttribute("href") + " -The link is not broken!!");
		
		//Count the number of link present in the page
		System.out.println("The no of links present in the page is: "+driver.findElements(By.tagName("a")).size());
		
		//Go to Home Page (Interact with same link name)
		driver.findElement(By.xpath("(//a[contains(text(), 'Go to Home Page')])[2]")).click();
		
		//Navigate to home page
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		
//********************IMAGE PAGE********************************************************************************
		// Navigate to Image page		
		driver.findElement(By.xpath("//img[@alt='Images']")).click();
		
		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		//Click on this image to go home page
		driver.findElement(By.xpath("//label[contains(text(),'Click on this image to go home page')]//following-sibling::img[1]")).click();
		driver.navigate().back();

		//Am I Broken Image?
		driver.findElement(By.xpath("//*[contains(text(), 'Am I Broken Image')]/following-sibling::img[1]")).click();
		if(driver.getTitle().contains("Interact"))
			System.out.println("The link 'Am I Broken Image?' is broken");
		else
			System.out.println("The link 'Am I Broken Image?' is not broken");
		
		//Click me using Keyboard or Mouse
		//driver.findElement(By.xpath("//*[contains(text(), 'Keyboard or Mouse')]//following-sibling::img[1]")).sendKeys(Keys.ENTER);
		
		//Navigate to home page
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		
//********************DROPDOWN PAGE********************************************************************************	
		// Navigate to dropdown page
		driver.findElement(By.xpath("//img[@alt='ListBox']")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		//Select by Index
		WebElement dr1 = driver.findElement(By.id("dropdown1"));
		Select select1 = new Select(dr1);
		select1.selectByIndex(1);
		
		//Select by visible text
		WebElement dr2 = driver.findElement(By.name("dropdown2"));
		Select select2 = new Select(dr2);
		select2.selectByVisibleText("Selenium");
		
		//Select by Value
		WebElement dr3 = driver.findElement(By.name("dropdown3"));
		Select select3 = new Select(dr3);
		select3.selectByValue("2");		
		
		//Get the number of dropdowns to print
		WebElement dr4 = driver.findElement(By.xpath("//select[@class='dropdown']"));
		Select select4 = new Select(dr4);
		List<WebElement> options = select4.getOptions();
		for (int i = 0; i < options.size(); i++) {
			System.out.println("The dropdown value is ["+i+ "]: " +options.get(i).getText());
		}
			
		//You Can also use sendkeys to select
		driver.findElement(By.xpath("((//div[@class='example'])[5])/child::select")).sendKeys("Loadrunner");
		
		//Multiple dropdowns
		WebElement dr6 = driver.findElement(By.xpath("((//div[@class='example'])[6])/child::select"));
		Select select6 = new Select(dr6);
		select6.selectByIndex(1);
		select6.selectByIndex(3);
		
		//Navigate to home page
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		
		
//********************RADIO BUTTON PAGE********************************************************************************	
		// Navigate to Radio Button page
		driver.findElement(By.xpath("//img[@alt='Radio Button']")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());
		
		//Are you enjoying the classes
		driver.findElement(By.id("yes")).click();
		
		//Check Default Selected Radio button
		if(driver.findElement(By.xpath("//label[@for='Checked']")).isSelected()==true)
			System.out.println("The Default Selected Radio button already selected");
		else
			System.out.println("The Default Selected Radio button NOT selected");
		
		//Select your age group (Only if choice wasn't selected)
		driver.findElement(By.xpath("//input[@value='0'][@name='age']")).click();
		
		//Navigate to home page
		driver.findElement(By.xpath("//img[@alt='logo Testleaf']")).click();
		
//********************CHECKBOXES BUTTON PAGE********************************************************************************	
		// Navigate to Radio Checkboxes page
		driver.findElement(By.xpath("//img[@alt='Checkbox']")).click();

		// Get title of the page
		System.out.println("The title is: " + driver.getTitle());

		// Get current URL of the page
		System.out.println("The page url is: " + driver.getCurrentUrl());	
		
		//Select the languages that you know?
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[1]/div[4]/input")).click();
		
		//Confirm Selenium is checked
		if(driver.findElement(By.xpath("//*[@id='contentblock']/section/div[2]/div/input")).isSelected()==true)
			System.out.println("Selenium is already selected");
		else
			System.out.println("Selenium is NOT selected");
		
		//DeSelect only checked
		if(driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[2]/input")).isSelected()==true)
		{
			driver.findElement(By.xpath("//*[@id='contentblock']/section/div[3]/div[2]/input")).click();
			System.out.println("DeSelect only checked");
		}
		
		//Select all below checkboxes
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[1]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[2]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[3]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[4]/input")).click();
		driver.findElement(By.xpath("//*[@id='contentblock']/section/div[4]/div[5]/input")).click();
		
		Thread.sleep(2000);
		driver.close();

	}
}