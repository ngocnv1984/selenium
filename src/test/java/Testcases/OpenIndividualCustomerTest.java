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
	public void OpenIndividualCustomer(String sector, String vpbIndustry, String target, String documentType, String documentNum, String issuePlace,
			String issueDate, String legalId, String nationality, String residence, String customerStatus, String companyBook, 
			String birthDate, String dao, String daoPb, String gender, String contactType, String contactNumber, String emailAddress) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenIndividualCustomerPage.t24Version(),OpenIndividualCustomerPage.versionTitle());
		
		Log.info("Start <Open Individual Customer> Testcase");
				
		OpenIndividualCustomerPage.btnNew(driver).click();
		
		String cif = OpenIndividualCustomerPage.txtCif(driver).getAttribute("value");
		
		////////////////BASIC TAB		
		Log.info("btnNew found");
		clearAndType(OpenIndividualCustomerPage.txtCustomerMnemonic(driver),"CIF"+cif);
		Log.info("txtCustomerMnemonic found");
		clearAndType(OpenIndividualCustomerPage.txtShortName(driver), "Auto short name");
		Log.info("txtShortName found");
		clearAndType(OpenIndividualCustomerPage.txtFullName(driver), "Auto full name");
		Log.info("txtFullName found");
		clearAndType(OpenIndividualCustomerPage.txtSector(driver), sector);
		Log.info("txtSector found");
		clearAndType(OpenIndividualCustomerPage.txtVpbIndustry(driver),vpbIndustry);
		Log.info("txtVpbIndustry found");
		OpenIndividualCustomerPage.txtTarget(driver).clear();
		clearAndType(OpenIndividualCustomerPage.txtTarget(driver),target);
		Log.info("txtTarget found");
		clearAndType(OpenIndividualCustomerPage.txtDocumentType(driver),documentType);
		Log.info("txtDocumentType found");
		
		if(documentNum.equals("N"))
			clearAndType(OpenIndividualCustomerPage.txtDocumentNum(driver),"00"+cif);
		else
			clearAndType(OpenIndividualCustomerPage.txtDocumentNum(driver),documentNum);		
		Log.info("txtDocumentNum found");
		
		clearAndType(OpenIndividualCustomerPage.txtIssuePlace(driver),issuePlace);
		Log.info("txtIssuePlace found");
		clearAndType(OpenIndividualCustomerPage.txtIssueDate(driver),issueDate);
		Log.info("txtIssueDate found");
		
		if(legalId.equals("N"))
			clearAndType(OpenIndividualCustomerPage.txtLegalId(driver),"00"+cif);
		else
			clearAndType(OpenIndividualCustomerPage.txtLegalId(driver),legalId);
		Log.info("txtLegalId found");
		
		clearAndType(OpenIndividualCustomerPage.txtNationality(driver),nationality);
		Log.info("txtNationality found");
		clearAndType(OpenIndividualCustomerPage.txtResidence(driver),residence);
		Log.info("txtResidence found");
		clearAndType(OpenIndividualCustomerPage.txtCustomerStatus(driver),customerStatus);
		Log.info("txtCustomerStatus found");
		clearAndType(OpenIndividualCustomerPage.txtCompanyBook(driver),companyBook);
		Log.info("txtCompanyBook found");
		clearAndType(OpenIndividualCustomerPage.txtBirthDate(driver),birthDate);
		Log.info("txtBirthDate found");
		clearAndType(OpenIndividualCustomerPage.txtLanguage(driver),"2");
		Log.info("txtLanguage found");
		clearAndType(OpenIndividualCustomerPage.txtStreet(driver),"Dich Vong Hau");
		Log.info("txtStreet found");
		clearAndType(OpenIndividualCustomerPage.txtTown(driver),"Cau Giay");
		Log.info("txtTown found");
		clearAndType(OpenIndividualCustomerPage.txtProvince(driver),"Ha Noi");
		Log.info("txtProvince found");
		clearAndType(OpenIndividualCustomerPage.txtAddStreet(driver),"Dich Vong Hau");
		Log.info("txtAddStreet found");
		clearAndType(OpenIndividualCustomerPage.txtAddProvince(driver),"Ha Noi");
		Log.info("txtAddProvince found");
		clearAndType(OpenIndividualCustomerPage.txtDao(driver),dao);
		Log.info("txtDao found");
		clearAndType(OpenIndividualCustomerPage.txtDaoPb(driver),daoPb);
		Log.info("txtDaoPb found");
		OpenIndividualCustomerPage.rbtPCB(driver).click();
		Log.info("rbtPcb found");
		
		//////////////// OTHER DETAILS TAB
		OpenIndividualCustomerPage.btnTabOther(driver).click();
		Log.info("btnTabOther found");
		
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
		Log.info("ddlContactType found");
		
		clearAndType(OpenIndividualCustomerPage.txtContactNumber(driver),contactNumber);
		Log.info("txtContactNumber found");
		clearAndType(OpenIndividualCustomerPage.txtEmailAddress(driver),emailAddress);
		Log.info("txtEmailAddress found");
		OpenIndividualCustomerPage.btnCommit(driver).click();
		Log.info("btnCommit found");
		
		if(OpenIndividualCustomerPage.lblOverride(driver)!=null)
		{
			OpenIndividualCustomerPage.lblOverride(driver).click();
			Log.info("lblOverride found");
		}
		else
			Log.info("lblOverride not found");
		
		// Authorize CIF
		signin.switchMainId();
		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenIndividualCustomerPage.t24Version(),OpenIndividualCustomerPage.versionTitle());
		
		clearAndType(OpenIndividualCustomerPage.txtTransactionId(driver), cif);
		OpenIndividualCustomerPage.btnPerform(driver).click();
		OpenIndividualCustomerPage.btnAuthorise(driver).click();		
		
//		updateResult(cif, i, 19);
//		i++;
		
		Log.info(cif);
	}
	
	@AfterMethod
	public void tearDown() throws Exception {
		driver.quit();
	}
}
