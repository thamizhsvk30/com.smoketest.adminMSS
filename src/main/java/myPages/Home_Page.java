package myPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Home_Page extends BasePage {

	public Home_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	private By Homemenu = By.xpath("(//a[@href='https://inedgenxt.worqhub.com/home/dashboard'])[1]");
	private By Todaystatus = By.xpath("//*[@id=\"hep_nav\"]/li[2]/a");
	private By Dashboardtext = By.xpath("//p[@class='qworq_page_desc mt-1 mb-0']");
	private By Attendancedashboard = By.xpath("(//a[text()='Attendance Dashboard'])[2]");
	private By Dashboard2text = By.xpath("//p[@class='qworq_page_desc mt-1 mb-0']");
	private By Separationdash = By.xpath("//*[@id=\"hep_nav_overflow\"]/li/a");
	private By threedot = By.xpath("//*[@id=\"hep_nav\"]/li[10]");
	
	public WebElement get_Homemenu() {
		return get_Element(Homemenu);
}
	public WebElement get_Todaystatus() {
		return get_Element(Todaystatus);
}
	public WebElement get_Dashboardtext() {
		return get_Element(Dashboardtext);
}
	public WebElement get_Attendancedashboard() {
		return get_Element(Attendancedashboard);
}
	public WebElement get_Dashboard2text() {
		return get_Element(Dashboard2text);
}
	public WebElement get_Separationdash() {
		return get_Element(Separationdash);
}
	public WebElement get_threedot() {
		return get_Element(threedot);
}
	
	

	public void todayStatus() throws Throwable {
	
		pageWait();
		get_Todaystatus().click();
//		String title = driver.getTitle();
//		System.out.println(title);
		pageWait();		
	}
	
	
	
	public void AttendDashboard() throws Throwable {
		
		pageWait();
		get_Attendancedashboard().click();
//		String title = driver.getTitle();
//		System.out.println(title);
		pageWait();
		
	}
	public void separationdash_page() throws Throwable {
		
		pageWait();
		Actions Ac = new Actions(driver);
		Ac.moveToElement(get_threedot()).perform();
		get_Separationdash().click();
//		String title = driver.getTitle();
//		System.out.println(title);
		pageWait();
}
}






