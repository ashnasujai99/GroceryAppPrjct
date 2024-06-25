package testscript;

//import pages.LoginClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constants;
import utilities.ScreenShotCaptureUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

//import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;

public class BaseClass {
	WebDriver driver;
	public ScreenShotCaptureUtility scrshot;
	public Properties properties;
	public FileInputStream files;

	@BeforeMethod(alwaysRun = true)
	@Parameters("browser")

	public void initializeBrowser(String browser) throws Exception {
		try {
			properties = new Properties();
			files = new FileInputStream(Constants.CONFIG_FILE);
			properties.load(files);
		} catch (FileNotFoundException exception) {
			exception.printStackTrace();
		}
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();

		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else {
			throw new Exception("browser is not correct");
		}
		driver.get(properties.getProperty("url"));
		driver.manage().window().maximize();
	}

	@AfterMethod
	public void browserQuit(ITestResult itestresult) throws IOException {
		if (itestresult.getStatus() == ITestResult.FAILURE) {
			scrshot = new ScreenShotCaptureUtility();
			scrshot.captureFailureScreenShot(driver, itestresult.getName());// method in screenshot utility
	  driver.close();
		}
	}
}
