package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class OpenAccountPage extends TestBase
{
	private static WebElement element = null;
	private static String inputValue = null;
	static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/OpenAccountRepo.properties"));
    
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
	
	public static WebElement ddlBonusType(WebDriver driver)
    {
        element = driver.findElement(map.getObject("DDL_BONUS_TYPE"));
        return element;
	}
	
	public static WebElement ddlCustType(WebDriver driver)
    {
        element = driver.findElement(map.getObject("DDL_CUST_TYPE"));
        return element;
	}
	
	public static WebElement txtDao(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_DAO"));
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
