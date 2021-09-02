package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class BanksBranches_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Main Menu Sucursals
	By locatorMenuOficinaBancaria = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Oficinas Bancarias\")"));

	// Locators
	By locatorIconSearch = By.id("cu.cesol.bancometropolitano:id/action_search");
	By locatorSearchSucursal = By.id("cu.cesol.bancometropolitano:id/edt_tool_search");
	By locatorIconMap = By.id("cu.cesol.bancometropolitano:id/loc_suc");
	By locatorMap = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/mapView\")"));

	// Locators Regla
	By locatorRegla = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/tv_identificador_suc\").text(\"Regla\")"));
	By locatorDetailsReglaIcon = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/iviewmapa\")"));
	By locatorDetailsReglaMap = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/mapView\")"));

	// Locators Favorite
	By locatorDetailsReglaFavorite = MobileBy.AndroidUIAutomator(String
			.format("new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/ivfav\")"));
	By locatorfavorite = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(2).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/flechasucursal\")"));
	By locatorPalacio = MobileBy.xpath("//android.widget.TextView[@text='Palacio']");
	By locatorExit = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/btnPositive\").text(\"CERRAR\")"));
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/iv_delete_fav")
	private MobileElement locatorDelete;

	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/snackbar_action")
	private MobileElement locatorDeleteYes;

	// Locators Home Page
	By locatorMenu = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(0).clickable(true).resourceId(\"\").text(\"\")"));

	// Locators info
	By locatorInfo = MobileBy.AccessibilityId("Information");
	By locatorInfoVisible = MobileBy.xpath("//android.widget.TextView[@text='INFORMACIÓN']");

	// Locators Filter
	By locatorSeeSchedule = MobileBy.id("cu.cesol.bancometropolitano:id/filter_sucursal");
	By locatorSunday = MobileBy.xpath("//android.widget.RadioButton[@text='Domingo']");
	By locatorAceppt = MobileBy.xpath("//android.widget.TextView[@text='ACEPTAR']");
	By locatorHabVieja = MobileBy.xpath("//android.widget.TextView[@text='Habana Vieja']");
	By locatorObispo = MobileBy.xpath(
			"//android.widget.TextView[@text='Obispo (especializada en Cambio de Monedas), de lunes a domingo']");
	By locatorCalendar = MobileBy.xpath(
			"//android.widget.TextView[@text='8:30 am - 7:30 pm de Lunes a Sábado y 8:30 am - 3:30 pm el Domingo']");

	public BanksBranches_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Entering to the application
	public void allowAccess() {
		tap(allowAccess);
	}

	public void tapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	// Methods for search sucursal
	public void tapOnBanksBranchesMenu() {
		wait(locatorMenuOficinaBancaria);
		tap(locatorMenuOficinaBancaria);
	}

	public void tapOnSearchIcon() {
		wait(locatorIconSearch);
		tap(locatorIconSearch);
	}

	public void typeText() {
		wait(locatorSearchSucursal);
		type("regla", locatorSearchSucursal);
	}

	public void tapOnIconShowMap() {
		wait(locatorIconMap);
		tap(locatorIconMap);
	}

	public Boolean isTheMapVisible() {

		wait(locatorMap);

		if (isDisplayed(locatorMap)) {
			System.out.println("The map was displayed correctly");
			return true;
		} else {
			System.out.println("The map was'nt displayed correctly");
			return false;
		}
	}

	// Methods for details about Regla
	public void tapOnRegla() {
		wait(locatorRegla);
		tap(locatorRegla);
	}

	public void tapOnRegla_Details_Icon() {
		wait(locatorDetailsReglaIcon);
		tap(locatorDetailsReglaIcon);
	}

	public Boolean isTheMapVisible_Details() {

		wait(locatorDetailsReglaMap);

		if (isDisplayed(locatorDetailsReglaMap)) {
			System.out.println("The map was displayed correctly");
			return true;
		} else {
			System.out.println("The map was'nt displayed correctly");
			return false;
		}

	}

	// Add sucursal to favorites
	public void addSucursalToFavorities() {
		wait(locatorDetailsReglaFavorite);
		tap(locatorDetailsReglaFavorite);
	}

	// Delete Sucursal from favorites
	public void deleteSucursalfromFavorities() {
		wait(locatorDelete);
		tap(locatorDelete);

		wait(locatorDeleteYes);
		tap(locatorDeleteYes);
	}

	public void tapOnPlaya() {
		wait(locatorfavorite);
		tap(locatorfavorite);
	}

	public void tapOnPlaya_Palacio() {
		wait(locatorPalacio);
		tap(locatorPalacio);
	}

	// Methods Home Page
	public void tapOnExit() {
		wait(locatorExit);
		tap(locatorExit);
	}

	public void tapOnMenu() {
		wait(locatorMenu);
		tap(locatorMenu);
	}

	// Methods info
	public void tapOnInfo() {
		wait(locatorInfo);
		tap(locatorInfo);
	}

	public Boolean isInfoVisible() {
		wait(locatorInfoVisible);
		if (isDisplayed(locatorInfoVisible)) {
			System.out.println("The information was displayed correctly");
			return true;
		} else {
			System.out.println("The information was'nt displayed correctly");
			return false;
		}
	}

	// Methods see schedule
	public void tapOnSeeSchedule() {
		wait(locatorSeeSchedule);
		tap(locatorSeeSchedule);
	}

	public void tapOnSunday() {
		wait(locatorSunday);
		tap(locatorSunday);
	}

	public void tapOnAcceptBtn() {
		wait(locatorAceppt);
		tap(locatorAceppt);
	}

	public void tapOnHabVieja() {
		wait(locatorHabVieja);
		tap(locatorHabVieja);
	}

	public void tapOnObispo() {
		wait(locatorObispo);
		tap(locatorObispo);
	}

	public Boolean isFilterScheduleWorking() {

		wait(locatorCalendar);

		String textToSearch = "domingo";
		String textWhereImGoingToSearch = getText(locatorCalendar);
		Boolean thereIsText = textWhereImGoingToSearch.toLowerCase().contains(textToSearch.toLowerCase());

		if (thereIsText) {

			System.out.println("The word: '" + textToSearch + "' was finded on the follow text: '"
					+ textWhereImGoingToSearch + "'");
			return true;

		} else {

			System.out.println("The word: '" + textToSearch + "' was'nt finded on the follow text: '"
					+ textWhereImGoingToSearch + "'");
			return false;
		}
	}
}
