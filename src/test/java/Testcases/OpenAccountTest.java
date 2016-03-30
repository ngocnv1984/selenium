package Testcases;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenAccountPage;
import Pages.SignInPage;

public class OpenAccountTest extends TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void openAccount(String No, String customerNo, String depositType, String currency, 
			String bonusType, String custType, String dao) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAccountPage.t24Version(),OpenAccountPage.versionTitle());
		
		OpenAccountPage.btnNew(driver).click();
		String account = OpenAccountPage.txtAccount(driver).getAttribute("value");
		clearAndType(OpenAccountPage.txtCustomerNo(driver), customerNo);
		clearAndType(OpenAccountPage.txtDepositType(driver), depositType);
		clearAndType(OpenAccountPage.txtCurrency(driver), currency);
		
		if(!bonusType.isEmpty())
			selectOption(OpenAccountPage.ddlBonusType(driver), bonusType);
		
		if(!custType.isEmpty())
			selectOption(OpenAccountPage.ddlCustType(driver), custType);
		
		clearAndType(OpenAccountPage.txtDao(driver), dao);
		OpenAccountPage.btnCommit(driver).click();
		
		if(OpenAccountPage.lblOverride(driver)!=null)
			OpenAccountPage.lblOverride(driver).click();

		Log.info(account);
		updateResult("openaccount",account, Integer.parseInt(No), 0);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
