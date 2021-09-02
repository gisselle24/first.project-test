package pages;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class CreditsInterest_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Interests Credit Menu
	By locatorMobileMenuIntereCredito = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Interés para créditos\")"));

	// locators Page interest for credits
	By locatorbtnCalcular = By.id("cu.cesol.bancometropolitano:id/btncalcular");
	By locatorTextBoxImporte = MobileBy.id("cu.cesol.bancometropolitano:id/etcantidad_importe");
	By locatorSelectBoxMeses = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(0).clickable(false).text(\"Meses\")"));
	By locatorShowBoxTasaDeInteres = MobileBy.id("cu.cesol.bancometropolitano:id/pn_tasa_interes");
	By locatorShowBoxCuotaMensual = MobileBy.id("cu.cesol.bancometropolitano:id/pn_mensualidad");
	By locatorShowBoxDeudaTotal = MobileBy.id("cu.cesol.bancometropolitano:id/pn_deuda");
	By locatorShowBoxIntereses = MobileBy.id("cu.cesol.bancometropolitano:id/pn_intereses");
	By locatorErrorMessage = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/alerta\").text(\"El importe debe ser mayor que $1000.00 CUP\")"));

	// Locators Select Months
	By locatorSelectMeses_3 = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(1).clickable(true).text(\"3\")"));
	By locatorSelectMeses_3_SinExpandir = MobileBy.AndroidUIAutomator(String
			.format("new UiSelector().index(0).clickable(false).className(\"android.widget.TextView\").text(\"3\")"));

	By locatorSelectMeses_36 = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(5).clickable(true).text(\"36\")"));
	By locatorSelectMeses_36_SinExpandir = MobileBy.AndroidUIAutomator(String
			.format("new UiSelector().index(0).clickable(false).className(\"android.widget.TextView\").text(\"36\")"));
	By locatorSelectMeses_120 = MobileBy.AndroidUIAutomator(String
			.format("new UiSelector().index(12).clickable(true).className(\"android.widget.TextView\").text(\"120\")"));
	//By locatorSelectMeses_120 = MobileBy.xpath("//android.widget.TextView[@text='120']");
	//By locatorSelectMeses_120_SinExpandir = MobileBy.AndroidUIAutomator(String.format("new UiSelector().index(0).clickable(false).className(\"android.widget.TextView\").text(\"120\")"));

	// Locators information
	By locatorInfo = MobileBy.id("cu.cesol.bancometropolitano:id/bar_info_1");
	By locatorCredits = MobileBy.id("cu.cesol.bancometropolitano:id/tvtitle");

	public CreditsInterest_Page(AndroidDriver driver) {
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

	public Boolean isBtnCalculateVisible() {

		wait(locatorbtnCalcular);

		if (isDisplayed(locatorbtnCalcular)) {

			return true;
		}

		return false;
	}

	public void sendKeys(String n) {
		wait(locatorTextBoxImporte);
		type(n, locatorTextBoxImporte);
	}

	public void tapBtnCalculate() {
		tap(locatorbtnCalcular);
	}

	public void numberOfMonth36() {
		tap(locatorSelectBoxMeses);
		tap(locatorSelectMeses_36);
	}

	public void numberOfMonth120() {
		tap(locatorSelectMeses_36_SinExpandir);
		wait(locatorSelectMeses_120);
		tap(locatorSelectMeses_120);
	}

	/*
	 * public void numberOfMonthMiddle() { tap(locatorSelectMeses_120_SinExpandir);
	 * tap(locatorSelectMeses_36); }
	 */

	public void searchElementInteresCreditOnMenu() {
		while (isDisplayed(locatorMobileMenuIntereCredito) == false) {
			scroll();
		}
		tap(locatorMobileMenuIntereCredito);
	}

	public String getCalulateBtnText() {
		return getText(locatorbtnCalcular);
	}

	public String getInterestRateText() {
		return getText(locatorShowBoxTasaDeInteres);
	}

	public String getMonthlyFeeText() {
		return getText(locatorShowBoxCuotaMensual);
	}

	public String getTotalDebtText() {
		return getText(locatorShowBoxDeudaTotal);
	}

	public String getInterestText() {
		return getText(locatorShowBoxIntereses);
	}

	public String getErrorMessageText() {
		return getText(locatorErrorMessage);
	}

	public void tapOnInfo() {
		wait(locatorInfo);
		tap(locatorInfo);
	}

	public Boolean isWorkingInfo() {

		wait(locatorCredits);

		if (isDisplayed(locatorCredits)) {

			return true;
		}

		return false;
	}
}
