package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;

public class Bonus_Page extends BaseClass {

	// Locators Allows
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locator Bonus Page
	By locatorMobileMenuBonus = MobileBy.xpath("//android.widget.TextView[@text='Bonificaciones']");
	By locatorCheckBonusPage = MobileBy
			.AndroidUIAutomator(String.format("new UiSelector().index(1).clickable(false).text(\"Bonificaciones\")"));

	public Bonus_Page(AndroidDriver driver) {
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
	public void searchElementBonus_PageOnMenu() {
		while (isDisplayed(locatorMobileMenuBonus) == false) {
			scroll();
		}
		tap(locatorMobileMenuBonus);
	}
	
	/*public void scrollTEST() {
		while (isDisplayed(locatorMobileMenuBonus) == false) {
			scrollTest(locatorMobileMenuBonus);
		}
		tap(locatorMobileMenuBonus);
	}*/

	// Checking if the page opened well
	public Boolean IsBonusPagOpeningWell() {
		
		wait(locatorCheckBonusPage);
		
		if (isDisplayed(locatorCheckBonusPage)) {
			
			return true;
		}
		
		return false;
	}

}
