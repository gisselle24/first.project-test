package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class BankFees_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Bank Fees Page
	By locatorMobileMenuBankFees = MobileBy
			.xpath("//android.widget.TextView[@text='Tarifas de comisiones y otros cargos']");
	By locatorCheckBankFeesPage = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().text(\"TARIFAS DE COMISIONES Y OTROS CARGOS\")"));

	public BankFees_Page(AndroidDriver driver) {
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
	public void searchElementBankFees_PageOnMenu() {
		while (isDisplayed(locatorMobileMenuBankFees) == false) {
			scroll();
		}
		tap(locatorMobileMenuBankFees);
	}

	// Check if page opened well
	public Boolean IsBankFeesPagOpeningWell() {
		
		wait(locatorCheckBankFeesPage);
		
		if (isDisplayed(locatorCheckBankFeesPage)) {
			
			return true;
			
		} else {
			
			return false;
		}
	}
}
