package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class OpenLimitControlPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenLimitControlRepo.properties"));
    
	public static String globalLimitVersion()
	{
		inputValue = map.getValue("GLOBAL_LIMIT_VERSION");
		return inputValue;
	}
	
	public static String globalLimitTitle()
	{
		inputValue = map.getValue("GLOBAL_LIMIT_TITLE");
		return inputValue;
	}
	
	public static String productLimitVersion()
	{
		inputValue = map.getValue("PRODUCT_LIMIT_VERSION");
		return inputValue;
	}
	
	public static String productLimitTitle()
	{
		inputValue = map.getValue("PRODUCT_LIMIT_TITLE");
		return inputValue;
	}
	
	////////////// GET OBJECT /////////////////////	
	public static WebElement btnEdit(WebDriver driver)
    {
		element = driver.findElement(map.getObject("BTN_EDIT"));
        return element;
	}
	
	public static WebElement txtTransactionId(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TRANSACTION_ID"));
        return element;
	}
	
	public static WebElement txtLimitCurrency(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_LIMIT_CURRENCY"));
        return element;
	}
	
	public static WebElement txtCountry(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COUNTRY"));
        return element;
	}
	
	public static WebElement txtApprovedDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_APPROVED_DATE"));
        return element;
	}
	
	public static WebElement txtProposalDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_PROPOSAL_DATE"));
        return element;
	}
	
	public static WebElement txtAvailableDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_AVAILABLE_DATE"));
        return element;
	}
	
	public static WebElement txtOfferedUntil(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_OFFERED_UNTIL"));
        return element;
	}
	
	public static WebElement txtFrequencyReview(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_FREQUENCY_REVIEW"));
        return element;
	}
	
	public static WebElement txtExpiryDate(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_EXPIRY_DATE"));
        return element;
	}
	
	public static WebElement txtLimitAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_AMOUNT"));
        return element;
	}
	
	public static WebElement txtCompany(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COMPANY_GL_LIMIT"));
        return element;
	}
	
	public static WebElement txtInternalAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_INTERNAL_AMOUNT"));
        return element;
	}
	
	public static WebElement txtAdvisedAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_ADVISED_AMOUNT"));
        return element;
	}
	
	public static WebElement rbtAvailableMakerN(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_AVAILABLE_MAKER_N"));
        return element;
	}
	
	public static WebElement rbtAvailableMakerY(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_AVAILABLE_MAKER_Y"));
        return element;
	}
	
	public static WebElement rbtAvailableMakerR(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_AVAILABLE_MAKER_R"));
        return element;
	}
	
	public static WebElement txtNotes(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_NOTES"));
        return element;
	}
	
	public static WebElement rbtFixedAvailableN(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_FIXED_VARIABLE_N"));
        return element;
	}
	
	public static WebElement rbtFixed(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_FIXED_VARIABLE_FIXED"));
        return element;
	}
	
	public static WebElement rbtAvailable(WebDriver driver)
    {
        element = driver.findElement(map.getObject("RBT_FIXED_VARIABLE_VARIABLE"));
        return element;
	}
	
	public static WebElement txtCollateralCode(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COLLATERAL_CODE"));
        return element;
	}
	
	public static WebElement txtMaximumSecured(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_MAXIMUM_SECURED"));
        return element;
	}
	
	public static WebElement txtMaximumUnsecured(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_MAXIMUM_UNSECURED"));
        return element;
	}
	
	public static WebElement txtMaximumTotal(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_MAXIMUM_TOTAL"));
        return element;
	}
	
	public static WebElement btnExpand(WebDriver driver)
    {
        element = driver.findElement(map.getObject("BTN_EXPAND"));
        return element;
	}
	
	public static WebElement txtVpbProduct(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_VPB_PRODUCT"));
        return element;
	}
	
	public static WebElement txtVpbProduct(WebDriver driver, int no)
    {
        element = driver.findElement(map.getObject("TXT_VPB_PRODUCT",no));
        return element;
	}
	
	public static WebElement txtLimitProSecAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_PRO_SEC_AMOUNT"));
        return element;
	}
	
	public static WebElement txtLimitProSecAmount(WebDriver driver, int no)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_PRO_SEC_AMOUNT",no));
        return element;
	}
	
	public static WebElement txtLimitProUnsecAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_PRO_UNSEC_AMOUNT"));
        return element;
	}
	
	public static WebElement txtLimitProUnsecAmount(WebDriver driver, int no)
    {
        element = driver.findElement(map.getObject("TXT_LIMIT_PRO_UNSEC_AMOUNT",no));
        return element;
	}
	
	public static WebElement txtAppraisalPerson(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_APPRAISAL_PERSON"));
        return element;
	}
	
	public static WebElement txtApprovePerson(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_APPROVE_PERSON"));
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