package Pages;

import Base.ObjectMap;
import Base.TestBase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FundTransferPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/FundTransferRepo.properties"));
    
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
	
	public static WebElement txtTransferType(WebDriver driver)
    {
		element = driver.findElement(map.getObject("TXT_TRANSFER_TYPE"));
        return element;
	}
	
	public static WebElement txtDebitAccount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEBIT_ACCOUNT"));
        return element;
	}
	
	public static WebElement txtDebitCurrency(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEBIT_CURRENCY"));
        return element;
	}
	
	public static WebElement txtDebitAmount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DEBIT_AMOUNT"));
        return element;
	}
	
	public static WebElement txtCreditAccount(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CREDIT_ACCOUNT"));
        return element;
	}
	
	public static WebElement txtCreditCurrency(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_CREDIT_CURRENCY"));
        return element;
	}
	
	public static WebElement txtOrderBank(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_ORDER_BANK"));
        return element;
	}
	
	public static WebElement btnCommit(WebDriver driver)
    {
        element = driver.findElement(map.getObject("BTN_COMMIT"));
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