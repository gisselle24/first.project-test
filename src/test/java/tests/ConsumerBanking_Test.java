package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.AcconutInUSD_Page;
import pages.CertificatesDeposit_Page;
import pages.CreditToNaturalPersons_Page;
import pages.CurrentAccounts_Page;
import pages.DemandSaving_Page;
import pages.FoundFormation_Page;
import pages.TermDeposit_Page;
import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class ConsumerBanking_Test {

	private AndroidDriver driver;
	TermDeposit_Page term;
	CertificatesDeposit_Page certificate;
	DemandSaving_Page demand;
	CurrentAccounts_Page current;
	FoundFormation_Page found;
	CreditToNaturalPersons_Page credit;
	AcconutInUSD_Page account;

	@BeforeMethod
	public void beforeMethodConsumerBanking_Page() throws MalformedURLException {
		term = new TermDeposit_Page(driver);
		driver = (AndroidDriver) term.banMetDriverConnection();
		term.allowAccess();
		term.allowAccess();
		term.tapOnNext();
		term.tapOnNext();
		term.tapOnNext();
		term.tapOnNext();
	}

	@Test(enabled = true, priority = 0)
	public void isTermDepositPagOpeningWell() {
		term.searchElementConsumerBanking_PageOnMenu();
		assertTrue(term.isTermDepositPagOpeningWell(), "Term Deposit page was'nt opened well");
	}

	@Test(enabled = true, priority = 1)
	public void isCertificatesOfDepositPagOpeningWell() {
		certificate = new CertificatesDeposit_Page(driver);
		certificate.searchElementConsumerBanking_PageOnMenu();
		assertTrue(certificate.isCertificatesOfDepositPagOpeningWell(),
				"Certificates of Deposit page was'nt opened well");
	}

	@Test(enabled = true, priority = 2)
	public void isDemandsSavingPagOpeningWell() {
		demand = new DemandSaving_Page(driver);
		demand.searchElementConsumerBanking_PageOnMenu();
		assertTrue(demand.isDemandSavingsPagOpeningWell(), "Demand Savings page was'nt opened well");
	}

	@Test(enabled = true, priority = 3)
	public void isCurrentAccountsPagOpeningWell() {
		current = new CurrentAccounts_Page(driver);
		current.searchElementConsumerBanking_PageOnMenu();
		assertTrue(current.isCurrentAccountsPagOpeningWell(), "Current Accounts page was'nt opened well");
	}

	@Test(enabled = true, priority = 4)
	public void isFoundFormationPagOpeningWell() {
		found = new FoundFormation_Page(driver);
		found.searchElementConsumerBanking_PageOnMenu();
		assertTrue(found.isFoundFormationPagOpeningWell(), "Found Formation page was'nt opened well");
	}

	@Test(enabled = true, priority = 5)
	public void isCreditToNaturalPersonsPagOpeningWell() throws InterruptedException {
		credit = new CreditToNaturalPersons_Page(driver);
		credit.searchElementConsumerBanking_PageOnMenu();
		assertTrue(credit.isCreditToNaturalPersonsPagOpeningWell(),
				"Credit to Natural Persons page was'nt opened well");
	}

	@Test(enabled = true, priority = 6)
	public void isAccountInUSDPagOpeningWell() {
		account = new AcconutInUSD_Page(driver);
		account.searchElementConsumerBanking_PageOnMenu();
		assertTrue(account.isAccountInUSDPagOpeningWell(), "Account in USD page was'nt opened well");
	}

	@AfterMethod
	public void afterMethodConsumerBanking_Page() {
		driver.quit();
	}
}
