package ApllicationLayer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage {
@FindBy(xpath="//td//td//td//td[3]//a[1]//img[1]")
WebElement clicklogout;
public void verifyLogout()
{
	clicklogout.click();
}
}
