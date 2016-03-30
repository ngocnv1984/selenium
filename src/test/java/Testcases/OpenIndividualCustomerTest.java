package Testcases;

import Base.TestBase;
import Base.DataProviderSource;
import Base.Log;
import Pages.OpenIndividualCustomerPage;
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

public class OpenIndividualCustomerTest extends TestBase {
	
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
	public void OpenIndividualCustomer(String No, String sector, String vpbIndustry, String target, String documentType, String documentNum, String issuePlace,
			String issueDate, String legalId, String nationality, String residence, String customerStatus, String companyBook, 
			String birthDate, String dao, String daoPb, String gender, String contactType, String contactNumber, String emailAddress) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenIndividualCustomerPage.t24Version(),OpenIndividualCustomerPage.versionTitle());
		OpenIndividualCustomerPage.btnNew(driver).click();
		String cif = OpenIndividualCustomerPage.txtCif(driver).getAttribute("value");
		
		////////////////BASIC TAB		
		clearAndType(OpenIndividualCustomerPage.txtCustomerMnemonic(driver),"CIF"+cif);
		clearAndType(OpenIndividualCustomerPage.txtShortName(driver), "Auto short name");
		clearAndType(OpenIndividualCustomerPage.txtFullName(driver), "Auto full name");
		clearAndType(OpenIndividualCustomerPage.txtSector(driver), sector);
		clearAndType(OpenIndividualCustomerPage.txtVpbIndustry(driver),vpbIndustry);
		OpenIndividualCustomerPage.txtTarget(driver).clear();
		clearAndType(OpenIndividualCustomerPage.txtTarget(driver),target);
		clearAndType(OpenIndividualCustomerPage.txtDocumentType(driver),documentType);
		
		if(documentNum.equals("N"))
			clearAndType(OpenIndividualCustomerPage.txtDocumentNum(driver),"00"+cif);
		else
			clearAndType(OpenIndividualCustomerPage.txtDocumentNum(driver),documentNum);		
		
		clearAndType(OpenIndividualCustomerPage.txtIssuePlace(driver),issuePlace);
		clearAndType(OpenIndividualCustomerPage.txtIssueDate(driver),issueDate);
		
		if(legalId.equals("N"))
			clearAndType(OpenIndividualCustomerPage.txtLegalId(driver),"00"+cif);
		else
			clearAndType(OpenIndividualCustomerPage.txtLegalId(driver),legalId);
		
		clearAndType(OpenIndividualCustomerPage.txtNationality(driver),nationality);
		clearAndType(OpenIndividualCustomerPage.txtResidence(driver),residence);
		clearAndType(OpenIndividualCustomerPage.txtCustomerStatus(driver),customerStatus);
		clearAndType(OpenIndividualCustomerPage.txtCompanyBook(driver),companyBook);
		clearAndType(OpenIndividualCustomerPage.txtBirthDate(driver),birthDate);
		clearAndType(OpenIndividualCustomerPage.txtLanguage(driver),"2");
		clearAndType(OpenIndividualCustomerPage.txtStreet(driver),"Dich Vong Hau");
		clearAndType(OpenIndividualCustomerPage.txtTown(driver),"Cau Giay");
		clearAndType(OpenIndividualCustomerPage.txtProvince(driver),"Ha Noi");
		clearAndType(OpenIndividualCustomerPage.txtAddStreet(driver),"Dich Vong Hau");
		clearAndType(OpenIndividualCustomerPage.txtAddProvince(driver),"Ha Noi");
		clearAndType(OpenIndividualCustomerPage.txtDao(driver),dao);
		clearAndType(OpenIndividualCustomerPage.txtDaoPb(driver),daoPb);
		OpenIndividualCustomerPage.rbtPCB(driver).click();
		
		//////////////// OTHER DETAILS TAB
		OpenIndividualCustomerPage.btnTabOther(driver).click();
		
		switch(gender.toLowerCase()){
			case "m":
				OpenIndividualCustomerPage.rbtGenderMale(driver).click();
				break;
			case "f":
				OpenIndividualCustomerPage.rbtGenderFemale(driver).click();
				break;
			default:
				OpenIndividualCustomerPage.rbtGenderOther(driver).click();
				break;
		}
		Log.info("rbtGender found");
		
		switch(contactType.toLowerCase()){
			case "land line":				
				selectOption(OpenIndividualCustomerPage.ddlContactType(driver),"Land Line");
				break;
			case "fax":
				selectOption(OpenIndividualCustomerPage.ddlContactType(driver),"Fax");
				break;
			case "pager":
				selectOption(OpenIndividualCustomerPage.ddlContactType(driver),"Pager");
				break;
			case "office":
				selectOption(OpenIndividualCustomerPage.ddlContactType(driver),"Office");
				break;
			default:
				selectOption(OpenIndividualCustomerPage.ddlContactType(driver),"Mobile");
				break;
		}
		
		clearAndType(OpenIndividualCustomerPage.txtContactNumber(driver),contactNumber);
		clearAndType(OpenIndividualCustomerPage.txtEmailAddress(driver),emailAddress);
		OpenIndividualCustomerPage.btnCommit(driver).click();
		
		if(OpenIndividualCustomerPage.lblOverride(driver)!=null)
			OpenIndividualCustomerPage.lblOverride(driver).click();
		
		// Authorize CIF
		signin.switchMainId();
		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenIndividualCustomerPage.t24Version(),OpenIndividualCustomerPage.versionTitle());
		
		clearAndType(OpenIndividualCustomerPage.txtTransactionId(driver), cif);
		OpenIndividualCustomerPage.btnPerform(driver).click();
		OpenIndividualCustomerPage.btnAuthorise(driver).click();		
		
		Log.info(cif);
		updateResult("individualcus", cif, Integer.parseInt(No), 0);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
