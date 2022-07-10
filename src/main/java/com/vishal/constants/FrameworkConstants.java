package com.vishal.constants;

import com.vishal.enums.ConfigProperties;
import com.vishal.utils.PropertyUtils;

public final class FrameworkConstants {

	private FrameworkConstants() {

	}

	private static final String PATHTORESOURCES = System.getProperty("user.dir") + "/src/test/resources";
	private static final String CHROMEDRIVERPATH = PATHTORESOURCES + "/executables/chromedriver.exe";
	private static final String GECKODRIVERPATH = PATHTORESOURCES + "/executables/geckodriver.exe";
	private static final String CONFIGFILEPATH = PATHTORESOURCES + "/config/config.properties";
	private static final String JSONCONFIGPATH = PATHTORESOURCES + "/config/config.json";
	private static final String EXCELPATH = PATHTORESOURCES + "/excel/testData.xlsx";
	private static final String RUNMANAGERSHEET = "RUNMANAGER";
	private static final String ITERATIONDATASHEET= "DATA";

	public static String getGeckodriverpath() {
		return GECKODRIVERPATH;
	}

	public static String getRunmanagersheet() {
		return RUNMANAGERSHEET;
	}

	public static String getIterationdatasheet() {
		return ITERATIONDATASHEET;
	}

	public static String getExcelpath() {
		return EXCELPATH;
	}

	private static final String EXTENTREPORTFOLDERPATH = System.getProperty("user.dir")+"/extent-test-output";
	private static String extentReportFilePath = "";

	public static String getExtentReportFilePath() throws Exception {
		if(extentReportFilePath.isEmpty())
		{
			extentReportFilePath = createReportPath();
		}
		return extentReportFilePath;
	}

	private static String createReportPath() throws Exception
	{
		if(PropertyUtils.getValue(ConfigProperties.OVERRIDEREPORTS).equalsIgnoreCase("no"))
		{
			return EXTENTREPORTFOLDERPATH+"/"+System.currentTimeMillis()+"index.html";
		}
		else
		{
			return EXTENTREPORTFOLDERPATH+"/index.html";
		}
	}

	public static String getJsonconfigpath() {
		return JSONCONFIGPATH;
	}

	private static final int EXPLICITWAIT = 10;

	public static int getExplicitwait() {
		return EXPLICITWAIT;
	}

	public static String getConfigFilepath() {
		return CONFIGFILEPATH;
	}

	public static String getChromedriverpath() {
		return CHROMEDRIVERPATH;
	}
}
