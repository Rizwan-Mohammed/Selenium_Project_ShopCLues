package StepDefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import SC_pages.scHomePage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class searchBarAndCorrespondingRow {
	
	WebDriver driver = null;
	scHomePage p1;
	
	@Given("when the user is on the homepage of shopclues")
	public void when_the_user_is_on_the_homepage_of_shopclues() throws InterruptedException {
	    String projectPath = System.getProperty("user.dir");
	    System.out.println(projectPath);
	    
	    // setting up the desired capbilities so to start in incognito and no alerts
	    DesiredCapabilities DC = new DesiredCapabilities();
	    FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("-private");
	    DC.setCapability("moz:firefoxoptions", options);
	    
	    System.setProperty("Webdriver.gecko.driver", projectPath+"Drivers/WinDrivers/geckodriver.exe");
	    driver = new FirefoxDriver();
	   
	    driver.get("https://www.shopclues.com/");
	    driver.manage().window().maximize();
		
	//    Alert a = driver.switchTo().alert();
	  //  String alertMessage = driver.switchTo().alert().getText();
	   // System.out.println(alertMessage);
	   // a.accept();
	    Thread.sleep(5000);
	    p1 = new scHomePage(driver);	
		p1.clickOnDontAllowButton();
		Thread.sleep(2000);
	}

	@When("the user clicks in search bar and enter the text")
	public void the_user_clicks_in_search_bar_and_enter_the_text() {
				
			p1.enterTextInSearchBox("Mens Jeans");
	}

	@And("user click on search button")
	public void user_click_on_search_button() {
		p1.clickSearchButton();
	}

	
	@Then("the user is presented with list options")
	public void the_user_is_presented_with_list_options() throws InterruptedException {
		boolean ifExpected = driver.getPageSource().contains("Showing");
		Assert.assertTrue(ifExpected);
		Thread.sleep(5000);
		driver.close();
		driver.quit();
	}
}
