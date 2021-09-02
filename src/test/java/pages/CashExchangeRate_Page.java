package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class CashExchangeRate_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Menu Change and Exchange
	By locatorMobileMenuChangeAndExchange = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Tasa de cambio de efectivo en sucursales\")"));

	By locatorVerifyEntryToChangeAndExchange = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/flbcalendario\")"));
	By locatorBtnActualizar = MobileBy.id("cu.cesol.bancometropolitano:id/bt_getactualizacion");

	public CashExchangeRate_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void allowAccess() {
		tap(allowAccess);
	}

	public void tapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	public void searchElementInteresCreditOnMenu() {
		while (isDisplayed(locatorMobileMenuChangeAndExchange) == false) {
			scroll();
		}
		tap(locatorMobileMenuChangeAndExchange);
	}

	public Boolean isCashExhangeRatePageOpeningWell() {
		
		wait(locatorVerifyEntryToChangeAndExchange);
		
		if (isDisplayed(locatorVerifyEntryToChangeAndExchange)) {
			
			return true;
		}
		
		return false;
	}

	public void tapBtnUpdate() {
		tap(locatorBtnActualizar);
	}

}
