package excel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static XSSFSheet ExcelWSheet;
	private static XSSFWorkbook ExcelWBook;
	private static XSSFCell Cell;
	private static XSSFRow Row;
	private static MissingCellPolicy xRow;

	// This method is to set the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method

	public static void setExcelFile(String Path, String SheetName)
			throws Exception {
		try {
			FileInputStream ExcelFile = new FileInputStream(Path);
			// Access the required test data sheet
			ExcelWBook = new XSSFWorkbook(ExcelFile);
			ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {

			throw (e);

		}

	}
	
	// This method is to write the File path and to open the Excel file, Pass
	// Excel Path and Sheetname as Arguments to this method
	public static void writeExcelFile(String Path)
			throws Exception {
		try {
			FileOutputStream ExcelFile = new FileOutputStream(Path);
			// Access the required test data sheet
			ExcelWBook.write(ExcelFile);
			//ExcelWSheet = ExcelWBook.getSheet(SheetName);
		} catch (Exception e) {

			throw (e);

		}

	}
	
	public static void writeCellData(String Path, String valueURL, String sessID, String executor)
			throws Exception {
		try {

			    XSSFWorkbook workbook = new XSSFWorkbook();
			    XSSFSheet sheet = workbook.createSheet("FirstSheet");  


			    XSSFRow row = sheet.createRow((short)1);
			    row.createCell(0).setCellValue(valueURL);
			    row.createCell(1).setCellValue(sessID);
			    row.createCell(2).setCellValue(executor);

			    FileOutputStream fileOut = new FileOutputStream(Path);
			    workbook.write(fileOut);
			    fileOut.close();
			    System.out.println("Your excel file has been generated!");
		} catch (Exception e) {

			throw (e);

		}

	}
  
	// This method is to read the test data from the Excel cell, in this we are
	// passing parameters as Row num and Col num
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			Cell = ExcelWSheet.getRow(RowNum).getCell(ColNum);
			String CellData = Cell.getStringCellValue();
			return CellData;
		} catch (Exception e) {

			return "";

		}

	}

	// This method is to write in the Excel cell, Row num and Col num are the
	// parameters

	public static void setCellData(String Result, int RowNum, int ColNum)
			throws Exception {
		try {
			Row = ExcelWSheet.getRow(RowNum);
			Cell = Row.getCell(ColNum,
					xRow.RETURN_BLANK_AS_NULL);
			if (Cell == null) {
				Cell = Row.createCell(ColNum);
				Cell.setCellValue(Result);
			} else {
				Cell.setCellValue(Result);
			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(
					Constant.PATH_NETWORKDATA);
			ExcelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			throw (e);

		}

	}
	
	public static String getCellFromFreeExcel(String linktoexcelfile,String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(linktoexcelfile, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	


}
