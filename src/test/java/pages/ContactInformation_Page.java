package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;

import baseClass.BaseClass;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ContactInformation_Page extends BaseClass {

	// Locators for allow access to the application
	@AndroidFindBy(id = "com.android.packageinstaller:id/permission_allow_button")
	private MobileElement allowAccess;
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/btn_next")
	private MobileElement buttonNext;

	// Locator Main Menu
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Información de contacto']")
	private MobileElement locatorContactInfo;

	// Testing Pone 1
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/telefonocontacto1")
	private MobileElement locatorPhone1;
	@AndroidFindBy(id = "com.samsung.android.dialer:id/digits")
	private MobileElement locatorAppDialing;

	// Testing Phone 2
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/telefonocontacto2")
	private MobileElement locatorPhone2;

	// Testing Clients Atention
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/atencion_cliente")
	private MobileElement locatorClientAtention;
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/tvtitle")
	private MobileElement locatorClientAtentionInfo;

	// Testing Email
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/email")
	private MobileElement locatorEmail;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Gmail']")
	private MobileElement locatorEmailIcon;
	@AndroidFindBy(id = "com.google.android.gm:id/to")
	private MobileElement locatorEmailAddress;

	// Testing LinkedIn
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/linkedin")
	private MobileElement locatorLinkedIn;
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/linkedin")
	private MobileElement locatorLinkedInTitle;

	// Testing Youtube
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/youtube")
	private MobileElement locatorYoutube;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='YouTube']")
	private MobileElement locatorYoutubetest;

	// Testing Twitter
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/twitter")
	private MobileElement locatorTwitter;
	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private MobileElement locatorTwittertest;

	// Testing Facebook
	@AndroidFindBy(id = "cu.cesol.bancometropolitano:id/facebook")
	private MobileElement locatorFacebook;
	@AndroidFindBy(id = "com.android.chrome:id/url_bar")
	private MobileElement locatorFacebooktest;

	public ContactInformation_Page(AndroidDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	public void allowAccess() {
		tap(allowAccess);
	}

	public void TapOnNext() {
		wait(buttonNext);
		tap(buttonNext);
	}

	public void goToContactInformation() {
		while (isDisplayed(locatorContactInfo) == false) {
			scroll();
		}
		tap(locatorContactInfo);
	}

	public Boolean testPhone1() {
		wait(locatorPhone1);
		tap(locatorPhone1);

		wait(locatorAppDialing);
		if (isDisplayed(locatorAppDialing)) {
			return true;
		}
		return false;
	}

	public Boolean testPhone2() {
		wait(locatorPhone2);
		tap(locatorPhone2);

		wait(locatorAppDialing);
		if (isDisplayed(locatorAppDialing)) {
			return true;
		}
		return false;
	}

	public Boolean testClientsAtention() {
		wait(locatorClientAtention);
		tap(locatorClientAtention);

		wait(locatorClientAtentionInfo);
		if (isDisplayed(locatorClientAtentionInfo)) {
			return true;
		}
		return false;
	}

	public String testEmail() {
		String text = "";

		wait(locatorEmail);
		tap(locatorEmail);

		wait(locatorEmailIcon);
		tap(locatorEmailIcon);

		wait(locatorEmailAddress);
		if (isDisplayed(locatorEmailAddress)) {
			text = getText(locatorEmailAddress);
		} else {
			text = "Email client is'nt open";
		}
		return text;
	}

	public Boolean testLinkedIn() {
		Boolean result = false;
		int tmp = 0;

		wait(locatorLinkedIn);
		tap(locatorLinkedIn);

		while (tmp < 10) {
			try {
				isDisplayed(locatorLinkedInTitle);
				result = true;
				break;
			} catch (StaleElementReferenceException e) {
				tmp += 2;
			}
		}
		return result;
	}

	public String testYoutube() {
		String text = "";
		int temp = 0;

		wait(locatorYoutube);
		tap(locatorYoutube);

		while (temp < 10) {
			try {
				isDisplayed(locatorYoutubetest);
				text = getText(locatorYoutubetest);
			} catch (StaleElementReferenceException e) {
			}
			temp += 2;
		}
		return text;
	}
	
	public String testTwitter() {
		String text = "";
		int temp = 0;

		wait(locatorTwitter);
		tap(locatorTwitter);

		while (temp < 10) {
			try {
				isDisplayed(locatorTwittertest);
				text = getText(locatorTwittertest);
			} catch (StaleElementReferenceException e) {
			}
			temp += 2;
		}
		return text;
	}
	
	public String testFacebook() {
		String text = "";
		int temp = 0;

		wait(locatorFacebook);
		tap(locatorFacebook);

		while (temp < 10) {
			try {
				isDisplayed(locatorFacebooktest);
				text = getText(locatorFacebooktest);
			} catch (StaleElementReferenceException e) {
			}
			temp += 2;
		}
		return text;
	}
}
