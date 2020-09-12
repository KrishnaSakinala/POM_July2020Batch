package repo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelApiTest {

	public FileInputStream fis = null;
	public FileOutputStream fos = null;
	public XSSFWorkbook workbook = null;
	public XSSFSheet sheet = null;
	public XSSFRow row = null;
	public XSSFCell cell = null;
	public String xlFilePath = null;

	public ExcelApiTest(String xlFilePath) throws Exception {
		this.xlFilePath = xlFilePath;
		fis = new FileInputStream(xlFilePath);
		workbook = new XSSFWorkbook(fis);
		fis.close();
	}

	public String getCellData(String sheetName, int colNum, int rowNum)
	{
		try {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(rowNum);
			cell = row.getCell(colNum);
			
			if(cell.getCellTypeEnum() == CellType.STRING)
			{
				return cell.getStringCellValue();
			}
			else if(cell.getCellTypeEnum() == CellType.NUMERIC || cell.getCellTypeEnum() == CellType.FORMULA)
			{
				return String.valueOf(cell.getNumericCellValue());
			}
			else if(cell.getCellTypeEnum() == CellType.BLANK)
			{
				return "";
			}
			else
			{
				return String.valueOf(cell.getBooleanCellValue());
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
			return "row" + rowNum + " or Column " + colNum + " does not exist in the excel";
		}
	}

	public String getCellData(String sheetName, String colName, int rowNum) {
		return null;
	}

	public int getRowCount(String sheetName) {
		return 0;
	}

	public int getColumnCount(String sheetName) {
		return 0;
	}

	public boolean setCellData(String sheetName, int colNum, int rowNum, String value) {
		return true;
	}

	public boolean setCellData(String sheetName, String colName, int rowNum, String value) {
		return true;
	}

}
