package testauto;

import java.util.ArrayList;

import java.util.List;



import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.firefox.FirefoxDriver;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class multiple {



    public static void main(String args[]) {



        System.setProperty("webdriver.gecko.driver","C:\\Selenium\\firefox\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.amazon.in/");


        // driver.manage().window().maximize();



        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

        searchBox.sendKeys("Samsung A21s");



        WebElement searchSubmit = driver.findElement(By.id("nav-search-submit-button"));

        searchSubmit.click();



        WebElement mobilePhone = driver.findElement(By.linkText("Samsung Galaxy A21s (Blue, 4GB RAM, 64GB Storage) with No Cost EMI/Additional Exchange Offers"));

        mobilePhone.click();



        ArrayList<String> noOfTabs = new ArrayList<String>(driver.getWindowHandles());



        System.out.println("no of Tabs " + noOfTabs);



        driver.switchTo().window(noOfTabs.get(1));





        WebElement mobileNewPage = driver.findElement(By.id("bylineInfo"));

        mobileNewPage.isEnabled();





        WebElement mrpElement = driver.findElement(By.xpath("//*[@id=\"price\"]/table/tbody/tr[1]/td[1]"));

        String text = mrpElement.getText();

        System.out.println("mrpElement is "+ mrpElement);

        System.out.println("text is " + text);

        // TC - To check if MRP for that item exits or not

        assertTrue(text.equalsIgnoreCase("mrp:"));

//        assertEquals(false, false);
//
//        assertNull(text);









    }



}