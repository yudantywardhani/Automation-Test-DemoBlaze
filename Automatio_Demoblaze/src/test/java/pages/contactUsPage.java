package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class contactUsPage {
	WebDriver driver;
	
	By btn_contactus = By.linkText("Contact");
	By btn_sendmessage = By.xpath("//button[contains(text(), 'Send message')]");
	By txt_email = By.id("recipient-email");
	By txt_name = By.id("recipient-name");
	By txt_message = By.id("message-text");
	
	public contactUsPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickContactUs() {
		driver.findElement(btn_contactus).click();
	}
	
	public void formMessageisDisplayed() {
		driver.findElement(btn_sendmessage).isDisplayed();
	}
	
	public void input_email (String email) {
		driver.findElement(txt_email).sendKeys(email);
	}
	
	public void input_name (String name) {
		driver.findElement(txt_name).sendKeys(name);
	}
	
	public void input_message (String message) {
		driver.findElement(txt_message).sendKeys(message);
	}
	
	public void clickSendMessage() {
		driver.findElement(btn_sendmessage).click();
	}
}
