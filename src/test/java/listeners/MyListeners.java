package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import myPages.EmailSender;

public class MyListeners implements ITestListener {
		
		public static WebDriver driver;
		protected static ExtentReports reports;
		public static ExtentTest test;
		
		
		public void onTestStart(ITestResult result) {
			System.out.println("on test start");
			test = reports.startTest(result.getMethod().getMethodName());
			test.log(LogStatus.INFO, result.getMethod().getMethodName() + " test is started");
		}

		public void onTestSuccess(ITestResult result) {
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
		    }
			
			System.out.println("on test success");
			test.log(LogStatus.PASS, result.getMethod().getMethodName() + " test is passed");
			
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File(
						System.getProperty("user.dir") + "/Screenshots/" + result.getMethod().getMethodName() + ".png"));
				String file = test.addScreenCapture(
						System.getProperty("user.dir") + "/Screenshots/" + result.getMethod().getMethodName() + ".png");
				test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed", file);
				//test.log(LogStatus.PASS, result.getMethod().getMethodName() + "test is passed", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}

		public void onTestFailure(ITestResult result) {
			System.out.println("on test failure");
			test.log(LogStatus.FAIL, result.getMethod().getMethodName() + " test is failed");

			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			try {
				FileUtils.copyFile(src, new File(
						System.getProperty("user.dir") + "/Screenshots/" + result.getMethod().getMethodName() + ".png"));
				String file = test.addScreenCapture(
						System.getProperty("user.dir") + "/Screenshots/" + result.getMethod().getMethodName() + ".png");
				test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed", file);
				test.log(LogStatus.FAIL, result.getMethod().getMethodName() + "test is failed",
						result.getThrowable().getMessage());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		public void onTestSkipped(ITestResult result) {
			System.out.println("on test skipped");
			test.log(LogStatus.SKIP, result.getMethod().getMethodName() + " test is skipped");
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			System.out.println("on test sucess within percentage");
		}

		public void onStart(ITestContext context) {
			System.out.println("on start");
			reports = new ExtentReports(System.getProperty("user.dir") + "/Extent_Reports/"
					+ new SimpleDateFormat("yyyy-MM-dd hh-mm-ss-ms").format(new Date()) + "reports.html");
		}

		public void onFinish(ITestContext context) {
			System.out.println("on finish");
			reports.endTest(test);
			reports.flush();  
			
			String recipient = "thamizhselvan.v@heptagon.in"; // Replace with the recipient's email
	        String subject = "Test Automation Results";
	        String body = "The test suite has finished running. Here is the report...";

	        EmailSender.sendEmail(recipient, subject, body);
	    }
			
		}
	
