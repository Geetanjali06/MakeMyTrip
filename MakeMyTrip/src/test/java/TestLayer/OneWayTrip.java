package TestLayer;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class OneWayTrip {

	WebDriver driver;
	@BeforeMethod
	public void setUp() {
//		- connect browser
		System.setProperty("webdriver.edge.driver", "D:\\Project23\\Guru99TestNG\\AllDrivers\\msedgedriver.exe");
//		- up casting
		driver= new EdgeDriver();
//		- implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//		- maximize browser
		driver.manage().window().maximize();
//		- open a url https://demo.guru99.com/test/newtours/register.php
		driver.get("https://www.makemytrip.com/");
	}
	@Test(priority=1)
	public void VerifyLogo()
	{
		WebElement wb=driver.findElement(By.xpath("//img[@src='//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/logo@2x.png']"));
		System.out.println(wb.isDisplayed());
		Assert.assertEquals(wb.isDisplayed(),false);
		
	}
	@Test(priority=2)
	public void selTrip()

	{
//		Click on Flight
		WebElement FlightTab=driver.findElement(By.xpath("//li[@data-cy='menu_Flights']"));
		FlightTab.click();
//		Select one way trip
		 WebElement oneWayOption = driver.findElement(By.xpath("//li[@data-cy='oneWayTrip']"));
	     oneWayOption.click();

//		From city
		WebElement Fromcity=driver.findElement(By.xpath("//input[@data-cy='fromCity']"));
		Fromcity.click();
		Fromcity.sendKeys("Pune");
//		 Select the first option from the suggestion list
        WebElement fromCitySuggestion = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-1']"));
        fromCitySuggestion.click();
//		To City		
		WebElement Tocity=driver.findElement(By.xpath("//input[@data-cy='toCity']"));
		Fromcity.click();
		Tocity.sendKeys("Mumbai");
		 // Select the first option from the suggestion list
		WebElement toCitySuggestion = driver.findElement(By.xpath("//li[@id='react-autowhatever-1-section-0-item-0']"));
		toCitySuggestion.click();
	}

	@AfterMethod
	public void tearDown() throws InterruptedException {
		Thread.sleep(4000);
		driver.close();
	}
}
