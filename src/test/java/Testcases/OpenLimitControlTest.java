package Testcases;

import org.testng.annotations.Test;
import Base.DataProviderSource;
import Base.Log;
import Base.TestBase;
import Pages.OpenLimitControlPage;
import Pages.SignInPage;

public class OpenLimitControlTest extends TestBase {

	@Test(dataProvider="DataSource", dataProviderClass=DataProviderSource.class)
	public void OpenLimitControl(String No, String cif, String globalLimit, String limitCurrency, String country, 
			String approvedDate, String ProposalDate, String availableDate, String offeredUntil, String frequencyReview,
			String expiryDate, String limitAmount, String company, String internalAmount, String advisedAmount, String availableMaker,
			String notes, String fixedVariable, String collateralCode, String maximumSecured, String maximumUnsecured, String maximumTotal, 
			String productLimit, String vpbProduct, String appraisalPerson, String approvePerson) 
	{	
		SignInTest signin = new SignInTest();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenLimitControlPage.globalLimitVersion(),OpenLimitControlPage.globalLimitTitle());
		
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
//		signin.switchMainId();
//		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
//		signin.navigateToVersion(OpenLimitControlPage.globalLimitVersion(),OpenLimitControlPage.globalLimitTitle());
//		
//		clearAndType(OpenLimitControlPage.txtTransactionId(driver), cif+"."+globalLimit);
//		OpenLimitControlPage.btnPerform(driver).click();
//		OpenLimitControlPage.btnAuthorise(driver).click();		
//		
//		Log.info(cif+"."+globalLimit);
		
		//PRODUCT LIMIT
		signin.switchMainId();
		signin.signIn(driver,SignInPage.inputUser(),SignInPage.inputPassword());
		signin.navigateToVersion(OpenLimitControlPage.productLimitVersion(),OpenLimitControlPage.productLimitTitle());
		
		clearAndType(OpenLimitControlPage.txtTransactionId(driver), cif+"."+productLimit);
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
		
		clearAndType(OpenLimitControlPage.txtCollateralCode(driver), collateralCode);
		clearAndType(OpenLimitControlPage.txtMaximumSecured(driver), maximumSecured);
		clearAndType(OpenLimitControlPage.txtMaximumUnsecured(driver), maximumUnsecured);
		clearAndType(OpenLimitControlPage.txtMaximumTotal(driver), maximumTotal);
		
		String[] products = vpbProduct.split("/");        
        String[] subproduct = null;
        
        if(!vpbProduct.contains("/")){
        	subproduct = vpbProduct.split("-");
        	
        	clearAndType(OpenLimitControlPage.txtVpbProduct(driver, 1), subproduct[0]);
        	clearAndType(OpenLimitControlPage.txtLimitProSecAmount(driver, 1), subproduct[1]);
        	clearAndType(OpenLimitControlPage.txtLimitProUnsecAmount(driver, 1), subproduct[2]);
        } 
        else 
        {       
            for(int i=0; i<products.length;)
            {
            	subproduct = products[i].split("-");
            	
            	if(i<products.length-1)
            		OpenLimitControlPage.btnExpand(driver).click();
            	
            	i = i+1;
            	clearAndType(OpenLimitControlPage.txtVpbProduct(driver, i), subproduct[0]);
            	clearAndType(OpenLimitControlPage.txtLimitProSecAmount(driver, i), subproduct[1]);
            	clearAndType(OpenLimitControlPage.txtLimitProUnsecAmount(driver, i), subproduct[2]);
            }
        }
        
        clearAndType(OpenLimitControlPage.txtAppraisalPerson(driver), appraisalPerson);
        clearAndType(OpenLimitControlPage.txtApprovePerson(driver), approvePerson);
        OpenLimitControlPage.btnCommit(driver).click();
        
        if(OpenLimitControlPage.lblOverride(driver)!=null)
			OpenLimitControlPage.lblOverride(driver).click();
        
        signin.switchMainId();
		signin.signIn(driver,SignInPage.authoriseUser(),SignInPage.authorisePassword());
		signin.navigateToVersion(OpenLimitControlPage.productLimitVersion(),OpenLimitControlPage.productLimitTitle());
		
		clearAndType(OpenLimitControlPage.txtTransactionId(driver), cif+"."+productLimit);
		OpenLimitControlPage.btnPerform(driver).click();
		OpenLimitControlPage.btnAuthorise(driver).click();		
		
		Log.info(cif+"."+productLimit);
		Log.info(cif+".006"+subproduct[0]+".01");
		Log.info(cif+".006"+subproduct[0]+".01");
	}
}
