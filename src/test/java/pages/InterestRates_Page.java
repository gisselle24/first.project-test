package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class InterestRates_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Interest Rate Page
	By locatorMobileMenuInterestRate = MobileBy.xpath("//android.widget.TextView[@text='Tasas de Interés']");

	By locatorCheckIterestRate = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(1).clickable(false).text(\"Tasas de Interés\")"));

	public InterestRates_Page(AndroidDriver driver) {
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

	// Search on menu
	public void searchElementSecurityMeasures_PageOnMenu() {
		while (isDisplayed(locatorMobileMenuInterestRate) == false) {
			scroll();
		}
		tap(locatorMobileMenuInterestRate);
	}

	// Check if page opened well
	public Boolean isInterestRatePagOpeningWell() {
		
		wait(locatorCheckIterestRate);
		
		if (isDisplayed(locatorCheckIterestRate)) {
			
			return true;
		}
		
		return false;
	}
}
