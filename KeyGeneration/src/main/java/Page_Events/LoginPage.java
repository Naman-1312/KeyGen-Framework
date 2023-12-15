package Page_Events;

import org.openqa.selenium.By;
import org.testng.Assert;

import Page_Elements.LoginPage_Elements;
import Utils.ElementFetch;

public class LoginPage {
	ElementFetch ele = new ElementFetch();
public void enterCred() {
	ele.getWebElements("ID",LoginPage_Elements.userNameField).sendKeys("amitabh@yoctel.com");
	ele.getWebElements("ID",LoginPage_Elements.passwordField).sendKeys("Yoc@abc1/");
}
	
	
	public void signInButton() {
	ele.getWebElements("ID",LoginPage_Elements.loginBtn).click();
	}
	public void loginIdentifier() {
	Assert.assertSame(ele.getWebElements("ID", LoginPage_Elements.dateFilter_drp),"Element not found");
	}
}
