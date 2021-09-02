package pages;

import org.openqa.selenium.By;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ATMs_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/btn_next")
	private MobileElement buttonNext;

	// Locator to access to the Main Menu ATMs
	By locatorMenuATM = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Cajeros Automáticos\")"));

	// Locators
	By locatorIconSearch = MobileBy.id("cu.cesol.bancometropolitano:id/action_search");
	By locatorSearchATM = MobileBy.id("cu.cesol.bancometropolitano:id/edt_tool_search");
	By locatorIconMap = MobileBy.id("cu.cesol.bancometropolitano:id/ivloc_caj");
	By locatorMap = MobileBy.id("cu.cesol.bancometropolitano:id/mapView");

	// Locators Regla
	By locatorRegla = MobileBy.id("cu.cesol.bancometropolitano:id/tv_direccion_caj");
	By locatorDetailsReglaIcon = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/iviewmapa\")"));
	By locatorDetailsReglaMap = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/mapView\")"));

	// Locators Favorite
	By locatorDetailsReglaFavorite = MobileBy.AndroidUIAutomator(String
			.format("new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/ivfav\")"));
	By locatorfavorite = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/tv_nombre_munic_caj\")"));
	By locator5taAvenida = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/tv_direccion_caj\").text(\"5ta Avenida y 112\")"));
	By locatorExit = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/btnPositive\").text(\"CERRAR\")"));
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/iv_delete_fav")
	private MobileElement locatorDelete;

	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/snackbar_action")
	private MobileElement locatorDeleteYes;

	// Locator Home Page
	By locatorMenuHomePage = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(0).clickable(true).resourceId(\"\").text(\"\")"));

	// Locators view schedule
	By locatorBtnSchedule = MobileBy.id("cu.cesol.bancometropolitano:id/filter_cajero");
	By locatorFilter = MobileBy.xpath("//android.widget.RadioButton[@text='Cajeros automáticos recicladores']");
	By locatorAccept = MobileBy.xpath("//android.widget.TextView[@text='ACEPTAR']");
	By locatorPlaya = MobileBy.xpath("//android.widget.TextView[@text='Playa']");
	By locatorPlayaAdress = MobileBy.xpath("//android.widget.TextView[@text='Avenida 41 esquina a 46  ']");
	By locatorIdentifier = MobileBy.id("cu.cesol.bancometropolitano:id/identificador1");

	public ATMs_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void allowAccess() {
		tap(allowAccess);
	}

	public void TapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	// Testing search ATMs
	public void tapOnATMMenu() {
		wait(locatorMenuATM);
		tap(locatorMenuATM);
	}

	public void tapOnSearchIcon() {
		wait(locatorIconSearch);
		tap(locatorIconSearch);
	}

	public void typeText() {
		wait(locatorSearchATM);
		type("regla", locatorSearchATM);
	}

	public void tapOnIconShowMap() {
		wait(locatorIconMap);
		tap(locatorIconMap);
	}

	public Boolean isTheMapVisible() {

		wait(locatorMap);

		if (isDisplayed(locatorMap)) {

			return true;

		} else {

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

			return true;

		} else {

			return false;
		}

	}

	// Add sucursal to favorites
	public void addSucursalToFavorities() {
		wait(locatorDetailsReglaFavorite);
		tap(locatorDetailsReglaFavorite);
	}

	// Delete ATM from favorites
	public void deleteATMfromFavorities() {
		wait(locatorDelete);
		tap(locatorDelete);

		wait(locatorDeleteYes);
		tap(locatorDeleteYes);
	}

	public void tapOnPlaya() {
		wait(locatorfavorite);
		tap(locatorfavorite);
	}

	public void tapOn5taAvenida() {
		wait(locator5taAvenida);
		tap(locator5taAvenida);
	}

	// Methods Home Page
	public void tapOnExit() {
		wait(locatorExit);
		tap(locatorExit);
	}

	public void tapOnMenu() {
		wait(locatorMenuHomePage);
		tap(locatorMenuHomePage);
	}

	// Testing view Schedule
	public void goToTestFilterSchedule() {

		wait(locatorBtnSchedule);
		tap(locatorBtnSchedule);

		wait(locatorFilter);
		tap(locatorFilter);

		wait(locatorAccept);
		tap(locatorAccept);

		wait(locatorPlaya);
		tap(locatorPlaya);

		wait(locatorPlayaAdress);
		tap(locatorPlayaAdress);
	}

	public Boolean isFilterScheduleWorking() {

		wait(locatorIdentifier);

		String wordToSearch = "cajero automático reciclador";
		String textWhereImGoingToSearch = getText(locatorIdentifier);
		Boolean isThereText = textWhereImGoingToSearch.toLowerCase().contains(wordToSearch.toLowerCase());

		if (isThereText) {

			System.out.println("The word: '" + wordToSearch + "' was finded on the follow text: '"
					+ textWhereImGoingToSearch + "'");
			return true;

		} else {

			System.out.println("The word: '" + wordToSearch + "' was'nt finded on the follow text: '"
					+ textWhereImGoingToSearch + "'");
			return false;
		}
	}
}
