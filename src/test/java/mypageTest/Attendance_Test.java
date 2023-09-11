package mypageTest;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.relevantcodes.extentreports.LogStatus;
import myPages.ApprovalWorkflow_Page;
import myPages.Attendanceplan_Page;
import myPages.Imoff_Page;
import myPages.Login_Page;
import myPages.Overtime_page;
import myPages.Shiftroaster_page;
import myPages.Timesheet_Page;

public class Attendance_Test extends BaseTest {

	Login_Page loginpage;
	Attendanceplan_Page attendpage;

	@Test(priority = 4)
	public void loginpage_Test() {
		loginpage = page.getInstance(Login_Page.class);
		Login_Page UserLogin = page.getInstance(Login_Page.class).do_Login(get_Property_Data("AdminUserName"),
				get_Property_Data("AdminPassword"));
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Dashboard", get_Page_Title);
		test.log(LogStatus.PASS, "Logged in Successfully");
	}
	
	@Test(priority = 5)
	public void attendancePlan_Test() throws Throwable {
		page.getInstance(Attendanceplan_Page.class).add_Attendanceplan();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("New Attendance Plan", get_Page_Title);
		test.log(LogStatus.PASS, "Add Attendance plan working fine");
	}
	
	@Test(priority = 6)
	public void editAttendceplan_Test() throws Throwable {
		page.getInstance(Attendanceplan_Page.class).edit_Attendanceplan();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Edit Attendance Plan", get_Page_Title);
		test.log(LogStatus.PASS, "Edit Attendance plan working fine");
	}
	
	@Test(priority = 7)
	public void addOverTime_Test() throws Throwable {
		page.getInstance(Overtime_page.class).addovertime_plan();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("New Overtime Policy", get_Page_Title);
		test.log(LogStatus.PASS, "Add Overtime plan working fine");
	}

	@Test(priority = 8)
	public void editOverTime_Test() throws Throwable {
		page.getInstance(Overtime_page.class).edit_OTplan();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Edit Overtime Policy", get_Page_Title);
		test.log(LogStatus.PASS, "Edit Overtime plan working fine");
	}

	@Test(priority = 9)
	public void shiftRoasterNew_Test() throws Throwable {
		page.getInstance(Shiftroaster_page.class).shiftroasterpage();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Shift Roster", get_Page_Title);
		test.log(LogStatus.PASS, "ShiftRoasteringNew screen was Loading fine");
	}

	@Test(priority = 10)
	public void timesheet_Test() throws Throwable {
		page.getInstance(Timesheet_Page.class).timesheet_page();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Timesheet Setting", get_Page_Title);
		test.log(LogStatus.PASS, "Timesheet page was Working as Expected");
	}

	@Test(priority = 11)
	public void imoffPage_Test() throws Throwable {
		page.getInstance(Imoff_Page.class).imoffpage_Test();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("New I'm Off Settings", get_Page_Title);
		test.log(LogStatus.PASS, "I'm off page was Working as Expected");
	}

	@Test(priority = 12)
	public void addApprovalWorkflow_Test() throws Throwable {
		page.getInstance(ApprovalWorkflow_Page.class).add_workflow();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("New Approval Workflow", get_Page_Title);
		test.log(LogStatus.PASS, "Add Approval Workflow process working fine");
	}
	
	@Test(priority=13)
	public void editApprovalWorkflow() throws Throwable {
		page.getInstance(ApprovalWorkflow_Page.class).editApprovalWorkflow();
		String get_Page_Title = loginpage.get_Page_Title();
		Assert.assertEquals("Edit Approval Workflow", get_Page_Title);
		test.log(LogStatus.PASS, "Edit Approval Workflow process working fine");	
	}
}

