package Resource;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import ApllicationLayer.BranchCreationPage;
import ApllicationLayer.LoginPage;
import ApllicationLayer.LogoutPage;

public class TestScript {
WebDriver driver;
@BeforeTest
public void setup()throws Throwable
{
	//System.setProperty("webdriver.chrome.driver","D:\\Selenium_8oclock\\Automation_FrameWorks\\Drivers\\chromedriver.exe");
	driver= new ChromeDriver();
	driver.get("http://primusbank.qedgetech.com/");
	driver.manage().window().maximize();
	LoginPage login=PageFactory.initElements(driver, LoginPage.class);
login.verifyLogin("Admin", "Admin");
}
@Test
public void branches()throws Throwable
{
BranchCreationPage branch=PageFactory.initElements(driver, BranchCreationPage.class);	
branch.verifybranch("testing", "Hyderabad", "12345", "INDIA", "GOA", "GOA");
String alertmessage=driver.switchTo().alert().getText();
System.out.println(alertmessage);
Thread.sleep(5000);
driver.switchTo().alert().accept();
}
@AfterTest
public void tearDown()
{
	LogoutPage logout=PageFactory.initElements(driver, LogoutPage.class);
	logout.verifyLogout();
	driver.close();
}
}
