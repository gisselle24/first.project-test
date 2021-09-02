package pages;

import org.openqa.selenium.By;

import baseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CurrentAccountsCorporateBanking_Page extends BaseClass {

	// Locators Allows
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Corporate Banking Page
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Banca Corporativa']")
	private MobileElement locatorBancaCorporativa;

	// Other Locators
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Cuentas corrientes']")
	private MobileElement locatorCuentasCorrientes;

	public CurrentAccountsCorporateBanking_Page(AndroidDriver driver) {
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
	public Boolean isCuentasCorrientesPagOpeningWell() {

		wait(locatorCuentasCorrientes);
		tap(locatorCuentasCorrientes);

		if (isDisplayed(locatorCuentasCorrientes)) {

			return true;
		}

		return false;
	}

}
