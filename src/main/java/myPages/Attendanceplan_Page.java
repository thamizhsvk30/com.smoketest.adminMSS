package myPages;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Attendanceplan_Page extends BasePage {

	public Attendanceplan_Page(WebDriver driver) {
		super(driver);
	}

	private By Orgmenu = By.id("menu_organization");
	private By Attendancemenu = By.xpath("//li[@data-sub_menu_id='27']");
	private By Addplanbtn = By.id("create_new_plan");
	private By Planbackbutton = By.xpath("//a[@class='back_to_link pl-0']");
	private By Editbtn = By.xpath("(//img[@src='/images/common/worq_v1/icon-edit.svg'])[1]");
	private By PlanName = By.id("name_of_the_plan");
	private By Updatebtn = By.xpath("//*[text()='Update Plan'][1]");
	private By Createpublish = By.xpath("//*[text()='Create & Publish'][1]");
	private By Attendanceplanname = By.id("name_of_the_plan");
	private By Templatedropdown = By.id("choose_template");
	private By Createpublishbtn = By.xpath("//a[@class='create_publish_btn btn btn-default ml-2 primary_v2_btn pointer_event_none']");
	private By Successmsg= By.xpath("//label[text()=' Attendance plan mapped to 42 Users ']");




	public WebElement get_Orgmenu() {
		return get_Element(Orgmenu);
}
	public WebElement get_Attendancemenu() {
		return get_Element(Attendancemenu);
}
	public WebElement get_Addplanbtn() {
		return get_Element(Addplanbtn);
}
	public WebElement get_Editbtn() {
		return get_Element(Editbtn);
}
	public WebElement get_Planbackbutton() {
		return get_Element(Planbackbutton);
}
	public WebElement get_PlanName() {
		return get_Element(PlanName);
}
	public WebElement get_Updatebtn() {
		return get_Element(Updatebtn);
}
	public WebElement get_Createpublish() {
		return get_Element(Createpublish);
}
	public WebElement get_Attendanceplanname() {
		return get_Element(Attendanceplanname);
}
	public WebElement get_Templatedropdown() {
		return get_Element(Templatedropdown);
}
	public WebElement get_Createpublishbtn() {
		return get_Element(Createpublishbtn);
}
	public WebElement get_Successmsg() {
		return get_Element(Successmsg);
}

	public String get_current_date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}

	public void add_Attendanceplan() throws Throwable {
		get_Orgmenu().click();
		pageWait();
		get_Attendancemenu().click();
		get_Addplanbtn().click();
		get_Templatedropdown().click();
		pageWait();
		dropdown_select(get_Templatedropdown(),"Testing Attendance plan");
		pageWait();
		get_Attendanceplanname().clear();
		pageWait();
		get_Attendanceplanname().sendKeys("Automation Testing plan 00" + get_current_date());
		get_Createpublishbtn().click();
	}


	public void edit_Attendanceplan() throws Throwable {
		get_Editbtn().click();
		pageWait();
		get_PlanName().clear();
		pageWait();
		get_PlanName().sendKeys("Thamizh Test Plan 02"+ get_current_date());
		pageWait();
		get_Updatebtn().click();
	}



}