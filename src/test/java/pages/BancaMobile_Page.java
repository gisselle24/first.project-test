package pages;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class BancaMobile_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator to access to the Main Menu Banca Mobile
	By locatorBancaMobile = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(false).resourceId(\"cu.cesol.bancometropolitano:id/material_drawer_name\").text(\"Banca Móvil\")"));

	// Locators Banca Movil Page Descargar PDF
	By locatorPDF = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/icon_descarga\")"));
	By locatorPDF_Accept = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/bt_aceptar\").text(\"ACEPTAR\")"));
	By locatorPDF_Exit = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/bt_cerrar\").text(\"CERRAR\")"));

	// Locators Banca Movil Page Descargar Transfermovil
	By locatorTransfermovil_Start = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(1).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/buttonThirteen\").text(\"INICIAR\")"));
	By locatorTransfermovil_Exit = MobileBy.AndroidUIAutomator(String.format(
			"new UiSelector().index(0).clickable(true).resourceId(\"cu.cesol.bancometropolitano:id/buttonCancelThirteen\").text(\"CERRAR\")"));

	public BancaMobile_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	// Access to the app
	public void allowAccess() {
		tap(allowAccess);
	}

	public void tapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	// Enter to Banca Mobile
	public void tapOnBancaMobile() {
		wait(locatorBancaMobile);
		tap(locatorBancaMobile);
	}

	// Testing PDF
	public void tapOnPDF() {
		wait(locatorPDF);
		tap(locatorPDF);
	}

	public void tapOnPDF_Accept() {
		wait(locatorPDF_Accept);
		tap(locatorPDF_Accept);
	}

	public void tapOnPDF_Exit() {
		wait(locatorPDF_Exit);
		tap(locatorPDF_Exit);
	}

	public Boolean isPDF_ExitVisible() {

		wait(locatorPDF_Exit);

		if (isDisplayed(locatorPDF_Exit)) {

			return true;
		}

		return false;
	}

	// Testing Transfermovil
	public void tapTransfermovil_Start() {
		while (isDisplayed(locatorTransfermovil_Start) == false) {
			scroll();
		}
		tap(locatorTransfermovil_Start);
	}

	public void tapTransfermovil_Exit() {
		wait(locatorTransfermovil_Exit);
		tap(locatorTransfermovil_Exit);
	}	
}
