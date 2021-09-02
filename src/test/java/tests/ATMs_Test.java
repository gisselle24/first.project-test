package tests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;

import pages.ATMs_Page;
import pages.Home_Page;

import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class ATMs_Test {
	private AndroidDriver driver;
	ATMs_Page atm;
	Boolean isATMonFavorities;

	@BeforeMethod
	public void beforeMethodATMs() throws MalformedURLException {
		atm = new ATMs_Page(driver);
		driver = (AndroidDriver) atm.banMetDriverConnection();
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), atm);
		atm.allowAccess();
		atm.allowAccess();
		atm.TapOnNext();
		atm.TapOnNext();
		atm.TapOnNext();
		atm.TapOnNext();
	}

	// search cajero
	// filter cajero
	// list cajero
	// search cajero for municipio on map
	@Test(enabled = true, priority = 3)
	public void TestShowMap_Regla_CasaBlanca() {
		atm.tapOnATMMenu();
		atm.tapOnSearchIcon();
		atm.typeText();
		atm.tapOnIconShowMap();
		assertTrue(atm.isTheMapVisible());
	}

	// search info about ATMs
	@Test(enabled = true, priority = 1)
	public void TestDetails_Regla_Map() {
		atm.tapOnATMMenu();
		atm.tapOnSearchIcon();
		atm.typeText();
		atm.tapOnRegla();
		atm.tapOnRegla_Details_Icon();
		assertTrue(atm.isTheMapVisible_Details());
	}

	// Add ATM a favorities
	@Test(enabled = true, priority = 2)
	public void TestDetails_Regla_Favorite() {
		atm.tapOnATMMenu();
		atm.tapOnPlaya();
		atm.tapOn5taAvenida();
		atm.addSucursalToFavorities();
		atm.tapOnExit();
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(54, 126)).perform();
		Home_Page homepage;
		homepage = new Home_Page(driver);
		homepage.tapOnHomeMenu();
		homepage.tapOnFavoritiesHome();
		homepage.TapOnATMHomePage();
		isATMonFavorities = homepage.isFavoritiesElementsVisibleATM();
		assertTrue(isATMonFavorities,"ATM was'nt added to Favorities");
		atm.deleteATMfromFavorities();
		assertTrue(isATMonFavorities, "ATM was'nt removed");
	}
	
	@Test(enabled = true, priority = 0)
	public void isViewScheduleWorking() {
		atm.tapOnATMMenu();
		atm.goToTestFilterSchedule();
		assertTrue(atm.isFilterScheduleWorking(), "Filter's Schedule was'nt working");
	}

	@AfterMethod
	public void afterMethodATMs() {
		driver.quit();
	}

}
