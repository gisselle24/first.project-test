package tests;

import org.testng.annotations.Test;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.offset.PointOption;
import pages.Home_Page;
import pages.BanksBranches_Page;
import pdfReporter.JyperionListener;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;
import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class BanksBranches_Test {

	private AndroidDriver driver;
	BanksBranches_Page sucursals;
	Boolean isSucursalonFavorities;

	@BeforeMethod
	public void beforeClassSucursalsTest() throws MalformedURLException {
		sucursals = new BanksBranches_Page(driver);
		driver = (AndroidDriver) sucursals.banMetDriverConnection();
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), sucursals);
		sucursals.allowAccess();
		sucursals.allowAccess();
		sucursals.tapOnNext();
		sucursals.tapOnNext();
		sucursals.tapOnNext();
		sucursals.tapOnNext();
	}

	// Testing info
	@Test(enabled = true, priority = 0)
	public void isWorkingInfo() {
		sucursals.tapOnBanksBranchesMenu();
		sucursals.tapOnInfo();
		assertTrue(sucursals.isInfoVisible(), "Info isn't working");
	}

	// Testing see schedule
	@Test(enabled = true, priority = 1)
	private void isWorkingScheduleFilter() {
		sucursals.tapOnBanksBranchesMenu();
		sucursals.tapOnSeeSchedule();
		sucursals.tapOnSunday();
		sucursals.tapOnAcceptBtn();
		sucursals.tapOnHabVieja();
		sucursals.tapOnObispo();
		assertTrue(sucursals.isFilterScheduleWorking(), "The word was'nt finded on the text");
	}

	// Search sucural
	// Filter sucursal
	// List sucursal
	// Search sucursal por municipio en el mapa
	@Test(enabled = true, priority = 2)
	public void TestShowMap_Regla_CasaBlanca() {
		sucursals.tapOnBanksBranchesMenu();
		sucursals.tapOnSearchIcon();
		sucursals.typeText();
		sucursals.tapOnIconShowMap();
		assertTrue(sucursals.isTheMapVisible());
	}

	// Mostrar info de la sucursal
	@Test(enabled = true, priority = 3)
	public void TestDetails_Regla_Map() {
		sucursals.tapOnBanksBranchesMenu();
		sucursals.tapOnSearchIcon();
		sucursals.typeText();
		sucursals.tapOnRegla();
		sucursals.tapOnRegla_Details_Icon();
		assertTrue(sucursals.isTheMapVisible_Details());
	}

	// Add sucursal a favorities
	@Test(enabled = true, priority = 4)
	public void TestDetails_Regla_Favorite() {
		sucursals.tapOnBanksBranchesMenu();
		sucursals.tapOnPlaya();
		sucursals.tapOnPlaya_Palacio();
		sucursals.addSucursalToFavorities();
		sucursals.tapOnExit();
		TouchAction touchAction = new TouchAction(driver);
		touchAction.tap(PointOption.point(54, 126)).perform();
		Home_Page homepage;
		homepage = new Home_Page(driver);
		homepage.tapOnHomeMenu();
		homepage.tapOnFavoritiesHome();
		isSucursalonFavorities = homepage.isFavoritiesElementsVisibleBankBranches();
		assertTrue(isSucursalonFavorities, "Sucursal was'nt addedto favorities");
		sucursals.deleteSucursalfromFavorities();
		assertTrue(isSucursalonFavorities, "Bank Branches was'nt removed");
	}

	@AfterMethod
	public void afterSucursalTests() {
		driver.quit();
	}

}
