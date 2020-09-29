package ApllicationLayer;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class BranchCreationPage {
WebDriver driver;
public BranchCreationPage(WebDriver driver)
{
	this.driver=driver;
}
@FindBy(xpath="//tr//tr//tr//tr//tr[2]//td[1]//a[1]//img[1]")
WebElement clickbranches;
@FindBy(xpath="//input[@id='BtnNewBR']")
WebElement clicknebranch;
@FindBy(name="txtbName")
WebElement enterbname;
@FindBy(name="txtAdd1")
WebElement enteraddress1;
@FindBy(name="txtZip")
WebElement enterzipcode;
@FindBy(name="lst_counrtyU")
WebElement selectcountry;
@FindBy(name="lst_stateI")
WebElement selectstate;
@FindBy(name="lst_cityI")
WebElement selectcity;
@FindBy(name="btn_insert")
WebElement clicksubmit;
public void verifybranch(String bname,String address1,String zcode,String country,String state,String city)
throws Throwable{
this.clickbranches.click();
Thread.sleep(5000);
this.clicknebranch.click();
Thread.sleep(5000);
this.enterbname.sendKeys(bname);
this.enteraddress1.sendKeys(address1);
this.enterzipcode.sendKeys(zcode);
new Select(this.selectcountry).selectByVisibleText(country);
Thread.sleep(5000);
new Select(this.selectstate).selectByVisibleText(state);
Thread.sleep(5000);
new Select(this.selectcity).selectByVisibleText(city);
Thread.sleep(5000);
this.clicksubmit.click();
Thread.sleep(5000);
}
}
