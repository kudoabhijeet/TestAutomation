package testauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static org.testng.Assert.assertTrue;

public class SearchArticleTest {
    WebDriver driver;

    @BeforeClass
	public void Setup() {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://www.apple.com/in/");
	}

    @Test(priority = 0)
	public void NavigatetoArticle() {
		driver.findElement(By.xpath("/html/body/nav/div/ul[2]/li[4]/a")).click();
        WebElement article = driver.findElement(By.xpath("/html/body/nav[2]/div/ul/li[4]/a/span"));
		assertTrue(article.isEnabled());
		article.click();
	}

    @Test(priority = 1)
	public void input() {
		driver.findElement(By.id("noTradeIn")).click();

        driver.findElement(By.id("dimensionColor-black")).click();

        driver.findElement(By.id("Item2-dimensionCapacity-64gb")).click();

        driver.findElement(By.id("applecareplus_55_noapplecare")).click();
	}


	@AfterClass
	public void closeChromeWindow() {
		driver.close();
	}
    
}
