package Testcases;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import Base.TestBase;
import Base.DataProviderSource;
import Base.Log;
import Pages.SignInPage;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInTest extends TestBase {
	
	protected WebDriver driver;
	Set<String> windowId;
    Iterator<String> itererator;   
    String mainWinID, newAdwinID;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		Log.info("\n");
		Log.info("-------------------- -------------------- --------------------");
		Log.info("---------------- T24 SYSTEM AUTOMATION TESTING ---------------");
		Log.info("-------------------- -------------------- --------------------");
		Log.info("\n");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void signIn(String user, String pwd) 
	{		
		Log.startTestCase("<SIGN IN>");
		driver.get(SignInPage.t24Link());
		
		clearAndType(SignInPage.txt_UserName(driver),user);
		Log.endTestCase("Input username");
		
		clearAndType(SignInPage.txt_Password(driver),pwd);
		SignInPage.btn_SignIn(driver).click();
		
		Log.endTestCase("<SIGN IN>");
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	public void signIn(WebDriver driver, String user, String pwd) 
	{		
		this.driver = driver;
		driver.get(SignInPage.t24Link());
		
		clearAndType(SignInPage.txt_UserName(driver),user);
		Log.info("Input txt_UserName");
		
		clearAndType(SignInPage.txt_Password(driver),pwd);
		Log.info("Input txt_Password");
		
		SignInPage.btn_SignIn(driver).click();
		Log.info("Click btn_SignIn");
	}
	
	public void navigateToVersion(String version, String title)
	{
		driver.switchTo().frame(0);			
		clearAndType(SignInPage.txt_CommandLine(driver),version);
		Log.info("Input txt_CommandLine");
		SignInPage.btn_CommandImage(driver).click();
		Log.info("Click btn_CommandImage");
		
		switchChildId(title);
	}
	
	public void switchChildId(String title)
	{
		windowId = driver.getWindowHandles();
	    itererator = windowId.iterator();
		mainWinID = itererator.next();
		
		while(!driver.getTitle().equals(title))
		{
			newAdwinID = itererator.next();
			driver.switchTo().window(newAdwinID);
		}
		
		driver.manage().window().maximize();
		Log.info("Switch to "+driver.getTitle());
	}
	
	public void switchMainId()
	{
		driver.close();
		driver.switchTo().window(mainWinID);
		Log.info("Switch to mainWinID");
	}
}
