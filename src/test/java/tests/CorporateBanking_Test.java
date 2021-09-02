package tests;

import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.BillsOfExchange_Page;
import pages.CreditsLines_Page;
import pages.CurrentAccountsCorporateBanking_Page;
import pages.CurrentAccountsTCP_Page;
import pages.Financing_Page;
import pages.Loans_Page;
import pages.LocalCreditLetter_Page;
import pdfReporter.JyperionListener;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

@Listeners(JyperionListener.class)
public class CorporateBanking_Test {
	AndroidDriver<MobileElement> driver;
	Loans_Page prestamo;
	CreditsLines_Page creditLine;
	BillsOfExchange_Page billExchange;
	LocalCreditLetter_Page localCreditLetter;
	CurrentAccountsCorporateBanking_Page currentAccounts;
	Financing_Page financing;
	CurrentAccountsTCP_Page currentAccountTCP;

	@BeforeMethod
	public void beforeClass() throws MalformedURLException {
		prestamo = new Loans_Page(driver);
		driver = (AndroidDriver<MobileElement>) prestamo.banMetDriverConnection();
		prestamo.allowAccess();
		prestamo.allowAccess();
		prestamo.tapOnNext();
		prestamo.tapOnNext();
		prestamo.tapOnNext();
		prestamo.tapOnNext();
	}

	@Test(enabled = true, priority = 1)
	public void goPrestamoPage() {
		// PageFactory is used to find elements with @FindBy specified
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), prestamo);
		prestamo.searchElementCorporateBanking_PageOnMenu();
		assertTrue(prestamo.isPrestamoPagOpeningWell());
		assertTrue(prestamo.isInversionesPagOpeningWell());
	}

	@Test(enabled = true, priority = 2)
	public void goLineaCreditoPage() {
		creditLine = new CreditsLines_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), creditLine);
		creditLine.searchElementCorporateBanking_PageOnMenu();
		assertTrue(creditLine.isCreditLinesPagOpeningWell());
	}

	@Test(enabled = true, priority = 3)
	public void goBillsOfExchangePage() {
		billExchange = new BillsOfExchange_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), billExchange);
		billExchange.searchElementCorporateBanking_PageOnMenu();
		assertTrue(billExchange.isBillsOfExchangePagOpeningWell());
	}

	@Test(enabled = true, priority = 4)
	public void goLocalCreditLetterPage() {
		localCreditLetter = new LocalCreditLetter_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), localCreditLetter);
		localCreditLetter.searchElementCorporateBanking_PageOnMenu();
		assertTrue(localCreditLetter.isLocalCreditLetterPagOpeningWell());
	}

	@Test(enabled = true, priority = 5)
	public void goCurrentAccountsPage() {
		currentAccounts = new CurrentAccountsCorporateBanking_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), currentAccounts);
		currentAccounts.searchElementCorporateBanking_PageOnMenu();
		assertTrue(currentAccounts.isCuentasCorrientesPagOpeningWell());
	}
	
	@Test(enabled = true, priority = 6)
	public void goFinancingPage() {
		financing = new Financing_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), financing);
		financing.searchElementCorporateBanking_PageOnMenu();
		assertTrue(financing.isFinancingPagOpeningWell());
	}
	
	@Test(enabled = true, priority = 7)
	public void goCurrentAccountsTCPPage() {
		currentAccountTCP = new CurrentAccountsTCP_Page(driver);
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), currentAccountTCP);
		currentAccountTCP.searchElementCorporateBanking_PageOnMenu();
		assertTrue(currentAccountTCP.isCurrentAccountsTCPPagOpeningWell());
	}

	@AfterMethod
	public void afterClass() {
		driver.quit();
	}

}
