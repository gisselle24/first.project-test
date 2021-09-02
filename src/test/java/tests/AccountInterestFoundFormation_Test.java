package tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.AccountInterestCalculation_Page;
import pdfReporter.JyperionListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;

@Listeners(JyperionListener.class)
public class AccountInterestFoundFormation_Test {
	AndroidDriver driver;
	AccountInterestCalculation_Page account;	

	@BeforeClass
	public void beforeMethod() throws MalformedURLException {
		account = new AccountInterestCalculation_Page(driver);
		driver = (AndroidDriver) account.banMetDriverConnection();
		account.allowAccess();
		account.allowAccess();
		account.tapOnNext();
		account.tapOnNext();
		account.tapOnNext();
		account.tapOnNext();
	}
	
	@Test(priority = 0)
	private void isPageVisible() {
		account.searchElementAccountInteresOnMenu();
		assertTrue(account.isSavingModeVisible(), "The page Account Interest Calculator is not visible");
		account.TapFoundFormation();
	}
	
	@Test(priority = 2)
	public void isEmty() {
		account.sendImportEmty();		
		account.tapBtnCalculate();
		assertEquals(account.getErrorMessage(), "Debe llenar todos los campos");
	}

	@Test(priority = 1, dataProvider = "dataPro", enabled = true)
	public void acountInterest(String n) {

		account.sendImport(n);
		Integer imp = Integer.parseInt(n);

		switch (imp) {
		case 29:
			account.fillFieldsFoundFormation();
			account.tapBtnCalculate();
			assertEquals(account.getErrorMessage(), "El saldo debe ser mayor que $ 30");
			break;

		case 30:
			account.tapBtnCalculate();
			assertEquals(account.getResult(), "0.91");
			break;

		case 31:
			account.tapBtnCalculate();
			assertEquals(account.getResult(), "0.94");
			break;
		}
	}

	@DataProvider(name = "dataPro")
	public String[] getData() {

		String[] data = new String[3];

		data[0] = "29";
		data[1] = "30";
		data[2] = "31";

		return data;
	}

	@AfterClass	
	public void afterMethod() {
		driver.quit();
	}
}
