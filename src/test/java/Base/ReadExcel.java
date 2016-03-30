package Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

public class ReadExcel {

	@SuppressWarnings("resource")
	public static String[][] readExcelData(String filePath, String sheetName) 
	{
		String[][] testData = null;
	 
		try 
		{
			HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(filePath));
			HSSFSheet sheet = workbook.getSheet(sheetName);
			
			int startRow = 1;
			int endRow = sheet.getLastRowNum();
			int startCol = 0;
			int endCol = sheet.getRow(0).getLastCellNum();
 
			testData = new String[endRow - startRow + 1][endCol - startCol];
 
			for (int i = startRow; i < endRow + 1; i++) {
				for (int j = startCol; j < endCol; j++) {
					if(sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_STRING)
						testData[i - startRow][j - startCol] = sheet.getRow(i).getCell(j).getStringCellValue();
					else if(sheet.getRow(i).getCell(j).getCellType() == Cell.CELL_TYPE_NUMERIC)
					{
						sheet.getRow(i).getCell(j).setCellType(Cell.CELL_TYPE_STRING);
						testData[i - startRow][j - startCol] = sheet.getRow(i).getCell(j).getStringCellValue();
					}
				}
			}
		} 
		catch (FileNotFoundException e)
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		} 
		catch (IOException e) 
		{
			System.out.println("Could not read the Excel sheet");
			e.printStackTrace();
		}
	 
		return testData;
	}
}
