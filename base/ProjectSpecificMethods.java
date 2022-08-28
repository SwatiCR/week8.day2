package base;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ReadData;

public class ProjectSpecificMethods {

	//public static ChromeDriver driver;
	public String excelFileName = "";
	private static final ThreadLocal<RemoteWebDriver> remoteWebDriver = new ThreadLocal<RemoteWebDriver>();
	public static ExtentReports extent;
	public static ExtentTest test,node;
	public String testName, testDescription, testCategory, testAuthor;

	@BeforeSuite
	public void startReport() {
		// Step1: Set up physical report path
		ExtentHtmlReporter reporter = new ExtentHtmlReporter("./reports/result.html");
		// to keep the report history
		reporter.setAppendExisting(true);
		// Step2: Create object for ExtentReports
		extent = new ExtentReports();
		// Step3: attach the data with physical file
		extent.attachReporter(reporter);
	}
	
	@BeforeClass
	public void testCaseDetails() {
		test = extent.createTest(testName, testDescription);
		test.assignCategory(testCategory);
		test.assignAuthor(testAuthor);
	}
	
	public int takesnap() throws IOException {
		int ranNum = (int) (Math.random()*999999+100000); 
		
		File source = getDriver().getScreenshotAs(OutputType.FILE);
		File target = new File("./snaps/img"+ranNum+".png");
		
		FileUtils.copyFile(source, target);
		
		return ranNum;
	}
	
	public void reportStep(String stepDesc, String status) throws IOException {
		
		int ranNum = takesnap();
		MediaEntityModelProvider img = null;
		
		try {
			img = MediaEntityBuilder.createScreenCaptureFromPath(".././snaps/img"+ranNum+".png").build();
		} catch (IOException e) {
			
		}
		if(status.equalsIgnoreCase("pass")) {
			node.pass(stepDesc,img);
		}else if(status.equalsIgnoreCase("fail")) {
			node.fail(stepDesc,img);
			throw new RuntimeException("Look into report for further details");
		}
	}

	@AfterSuite
	public void stopReport() {
		extent.flush();
	}

	//setter method for driver
	public void setDriver() {
		remoteWebDriver.set(new ChromeDriver());
	}

	//getter method for driver
	public RemoteWebDriver getDriver() {
		return remoteWebDriver.get();
	}



	@DataProvider(name = "fetch" , indices = {0})
	public String[][] fetchData() throws IOException {
		String[][] data = ReadData.readData(excelFileName);
		return data;
	}

	@BeforeMethod
	public void init() {
		node = test.createNode(testName);
		
		WebDriverManager.chromedriver().setup();		
		//driver = new ChromeDriver();
		setDriver();
		getDriver().get("http://leaftaps.com/opentaps");		
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(90));
	}

	@AfterMethod
	public void close() {
		getDriver().close();
	}


}
