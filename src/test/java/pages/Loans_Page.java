package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import baseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class Loans_Page extends BaseClass {

	// Locators Allows
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Corporate Banking Page
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Banca Corporativa']")
	private MobileElement locatorBancaCorporativa;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Préstamos']")
	private MobileElement locatorPrestamo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CAPITAL DE TRABAJO']")
	private MobileElement locatorCapitalDeTrabajo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='INVERSIONES']")
	private MobileElement locatorInversiones;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Préstamo para capital de trabajo']")
	private MobileElement locatorPrestamoCapitalTrabajo;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Préstamos para inversiones']")
	private MobileElement locatorPrestamoInversiones;

	public Loans_Page(AndroidDriver driver) {
		super(driver);		
		// TODO Auto-generated constructor stub
	}

	// Go to pag
	public void allowAccess() {
		tap(allowAccess);
	}

	public void tapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	// Search on Menu
	public void searchElementCorporateBanking_PageOnMenu() {
		while (isDisplayed(locatorBancaCorporativa) == false) {
			scroll();
		}
		tap(locatorBancaCorporativa);
	}

	// Check page opened well
	public Boolean isPrestamoPagOpeningWell() {

		wait(locatorPrestamo);
		tap(locatorPrestamo);

		if (isDisplayed(locatorCapitalDeTrabajo)) {

			return true;
		}

		return false;
	}

	public Boolean isInversionesPagOpeningWell() {

		wait(locatorInversiones);
		tap(locatorInversiones);

		if (isDisplayed(locatorPrestamoInversiones)) {

			return true;
		}

		return false;
	}
}
