package mypageTest;

import java.io.File;
import java.io.FileInputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import listeners.MyListeners;
import myPages.BasePage;
import myPages.Page;


public class BaseTest extends MyListeners{
	
	public Page page;
	
	@BeforeClass
	@Parameters(value = { "browser" })
	public void setup(String browser) {
		
		
		if (browser.equalsIgnoreCase("chrome")) {
			//DesiredCapabilities capabilities = DesiredCapabilities.chrome();
			//ChromeOptions options = new ChromeOptions();
			//options.addArguments("--headless");
			//capabilities.setCapability(ChromeOptions.CAPABILITY, options);
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver","C:\\Users\\User\\eclipse-workspace\\Com.AdminMSS\\src\\test\\java\\property\\chromedriver.exe");	
			driver = new ChromeDriver();
		}
			
		else if (browser.equalsIgnoreCase("ff")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} 
		
		else {
			System.out.println("No browser define in the xml");
		}
		
		driver.manage().window().maximize();
		driver.get(get_Property_Data("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		page = new BasePage(driver);
	
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}

	public String get_Property_Data(String obj) {
		FileInputStream propfile;
		Properties prop;
		String value = "";
		try {
			prop = new Properties();
			propfile = new FileInputStream(".\\src\\test\\java\\property\\data.properties");
			prop.load(propfile);
			value = prop.getProperty(obj);
			return value;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public String get_Excel_Data(int rowNum, int colNum) {
		FileInputStream excelFile;
		String excelValue = null;
		try {
			excelFile = new FileInputStream(".\\src\\test\\java\\com\\property\\Report_Urls.xlsx");
			XSSFWorkbook workBook = new XSSFWorkbook(excelFile);
			XSSFSheet sheet = workBook.getSheet("Sheet1");
			excelValue = sheet.getRow(rowNum).getCell(colNum).toString();
			return excelValue;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return excelValue;

	}

	
	}


