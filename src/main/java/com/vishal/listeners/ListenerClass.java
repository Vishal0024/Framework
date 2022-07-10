package com.vishal.listeners;

import java.util.Arrays;

import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.vishal.reports.ExtentLogger;
import com.vishal.reports.VishalExtentReports;

public class ListenerClass implements ITestListener, ISuiteListener{

	@Override
	public void onStart(ISuite suite) {
		try {
			VishalExtentReports.initExtentReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onFinish(ISuite suite) {
		try {
			VishalExtentReports.flushReport();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestStart(ITestResult result) {
		VishalExtentReports.createTest(result.getMethod().getDescription());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ExtentLogger.pass(result.getMethod().getMethodName() + " is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		try {
			ExtentLogger.fail(result.getMethod().getMethodName() + " is failed",true);
			ExtentLogger.fail(result.getThrowable().toString());
			ExtentLogger.fail(Arrays.toString(result.getThrowable().getStackTrace()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ExtentLogger.skip(result.getMethod().getMethodName() + " is skipped");
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

//	@Override
//	public void onTestFailedWithTimeout(ITestResult result) {
//	}

	@Override
	public void onStart(ITestContext context) {
	}

	@Override
	public void onFinish(ITestContext context) {
	}
}
