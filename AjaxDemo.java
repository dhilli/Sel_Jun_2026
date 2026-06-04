package abcpack;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AjaxDemo {
	
	WebDriver d;
	@Test
	public void testAjax() throws Exception
	{
		// Load web page
		d.get("https://www.veethi.com/places/");
		// Verify page title
		assertEquals(d.getTitle(),"Places of India - states, districts, cities, towns and villages of India | Veethi");
		// Select state in the country
		Select state=new Select(d.findElement(By.id("state")));
		state.selectByVisibleText("Telangana");
		WebDriverWait wait=new WebDriverWait(d,Duration.ofMinutes(2));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//option[text()='Warangal Rural']")));
		// Select district
		Select district=new Select(d.findElement(By.id("district_id")));
		district.selectByVisibleText("Warangal Rural");
		// Select city
		Select city=new Select(d.findElement(By.id("list_city")));
		city.selectByVisibleText("Aleru");
		Thread.sleep(2000);
	}
	@BeforeMethod
	public void setUp()
	{
		// Launch the browser
		d=new FirefoxDriver();
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(3));
	}
	@AfterMethod
	public void tearDown()
	{
		// Close the browser
		d.quit();
	}

}
