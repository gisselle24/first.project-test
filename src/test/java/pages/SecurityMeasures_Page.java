package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

public class SecurityMeasures_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locators Menu Security Measures
	By locatorMobileSecurityMeasuresMenu_Page = MobileBy.xpath("//android.widget.TextView[@text='Medidas de Seguridad']");

	// Locator to check page opened well
	By locatorCheckEntryToSecurityMeasures_Page = MobileBy.AndroidUIAutomator(
			String.format("new UiSelector().index(1).clickable(false).text(\"Medidas de Seguridad\")"));

	public SecurityMeasures_Page(AndroidDriver driver) {
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
	public void searchElementSecurityMeasures_PageOnMenu() throws InterruptedException {
		wait(locatorMobileSecurityMeasuresMenu_Page);		
		tap(locatorMobileSecurityMeasuresMenu_Page);
	}	

	// Check if pag opened well
	public Boolean isSecurityMeasuresPagOpeningWell() {

		wait(locatorCheckEntryToSecurityMeasures_Page);

		if (isDisplayed(locatorCheckEntryToSecurityMeasures_Page)) {

			return true;
		}

		return false;
	}
}
