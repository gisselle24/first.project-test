package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.BankFees_Page;
import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class BankFees_Test {

	private AndroidDriver driver;
	BankFees_Page bankFees;

	@BeforeMethod
	public void beforeMethodBankFees_Page() throws MalformedURLException {
		bankFees = new BankFees_Page(driver);
		driver = (AndroidDriver) bankFees.banMetDriverConnection();
		bankFees.allowAccess();
		bankFees.allowAccess();
		bankFees.tapOnNext();
		bankFees.tapOnNext();
		bankFees.tapOnNext();
		bankFees.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void checkBankFeesOpenedWell() {
		bankFees.searchElementBankFees_PageOnMenu();
		assertTrue(bankFees.IsBankFeesPagOpeningWell(),"The page was'nt opened well");
	}

	@AfterMethod
	public void afterMethodBankFees_Page() {
		driver.quit();
	}

}
