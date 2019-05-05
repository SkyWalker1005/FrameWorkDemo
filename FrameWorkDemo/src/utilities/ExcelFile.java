package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	public String[][] readExcelFile(String fileName,String sheetName) throws IOException{
		String[][] arrayData=null;
		//Open File
		File newFile=new File(fileName);
		//Read File
		FileInputStream inputStream=new FileInputStream(newFile);
		Workbook workBook=null;
		String fileExtension=fileName.substring(fileName.indexOf("."));
		//Logic for xls or xlsx file
		if(fileExtension.equalsIgnoreCase(".xls")){
			workBook=new HSSFWorkbook(inputStream);
		}
		else if(fileExtension.equalsIgnoreCase(".xlsx")){
			workBook=new XSSFWorkbook(inputStream);
		}
		else{
			System.out.println("Invalid File Format");
			System.exit(0);
		}
		Sheet readSheet=workBook.getSheet(sheetName);
		int totalRows=readSheet.getLastRowNum()+1;
		int totalColumns=readSheet.getRow(0).getLastCellNum();
		arrayData=new String[totalRows][totalColumns];
		int rowNum=readSheet.getLastRowNum()-readSheet.getFirstRowNum();
		for(int i=0;i<rowNum+1;i++){
			Row row=readSheet.getRow(i);
			for(int j=0;j<row.getLastCellNum();j++){
				arrayData[i][j]=row.getCell(j).getStringCellValue();
			}
		}
		
		return arrayData;
		
	}
}
