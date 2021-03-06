package automation;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class taskOne {
	
	    private WebDriver driver;

	    @Before
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
	        driver = new ChromeDriver();
	        
	    }

	    @After
	    public void tearDown() {
	        driver.close();
	    }

	    @Test
	    public void addAUser() throws InterruptedException {
	        driver.get("http://thedemosite.co.uk/");

	        // Create a User
	        driver.findElement(By.linkText("3. Add a User")).click();
	        driver.findElement(By.name("username")).sendKeys("guest");
	        driver.findElement(By.name("password")).sendKeys("guest");
	        driver.findElement(By.name("FormsButton2")).click();

	        // Login new User
	        driver.findElement(By.linkText("4. Login")).click();
	        driver.findElement(By.name("username")).sendKeys("guest");
	        driver.findElement(By.name("password")).sendKeys("guest");
	        driver.findElement(By.name("FormsButton2")).click();

	        // Assert Test
	        assertEquals(driver.findElement(By.cssSelector("center > b")).getText(), "**Successful Login**");
	    }

}
