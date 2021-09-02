package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.SecurityMeasures_Page;
import pdfReporter.JyperionListener;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class SecurityMeasures_Test {
	private AndroidDriver driver;
	SecurityMeasures_Page securityMeasures;
	
	@BeforeMethod
	public void beforeMethodSecurityMeasures() throws MalformedURLException {
		securityMeasures = new SecurityMeasures_Page(driver);
		driver = (AndroidDriver) securityMeasures.banMetDriverConnection();
		securityMeasures.allowAccess();
		securityMeasures.allowAccess();
		securityMeasures.tapOnNext();
		securityMeasures.tapOnNext();
		securityMeasures.tapOnNext();
		securityMeasures.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void isSecurityMeasuresOpeningWell() throws InterruptedException {
		securityMeasures.searchElementSecurityMeasures_PageOnMenu();		
		assertTrue(securityMeasures.isSecurityMeasuresPagOpeningWell(),"The Security Measures page was'nt opened well");
	}	

	@AfterMethod
	public void afterMethodSecurityMeasures() {
		driver.quit();
	}
}
