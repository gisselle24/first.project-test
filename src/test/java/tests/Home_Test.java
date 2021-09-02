package tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.Home_Page;
import pdfReporter.JyperionListener;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class Home_Test {

	private AndroidDriver driver;
	Home_Page homepage;
	
	@BeforeMethod
	public void beforeClassHomeTest() throws MalformedURLException {

		homepage = new Home_Page(driver);
		driver = (AndroidDriver) homepage.banMetDriverConnection();
		homepage.allowAccess();
		homepage.allowAccess();
		homepage.tapOnNext();
		homepage.tapOnNext();
		homepage.tapOnNext();
		homepage.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void isLanguageWorking() {
		homepage.tapOnHomeMenu();
		homepage.changeLanguage();
		homepage.Read_More();
		assertTrue(homepage.isHomePageVisible_en());
		homepage.changeLanguage();
		homepage.Read_More();
		assertTrue(homepage.isHomePageVisible_es());
	}

	@Test(enabled = true, priority = 1)
	public void isMapWorking() {
		homepage.tapOnHomeMenu();
		homepage.tapOnIconShowMap();
		assertTrue(homepage.isTheMapVisible());
	}	

	@AfterMethod
	public void afterTestHomeTest() {
		driver.quit();
	}
}
