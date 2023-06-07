package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoAlertPresentException;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.signUpPage;

public class stepDefinitions {
	
	WebDriver driver = null;
	signUpPage signup;

	@Given("browser is open")
	public void browser_is_open() {
		System.setProperty("webdriver.chrome.driver","C:/Users/asus/eclipse-workspace/CucumberJava/src/test/resources/drivers/chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	    driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	    driver.manage().window().maximize();
	}

	@And(".*? is on home page$")
	public void user_is_on_home_page() {
		driver.navigate().to("https://www.demoblaze.com/index.html");
	}

	@When(".*? click signup button$")
	public void user_click_signup_button() {
		signup = new signUpPage(driver);
		signup.clickSignUp();
	}

	@Then("verified signup form")
	public void verified_signup_form() {
		signup.formSignUpDisplayed();
	}

	@When(".*? inputs (.*) and (.*)$")
	public void user_inputs_username1_and_password1(String username, String password) {
		signup = new signUpPage(driver);
		signup.input_username(username);
		signup.input_password(password);
	}

	@And(".*? clicks on signup button$")
	public void user_clicks_on_signup_button(){
		signup.clickSignUpProcess();
	}
	
	@And(".*?delay.*?(\\d+).*?$")
	public void delay(long seconds) {
		signup.waitFor(seconds);
	}
	
	@When("dialog box is displayed")
	public void dialog_box_is_displayed() {
		try {
	        driver.switchTo().alert();
	        // Dialog box is displayed
	    } catch (NoAlertPresentException e) {
	        assertTrue(false);
	    }
	}
	
	@Then(".*?clicks the OK button in the dialog box$")
	public void clicks_the_OK_button_in_the_dialog_box() {
		Alert alert = driver.switchTo().alert();
        alert.accept();
	}
	


}
