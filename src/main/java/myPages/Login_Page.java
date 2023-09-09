package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page extends BasePage{

	public Login_Page(WebDriver driver) {
		super(driver);

}	
	private By Username = By.xpath("//input[@placeholder='Email ID/User ID']");
	private By Password = By.xpath("//input[@placeholder='Password']");
	private By Signinbtn = By.id("sign_in_button");
	
	
	public WebElement get_Username() {
		return get_Element(Username);
	}
	public WebElement get_Password() {
		return get_Element(Password);
	}
	public WebElement get_Signinbtn() {
		return get_Element(Signinbtn);
	}
	
	
	
	public Login_Page do_Login(String username, String password) {
		get_Username().clear();
		get_Username().sendKeys(username);
		get_Password().clear();
		get_Password().sendKeys(password);
		get_Signinbtn().click();
		return getInstance(Login_Page.class);
	}
	
	public String get_page_tittle() {
		String title = driver.getTitle();
		return null;
	}
	
}