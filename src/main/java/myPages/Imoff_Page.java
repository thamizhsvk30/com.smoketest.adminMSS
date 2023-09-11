package myPages;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Imoff_Page extends BasePage {

	public Imoff_Page(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	//Xpath for Imoff_Page screen
		private By Imoffmenu = By.xpath("//a[text()='Im Off Settings']");
		private By CreateNewplan = By.id("create_new_plan");
		private By ChooseAttendplan = By.xpath("//span[@class='select2-selection select2-selection--multiple']");
		private By Imoffpolicyname = By.xpath("//input[@placeholder='Enter Name']");
		private By shortcode = By.xpath("//input[@placeholder='Enter Short code']");
		private By Regularisecheckbox = By.xpath("(//span[@class='checkmark top_4 mar_t6'])[7]");
		private By Save = By.xpath("//a[text()='Save']");
		private By Selectvalue = By.xpath("//li[text()='Employee Attendance plan']");
		
		
		
		// Web Elements for the above Xpath
		public WebElement get_Imoffmenu() {
			return get_Element(Imoffmenu);
	}
		public WebElement get_CreateNewplan() {
			return get_Element(CreateNewplan);
	}
		public WebElement get_ChooseAttendplan() {
			return get_Element(ChooseAttendplan);
	}
		public WebElement get_Imoffpolicyname() {
			return get_Element(Imoffpolicyname);
	}
		public WebElement get_shortcode() {
			return get_Element(shortcode);
	}
		public WebElement get_Regularisecheckbox() {
			return get_Element(Regularisecheckbox);
	}
		public WebElement get_Save() {
			return get_Element(Save);
	}
		public WebElement get_Selectvalue() {
			return get_Element(Selectvalue);
	}
		
		
		
		public String get_current_date() {
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ss");
			LocalDateTime now = LocalDateTime.now();
			return dtf.format(now);
		}
		
		public void dropdown_select(WebElement element,String text) {
			Select dropdown = new Select(element);
			dropdown.selectByVisibleText(text);
		}
		
		
		
		// Methods for Imoff_Page screen
		public void imoffpage_Test() throws Throwable {
			
			try {
			pageWait();
			get_Imoffmenu().click();
			get_CreateNewplan().click();
			pageWait();
			get_ChooseAttendplan().sendKeys("Employee Attendance plan");
			pageWait();
			Robot r = new Robot();
			for (int i = 0; i < 1; i++) {
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyRelease(KeyEvent.VK_ENTER);
			}
			get_Imoffpolicyname().sendKeys("Automation Testing plan 00" + get_current_date());
			pageWait();
			get_shortcode().sendKeys("EJ");
			get_Regularisecheckbox().click();
			pageWait();
			get_Save().click();
			pageWait();
			
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage());
			}

			
		}
		
		
		
		
		
		
		
}

