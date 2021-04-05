package testauto;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ExcelLogin {
	static WebDriver driver;
	static String baseurl = "https://www.apple.com/in/shop/bag";
	static String driverpath = "C:\\Selenium\\chromedriver.exe";

	public static void main(String[] args) throws IOException {

		FileInputStream fis = new FileInputStream("D:\\details.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet loginDetailSheet = wb.getSheet("Login");

		String uname, pwd;

		for (int i = 1; i <= loginDetailSheet.getLastRowNum(); i++) {
			System.out.println("i=" + i);
			XSSFRow row = loginDetailSheet.getRow(i);

			if (row.getCell(0).getCellType() == Cell.CELL_TYPE_NUMERIC) {
				uname = row.getCell(0).getRawValue();
			} else {
				uname = row.getCell(0).toString(); // getStringCellValue();
			}
			pwd = row.getCell(1).toString();
			System.out.println(i + ") name: " + uname + ", password:" + pwd);
			runLoginTest(uname, pwd);
		}

	}

	public static void runLoginTest(String u, String p) {
		System.setProperty("webdriver.chrome.driver", driverpath);
		WebDriver driver = new ChromeDriver();
		driver.get(baseurl);

		// Click on the Sign in Button
		WebElement Cart_B = driver.findElement(By.xpath("/html/body/div[3]/div[4]/div/div[2]/div[1]/div/div[2]/div/div[1]/div/a"));
		Cart_B.click();

		WebElement UserEmail = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[1]/input"));
		UserEmail.sendKeys(u);

		WebElement Password = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[1]/div[2]/input"));
		Password.sendKeys(p);

		WebElement Login_B = driver.findElement(By.xpath("/html/body/div[2]/div[4]/div[2]/div/div/div/form/div[2]/button"));
		Login_B.click();

	}

}