package Resource;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.ExcelFileUtil;

public class AppTest {
WebDriver driver;
ExtentReports report;
ExtentTest test;
String inputpath="F://Logindata.xlsx";
String outputpath="F://Datadriven.xlsx";
@BeforeTest
public void setUp()
{
	report= new ExtentReports("./ExtentReports/Report.html");
	driver= new ChromeDriver();
}
@Test
public void verifyLogin()throws Throwable
{
	//create object for excelfile util
	ExcelFileUtil xl= new ExcelFileUtil(inputpath);
	int rc=xl.rowCount("Login");
for(int i=1;i<=rc;i++)
{
	driver.get("http://orangehrm.qedgetech.com/");
	driver.manage().window().maximize();
	test=report.startTest("Validate Login");
String username=xl.getCellData("Login", i, 0);
String password=xl.getCellData("Login", i, 1);
driver.findElement(By.xpath("//input[@name='txtUsername']")).sendKeys(username);
driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys(password);
driver.findElement(By.xpath("//input[@name='Submit']")).click();
WebDriverWait wait=new WebDriverWait(driver, 10);

if(driver.getCurrentUrl().contains("dash"))
{
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//b[contains(text(),'Dashboard')]")));
	Reporter.log("LOgin success",true);
	xl.setCellData("Login", i, 2, "Login Success", outputpath);
	xl.setCellData("Login", i, 3, "Pass", outputpath);
	test.log(LogStatus.PASS, "Login Success");
}
else
{
	String message=driver.findElement(By.id("spanMessage")).getText();
	Reporter.log(message,true);
	xl.setCellData("Login", i, 2, message, outputpath);
	xl.setCellData("Login", i, 3, "Fail", outputpath);
	test.log(LogStatus.FAIL, message);
}
report.endTest(test);
report.flush();
}
}
@AfterTest
public void tearDown()
{
	driver.close();
}
}




