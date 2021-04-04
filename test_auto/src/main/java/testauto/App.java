package testauto;

import static org.testng.Assert.assertEquals;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

public class App {
	
	
	public static void main(String[] args) {
    	System.setProperty("webdriver.gecko.driver","C:\\Selenium\\firefox\\geckodriver.exe");

    	WebDriver driver = new FirefoxDriver();
    	

        driver.get("https://www.amazon.in/");
        

        giveInput("twotabsearchtextbox", "iPhone 12", driver);
        clickById("nav-search-submit-button",driver);        
        
        clickByLinkedText("New Apple iPhone 12 (128GB) - Blue", driver);
        
        Set<String> s = driver.getWindowHandles();
        
        
        
        driver.switchTo().window((String) s.toArray()[1]);
        
        boolean isImageDispalyed = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[5]/div[3]/div[1]/div[1]/div/div/div[2]/div[1]/div[1]/ul/li[1]/span/span/div/img")).isDisplayed();
        boolean isPriceDispalyed = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[4]/div[5]/div[4]/div[9]/div[1]/div/table/tbody/tr[1]/td[2]/span[1]")).isDisplayed();
        boolean isFlash = driver.findElement(By.id("noFlashContent")).isDisplayed();
         
        
        
        String price = driver.findElement(By.id("priceblock_dealprice")).getText();
        
  
        System.out.println(price);
        
        System.out.println(isImageDispalyed);
        System.out.println(isPriceDispalyed);
        System.out.println(isFlash);
        
        
        driver.close();
        driver.switchTo().window((String) s.toArray()[0]);
        driver.close();
      
    }
	
    static void giveInput(String id, String inputText, WebDriver driver) {
    	WebElement inputTextBox = driver.findElement(By.id(id));
    	inputTextBox.sendKeys(inputText);
    }
    
    
    static void clickById(String id, WebDriver driver) {
    	WebElement button = driver.findElement(By.id(id));
        button.click();
    }

    static void clickByLinkedText(String text, WebDriver driver) {
    	WebElement button = driver.findElement(By.linkText(text));
        button.click();
    }

}