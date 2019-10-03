package excel;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.HttpCommandExecutor;

public class ExcelData {
	final static Logger logger = LogManager.getLogger("Excel");

	public String getNetworkData(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_NETWORKDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getLabInfo(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_LABDATA, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getConfigurationSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_CONFIGSETTING, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}

	}

	public String getTestSetting(String sheetName, int row, int column) {
		try {
			ExcelUtils.setExcelFile(Constant.PATH_TEST, sheetName);
			String value = ExcelUtils.getCellData(row, column);
			return value;
		} catch (Exception e) {
			logger.error("" + e);
			return null;
		}
	}
	
	public static String configurationTab(String linktoexcelfile,String sheetName, int row){
		try {
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,0);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public static String configurationAttribute(String linktoexcelfile,String sheetName, int row){try {
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,1);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public static String configurationValue(String linktoexcelfile,String sheetName, int row){try {
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,2);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public static String User_Switch_DN(String linktoexcelfile,String sheetName, int row){try {
		//String ID=ExcelUtils.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheetName,row,3);
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,3);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	
	public static String getTextUser(String linktoexcelfile,String sheetName, int row, int column){try {
		//String ID=ExcelUtils.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheetName,row,3);
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,column);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	public static String getSessionInfo(int column){try {
		String linktoexcelfile = "C:\\AADS\\AADS_Configuration\\SessionInfo.xlsx" ;
		String sheetName = "FirstSheet" ;
		int row = 1;
		//String ID=ExcelUtils.getCellFromFreeExcel("C:\\AADS\\AADS_Configuration\\testData.xlsx", sheetName,row,3);
		String ID=ExcelUtils.getCellFromFreeExcel(linktoexcelfile, sheetName,row,column);
		return ID;
	} catch (Exception e) {
		e.printStackTrace();
		return null;
	}}
	

}
