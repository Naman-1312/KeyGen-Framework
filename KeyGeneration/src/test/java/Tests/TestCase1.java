package Tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import Base.basetest;
import Page_Events.LoginPage;
import Utils.ElementFetch;

public class TestCase1 extends basetest {
  
	ElementFetch ele = new ElementFetch();
	LoginPage LP = new LoginPage();
	
	
	@Test
  public void sampleMethodForLogin() {
	  LP.enterCred();
	  LP.signInButton();
	  LP.loginIdentifier();
  }
}
