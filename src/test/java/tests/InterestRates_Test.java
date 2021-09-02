package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.InterestRates_Page;
import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class InterestRates_Test {

	private AndroidDriver driver;
	InterestRates_Page interesRate;

	@BeforeMethod
	public void beforeMethodInterestRate() throws MalformedURLException {
		interesRate = new InterestRates_Page(driver);
		driver = (AndroidDriver) interesRate.banMetDriverConnection();
		interesRate.allowAccess();
		interesRate.allowAccess();
		interesRate.tapOnNext();
		interesRate.tapOnNext();
		interesRate.tapOnNext();
		interesRate.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void checkInterestRateOpenedWell() {
		interesRate.searchElementSecurityMeasures_PageOnMenu();
		assertTrue(interesRate.isInterestRatePagOpeningWell(), "The Interest Rate Page was'nt opened well ");
	}

	@AfterMethod
	public void afterMethodInterestRate() {
		driver.quit();
	}
}
