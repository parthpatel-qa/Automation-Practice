package test;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.HomePage;

public class IDrawTest {
	private static RemoteWebDriver driver;
	Actions action = new Actions(driver);
	HomePage nav = PageFactory.initElements(driver, HomePage.class);

	
	@BeforeClass
	public static void init() {
		System.setProperty("webdriver.chrome.driver",
				"src/test/resources/chromedriver.exe");
		ChromeOptions cOptions = new ChromeOptions();
		cOptions.setHeadless(false);
		driver = new ChromeDriver(cOptions);
//		cOptions.addPreference("profile.default_content_setting_values.cookies",2);
		driver.manage().window().setSize(new Dimension(1366, 768));
	}
	@Before
	public void setup() {
		driver.get(nav.URL);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void drawInitial() {
		WebElement canvas = driver.findElement(By.cssSelector("#catch"));
		nav.clickBrush();
		//first p
		action.moveToElement(canvas).clickAndHold().moveByOffset(0, -200)
		.moveByOffset(100,0).moveByOffset(0, 100).moveByOffset(-100, 0)
		.click().moveToElement(canvas).build().perform();
		
		//second p
		action.moveByOffset(200, 0).clickAndHold().moveByOffset(0, -200)
		.moveByOffset(100, 0).moveByOffset(0, 100).moveByOffset(-100, 0)
		.click().moveToElement(canvas).build().perform();
	}
}
