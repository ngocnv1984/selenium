package Testcases;

import Base.TestBase;
import Base.DataProviderSource;
import Base.Log;
import Pages.FundTransferPage;
import Pages.SignInPage;
import Testcases.SignInTest;
import org.testng.annotations.Test;

public class FundTransferTest extends TestBase {

	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void fundTransfer(String No, String transferType, String debitAccount, String debitCurrency, 
			String debitAmount, String creditAccount, String creditCurrency, String orderBank) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(FundTransferPage.t24Version(),FundTransferPage.versionTitle());
		
		FundTransferPage.btnNew(driver).click();
		String ft = FundTransferPage.txtFt(driver).getAttribute("value");
		clearAndType(FundTransferPage.txtTransferType(driver), transferType);
		clearAndType(FundTransferPage.txtDebitAccount(driver), debitCurrency+"14033");
		clearAndType(FundTransferPage.txtDebitCurrency(driver), debitCurrency);
		clearAndType(FundTransferPage.txtDebitAmount(driver), debitAmount);
		clearAndType(FundTransferPage.txtCreditAccount(driver), creditAccount);
		clearAndType(FundTransferPage.txtCreditCurrency(driver), creditCurrency);
		clearAndType(FundTransferPage.txtOrderBank(driver), orderBank);
		FundTransferPage.btnCommit(driver).click();
		
		if(FundTransferPage.lblOverride(driver)!=null)
			FundTransferPage.lblOverride(driver).click();

		Log.info(ft);
		updateResult("fundtransfer", ft, Integer.parseInt(No), 0);
	}
}
