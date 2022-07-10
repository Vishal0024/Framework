package com.vishal.reports;

import java.awt.Desktop;
import java.io.File;
import java.util.Objects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.vishal.constants.FrameworkConstants;

public class VishalExtentReports {

	private static ExtentReports extent;

	private VishalExtentReports () {

	}

	public static void initExtentReport() throws Exception {
		if(Objects.isNull(extent))
		{
			extent = new ExtentReports();
			ExtentSparkReporter spark = new ExtentSparkReporter(FrameworkConstants.getExtentReportFilePath());
			extent.attachReporter(spark);
			spark.config().setTheme(Theme.STANDARD);
			spark.config().setDocumentTitle("Vishal Report");
		}
	}

	public static void flushReport() throws Exception {
		if(Objects.nonNull(extent))
		{
			extent.flush();
		}
		ExtentManager.unload();
		Desktop.getDesktop().browse(new File(FrameworkConstants.getExtentReportFilePath()).toURI());
	}

	public static void createTest(String testName)
	{
		ExtentManager.setExtentTest(extent.createTest(testName));
	}

}
