package ApllicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
WebDriver driver;
public LoginPage(WebDriver driver)
{
	this.driver=driver;
	}
//define Repository
@FindBy(name="txtuId")
WebElement username;
@FindBy(name="txtPword")
WebElement password;
@FindBy(name="login")
WebElement clicklogin;
public void verifyLogin(String username,String password)throws Throwable
{
	this.username.sendKeys(username);
	this.password.sendKeys(password);
	clicklogin.click();
	Thread.sleep(5000);
}

}
