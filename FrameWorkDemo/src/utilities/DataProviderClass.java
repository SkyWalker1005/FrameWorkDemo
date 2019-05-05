package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderClass {

	@DataProvider(name="testData")
	public Object[][] readDataFromDataProvider() throws IOException{
		ExcelFile excelFile=new ExcelFile();
		String fileWithPath = System.getProperty("user.dir")+"\\src\\resources\\TestData.xls";
		Object[][] arrayObject=excelFile.readExcelFile(fileWithPath,"Sheet1");
		return arrayObject;
		
	}
}
