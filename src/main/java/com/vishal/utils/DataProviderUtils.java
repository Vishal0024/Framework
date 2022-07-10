package com.vishal.utils;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

import com.vishal.constants.FrameworkConstants;

public final class DataProviderUtils {

	private DataProviderUtils()
	{}

	private static List<Map<String, String>> list = new ArrayList<>();

	@DataProvider
	public static Object[] getData(Method m)
	{
		String testName = m.getName();
		if(list.isEmpty())
		{
			list = ExcelUtils.getTestDetails(FrameworkConstants.getIterationdatasheet());
		}

		List<Map<String, String>> iterationList = new ArrayList<>();
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("testName").equalsIgnoreCase(testName) &&
					list.get(i).get("execute").equalsIgnoreCase("yes"))
			{
				iterationList.add(list.get(i));
			}
		}
		return iterationList.toArray();
	}
}
