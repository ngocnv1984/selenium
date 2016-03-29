package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class OpenCardPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenCardRepo.properties"));
    
	public static String cardPrincipalVersion()
	{
		inputValue = map.getValue("CARD_PRINCIPAL_VERSION");
		return inputValue;
	}

	public static String cardPrincipalTitle()
	{
		inputValue = map.getValue("CARD_PRINCIPAL_TITLE");
		return inputValue;
	}
	
	public static String cardSubVersion()
	{
		inputValue = map.getValue("CARD_SUB_VERSION");
		return inputValue;
	}

	public static String cardSubTitle()
	{
		inputValue = map.getValue("CARD_SUB_TITLE");
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
	
	public static WebElement txtAl(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_AL"));
        return element;
	}
	
	public static WebElement txtPrincipalCardNumber(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_PRINCIPAL_CARD_NUMBER"));
        return element;
	}
	
	public static WebElement txtAtmAccountDefault(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_ATM_ACCOUNT_DEFAULT"));
        return element;
	}
	
	public static WebElement txtCustomerDefault(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CUSTOMER_DEFAULT"));
        return element;
	}
	
	public static WebElement rbtCreditTypeSec(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_CREDIT_TYPE_SEC"));
        return element;
	}
	
	public static WebElement rbtCreditTypeUnsec(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_CREDIT_TYPE_UNSEC"));
        return element;
	}
	
	public static WebElement rbtTopupN(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_TOPUP_N"));
        return element;
	}
	
	public static WebElement rbtTopupY(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_TOPUP_Y"));
        return element;
	}
	
	public static WebElement txtCollateralId(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COLLATERAL_ID"));
        return element;
	}
	
	public static WebElement txtLimitRef(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_REF"));
        return element;
	}
	
	public static WebElement txtLimitFromDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_FROM_DATE"));
        return element;
	}
	
	public static WebElement txtLimitToDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_TO_DATE"));
        return element;
	}
	
	public static WebElement txtSmeLimit(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_SME_LIMIT"));
        return element;
	}
	
	public static WebElement txtSmeInterestRate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_SME_INTEREST_RATE"));
        return element;
	}
	
	public static WebElement txtCustomer(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CUSTOMER"));
        return element;
	}
	
	public static WebElement txtCreditCardLimit(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CREDIT_CARD_LIMIT"));
        return element;
	}
	
	public static WebElement txtEmail(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_EMAIL"));
        return element;
	}
	
	public static WebElement txtEmbrossingName(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_EMBROSSING_NAME"));
        return element;
	}
	
	public static WebElement txtCompanyName(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COMPANY_NAME"));
        return element;
	}
	
	public static WebElement ddlCardClassification(WebDriver driver)
    {
        element = driver.findElement(map.getObject("DDL_CARD_CLASSIFICATION"));
        return element;
	}
	
	public static WebElement txtSecurityQuestion(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_SECURITY_QUESTION"));
        return element;
	}
	
	public static WebElement txtCardType(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CARD_TYPE"));
        return element;
	}
	
	public static WebElement rbtPaymentMethodFull(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_PAYMENT_METHOD_FULL"));
        return element;
	}
	
	public static WebElement rbtPaymentMethodMin(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_PAYMENT_METHOD_MIN"));
        return element;
	}
	
	public static WebElement txtBranch(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_BRANCH"));
        return element;
	}
	
	public static WebElement txtCustomerAddress(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CUSTOMER_ADDRESS"));
        return element;
	}
	
	public static WebElement txtIntroducer(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_INTRODUCER"));
        return element;
	}
	
	public static WebElement txtDao(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DAO"));
        return element;
	}
	
	public static WebElement ddlChannel(WebDriver driver)
    {
        element = driver.findElement(map.getObject("DDL_CHANNEL"));
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
