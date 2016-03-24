package Testcases;

import Base.TestBase;
import Base.DataProviderSource;
import Base.Log;
import Pages.FundTransferPage;
import Pages.SignInPage;
import Testcases.SignInTest;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FundTransferTest extends TestBase {

	protected WebDriver driver;
	
	@BeforeMethod
	public void setUp()
	{
		DOMConfigurator.configure("log4j.xml");
		Log.info("\n");
		Log.info("-------------------- -------------------- --------------------");
		Log.info("---------------- T24 SYSTEM AUTOMATION TESTING ---------------");
		Log.info("-------------------- -------------------- --------------------\n");
		
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		PageFactory.initElements(driver, this);
	}
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void fundTransfer(String No, String transferType, String debitAccount, String debitCurrency, 
			String debitAmount, String creditAccount, String creditCurrency, String orderBank) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(FundTransferPage.t24Version(),FundTransferPage.versionTitle());
		
		Log.info(driver.getTitle());
		
		FundTransferPage.btnNew(driver).click();
		Log.info("Click btnNew");
		
		String ft = FundTransferPage.txtFt(driver).getAttribute("value");
		
		clearAndType(FundTransferPage.txtTransferType(driver), transferType);
		Log.info("Input txtTransferType");
		
//		clearAndType(FundTransferPage.txtDebitAccount(driver), debitAccount);
		clearAndType(FundTransferPage.txtDebitAccount(driver), debitCurrency+"14033");
		Log.info("Input txtDebitAccount");
		
		clearAndType(FundTransferPage.txtDebitCurrency(driver), debitCurrency);
		Log.info("Input txtDebitCurrency");
		
		clearAndType(FundTransferPage.txtDebitAmount(driver), debitAmount);
		Log.info("Input txtDebitAmount");
		
		clearAndType(FundTransferPage.txtCreditAccount(driver), creditAccount);
		Log.info("Input txtCreditAccount");
		
		clearAndType(FundTransferPage.txtCreditCurrency(driver), creditCurrency);
		Log.info("Input txtCreditCurrency");
		
		clearAndType(FundTransferPage.txtOrderBank(driver), orderBank);
		Log.info("Input txtOrderBank");
		
		FundTransferPage.btnCommit(driver).click();
		Log.info("Click btnCommit");
		
		if(FundTransferPage.lblOverride(driver)!=null)
		{
			FundTransferPage.lblOverride(driver).click();
			Log.info("Click lblOverride");
		}
		else
			Log.info("lblOverride not found");

		Log.info(ft);
		updateResult("fundtransfer", ft, Integer.parseInt(No), 0);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
