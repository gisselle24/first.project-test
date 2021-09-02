package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Home_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Home
	By locatorMenuHome = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Inicio\")"));

	// Locators Map
	By locatorButtonMap = By.id("cu.cesol.bancometropolitano:id/mapa");
	By locatorMap = By.id("cu.cesol.bancometropolitano:id/mapView");

	// Locators Language
	By locatorLanguage = By.id("cu.cesol.bancometropolitano:id/action_change_idiom_en");
	By locatorLang_es = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/quienes\").text(\"¿Quiénes somos?\")"));
	By locatorLang_en = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/quienes\").text(\"Who are we?\")"));

	// Locators Read More
	By locatorID = MobileBy.id("cu.cesol.bancometropolitano:id/read");

	// Locators Favorities
	By locatorFavorite = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/favoritos\").text(\"FAVORITOS\")"));
	By locatorFavoriteVisibleATM = MobileBy.xpath(
			"//android.widget.TextView[contains(@resource-id,'cu.cesol.bancometropolitano:id/tv_direccion_fav') and @text='5ta Avenida y 112']");
	By locatorFavoriteVisibleBankBranches = MobileBy.xpath(
			"//android.widget.TextView[contains(@resource-id,'cu.cesol.bancometropolitano:id/tv_identificador_suc') and @text='Palacio']");
	By locatorATMHomePage = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(0).clickable(false).text(\"CAJEROS\")"));

	public Home_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// To acces to app
	public void allowAccess() {
		tap(allowAccess);
	}

	public void tapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	// Testing Map
	public void tapOnHomeMenu() {
		wait(locatorMenuHome);
		tap(locatorMenuHome);
	}

	public void tapOnIconShowMap() {
		wait(locatorButtonMap);
		tap(locatorButtonMap);
	}

	public Boolean isTheMapVisible() {

		wait(locatorMap);

		if (isDisplayed(locatorMap)) {

			return true;

		} else {

			return false;
		}
	}

	// Testing language
	public void changeLanguage() {
		wait(locatorLanguage);
		tap(locatorLanguage);
	}

	public Boolean isHomePageVisible_en() {
		
		wait(locatorLang_en);
		
		if (isDisplayed(locatorLang_en)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}

	public Boolean isHomePageVisible_es() {
		
		wait(locatorLang_es);
		
		if (isDisplayed(locatorLang_es)) {
			
			return true;
			
		} else {
			
			return false;
		}		
	}

	// Testing Read More
	public void Read_More() {
		wait(locatorID);
		tap(locatorID);
	}

	// Testing Favorities
	public void tapOnFavoritiesHome() {
		wait(locatorFavorite);
		tap(locatorFavorite);
	}

	public Boolean isFavoritiesElementsVisibleBankBranches() {

		wait(locatorFavoriteVisibleBankBranches);

		if (isDisplayed(locatorFavoriteVisibleBankBranches)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
	
	public Boolean isFavoritiesElementsVisibleATM() {

		wait(locatorFavoriteVisibleATM);

		if (isDisplayed(locatorFavoriteVisibleATM)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}

	public void TapOnATMHomePage() {
		wait(locatorATMHomePage);
		tap(locatorATMHomePage);
	}
}
