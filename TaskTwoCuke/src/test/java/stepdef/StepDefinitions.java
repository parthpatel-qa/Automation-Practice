package stepdef;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class StepDefinitions {
	private WebDriver driver;
	private static String URL = "http://automationpractice.com/index.php";

	@Before
	public void setup() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().setSize(new Dimension(1366, 768));
	}

	@After
	 public void tearDown() {
		 driver.close();
	}	 
		 @Given("^the correct URL$")
		 public void the_correct_URL() {
			 driver.get(URL);
		 }

		 @When("^I search for the dress$")
		 public void i_search_for_the_dress() {
				WebElement searchBar = driver.findElement(By.id("search_query_top"));
		        String searchTerm = "dress";
		        searchBar.sendKeys(searchTerm);
		        searchBar.submit();
			}
			 
		 

		 @Then("^I get the dress$")
		 public void i_get_the_dress() {
			 WebElement results = driver.findElement(By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/ul/li[2]/div/div[2]/h5/a"));
				assertEquals("Printed Dress", results.getText());
		 } 

}
