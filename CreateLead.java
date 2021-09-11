package week2.day1Assignment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

//	1. Launch URL "http://leaftaps.com/opentaps/control/login"  
//	 2. Enter UserName and Password  (demosalesmanager / crmsfa)
//	 3. Click on Login Button  
//	 4. Click on CRM/SFA Link
//	 5. Click on Leads Button 
//	6. Click on create Lead Button
//	7. Enter all the text fields in CreateLead page
//	          **Note
//	               1. Donot work on Parent Account Field
//	               2.Enter the Birthdate using SendKeys
//	8. Enter all the text fields in contact information 
//	 9. Enter all the text fields in primary address
//	 10. Get the Firstname and print it
//	 11. Click on create Lead Button 
//	 12. Get and Verify the Title of the resulting Page(View Lead)

	public static void main(String[] args) throws InterruptedException {
		// WebDriverManager.chromedriver().setup();
		// ChromeDriver driver = new ChromeDriver();

		// Here I am setting the system properties of chrome driver and specifying the
		// path to it.
		System.setProperty("webdriver.chrome.driver", "C:Selenium-java-edurekachromedriver_win32chromedriver.exe");
		// Creating a object to instantiate the browser driver
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.findElement(By.id("username")).sendKeys("demosalesmanager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		driver.findElement(By.className("decorativeSubmit")).click();
		driver.findElement(By.linkText("CRM/SFA")).click();
		driver.findElement(By.linkText("Leads")).click();
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Mohan");
		System.out.println(driver.findElement(By.id("createLeadForm_firstName")).getText());
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Seerangan");

		WebElement msource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		Select sourcedropdown = new Select(msource);
		sourcedropdown.selectByVisibleText("Employee");

		WebElement mCampaign = driver.findElement(By.id("createLeadForm_marketingCampaignId"));
		Select campaign = new Select(mCampaign);
		campaign.selectByVisibleText("Demo Marketing Campaign");

		WebElement Scurrency = driver.findElement(By.id("createLeadForm_currencyUomId"));
		Select currency = new Select(Scurrency);
		currency.selectByVisibleText("INR - Indian Rupee");

		WebElement mIndustry = driver.findElement(By.id("createLeadForm_industryEnumId"));
		Select Industry = new Select(mIndustry);
		Industry.selectByVisibleText("Computer Software");

		WebElement mOwnership = driver.findElement(By.id("createLeadForm_ownershipEnumId"));
		Select Ownership = new Select(mOwnership);
		Ownership.selectByIndex(3);

		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Mohan");
		driver.findElement(By.id("createLeadForm_lastNameLocal")).sendKeys("Seerangan");
		driver.findElement(By.id("createLeadForm_personalTitle")).sendKeys("Mr.");
		driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("04/13/94");
		driver.findElement(By.id("createLeadForm_generalProfTitle")).sendKeys("TestCase");
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("IT Dept.");
		driver.findElement(By.id("createLeadForm_annualRevenue")).sendKeys("20M");
		driver.findElement(By.id("createLeadForm_numberEmployees")).sendKeys("30");
		driver.findElement(By.id("createLeadForm_sicCode")).sendKeys("ISB56567");
		driver.findElement(By.id("createLeadForm_description"))
				.sendKeys("Top level training center for IT employees in Chennai");
		driver.findElement(By.id("createLeadForm_importantNote"))
				.sendKeys("Top level training center for IT employees in Chennai");
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).clear();
		driver.findElement(By.id("createLeadForm_primaryPhoneCountryCode")).sendKeys("91");
		driver.findElement(By.id("createLeadForm_primaryPhoneAreaCode")).sendKeys("001");
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys("9940174141");
		driver.findElement(By.id("createLeadForm_primaryPhoneExtension")).sendKeys("044");
		driver.findElement(By.id("createLeadForm_primaryPhoneAskForName")).sendKeys("Babu");
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("mohangbox@gmail.com");
		driver.findElement(By.id("createLeadForm_primaryWebUrl")).sendKeys("http://leaftaps.com/");
		driver.findElement(By.id("createLeadForm_generalToName")).sendKeys("Mohan S");
		driver.findElement(By.id("createLeadForm_generalAttnName")).sendKeys("mohangbox");
		driver.findElement(By.id("createLeadForm_generalAddress1")).sendKeys("415, D Block");
		driver.findElement(By.id("createLeadForm_generalAddress2")).sendKeys("EPA Pacific City, Kelambakkam");

		WebElement mcountry = driver.findElement(By.id("createLeadForm_generalCountryGeoId"));
		Select country = new Select(mcountry);
		country.selectByVisibleText("India");

		driver.findElement(By.id("createLeadForm_generalCity")).sendKeys("Chennai");

		WebElement mState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select VState = new Select(mState);
		Thread.sleep(3000);
		VState.selectByVisibleText("TAMILNADU");

		driver.findElement(By.id("createLeadForm_generalPostalCode")).sendKeys("603103");
		driver.findElement(By.id("createLeadForm_generalPostalCodeExt")).sendKeys("null");

		driver.findElement(By.name("submitButton")).click();

		Thread.sleep(5000);
		String text = driver.findElement(By.id("sectionHeaderTitle_leads")).getText();
		System.out.println(text);

		if (text.equalsIgnoreCase("View Lead")) {
			System.out.println("The View Lead page is created");
		} else {
			System.out.println("The View Lead page is not created");
		}
		Thread.sleep(5000);
		driver.close();
	}
}