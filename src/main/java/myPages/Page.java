package myPages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	static WebDriver driver;
	WebDriverWait wait;
	JavascriptExecutor js;
	
	public Page(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, 30);
	}
	
	public abstract String get_pageTitle();
	
	public abstract WebElement get_Element(By locator);
	
	public abstract Boolean waitUntilJQueryReady(WebDriver driver);
	
	public abstract void wait_for_element(By locator);
	
	public abstract List<WebElement> get_Elements(By locator);
	
	public <TPage extends BasePage>TPage getInstance(Class<TPage> pageClass) {
		try {
			return pageClass.getDeclaredConstructor(WebDriver.class).newInstance(this.driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	}
