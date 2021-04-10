package testauto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;



public class Login{
    public static void main(String[] args)
    {
        
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        // Launch Website
        driver.get("https://www.apple.com/in/shop/bag");

        //Maximize the current window
        driver.manage().window().maximize();
        
        // Click on the Sign in Button
        WebElement Cart_B = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/a"));
        Cart_B.click();

        WebElement UserEmail = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[1]/input"));
        UserEmail.sendKeys("mily.mishra01@gmail.com");

        WebElement Password = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[2]/input"));
        Password.sendKeys("*");

        WebElement Login_B = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[2]/button"));
        Login_B.click();
    }

}