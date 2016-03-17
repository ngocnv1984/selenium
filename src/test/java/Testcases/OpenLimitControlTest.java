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
import Pages.FundTransferPage;
import Pages.OpenIndividualCustomerPage;
import Pages.OpenLimitControlPage;
import Pages.SignInPage;

public class OpenLimitControlTest extends TestBase {

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
	public void OpenLimitControl(String No, String cif, String globalLimit, String limitCurrency, String country, 
			String approvedDate, String ProposalDate, String availableDate, String offeredUntil, String frequencyReview,
			String expiryDate, String limitAmount, String company, String internalAmount, String advisedAmount, String availableMaker,
			String notes, String fixedVariable, String collateralCode, String maximumSecured, String maximumUnsecured, String maximumTotal, 
			String productLimit, String vpbProduct, String appraisalPerson, String approvePerson) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenLimitControlPage.t24Version(),OpenLimitControlPage.versionTitle());
		
		Log.info(driver.getTitle());
		
		// GLOBAL LIMIT
		clearAndType(OpenLimitControlPage.txtTransactionId(driver), cif+"."+globalLimit);
		OpenLimitControlPage.btnEdit(driver).click();
		clearAndType(OpenLimitControlPage.txtLimitCurrency(driver), limitCurrency);
		clearAndType(OpenLimitControlPage.txtCountry(driver), country);
		clearAndType(OpenLimitControlPage.txtApprovedDate(driver), approvedDate);
		clearAndType(OpenLimitControlPage.txtAvailableDate(driver), availableDate);
		clearAndType(OpenLimitControlPage.txtOfferedUntil(driver), offeredUntil);
		clearAndType(OpenLimitControlPage.txtFrequencyReview(driver), frequencyReview);
		clearAndType(OpenLimitControlPage.txtExpiryDate(driver), expiryDate);
		clearAndType(OpenLimitControlPage.txtLimitAmount(driver), limitAmount);
		clearAndType(OpenLimitControlPage.txtCompany(driver), company);
		clearAndType(OpenLimitControlPage.txtInternalAmount(driver), internalAmount);
		clearAndType(OpenLimitControlPage.txtAdvisedAmount(driver), advisedAmount);
		
		switch (availableMaker.toLowerCase())
		{
			case "n":
				OpenLimitControlPage.rbtAvailableMakerN(driver).click();
				break;
			case "r":
				OpenLimitControlPage.rbtAvailableMakerR(driver).click();
				break;
			case "y":
				OpenLimitControlPage.rbtAvailableMakerY(driver).click();
				break;
			default:
				OpenLimitControlPage.rbtAvailableMakerY(driver).click();
				break;
		}
			
		clearAndType(OpenLimitControlPage.txtNotes(driver), notes);
		
		switch (fixedVariable.toLowerCase())
		{
			case "n":
				OpenLimitControlPage.rbtFixedAvailableN(driver).click();
				break;
			case "fixed":
				OpenLimitControlPage.rbtFixed(driver).click();
				break;
			case "available":
				OpenLimitControlPage.rbtAvailable(driver).click();
				break;
			default:
				OpenLimitControlPage.rbtFixed(driver).click();
				break;
		}
		
		clearAndType(OpenLimitControlPage.txtCollateralCode(driver), collateralCode);
		clearAndType(OpenLimitControlPage.txtMaximumSecured(driver), maximumSecured);
		clearAndType(OpenLimitControlPage.txtMaximumUnsecured(driver), maximumUnsecured);
		clearAndType(OpenLimitControlPage.txtMaximumTotal(driver), maximumTotal);
		OpenLimitControlPage.btnCommit(driver).click();
		
		if(OpenLimitControlPage.lblOverride(driver)!=null)
		{
			OpenLimitControlPage.lblOverride(driver).click();
			Log.info("Click lblOverride");
		}
		else
			Log.info("lblOverride not found");
		
		// Authorize CIF
		signin.switchMainId();
		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenLimitControlPage.t24Version(),OpenLimitControlPage.versionTitle());
		
		clearAndType(OpenLimitControlPage.txtTransactionId(driver), cif+"."+globalLimit);
		OpenLimitControlPage.btnPerform(driver).click();
		OpenLimitControlPage.btnAuthorise(driver).click();		
		
		Log.info(cif+"."+globalLimit);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
