package myPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Timesheet_Page extends BasePage {

	public Timesheet_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	//Xpath for Shift Timesheet screen
	private By TimesheetMenu = By.xpath("//a[text()='Timesheet Setting']");
	private By DownloadTimesheetCheckbox = By.xpath("(//span[@class='checkbox_sp'])[1]");
	private By ApprovalReqflag = By.xpath("(//span[@class='checkbox_sp'])[2]");
	private By UpdateAndSave = By.xpath("//button[@class='save_update_btn btn btn-default primary_v2_btn']");
	private By workflowdropdown = By.id("select2-approval_workflow_id-container");
	
	
	
	
	//Web Elements for the above Xpath
	public WebElement get_TimesheetMenu() {
			return get_Element(TimesheetMenu);
	}
	public WebElement get_DownloadTimesheetCheckbox() {
				return get_Element(DownloadTimesheetCheckbox);
	}
	public WebElement get_ApprovalReqflag() {
					return get_Element(ApprovalReqflag);
	}
	public WebElement get_UpdateAndSave() {
						return get_Element(UpdateAndSave);
	}
	public WebElement get_workflowdropdown() {
							return get_Element(workflowdropdown);
}		
	
	//Methods for Shift Timesheet screen 
	public void timesheet_page() throws Throwable {
		pageWait();
		get_TimesheetMenu().click();
		get_DownloadTimesheetCheckbox().click();
		pageWait();
		get_UpdateAndSave().click();
		pageWait();
		
}}
