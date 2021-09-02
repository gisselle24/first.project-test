package pages;

import java.util.List;

import org.openqa.selenium.By;

import baseClass.BaseClass;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class AccountInterestCalculation_Page extends BaseClass {

	// Locators for allow access to the application
	By allowAccess = By.id("com.android.packageinstaller:id/permission_allow_button");
	By buttonNext = By.id("cu.cesol.bancometropolitano:id/btn_next");

	// Locators
	By accountInterestLocator = MobileBy.xpath("//android.widget.TextView[@text='Cálculo del interés de mi cuenta']");

	By savingModeLocator = MobileBy.xpath("//android.widget.TextView[@text='Seleccione la modalidad de ahorro']");
	By sightSavingsLocator = MobileBy.xpath("//android.widget.TextView[@text='Ahorro a la vista']");
	By balanceLocator = MobileBy.id("cu.cesol.bancometropolitano:id/etcantidad_saldo");
	By currencyTypeLocator = MobileBy.xpath("//android.widget.TextView[@text='Tipo de moneda']");
	By cupLocator = MobileBy.xpath("//android.widget.TextView[@text='CUP']");
	By initialDateLocator = MobileBy.id("cu.cesol.bancometropolitano:id/calendario_fi");
	By expirationDateLocator = MobileBy.id("cu.cesol.bancometropolitano:id/calendario_fv");
	By calculateLocator = MobileBy.id("cu.cesol.bancometropolitano:id/btncalcular");
	By resultLocator = MobileBy.id("cu.cesol.bancometropolitano:id/pn_intereses");
	By calendarInitialDateLocator = MobileBy.id("cu.cesol.bancometropolitano:id/mdtp_animator");
	By okLocator = MobileBy.id("cu.cesol.bancometropolitano:id/mdtp_ok");
	By viewAnimatorLocator = MobileBy.id("cu.cesol.bancometropolitano:id/mdtp_animator");
	By anoLocator = MobileBy.id("cu.cesol.bancometropolitano:id/mdtp_date_picker_year");
	By textAlertLocator = MobileBy.id("cu.cesol.bancometropolitano:id/textoalerta");

	By extractionsLocator = MobileBy.xpath("//android.widget.TextView[@text='Extracciones']");
	By foundFormationLocator = MobileBy.xpath("//android.widget.TextView[@text='Cuentas de formación de fondo']");
	By oneYearLocator = MobileBy.xpath("//android.widget.TextView[@text='1 año']");

	public AccountInterestCalculation_Page(AndroidDriver driver) {
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

	public void searchElementAccountInteresOnMenu() {
		while (isDisplayed(accountInterestLocator) == false) {
			scroll();
		}
		tap(accountInterestLocator);
	}

	// Saving Mode
	public Boolean isSavingModeVisible() {
		wait(savingModeLocator);
		if (isDisplayed(savingModeLocator)) {
			return true;
		}
		return false;
	}

	// Sight Savings Methods
	public void tapSightSavings() {
		wait(savingModeLocator);
		tap(savingModeLocator);

		wait(sightSavingsLocator);
		tap(sightSavingsLocator);
	}

	public void sendImport(String n) {
		wait(balanceLocator);
		type(n, balanceLocator);
	}

	public void sendImportEmty() {
		wait(balanceLocator);
		type("", balanceLocator);
	}

	public MobileElement selectExpirationDate() {
		wait(viewAnimatorLocator);
		MobileElement parentElement = findElement(viewAnimatorLocator);
		List<MobileElement> childElements = findElementsByClassName(parentElement, "android.widget.TextView");
		MobileElement nextElement = null;

		for (int i = 0; i < childElements.size(); i++) {
			if (childElements.get(i).getAttribute("content-desc").contains("seleccionado")) {
				nextElement = childElements.get(i + 1);
				break;
			}
		}
		return nextElement;
	}

	public void fillFields() {
		wait(currencyTypeLocator);
		tap(currencyTypeLocator);

		wait(cupLocator);
		tap(cupLocator);

		wait(initialDateLocator);
		tap(initialDateLocator);

		wait(okLocator);
		tap(okLocator);

		wait(expirationDateLocator);
		tap(expirationDateLocator);

		wait(anoLocator);
		tap(anoLocator);

		MobileElement nextAno = selectExpirationDate();
		tap(nextAno);

		wait(okLocator);
		tap(okLocator);
	}

	public void tapBtnCalculate() {
		while (isDisplayed(calculateLocator) == false) {
			scroll();
		}
		tap(calculateLocator);
	}

	public String getErrorMessage() {
		wait(textAlertLocator);
		return getText(textAlertLocator);
	}

	public String getResult() {
		wait(resultLocator);
		return getText(resultLocator);
	}

	// Found Formation Accounts Methods
	public void TapFoundFormation() {
		wait(savingModeLocator);
		tap(savingModeLocator);

		wait(foundFormationLocator);
		tap(foundFormationLocator);
	}

	public void fillFieldsFoundFormation() {
		wait(extractionsLocator);
		tap(extractionsLocator);

		wait(oneYearLocator);
		tap(oneYearLocator);

		wait(initialDateLocator);
		tap(initialDateLocator);

		wait(okLocator);
		tap(okLocator);

		wait(expirationDateLocator);
		tap(expirationDateLocator);

		wait(anoLocator);
		tap(anoLocator);

		MobileElement nextAno = selectExpirationDate();
		tap(nextAno);

		wait(okLocator);
		tap(okLocator);
	}

	public void termDeposit() {

	}

	public void certificatesOfDeposit() {

	}

}
