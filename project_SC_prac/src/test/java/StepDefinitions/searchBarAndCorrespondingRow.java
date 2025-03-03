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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

public class searchBarAndCorrespondingRow {
	
	
	WebDriver driver = null;
	private static Logger logger = LogManager.getLogger(searchBarAndCorrespondingRow.class);
	scHomePage p1;
	String baseUrl = "https://www.shopclues.com/";
	
	@Given("when the user is on the homepage of shopclues")
	public void when_the_user_is_on_the_homepage_of_shopclues() throws InterruptedException {
	    String projectPath = System.getProperty("user.dir");
	    System.out.println(projectPath);
	    
	    // setting up the desired capbilities so to start in incognito and no alerts
	    DesiredCapabilities DC = new DesiredCapabilities();
	    FirefoxOptions options = new FirefoxOptions();
	    options.addArguments("-private");
	    options.addPreference("dom.webnotifications.enabled", false);
	    DC.setCapability("moz:firefoxoptions", options);
	    logger.info("firefox with private session, webnotifications disabled");
	    
	    System.setProperty("Webdriver.gecko.driver", projectPath+"Drivers/WinDrivers/geckodriver.exe");
	    driver = new FirefoxDriver();
	   
	    driver.get(baseUrl);
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
			logger.atWarn();
	}

	@And("user click on search button")
	public void user_click_on_search_button() {
		p1.clickSearchButton();
		logger.fatal("Fatal message");;
	}

	
	@Then("the user is presented with list options")
	public void the_user_is_presented_with_list_options() throws InterruptedException {
		boolean ifExpected = driver.getPageSource().contains("Showing");
		System.out.println(ifExpected);
		Assert.assertTrue(ifExpected);
		Assert.assertTrue("This is now passed", ifExpected);
		Thread.sleep(8000);
		//driver.close();
		driver.quit();
		logger.trace("This is trace message");
	}
	
	@When("the user clicks on the cart icon")
	public void the_user_clicks_on_the_cart_icon() {
	  p1.clickOnCartButton();
	  logger.info("This is the info from Logger");
	}

	@Then("the user is navigated to MyCart")
	public void the_user_is_navigated_to_my_cart() throws Exception {
	    Boolean ifNavigatedToCart = driver.getCurrentUrl().contains("https://secure.shopclues.com/atom/acart/getcart");
	    Assert.assertTrue(ifNavigatedToCart);
	    //driver.close();
	    Thread.sleep(2000);
	   driver.quit();
	    // adding this line of code to see the commit going through with which user 
	    // rizwan-mohammed or rizwan033
	}
	

@When("when the user is on MyCart page")
public void when_the_user_is_on_my_cart_page() {
System.out.println("user is on my cart page");
}

@When("the user clicks on Home page button")
public void the_user_clicks_on_home_page_button() throws Exception {
	Thread.sleep(2000);
	p1.clickOnHomeButtonFromMyCart();
   
}

@Then("the user is navigated to Home page")
public void the_user_is_navigated_to_home_page() {
	
	Boolean IfcurrentURL = driver.getCurrentUrl().contentEquals(baseUrl);
	if(IfcurrentURL == true) {
		System.out.println("The test is passed");
		logger.info("the test is passed");
	}
	driver.quit();
}




}
