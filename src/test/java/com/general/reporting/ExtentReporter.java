package com.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;

public class ExtentReporter {
	private ExtentReports extent;
	private ExtentHtmlReporter htmlReporter;

	public void cleanExtentReport() {
		extent.flush();
	
	}

	/*public void deleteExtentReport() {
		String workingDir = System.getProperty("user.dir");
		File file = new File(workingDir + File.separator + "reports" + File.separator + "extentreports"
				+ File.separator + customerName + "_ExtentReportResults.html");
		if (file.exists()) {
			file.delete();
		}
	}*/

	public synchronized ExtentReports initReporter() {
		if (extent == null) {
			// Set HTML reporting file location
			extent = new ExtentReports();
			String workingDir = System.getProperty("user.dir");
			htmlReporter = new ExtentHtmlReporter(workingDir + File.separator + "reportsandlogs" + File.separator + "Custom" + "_ExtentReportResults.html");
			extent.attachReporter(htmlReporter);
			htmlReporter.loadConfig(workingDir + "/src/test/java/com/reporting/" + "extent-config.xml");
			htmlReporter.config().setTheme(Theme.DARK);// Default Theme of Report
			htmlReporter.config().setDocumentTitle("Custom Execution Report");
			htmlReporter.config().enableTimeline(true);
			extent.setSystemInfo("Application Name", "Test Application");
		}
		return extent;
	}
}
