package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginPage {
	
	WebDriver driver;
	
	By btn_login = By.id("login2");
	By btn_loginProcess = By.xpath("//button[contains(text(), 'Log in')]");
	By txt_username = By.id("loginusername");
	By txt_password = By.id("loginpassword");
	By btn_logout = By.id("logout2");
	
	public loginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLogIn () {
		driver.findElement(btn_login).click();
	}
	
	public void formLogInisplayed() {
		driver.findElement(btn_loginProcess).isDisplayed();
	}
	
	public void input_username (String username) {
		driver.findElement(txt_username).sendKeys(username);
	}
	
	public void input_password (String password) {
		driver.findElement(txt_password).sendKeys(password);
	}
	
	public void clickLogInProcess () {
		driver.findElement(btn_loginProcess).click();
	}
	public void buttonLogoutisplayed() {
		driver.findElement(btn_logout).isDisplayed();
	}

}
