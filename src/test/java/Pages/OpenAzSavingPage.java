package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class OpenAzSavingPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenAzSavingRepo.properties"));
	
	public static String baseVersion()
	{
		inputValue = map.getValue("BASE_VERSION");
		return inputValue;
	}
	
	public static String baseTitle()
	{
		inputValue = map.getValue("BASE_TITLE");
		return inputValue;
	}
	
	public static String fixedVersion()
	{
		inputValue = map.getValue("FIXED_VERSION");
		return inputValue;
	}
	
	public static String fixedTitle()
	{
		inputValue = map.getValue("FIXED_TITLE");
		return inputValue;
	}
	
	public static String mipVersion()
	{
		inputValue = map.getValue("MIP_VERSION");
		return inputValue;
	}
	
	public static String mipTitle()
	{
		inputValue = map.getValue("MIP_TITLE");
		return inputValue;
	}
	
	public static String intergrateBaseVersion()
	{
		inputValue = map.getValue("INTERGRATE_BASE_VERSION");
		return inputValue;
	}
	
	public static String intergrateBaseTitle()
	{
		inputValue = map.getValue("INTERGRATE_BASE_TITLE");
		return inputValue;
	}
	
	public static String intergrateTimeDepositVersion()
	{
		inputValue = map.getValue("INTERGRATE_TIME_DEPOSIT_VERSION");
		return inputValue;
	}
	
	public static String intergrateTimeDepositTitle()
	{
		inputValue = map.getValue("INTERGRATE_TIME_DEPOSIT_TITLE");
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
	
	public static WebElement txtAccount(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_ACCOUNT"));
        return element;
	}
	
	public static WebElement txtCustomerNo(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_CUSTOMER_NO"));
        return element;
	}
	
	public static WebElement txtDepositType(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEPOSIT_TYPE"));
        return element;
	}
	
	public static WebElement txtCurrency(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CURRENCY"));
        return element;
	}
	
	public static WebElement txtDepositProduct(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEPOSIT_PRODUCT"));
        return element;
	}
	
	public static WebElement txtPrincipalAmount(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_PRINCIPAL_AMOUNT"));
        return element;
	}
	
	public static WebElement txtOpenDate(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_OPEN_DATE"));
        return element;
	}
	
	public static WebElement txtMaturityDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_MATURITY_DATE"));
        return element;
	}
	
	public static WebElement txtTerm(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_TERM"));
        return element;
	}
	
	public static WebElement txtDebitAccount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEBIT_ACCOUNT"));
        return element;
	}
	
	public static WebElement txtNominatedAccount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NOMIMATED_ACCOUNT"));
        return element;
	}
	
	public static WebElement txtInterestRate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_INTEREST_RATE"));
        return element;
	}
	
	public static WebElement txtDao(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DAO"));
        return element;
	}
	
	public static WebElement txtMobilePhone(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_MOBILE_PHONE"));
        return element;
	}
	
	public static WebElement tabChgsSchedules(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TAB_CHGS_SCHEDULES"));
        return element;
	}
	
	public static WebElement rbtSchedulesN(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_SCHEDULES_N"));
        return element;
	}
	
	public static WebElement rbtCalculationBasePrincipal(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_CALCULATION_BASE_PRINCIPAL"));
        return element;
	}
	
	public static WebElement rbtNrProgramN(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_NR_PROGRAM_N"));
        return element;
	}
	
	public static WebElement rbtNrProgramY(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_NR_PROGRAM_Y"));
        return element;
	}
	
	public static WebElement ddlNrProgram(WebDriver driver)
    {
        element = driver.findElement(map.getObject("DDL_NR_PROGRAM"));
        return element;
	}
	
	public static WebElement txtNrDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NR_DATE"));
        return element;
	}
	
	public static WebElement txtNrRate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NR_RATE"));
        return element;
	}
	
	public static WebElement txtNrAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NR_AMOUNT"));
        return element;
	}
	
	public static WebElement txtNrAccount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NR_ACCOUNT"));
        return element;
	}
	
	public static WebElement btnEdit(WebDriver driver)
    {
        element = driver.findElement(map.getObject("BTN_EDIT"));
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
