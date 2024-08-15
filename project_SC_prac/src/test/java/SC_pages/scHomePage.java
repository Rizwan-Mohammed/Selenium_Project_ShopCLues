package SC_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class scHomePage {
	
	WebDriver driver;
	
	By search_TextBox = By.xpath("/html//input[@id='autocomplete']");
	By Search_Button = By.xpath("//a[@onClick='searchTrigger()']");
	// By alertWindow = By.xpath("//p[@class='moe-notification-message-safari']");
	By dontAllowButton = By.xpath("//button[contains(text(),'Don')]");
	By cartIcon = By.xpath("//li[@class='qCart']");
	
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
	
	
}
