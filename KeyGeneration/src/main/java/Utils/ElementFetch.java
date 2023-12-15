package Utils;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.basetest;

public class ElementFetch {
	public WebElement getWebElements(String indetifierType, String indentifierValue) {

		switch(indetifierType) {
		case "XPATH" :
			return basetest.driver.findElement(By.xpath(indentifierValue));

		case "CSS" :
			return basetest.driver.findElement(By.cssSelector(indentifierValue));

		case "ID" : 
			return basetest.driver.findElement(By.id(indentifierValue));
		case "NAME" : 
			return basetest.driver.findElement(By.name(indentifierValue));
		case "TAGNAME" : 
			return basetest.driver.findElement(By.tagName(indentifierValue));
		case "LINKTEXT" : 
			return basetest.driver.findElement(By.linkText(indentifierValue));
		default : 
			return null;
		}
	}
	public List<WebElement> getWebElement(String indetifierType, String indentifierValue) {

		switch(indetifierType) {
		case "XPATH" :
			return basetest.driver.findElements(By.xpath(indentifierValue));

		case "CSS" :
			return basetest.driver.findElements(By.cssSelector(indentifierValue));

		case "ID" : 
			return basetest.driver.findElements(By.id(indentifierValue));
		case "NAME" : 
			return basetest.driver.findElements(By.name(indentifierValue));
		case "TAGNAME" : 
			return basetest.driver.findElements(By.tagName(indentifierValue));
		case "LINKTEXT" : 
			return basetest.driver.findElements(By.linkText(indentifierValue));
		default : 
			return null;
		}
}
}