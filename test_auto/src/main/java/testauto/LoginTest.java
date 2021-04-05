package testauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    WebDriver driver;

    @BeforeClass
	public void openAmazon() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.apple.com/in/shop/bag");
	}

    @Test(priority = 0)
	public void signInButton() {
		WebElement signin = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/a"));
		assertTrue(signin.isEnabled());
		signin.click();
	}

    @Test(priority = 1)
	public void input() {
		WebElement email = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[1]/input"));
		email.sendKeys("mily.mishra01@gmail.com");
		
		WebElement password = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[2]/input"));
		password.sendKeys("*");
	}

	@Test(priority = 2)
	public void loginButton() {
		WebElement loginButton = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[2]/button"));
		assertTrue(loginButton.isEnabled());
		loginButton.click();
	}

	@AfterClass
	public void closeChromeWindow() {
		driver.close();
	}
    
}
