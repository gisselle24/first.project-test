package tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.CashExchangeRate_Page;
import pdfReporter.JyperionListener;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class CashExchangeRate_Test {

	private AndroidDriver driver;
	CashExchangeRate_Page cashExchangeRate;

	@BeforeMethod
	public void beforeMethodCashExchangeRate() throws MalformedURLException {
		cashExchangeRate = new CashExchangeRate_Page(driver);
		driver = (AndroidDriver) cashExchangeRate.banMetDriverConnection();
		cashExchangeRate.allowAccess();
		cashExchangeRate.allowAccess();
		cashExchangeRate.tapOnNext();
		cashExchangeRate.tapOnNext();
		cashExchangeRate.tapOnNext();
		cashExchangeRate.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void checkEntryToPageCashExchangeRate() {
		cashExchangeRate.searchElementInteresCreditOnMenu();
		assertTrue(cashExchangeRate.isCashExhangeRatePageOpeningWell(), "The page was'nt opened well");
	}

	@Test(enabled = false, priority = 1)
	private void tapBtnUpdate() {
		cashExchangeRate.tapBtnUpdate();
	}

	@AfterMethod
	public void afterMethodCashExchangeRate() {
		driver.quit();
	}
}
