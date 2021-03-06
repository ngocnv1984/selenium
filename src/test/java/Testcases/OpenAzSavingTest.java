package Testcases;

import org.testng.annotations.Test;
import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenAzSavingPage;
import Pages.SignInPage;

public class OpenAzSavingTest extends TestBase {

	String[] dataset = new String[19];
	
	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void openAz(String no, String customerNo, String depositType, 
			String currency, String depositProduct, String amount, String valueDate, 
			String maturityDate, String term, String debitAccount, String nominatedAccount, 
			String interestRate, String dao, String mobilePhone, String nrProgram, 
			String nrDate, String nrRate, String nrAmount, String nrAccount) 
	{	
		this.dataset[0] = no;			
		this.dataset[1] = customerNo;	
		this.dataset[2] = depositType;
		this.dataset[3] = currency;		
		this.dataset[4] = depositProduct;	
		this.dataset[5] = amount;
		this.dataset[6] = valueDate;	
		this.dataset[7] = maturityDate;	
		this.dataset[8] = term;
		this.dataset[9] = debitAccount;	
		this.dataset[10] = nominatedAccount;	
		this.dataset[11] = interestRate;
		this.dataset[12] = dao;	
		this.dataset[13] = mobilePhone;	
		this.dataset[14] = nrProgram;
		this.dataset[15] = nrDate;	
		this.dataset[16] = nrRate;	
		this.dataset[17] = nrAmount;
		this.dataset[18] = nrAccount;
		
		if(depositType.equals("6601")||depositType.equals("6602")||depositType.equals("6603")||depositType.equals("6604"))
			timeDepositWithNr();
		else
			timeDepositWithoutNr();
	}
	
	private void timeDepositWithNr()
	{
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAzSavingPage.baseVersion(),OpenAzSavingPage.baseTitle());
		
		OpenAzSavingPage.btnNew(driver).click();
		String account = OpenAzSavingPage.txtAccount(driver).getAttribute("value");
		
		///////// OPEN BASE ACCOUNT
		clearAndType(OpenAzSavingPage.txtCustomerNo(driver), dataset[1]);
		clearAndType(OpenAzSavingPage.txtDepositType(driver), dataset[2]);
		clearAndType(OpenAzSavingPage.txtCurrency(driver), dataset[3]);
		OpenAzSavingPage.btnCommit(driver).click();
		Log.info(OpenAzSavingPage.lblResult(driver).getText());
		
		signin.switchMainId();
		
		if(dataset[2].equals("6601")||dataset[2].equals("6603"))
		{
			signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
			openFixed(account);
		}
		else
		{
			signin.navigateToVersion(OpenAzSavingPage.mipVersion(),OpenAzSavingPage.mipTitle());
			openMip(account);
		}
		
		// AUTHORIZE FIXED AZ
		signin.switchMainId();
        signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
        
		if(dataset[2].equals("6601")||dataset[2].equals("6603"))
			signin.navigateToVersion(OpenAzSavingPage.fixedVersion(),OpenAzSavingPage.fixedTitle());
		else
			signin.navigateToVersion(OpenAzSavingPage.mipVersion(),OpenAzSavingPage.mipTitle());
		
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnPerform(driver).click();
		OpenAzSavingPage.btnAuthorise(driver).click();
		Log.info(account);
		updateResult("openaz", account, Integer.parseInt(dataset[0]), 0);
	}
	
	private void openFixed(String account)
	{
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), dataset[4]);
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), dataset[5]);
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),dataset[6]);
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), dataset[7]);
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), dataset[9]);
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), dataset[10]);
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), dataset[11]);
		
		//////// Input NR
		if(dataset[14]==null||dataset[14].equals(""))
			OpenAzSavingPage.rbtNrProgramN(driver).click();
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			inputNr();
		}
		
		clearAndType(OpenAzSavingPage.txtDao(driver), dataset[12]);
		clearAndType(OpenAzSavingPage.txtMobilePhone(driver), dataset[13]);
		OpenAzSavingPage.btnCommit(driver).click();
		
		if(OpenAzSavingPage.lblOverride(driver)!=null)
			OpenAzSavingPage.lblOverride(driver).click();

		Log.info(OpenAzSavingPage.lblResult(driver).getText());
	}
	
	private void openMip(String account)
	{
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), dataset[4]);
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), dataset[5]);
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),dataset[6]);
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), dataset[7]);
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), dataset[9]);
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), dataset[10]);
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), dataset[11]);
		
		//////// Input NR
		if(dataset[14]==null||dataset[14].equals(""))
			OpenAzSavingPage.rbtNrProgramN(driver).click();
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			inputNr();
		}
		
		clearAndType(OpenAzSavingPage.txtMobilePhone(driver), dataset[13]);
		OpenAzSavingPage.tabChgsSchedules(driver).click();
		OpenAzSavingPage.rbtCalculationBasePrincipal(driver).click();
		OpenAzSavingPage.rbtSchedulesN(driver).click();
		OpenAzSavingPage.btnCommit(driver).click();
		
		if(OpenAzSavingPage.lblOverride(driver)!=null)
			OpenAzSavingPage.lblOverride(driver).click();

		Log.info(OpenAzSavingPage.lblResult(driver).getText());
	}
	
	private void inputNr()
	{
		
	}
	
	private void timeDepositWithoutNr()
	{
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenAzSavingPage.intergrateBaseVersion(),OpenAzSavingPage.intergrateBaseTitle());
		
		OpenAzSavingPage.btnNew(driver).click();
		String account = OpenAzSavingPage.txtAccount(driver).getAttribute("value");
		
		///////// OPEN BASE ACCOUNT
		clearAndType(OpenAzSavingPage.txtCustomerNo(driver), dataset[1]);
		clearAndType(OpenAzSavingPage.txtDepositType(driver), dataset[2]);
		clearAndType(OpenAzSavingPage.txtCurrency(driver), dataset[3]);
		OpenAzSavingPage.btnCommit(driver).click();
		Log.info(OpenAzSavingPage.lblResult(driver).getText());
		signin.switchMainId();
		signin.navigateToVersion(OpenAzSavingPage.intergrateTimeDepositVersion(),OpenAzSavingPage.intergrateTimeDepositTitle());
		openTimeDeposit(account);
		
		// AUTHORIZE FIXED AZ
		signin.switchMainId();
        signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenAzSavingPage.intergrateTimeDepositVersion(),OpenAzSavingPage.intergrateTimeDepositTitle());

		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnPerform(driver).click();
		OpenAzSavingPage.btnAuthorise(driver).click();
		Log.info(OpenAzSavingPage.lblResult(driver).getText());
		
		updateResult("openaz", account, Integer.parseInt(dataset[0]), 0);
	}
	
	private void openTimeDeposit(String account)
	{
		clearAndType(OpenAzSavingPage.txtTransactionId(driver), account);
		OpenAzSavingPage.btnEdit(driver).click();
		clearAndType(OpenAzSavingPage.txtDepositProduct(driver), dataset[4]);
		clearAndType(OpenAzSavingPage.txtPrincipalAmount(driver), dataset[5]);
		OpenAzSavingPage.txtOpenDate(driver).click();
		clearAndType(OpenAzSavingPage.txtOpenDate(driver),dataset[6]);
		clearAndType(OpenAzSavingPage.txtMaturityDate(driver), dataset[7]);
		clearAndType(OpenAzSavingPage.txtDebitAccount(driver), dataset[9]);
		clearAndType(OpenAzSavingPage.txtNominatedAccount(driver), dataset[10]);
		clearAndType(OpenAzSavingPage.txtInterestRate(driver), dataset[11]);
		
		//////// Input NR
		if(dataset[14]==null||dataset[14].equals(""))
			OpenAzSavingPage.rbtNrProgramN(driver).click();
		else
		{
			OpenAzSavingPage.rbtNrProgramY(driver).click();
			inputNr();
		}
		
		clearAndType(OpenAzSavingPage.txtDao(driver), dataset[12]);
		clearAndType(OpenAzSavingPage.txtMobilePhone(driver), dataset[13]);
		OpenAzSavingPage.btnCommit(driver).click();
		
		if(OpenAzSavingPage.lblOverride(driver)!=null)
			OpenAzSavingPage.lblOverride(driver).click();

		Log.info(OpenAzSavingPage.lblResult(driver).getText());
	}
}