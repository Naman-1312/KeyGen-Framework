package Base;

import java.io.File;
import java.lang.reflect.Method;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.utility.Constants;

public class basetest {
	public static WebDriver driver;
	public ExtentSparkReporter sparkReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	@BeforeTest
	public void beforeTestMethod() {
		sparkReporter= new ExtentSparkReporter(System.getProperty("user.dir")+ File.separator + "Reports" + File.separator + "KeyGeneration Report");
		extent = new ExtentReports();
		extent.attachReporter(sparkReporter);
		sparkReporter.config().setTheme(Theme.DARK);
		extent.setSystemInfo("Hostname", "Naman");
		extent.setSystemInfo("Username", "root");
		sparkReporter.config().setDocumentTitle("Automation Report");
		sparkReporter.config().setReportName("KeyGeneration Automation Results");


	}
	@BeforeMethod
	@Parameters("browser")
	public void beforeMethodMethod(String browser, Method testMethod) {
		logger = extent.createTest(testMethod.getName());
		setupDriver(browser);
		driver.manage().window().maximize();
//	driver.get(Constants.url);
		driver.get("http://keygen.yoctel.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	@AfterMethod
	public void afterMethod(ITestResult result) {

		if(result.getStatus()== ITestResult.FAILURE) {
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+ "- Test Case is Failed",ExtentColor.RED));
			logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ "- Test Case is Failed",ExtentColor.RED));
		}
		else if (result.getStatus() == ITestResult.SKIP) {
			logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+ "- Test Case is SKIPPED",ExtentColor.ORANGE));
		}
		else if (result.getStatus() == ITestResult.SUCCESS) {
			logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "- Test Case is Pass",ExtentColor.GREEN));
		}
		driver.quit();
	}


	@AfterTest
	public void afterTest() {
		extent.flush();
	}


	public void setupDriver(String browser) {
		System.setProperty("webdriver.chrome.driver","C:/Users/Naman Goel/eclipse-workspace/KeyGeneration/Drivers/chromedriver.exe");
//		WebDriver driver = new ChromeDriver();

	}
}

