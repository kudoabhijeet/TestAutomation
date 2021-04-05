package testauto;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SearchArticle {
    public static void main(String[] args) {
        // declaration and instantiation of objects/variables

        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Launch website

        driver.navigate().to("https://www.apple.com/in/");

        driver.manage().window().maximize();

        driver.findElement(By.xpath("/html/body/nav/div/ul[2]/li[4]/a")).click();
        driver.findElement(By.xpath("/html/body/nav[2]/div/ul/li[4]/a/span")).click();

        // selection
        
        driver.findElement(By.id("noTradeIn")).click();

        driver.findElement(By.id("dimensionColor-black")).click();

        driver.findElement(By.id("Item2-dimensionCapacity-64gb")).click();

        driver.findElement(By.id("applecareplus_55_noapplecare")).click();

        driver.close();

    }

}