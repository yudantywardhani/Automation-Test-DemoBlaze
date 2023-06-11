package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoAlertPresentException;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.cartPage;
import pages.contactUsPage;
import pages.loginPage;
import pages.signUpPage;
import org.openqa.selenium.JavascriptExecutor;

public class stepDefinitions {
	
	WebDriver driver = null;
	String dialogText;
	
	signUpPage signup;
	loginPage login;
	contactUsPage contactus;
	cartPage cart;

///////////////-GENERAL-//////////////////////////////////////////////////
	
	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver","C:/Users/asus/eclipse-workspace/Automatio_Demoblaze/src/test/resources/driver/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And(".*? is on home page$")
	public void user_is_on_home_page() {
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}
	
	@And(".*?delay.*?(\\d+).*?$")
	public void delay(long seconds) {
		signup.waitFor(seconds);
	}
	
	@When("dialog box is displayed")
	public void dialog_box_is_displayed() {
		try {
	        driver.switchTo().alert(); 							//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
	        // Dialog box is displayed
	    } catch (NoAlertPresentException e) { 					//Jika tidak ada kotak dialog yang ditampilkan, maka NoAlertPresentException akan dilempar.
	        assertTrue(false);									//Jika pengecualian NoAlertPresentException terjadi, kita menganggap bahwa dialog box tidak ditampilkan dan asert akan gagal.
	    }
	}
	
	@And("close browser")
	public void close_browser() {
		driver.quit();
	}
	
	@And (".*? scroll down$")
	public void scroll_down() {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	@And (".*? clicks Home button$")
	public void clicks_Home_button() {
		cart.clickHome();
	}

///////////////-SIGNUP-//////////////////////////////////////////////////
	
	@When(".*? click signup button$")
	public void user_click_signup_button() {
		signup = new signUpPage(driver);
		signup.clickSignUp();
	}

	@Then("verified signup form")
	public void verified_signup_form() {
		signup.formSignUpDisplayed();
	}

	@When(".*? inputs (.*) and (.*) signup$")
	public void user_inputs_username_and_password_signup(String username, String password) {
		signup = new signUpPage(driver);
		signup.input_username(username);
		signup.input_password(password);
	}

	@And(".*? clicks on signup button$")
	public void user_clicks_on_signup_button(){
		signup.clickSignUpProcess();
	}
	
	@Then("verified sign up sucessful")
	public void verified_sign_up_sucessful  () {
		Alert alert = driver.switchTo().alert(); 				//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
        dialogText = alert.getText();			 				// Ambil teks dialog yang muncul
        assertEquals("Sign up successful.", dialogText); 		// Verifikasi teks dialog dengan teks yang diharapkan (ekspektasi, realita)
        alert.accept();							 				//mengkonfirmasi dan menutup kotak dialog
	}
	
	@Then("verified sign up failed")
	public void verified_sign_up_failed() {
		Alert alert = driver.switchTo().alert(); 				//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
        dialogText = alert.getText();			 				// Ambil teks dialog yang muncul
        assertEquals("This user already exist.", dialogText); 	// Verifikasi teks dialog dengan teks yang diharapkan
        alert.accept();							 				//mengkonfirmasi dan menutup kotak dialog
	}
	
///////////////-LOGIN-//////////////////////////////////////////////////
	
	@Then("verified login form")
	public void verified_login_form() {
		login.formLogInisplayed();
	}
	
	@When(".*?click login button$")
	public void click_login_button() {
		login = new loginPage(driver);
		login.clickLogIn();
	}
	
	@And(".*?clicks on login process button$")
	public void clicks_on_login_process_button() {
		login.clickLogInProcess();
	}
	
	@When(".*? inputs (.*) and (.*) login$")
	public void user_inputs_username_and_password_login(String username, String password) {
		login = new loginPage(driver);
		login.input_username(username);
		login.input_password(password);
	}
	
	@Then("verified login sucessful")
	public void verified_login_sucessful() {
		login.buttonLogoutisplayed();
	}
	
	@Then("verified login failed cause username and pass empty")
	public void verified_login_failed_cause_username_and_pass_empty() {
		Alert alert = driver.switchTo().alert(); 				
        dialogText = alert.getText();			 				
        assertEquals("Please fill out Username and Password.", dialogText); 
        alert.accept();	
	}
	
	@Then("verified login failed cause wrong password")
	public void verified_login_failed_cause_wrong_password() {
		Alert alert = driver.switchTo().alert(); 				
        dialogText = alert.getText();			 				
        assertEquals("Wrong password.", dialogText); 
        alert.accept();	
	}

///////////////-CONTACT-//////////////////////////////////////////////////
	
	@When(".*?click contact us button$")
	public void user_click_contact_us_button() {
		contactus = new contactUsPage(driver);
		contactus.clickContactUs();
	}
	
	@Then("verified new message form")
	public void verified_new_message_form() {
		contactus.formMessageisDisplayed();
	}
	
	@When(".*? inputs (.*) and (.*) and (.*) contact$")
	public void inputs_email_and_name_and_message_contact(String email, String name, String message) {
		contactus = new contactUsPage(driver);
		contactus.input_email(email);
		contactus.input_name(name);
		contactus.input_message(message);
	}
	
	@And (".*? clicks send message button$")
	public void clicks_send_message_button() {
		contactus.clickSendMessage();
	}
	
	@Then("verified send message sucessful")
	public void verified_send_message_sucessful() {
		Alert alert = driver.switchTo().alert(); 				
        dialogText = alert.getText();			 				
        assertEquals("Thanks for the message!!", dialogText); 
        alert.accept();	
	}
	
///////////////-GENERAL-//////////////////////////////////////////////////
	
	@And (".*? clicks Laptops category$")
	public void clicks_Laptops_category() {
		cart = new cartPage(driver);
		cart.clickLaptopCategory();
	}
	
	@When (".*? clicks MacBook Pro$")
	public void clicks_MacBook_Pro() {
		cart.clickMacbookPro();
	}
	
	@Then ("verified product details")
	public void verified_product_details() {
		cart.addtochartIsDisplayed();
	}
	@And (".*? clicks Add to Chart button$")
	public void clicks_Add_to_Chart_button() {
		cart.clickAddToChart();
	}
	@Then ("verified product added")
	public void verified_product_added() {
		Alert alert = driver.switchTo().alert(); 				
        dialogText = alert.getText();			 				
        assertEquals("Product added", dialogText); 
        alert.accept();	
	}
	
	@And (".*? clicks Monitor category$")
	public void clicks_Monitor_category() {
		cart.clickMonitorCategory();
	}
	
	@When (".*? clicks Apple Monitor$")
	public void clicks_Apple_Monitor() {
		cart.clickAppleMonitor();
	}
	
	@When (".*? clicks cart button$")
	public void clicks_cart_button() {
		cart.clickCart();
	}
	@Then ("verified cart page")
	public void verified_cart_page() {
		cart.placeorderIsDisplayed();
	}
	@And (".*? clicks delete button$")
	public void clicks_delete_button() {
		cart.clickDelete();
	}
	@And (".*? clicks place order button$")
	public void clicks_place_order_button() {
		cart.clicPlaceOrder();
	}
	@And (".*? inputs (.*) (.*) (.*) (.*) (.*) and (.*) po$")
	public void inputs_name_country_city_creditcard_month_and_year_po(String name, String country, String city, String creditcard, String month, String year) {
		cart = new cartPage(driver);
		cart.input_name(name);
		cart.input_country(country);
		cart.input_city(city);
		cart.input_credit(creditcard);
		cart.input_month(month);
		cart.input_year(year);
	}
	@And (".*? clicks purchase button$")
	public void clicks_purchase_button() {
		cart.clickPurchase();
	}
	@Then ("purchase successful")
	public void purchase_successful() {
		cart.purchaseSuccess();
	}

}
