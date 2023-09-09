package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Shiftroaster_page extends BasePage{

	public Shiftroaster_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Xpath for Shift roastering screen
	private By shiftroastermenu = By.xpath("//a[text()='Shift Rostering (New)']");

	
	
	// Web Elements for the above Xpath
	public WebElement get_shiftroastermenu() {
		return get_Element(shiftroastermenu);
}
	
	
	// Methods for Shift roastering screen
	public void shiftroasterpage() throws Throwable {
		
		get_shiftroastermenu().click();
		pageWait();
		driver.navigate().refresh();
	}
	
	
}
