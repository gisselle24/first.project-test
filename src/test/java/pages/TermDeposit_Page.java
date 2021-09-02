package pages;

import org.openqa.selenium.By;
import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class TermDeposit_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Consumer Banking Page
	By locatorMobileMenuConsumerBanking = MobileBy.xpath("//android.widget.TextView[@text='Banca Personal']");
	By locatorTermDeposit = MobileBy.xpath("//android.widget.TextView[@text='Depósitos a plazo fijo']");
	By locatorImInTermDeposit = MobileBy.xpath("//android.widget.TextView[@text='Depósitos a plazo fijo']");

	public TermDeposit_Page(AndroidDriver driver) {
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
	public void searchElementConsumerBanking_PageOnMenu() {
		while (isDisplayed(locatorMobileMenuConsumerBanking) == false) {
			scroll();
		}
		tap(locatorMobileMenuConsumerBanking);
	}

	// Check page opened well
	public Boolean isTermDepositPagOpeningWell() {

		while (isDisplayed(locatorTermDeposit) == false) {
			scroll();
		}

		tap(locatorTermDeposit);

		wait(locatorImInTermDeposit);
		if (isDisplayed(locatorImInTermDeposit)) {

			return true;
		}

		return false;
	}	
}
