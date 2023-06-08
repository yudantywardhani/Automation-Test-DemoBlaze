package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class signUpPage {
	
	WebDriver driver;
	
	By btn_signup = By.id("signin2");
	By btn_signupProcess = By.xpath("//button[contains(text(),'Sign up')]");
	By txt_username = By.id("sign-username");
	By txt_password = By.id("sign-password");
	
	public signUpPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickSignUp () {
		driver.findElement(btn_signup).click();
	}
	
	public void formSignUpDisplayed() {
		driver.findElement(btn_signupProcess).isDisplayed();
	}
	
	public void input_username (String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void input_password (String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickSignUpProcess () {
		driver.findElement(btn_signupProcess).click();
	}
	
	public static void waitFor (long timeout) {
		long multipliedTimedOut = timeout * 1000;
		try {
			Thread.sleep(multipliedTimedOut);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
//	public void clear_username() {
//		driver.findElement(txt_username).clear();
//	}
//	public void clear_password() {
//		driver.findElement(txt_password).clear();
//	}
}

