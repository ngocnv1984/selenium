package Base;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

public class DataProviderSource extends TestBase {

	@DataProvider(name="DataSource") 
	public static String[][] getData(Method method) {
		
		String[][] testData = null;
		String testName = method.getName().toLowerCase();
		
		switch(testName)
		{
		case "signin":
			testData = ReadExcel.readExcelData("datasource.xls","signin");
			break;
		case "fundtransfer":
			testData = ReadExcel.readExcelData("datasource.xls","fundtransfer");
			break;
		case "openindividualcustomer":
			testData = ReadExcel.readExcelData("datasource.xls","individualcus");
			break;
		case "openindividualfatca":
			testData = ReadExcel.readExcelData("datasource.xls","individualfatca");
			break;
		case "openaccount":
			testData = ReadExcel.readExcelData("datasource.xls","openaccount");
			break;
		case "opensavingaccount":
			testData = ReadExcel.readExcelData("datasource.xls","savingaccount");
			break;
		case "openlimitcontrol":
			testData = ReadExcel.readExcelData("datasource.xls","limitcontrol");
			break;
		default:
			break;
		}
		return testData;
	}
}