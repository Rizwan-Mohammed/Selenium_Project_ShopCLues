package SC_pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class scHomePage {
	
	WebDriver driver;
	
	By search_TextBox = By.xpath("/html//input[@id='autocomplete']");
	By Search_Button = By.xpath("//a[@onClick='searchTrigger()']");
	
	public scHomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void enterTextInSearchBox(String searchText) {
		driver.findElement(Search_Button).sendKeys(searchText);
	}
	
	public void clickSearchButton() {
		driver.findElement(Search_Button).sendKeys(Keys.RETURN);
	}
}
