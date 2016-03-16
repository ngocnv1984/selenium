package Pages;

import Base.ObjectMap;
import Base.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenIndividualCustomerPage extends TestBase {

	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenIndividualCustomerRepo.properties"));
    
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
	
	////////////// GET OBJECT /////////////////////	
	public static WebElement btnNew(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_NEW"));
        return element;
	}
	
	public static WebElement txtTransactionId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TRANSACTION_ID"));
        return element;
	}
	
	public static WebElement txtCif(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CIF"));
        return element;
	}
	
	public static WebElement btnTabOther(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_TAB_OTHER"));
        return element;
	}
	
	public static WebElement txtCustomerMnemonic(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CUSTOMER_MNEMONIC"));
        return element;
	}
	
	public static WebElement txtShortName(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_SHORT_NAME"));
        return element;
	}
	
	public static WebElement txtFullName(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_FULL_NAME"));
        return element;
	}
	
	public static WebElement txtSector(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_SECTOR"));
        return element;
	}
	
	public static WebElement txtVpbIndustry(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_VPB_INDUSTRY"));
        return element;
	}
	
	public static WebElement txtTarget(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TARGET"));
        return element;
	}
	
	public static WebElement txtDocumentType(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_DOCUMENT_TYPE"));
        return element;
	}
	
	public static WebElement txtDocumentNum(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_DOCUMENT_NUM"));
        return element;
	}
	
	public static WebElement txtIssuePlace(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ISSUE_PLACE"));
        return element;
	}
	
	public static WebElement txtIssueDate(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ISSUE_DATE"));
        return element;
	}
	
	public static WebElement txtLegalId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_LEGAL_ID"));
        return element;
	}
	
	public static WebElement txtNationality(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_NATIONALITY"));
        return element;
	}
	
	public static WebElement txtResidence(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_RESIDENCE"));
        return element;
	}
	
	public static WebElement txtCustomerStatus(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CUSTOMER_STATUS"));
        return element;
	}
	
	public static WebElement txtCompanyBook(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_COMPANY_BOOK"));
        return element;
	}
	
	public static WebElement txtBirthDate(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_BIRTH_DATE"));
        return element;
	}
	
	public static WebElement txtLanguage(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_LANGUAGE"));
        return element;
	}
	
	public static WebElement txtStreet(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_STREET"));
        return element;
	}
	
	public static WebElement txtTown(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TOWN"));
        return element;
	}
	
	public static WebElement txtProvince(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_PROVINCE"));
        return element;
	}
	
	public static WebElement txtAddStreet(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ADD_STREET"));
        return element;
	}
	
	public static WebElement txtAddProvince(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ADD_PROVINCE"));
        return element;
	}
	
	public static WebElement txtDao(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_DAO"));
        return element;
	}
	
	public static WebElement txtDaoPb(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_DAOPB"));
        return element;
	}

	public static WebElement rbtPCB(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_PCB"));
        return element;
	}
	
	public static WebElement rbtGenderMale(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GENDER_M"));
        return element;
	}
	
	public static WebElement rbtGenderFemale(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GENDER_F"));
        return element;
	}
	
	public static WebElement rbtGenderOther(WebDriver driver)
    {
		element = driver.findElement(map.getObject("RBT_GENDER_O"));
        return element;
	}
	
	public static WebElement ddlContactType(WebDriver driver)
    {
		element = driver.findElement(map.getObject("DDL_CONTACT_TYPE"));
        return element;
	}
	
	public static WebElement txtContactNumber(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CONTACT_NUMBER"));
        return element;
	}
	
	public static WebElement txtEmailAddress(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_EMAIL_ADDRESS"));
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
	
	public static WebElement lblOverride(WebDriver driver)
    {
		if(isElementPresent(driver,map.getObject("LBL_OVERRIDE")))
			element = driver.findElement(map.getObject("LBL_OVERRIDE"));
		else
			element = null;
        return element;
	}
	
	public static WebElement lblResult(WebDriver driver)
    {
		element = driver.findElement(map.getObject("LBL_RESULT"));
        return element;
	}
}
