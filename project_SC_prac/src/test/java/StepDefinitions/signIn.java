package StepDefinitions;


import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SC_pages.scHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class signIn {
	scHomePage p2;
	String baseUrl = "https://www.shopclues.com";
	String projectPath;
	WebDriver driver=null;
	
	@Given("when the user is on the homepage")
	public void when_the_user_is_on_the_homepage() throws Exception {
	  projectPath= System.getProperty("user.dir");
	
	  DesiredCapabilities DC = new DesiredCapabilities();
	  FirefoxOptions options = new FirefoxOptions();
	  options.addArguments("private");
	  options.addPreference("dom.webnotifications.enabled", false);
	  DC.setCapability("moz:firefoxoptions", options);
	  System.setProperty("Webdriver.gecko.driver", projectPath+"Drivers/WinDrivers/geckodriver.exe");
	  driver = new FirefoxDriver();
	  driver.get(baseUrl);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(2));
	 
	  Thread.sleep(2000);
	  p2 = new scHomePage(driver);
	  p2.clickOnDontAllowButton();
	 // Thread.sleep(2000);
	}
	
	
	@When("the user goes to signIn and click on help & support")
	public void the_user_goes_to_sign_in_and_click_on_help_support() throws Exception {
		//Thread.sleep(2000);
		p2.signInButtonDropdownHelp();
		Thread.sleep(2000);
		
	}

	@Then("the user is navigated to Help page")
	public void the_user_is_navigated_to_help_page() throws InterruptedException {
		
		WebDriverWait w = new WebDriverWait(driver, Duration.ofMillis(2000));
		String helpPage = driver.getCurrentUrl();
		String expectedHelpPageURL = "https://myaccount.shopclues.com/index.php?dispatch=write_to_us.support";
		w.until(ExpectedConditions.urlToBe(helpPage));
	
		boolean result1 = helpPage.contentEquals(expectedHelpPageURL);
	//	boolean result = helpPage.contentEquals(expectedHelpPageURL);
		if(result1 == true)
		{
			System.out.println("test is passed");
		}
		else
			System.out.println("test is failed");
		Thread.sleep(2000);
		driver.quit();
		}
	

	}

