package SC_pages;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class scHomePage {
	
	WebDriver driver;
	
	By search_TextBox = By.xpath("/html//input[@id='autocomplete']");
	By Search_Button = By.xpath("//a[@onClick='searchTrigger()']");
	// By alertWindow = By.xpath("//p[@class='moe-notification-message-safari']");
	By dontAllowButton = By.xpath("//button[contains(text(),'Don')]");
	By cartIcon = By.xpath("//li[@class='qCart']");
	By homeIconButtonFromMyCart = By.xpath("//div[@class='logo']");
	
	
	
	public scHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTextInSearchBox(String searchText) {
		driver.findElement(search_TextBox).click();
		driver.findElement(search_TextBox).clear();
		driver.findElement(search_TextBox).sendKeys(searchText);

	}
	
	public void clickSearchButton() {
		driver.findElement(Search_Button).click();
		//sendKeys(Keys.RETURN);
	}
	
	public void clickOnDontAllowButton(){
		
		driver.findElement(dontAllowButton).click();
		
		/*
		 * if( driver.findElement(alertWindow).isDisplayed()) {
		 * driver.findElement(alertWindow).click(); driver.switchTo().alert().accept();
		 * }
		 */
	}
	
	public void clickOnCartButton() {
		driver.findElement(cartIcon).click();
	}
	
	public void clickOnHomeButtonFromMyCart() {
		driver.findElement(homeIconButtonFromMyCart).click();
	}
	
	public void signInButtonDropdownHelp() throws InterruptedException {
		WebElement signInButton = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[4]/ul[1]/li[6]/a[1]"));
		WebElement helpAndSupportButton = driver.findElement(By.xpath("//body/div[4]/div[1]/div[1]/div[4]/ul[1]/li[6]/div[1]/div[1]/ul[1]/li[9]/a[1]"));
		Actions action = new Actions(driver);
		action.moveToElement(signInButton).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(2000));
		//wait.until(ExpectedConditions.elementToBeClickable(signInButton));
		wait.until(ExpectedConditions.elementToBeClickable(helpAndSupportButton));
		action.moveToElement(helpAndSupportButton).build().perform();
		wait.until(ExpectedConditions.elementToBeClickable(helpAndSupportButton));
		action.click(helpAndSupportButton);
		action.build();
		
		
		/*
		 * Select sel = new Select(signInButton); sel.se
		 * sel.selectByVisibleText("Help & Support");
		 */		
	}
	
}
