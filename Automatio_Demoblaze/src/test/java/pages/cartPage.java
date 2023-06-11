package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class cartPage {
	
	WebDriver driver;
	
	By btn_laptopcty = By.linkText("Laptops");
	By btn_macbookpro = By.xpath("//a[normalize-space()='MacBook Pro']");
	By btn_addtochart = By.xpath("//a[@class='btn btn-success btn-lg']");
	By btn_home = By.cssSelector("a.nav-link[href='index.html']");
	By btn_monitorcty = By.linkText("Monitors");
	By btn_applemonitor = By.xpath("//a[normalize-space()='Apple monitor 24']");
	By btn_cart = By.id("cartur");
	By btn_placeorder = By.xpath("//button[normalize-space()='Place Order']");
	By btn_delete = By.xpath("//a[normalize-space()='Delete']");
	By txt_name = By.id("name");
	By txt_country = By.id("country");
	By txt_city = By.id("city");
	By txt_creditcart = By.id("card");
	By txt_month = By.id("month");
	By txt_year = By.id("year");
	By btn_purchase = By.xpath("//button[contains(text(), 'Purchase')]");
	By purchase_success = By.xpath("//h2[contains(text(), 'Thank you for your purchase!')]");
	
	public cartPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void clickLaptopCategory() {
		driver.findElement(btn_laptopcty).click();
	}
	
	public void clickMacbookPro() {
		driver.findElement(btn_macbookpro).click();
	}
	public void addtochartIsDisplayed() {
		driver.findElement(btn_addtochart).isDisplayed();
	}
	public void clickAddToChart() {
		driver.findElement(btn_addtochart).click();
	}
	public void clickHome() {
		driver.findElement(btn_home).click();
	}
	public void clickMonitorCategory() {
		driver.findElement(btn_monitorcty).click();
	}
	public void clickAppleMonitor() {
		driver.findElement(btn_applemonitor).click();
	}
	public void clickCart() {
		driver.findElement(btn_cart).click();
	}
	public void placeorderIsDisplayed() {
		driver.findElement(btn_placeorder).isDisplayed();
	}
	public void clickDelete() {
		driver.findElement(btn_delete).click();
	}
	public void clicPlaceOrder() {
		driver.findElement(btn_placeorder).click();
	}
	public void input_name(String name) {
		driver.findElement(txt_name).sendKeys(name);
	}
	public void input_country(String country) {
		driver.findElement(txt_country).sendKeys(country);
	}
	public void input_city(String city) {
		driver.findElement(txt_city).sendKeys(city);
	}
	public void input_credit(String creditcard) {
		driver.findElement(txt_creditcart).sendKeys(creditcard);
	}
	public void input_month(String month) {
		driver.findElement(txt_month).sendKeys(month);
	}
	public void input_year(String year) {
		driver.findElement(txt_year).sendKeys(year);
	}
	public void clickPurchase() {
		driver.findElement(btn_purchase).click();
	}
	public void purchaseSuccess() {
		driver.findElement(purchase_success).getText();
	}
	
}
