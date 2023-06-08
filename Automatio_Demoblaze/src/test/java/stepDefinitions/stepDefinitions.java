package stepDefinitions;

import static org.junit.Assert.assertTrue;
import org.openqa.selenium.NoAlertPresentException;
import static org.junit.Assert.assertEquals;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.en.*;
import pages.signUpPage;

public class stepDefinitions {
	
	WebDriver driver = null;
	signUpPage signup;
	String dialogText;

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
	public void user_inputs_username_and_password(String username, String password) {
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
	        driver.switchTo().alert(); 							//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
	        // Dialog box is displayed
	    } catch (NoAlertPresentException e) { 					//Jika tidak ada kotak dialog yang ditampilkan, maka NoAlertPresentException akan dilempar.
	        assertTrue(false);									//Jika pengecualian NoAlertPresentException terjadi, kita menganggap bahwa dialog box tidak ditampilkan dan asert akan gagal.
	    }
	}
	
	@Then("verified sign up sucessful")
	public void verified_sign_up_sucessful  () {
		Alert alert = driver.switchTo().alert(); 				//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
		
        dialogText = alert.getText();			 				// Ambil teks dialog yang muncul
        assertEquals("Sign up successful.", dialogText); 		// Verifikasi teks dialog dengan teks yang diharapkan
		
        alert.accept();							 				//mengkonfirmasi dan menutup kotak dialog
	}
	
//	@And(".*? clear username field$")
//	public void clear_username_field() {
//		signup.clear_username();
//	}
//	
//	@And(".*? clear password field$")
//	public void clear_password_field() {
//		signup.clear_password();
//	}
	
	@Then("verified sign up failed")
	public void verified_sign_up_failed() {
		Alert alert = driver.switchTo().alert(); 				//mengarahkan driver Selenium untuk beralih ke dialog aktif yang ditampilkan di browser
		
        dialogText = alert.getText();			 				// Ambil teks dialog yang muncul
        assertEquals("This user already exist.", dialogText); 	// Verifikasi teks dialog dengan teks yang diharapkan
		
        alert.accept();							 				//mengkonfirmasi dan menutup kotak dialog
	}
}
