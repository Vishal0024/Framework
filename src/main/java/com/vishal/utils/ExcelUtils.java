package com.vishal.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.vishal.constants.FrameworkConstants;

public final class ExcelUtils {
	private ExcelUtils() {
	}

	public static List<Map<String,String>> getTestDetails(String sheetName){
		List<Map<String,String>> list = null;
		FileInputStream fs = null;
		XSSFWorkbook workbook = null;

		try {
			fs = new FileInputStream(FrameworkConstants.getExcelpath());
			workbook = new XSSFWorkbook(fs);
			XSSFSheet sheet = workbook.getSheet(sheetName);

			Map<String,String> map = null;
			list = new ArrayList<>();

			int lastRowNum = sheet.getLastRowNum();
			int lastColNum = sheet.getRow(0).getLastCellNum();

			for(int i=1;i<=lastRowNum;i++)
			{
				map = new HashMap<>();
				for(int j=0;j<lastColNum;j++)
				{
					String key = sheet.getRow(0).getCell(j).getStringCellValue();
					DataFormatter formatter = new DataFormatter();
					String value = formatter.formatCellValue(sheet.getRow(i).getCell(j));
					//String value = sheet.getRow(i).getCell(j).getStringCellValue();
					map.put(key, value);
				}
				list.add(map);
			}
		} 
		catch (FileNotFoundException e1) {
			e1.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			try
			{
				if(Objects.nonNull(fs))
				{
					fs.close();
				}
				if(Objects.nonNull(workbook))
				{
					workbook.close();
				}
			}
			catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
