package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Base.ObjectMap;
import Base.TestBase;

public class SignInPage extends TestBase{
	
	private static WebElement element = null;
	private static String inputValue = null;
	private static ObjectMap map =  new ObjectMap(pathFile("/src/test/resources/T24Repo/SignInRepo.properties"));
	
	public static String inputUser()
	{
		inputValue = map.getValue("INPUT_USER");
		return inputValue;
	}
	
	public static String inputPassword()
	{
		inputValue = map.getValue("INPUT_PASSWORD");
		return inputValue;
	}
	
	public static String authoriseUser()
	{
		inputValue = map.getValue("AUTH_USER");
		return inputValue;
	}
	
	public static String authorisePassword()
	{
		inputValue = map.getValue("AUTH_PASSWORD");
		return inputValue;
	}
	
	public static String t24Link()
	{
		inputValue = map.getValue("T24_LINK");
		return inputValue;
	}
	
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
	
	///////////////// GET OBJECT /////////////////////
    public static WebElement txt_UserName(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_SIGN_ON_NAME"));
        return element;
	}

    public static WebElement txt_Password(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_PASSWORD"));
        return element;
	}

    public static WebElement btn_SignIn(WebDriver driver)
    {
        element = driver.findElement(map.getObject("BTN_SIGN_IN"));
        return element;
    }
    
    public static WebElement txt_CommandLine(WebDriver driver)
    {
        element = driver.findElement(map.getObject("TXT_COMMAND_LINE"));
        return element;
    }
    
    public static WebElement btn_CommandImage(WebDriver driver)
    {
        element = driver.findElement(map.getObject("BTN_COMMAND_LINE"));
        return element;
    }
}
