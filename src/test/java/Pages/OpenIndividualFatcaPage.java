package Pages;

import Base.ObjectMap;
import Base.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenIndividualFatcaPage extends TestBase{
	
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenIndividualFatcaRepo.properties"));
	
	public static String t24Version()
	{
		inputValue = map.getValue("T24_VERSION");
		return inputValue;
	}
	
	public static String versionTitle()
	{
		inputValue = map.getValue("VERSION_TITLE");
		return inputValue;
	}
	
	public static String dataFile()
	{
		inputValue = map.getValue("DATA_FILE");
		return inputValue;
	}
	
	////////////// GET OBJECT /////////////////////		
	public static WebElement txtTransactionId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TRANSACTION_ID"));
        return element;
	}
	
	public static WebElement btnEdit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_EDIT"));
        return element;
	}
	
	public static WebElement txtCif(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CIF"));
        return element;
	}
	
	public static WebElement ddlFatcaStatus(WebDriver driver)
    {
		element = driver.findElement(map.getObject("DDL_FATCA_STATUS"));
        return element;
	}

	public static WebElement txtCitizenship(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CITIZENSHIP"));
        return element;
	}
	
	public static WebElement txtBirthPlace(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_BIRTH_PLACE"));
        return element;
	}
	
	public static WebElement rbtGreenCardNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GREEN_CARD_NO"));
        return element;
	}
	
	public static WebElement rbtGreenCardNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GREEN_CARD_NO_INFO"));
        return element;
	}
	
	public static WebElement rbtGreenCardYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GREEN_CARD_YES"));
        return element;
	}

	public static WebElement rbtResidentNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_RESIDENT_NO"));
        return element;
	}

	public static WebElement rbtResidentNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_RESIDENT_NO_INFO"));
        return element;
	}

	public static WebElement rbtResidentYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_RESIDENT_YES"));
        return element;
	}

	public static WebElement rbtTransferReceiveNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_TRANSFER_RECEIVE_NO"));
        return element;
	}

	public static WebElement rbtTransferReceiveNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_TRANSFER_RECEIVE_NO_INFO"));
        return element;
	}

	public static WebElement rbtTransferReceiveYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_TRANSFER_RECEIVE_YES"));
        return element;
	}

	public static WebElement rbtUsAddressNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_US_ADDRESS_NO"));
        return element;
	}

	public static WebElement rbtUsAddressNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_US_ADDRESS_NO_INFO"));
        return element;
	}

	public static WebElement rbtUsAddressYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_US_ADDRESS_YES"));
        return element;
	}

	public static WebElement rbtAttorneyNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_NO"));
        return element;
	}

	public static WebElement rbtAttorneyNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_NO_INFO"));
        return element;
	}

	public static WebElement rbtAttorneyYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_YES"));
        return element;
	}

	public static WebElement rbtAttorneyUsNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_US_NO"));
        return element;
	}

	public static WebElement rbtAttorneyUsNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_US_NO_INFO"));
        return element;
	}

	public static WebElement rbtAttorneyUsYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_ATTORNEY_US_YES"));
        return element;
	}

	public static WebElement rbtSentViaNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_SENT_VIA_NO"));
        return element;
	}

	public static WebElement rbtSentViaNoInfo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_SENT_VIA_NO_INFO"));
        return element;
	}

	public static WebElement rbtSentViaYes(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_SENT_VIA_YES"));
        return element;
	}

	public static WebElement txtTin(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TIN"));
        return element;
	}

	public static WebElement txtDocument(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_DOCUMENT"));
        return element;
	}

	public static WebElement txtIssueDate(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ISSUE_DATE"));
        return element;
	}

	public static WebElement txtExpireDate(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_EXPIRE_DATE"));
        return element;
	}

	public static WebElement btnCommit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_COMMIT"));
        return element;
	}
	
	public static WebElement btnPerform(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_PERFORM"));
        return element;
	}
	
	public static WebElement btnAuthorise(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_AUTHORISE"));
        return element;
	}
}
