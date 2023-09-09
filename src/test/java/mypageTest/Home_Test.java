package mypageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import myPages.Home_Page;
import myPages.Login_Page;

public class Home_Test extends BaseTest{

	Login_Page loginpage;
	
	@Test(priority = 0)
	public void loginpage_Test() {
		loginpage = page.getInstance(Login_Page.class);
		Login_Page UserLogin = page.getInstance(Login_Page.class).do_Login(get_Property_Data("AdminUserName"),
				get_Property_Data("AdminPassword"));
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Dashboard", get_Page_Title);
		test.log(LogStatus.PASS, "Logged in Successfully");
	}
	
	@Test(priority = 1)
	public void todaystatuspage_Test() throws Throwable{
		page.getInstance(Home_Page.class).todayStatus();;
		test.log(LogStatus.PASS, "Today status screen was working fine");
	}
	
	@Test(priority = 2)
	public void attenddash_Test() throws Throwable{
		page.getInstance(Home_Page.class).AttendDashboard();;
		test.log(LogStatus.PASS, "Attendance dashbaord screen was working fine");
	}
	
	@Test(priority = 3)
	public void separationdash_Test() throws Throwable{
		page.getInstance(Home_Page.class).separationdash_page();;
		test.log(LogStatus.PASS, "Separation dashbaord screen was working fine");
	}
}
