package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.Bonus_Page;
import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class Bonus_Test {

	private AndroidDriver driver;
	Bonus_Page bonus;
	
	@BeforeMethod
	public void beforeMethodBonus_Page() throws MalformedURLException {
		bonus = new Bonus_Page(driver);
		driver = (AndroidDriver) bonus.banMetDriverConnection();
		bonus.allowAccess();
		bonus.allowAccess();
		bonus.tapOnNext();
		bonus.tapOnNext();
		bonus.tapOnNext();
		bonus.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void checkBonusOpenedWell() {
		bonus.searchElementBonus_PageOnMenu();
		//bonus.scrollTEST();
		assertTrue(bonus.IsBonusPagOpeningWell());
	}
	
	@AfterMethod
	public void afterMethodBonus_Page() {
		driver.quit();
	}
}
