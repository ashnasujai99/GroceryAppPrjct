package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtendReportUtilities {
	public static final ExtentReports extentReports = new ExtentReports();//when,where report stored
//	public synchronized static ExtentReports createExtentReports() {

	public static ExtentReports createExtentReports() {
		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("7RMart  Project");
		extentReports.attachReporter(reporter);
		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", "Ashna");
		return extentReports;
	}
//dependency addedd,
}
