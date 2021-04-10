package testauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import static org.testng.Assert.assertEquals;

public class LoginTest{
	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	@BeforeClass
	public void SetUp() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		htmlReporter = new ExtentHtmlReporter("index.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);

		driver.navigate().to("https://www.apple.com/in/shop/bag");
		
	}

	@Test(priority = 0)
	public void signInButton() {
		ExtentTest test = extent.createTest("SignIn Button Test", "Check if SignIn Button is Available");

        // log(Status, details)
        test.log(Status.INFO, "Signin Button test.");
		WebElement signin = driver
				.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/a"));
		assertTrue(signin.isEnabled());
		if(signin.isEnabled()) {
			test.pass("Sign In button enabled!");
		}
		else {
			test.fail("Sign in button not enabled");
		}
		signin.click();
	}

	@Test(priority = 1)
	public void input() {
		WebElement email = driver
				.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[1]/input"));
		email.sendKeys("mily.mishra01@gmail.com");

		WebElement password = driver
				.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[2]/input"));
		password.sendKeys("Lovemyself01");
	}

	@Test(priority = 2)
	public void loginButton() {
		WebElement loginButton = driver
				.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[2]/button"));
		assertTrue(loginButton.isEnabled());
		loginButton.click();
	}
	

	@AfterClass
	public void closeChromeWindow() {
		driver.close();
		extent.flush();
	}

}
