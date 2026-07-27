package utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExtentReportManager 
{
	private static ExtentReports extent;
	private static ExtentTest test;
	
	public static void initializeReport()
	{
		if (extent == null)
		{
			String reportPath = getReportPath();
			ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
			
			// Configure report details
			sparkReporter.config().setReportName("REST Assured Automation Report");
			sparkReporter.config().setDocumentTitle("Test Execution Report");
			sparkReporter.config().setTheme(com.aventstack.extentreports.reporter.configuration.Theme.DARK);
			
			extent = new ExtentReports();
			extent.attachReporter(sparkReporter);
			extent.setSystemInfo("Tester", "QA Team");
			extent.setSystemInfo("Project", "REST Assured Automation Framework");
			extent.setSystemInfo("Environment", "Testing");
			extent.setSystemInfo("OS", System.getProperty("os.name"));
			extent.setSystemInfo("Java Version", System.getProperty("java.version"));
		}
	}
	
	public static void createTest(String testName)
	{
		test = extent.createTest(testName);
	}
	
	public static void createTest(String testName, String description)
	{
		test = extent.createTest(testName, description);
	}
	
	public static ExtentTest getTest()
	{
		return test;
	}
	
	public static void logPass(String message)
	{
		if (test != null)
		{
			test.pass(message);
		}
	}
	
	public static void logFail(String message)
	{
		if (test != null)
		{
			test.fail(message);
		}
	}
	
	public static void logInfo(String message)
	{
		if (test != null)
		{
			test.info(message);
		}
	}
	
	public static void logWarning(String message)
	{
		if (test != null)
		{
			test.warning(message);
		}
	}
	
	public static void logException(Throwable exception)
	{
		if (test != null)
		{
			test.fail(exception);
		}
	}
	
	public static void flushReport()
	{
		if (extent != null)
		{
			extent.flush();
		}
	}
	
	private static String getReportPath()
	{
		String reportDir = "test-reports";
		File dir = new File(reportDir);
		if (!dir.exists())
		{
			dir.mkdirs();
		}
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
		String timestamp = LocalDateTime.now().format(formatter);
		String reportName = "ExtentReport_" + timestamp + ".html";
		
		return reportDir + File.separator + reportName;
	}
}
