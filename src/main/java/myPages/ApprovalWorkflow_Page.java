package myPages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ApprovalWorkflow_Page extends BasePage{

	public ApprovalWorkflow_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	Attendanceplan_Page attendpage;
	
	private By ApprovalWorkflow = By.xpath("//*[@id=\"hep_nav_overflow\"]/li[1]/a");
	private By addnewworkflow = By.id("add_new_btn");
	private By workflowname = By.id("workflow_name");
	private By selectworkflowtype = By.xpath("//select[@class='form-control input_he role approver_list primary']");
	private By addbutton1 = By.xpath("//button[@class='btn btn-info batch_add_new_button']");
	private By Selectworkflow2 = By.xpath("(//select[@class='form-control input_he role approver_list primary'])[2]");
	private By Savebtn = By.id("setup_addbtn_100120");
	private By Threedots = By.xpath("//*[@id=\"hep_nav\"]/li[12]/span");
	private By Actionbutton = By.xpath("(//button[@class='btn btn-primary btn-md dropdown-toggle'])[2]");
	
	
	
	public WebElement get_ApprovalWorkflow() {
		return get_Element(ApprovalWorkflow);
}
	public WebElement get_addnewworkflow() {
		return get_Element(addnewworkflow);
	}
	public WebElement get_workflowname() {
		return get_Element(workflowname);
	}
	public WebElement get_selectworkflowtype() {
		return get_Element(selectworkflowtype);
	}
	
	public WebElement get_addbutton1() {
		return get_Element(addbutton1);
	}
	public WebElement get_Selectworkflow2() {
		return get_Element(Selectworkflow2);
	}
	public WebElement get_Savebtn() {
		return get_Element(Savebtn);
	}
	public WebElement get_Threedots() {
		return get_Element(Threedots);
	}
	public WebElement get_Actionbutton() {
		return get_Element(Actionbutton);
	}
	
	public String get_current_date() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-M-yyyy hh:mm:ss");
		LocalDateTime now = LocalDateTime.now();
		return dtf.format(now);
	}
	
	
	public void add_workflow() throws Throwable {
		
		
		try {
			
			pageWait();
			Actions Ac = new Actions(driver);
			Ac.moveToElement(get_Threedots()).perform();
			get_ApprovalWorkflow().click();
			pageWait();
			get_addnewworkflow().click();
			pageWait();
			get_workflowname().click();
			get_workflowname().sendKeys("Automation workflow with RM and FA "+ get_current_date());
			pageWait();
			
			get_selectworkflowtype().click();
			dropdown_select(get_selectworkflowtype(),"Reporting Manager");
			pageWait();
			get_addbutton1().click();
			
			get_Selectworkflow2().click();
			dropdown_select(get_Selectworkflow2(),"L2");
			pageWait();
			get_Savebtn().click();
		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
	}
	
	public void editApprovalWorkflow()  {
		try {
			pageWait();
			get_Actionbutton().click();
			pageWait();
			Robot r = new Robot();
			for (int i = 0; i < 1; i++) {
				r.keyPress(KeyEvent.VK_DOWN);r.keyRelease(KeyEvent.VK_DOWN);
				r.keyPress(KeyEvent.VK_UP);r.keyRelease(KeyEvent.VK_UP);
				r.keyPress(KeyEvent.VK_ENTER);r.keyRelease(KeyEvent.VK_ENTER);
			}
			pageWait();
			get_Selectworkflow2().click();
			dropdown_select(get_Selectworkflow2(), "L3");
			pageWait();
			get_Savebtn().click();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
}
