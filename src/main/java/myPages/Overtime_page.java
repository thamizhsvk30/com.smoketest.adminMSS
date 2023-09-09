package myPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Overtime_page extends BasePage {

	public Overtime_page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	private By OvertimeSubmenu = By.xpath("//li[@data-inner_menu_id='301']");
	private By AddOtplan = By.xpath("//a[@class='btn add_action_btn create_new_policy_btn']");
	private By OTplanname = By.id("name");
	private By Approvalflag = By.xpath("(//span[@class='checkbox_sp'])[10]");
	private By Empmappings = By.xpath("(//input[@class='select2-search__field'])[2]");
	private By CreatePublish = By.xpath("(//a[@class='create_publish_btn btn btn-default primary_v2_btn'])[2]");
	private By EditOTplan = By.xpath("(//a[@class='list_action_icons edit_action_icon edit_link'])[1]");
	private By editOTname = By.id("name");
	private By editUpdatebtn = By.xpath("(//a[text()='Update Policy'])[1]");
	
	
	
	
	
	public WebElement get_OvertimeSubmenu() {
		return get_Element(OvertimeSubmenu);
}
	public WebElement get_AddOtplan() {
		return get_Element(AddOtplan);
}
	public WebElement get_OTplanname() {
		return get_Element(OTplanname);
}
	public WebElement get_Approvalflag() {
		return get_Element(Approvalflag);
}
	public WebElement get_Empmappings() {
		return get_Element(Empmappings);
}
	public WebElement get_CreatePublish() {
		return get_Element(CreatePublish);
}
	public WebElement get_EditOTplan() {
		return get_Element(EditOTplan);
}
	public WebElement get_editOTname() {
		return get_Element(editOTname);
}
	public WebElement get_editUpdatebtn() {
		return get_Element(editUpdatebtn);
}
	
	
	public String get_current_date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	
	public void addovertime_plan() throws Throwable {
		get_OvertimeSubmenu().click();
		pageWait();
		get_AddOtplan().click();
		get_OTplanname().sendKeys("Automation OT plan 01 " + get_current_date());
		pageWait();
		get_Approvalflag().click();;
		Robot r = new Robot();
		for (int i = 0; i < 1; i++) {
			r.keyPress(KeyEvent.VK_TAB);r.keyRelease(KeyEvent.VK_TAB);
			r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
		}
		pageWait();
		get_Empmappings().click();
		get_Empmappings().sendKeys("Employee");
		
		for (int i = 0; i < 1; i++) {
			r.keyPress(KeyEvent.VK_DOWN); r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_DOWN); r.keyRelease(KeyEvent.VK_DOWN);
			r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
			}
		
		pageWait();
		get_CreatePublish().click();
	}
	
	public void edit_OTplan() throws Throwable {
		
		get_OvertimeSubmenu().click();
		pageWait();
		get_EditOTplan().click();
		pageWait();
		get_editOTname().clear();
		get_editOTname().sendKeys(" Overtime Automation plan 01 " + get_current_date());
		pageWait();
		get_editUpdatebtn().click();
	}
}
