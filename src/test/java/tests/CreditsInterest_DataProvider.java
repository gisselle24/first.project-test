package tests;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.CreditsInterest_Page;
import pdfReporter.JyperionListener;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;

@Listeners(JyperionListener.class)
public class CreditsInterest_DataProvider {
	private AndroidDriver driver;
	CreditsInterest_Page interestCredit;

	@BeforeClass
	public void beforeClassCreditInterest() throws MalformedURLException {
		interestCredit = new CreditsInterest_Page(driver);
		driver = (AndroidDriver) interestCredit.banMetDriverConnection();
		interestCredit.allowAccess();
		interestCredit.allowAccess();
		interestCredit.tapOnNext();
		interestCredit.tapOnNext();
		interestCredit.tapOnNext();
		interestCredit.tapOnNext();
	}

	@Test(priority = 2)
	public void isWorkingInfo() {
		interestCredit.tapOnInfo();
		interestCredit.isWorkingInfo();
		assertTrue(interestCredit.isWorkingInfo(), "Icon info is not working");
	}

	@Test(priority = 0)
	public void amIIntoPageInterestCredic() {
		interestCredit.searchElementInteresCreditOnMenu();
		assertTrue(interestCredit.isBtnCalculateVisible());
	}

	@Test(priority = 1, dataProvider = "dataPro")
	public void creditInterest(String n) {

		interestCredit.sendKeys(n);
		Integer imp = Integer.parseInt(n);

		switch (imp) {
		case 999:
			interestCredit.numberOfMonth36();
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getErrorMessageText(), "El importe debe ser mayor que $1000.00 CUP");

			break;

		case 1000:
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getMonthlyFeeText(), "30.38");
			assertEquals(interestCredit.getTotalDebtText(), "1093.58");

			break;

		case 2000:
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getMonthlyFeeText(), "60.75");
			assertEquals(interestCredit.getTotalDebtText(), "2187.15");

			break;

		/*case 99500:
			interestCredit.numberOfMonth120();
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getMonthlyFeeText(), "1186.44");
			assertEquals(interestCredit.getTotalDebtText(), "142373.20");

			break;*/

		case 100000:
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getMonthlyFeeText(), "1192.41");
			assertEquals(interestCredit.getTotalDebtText(), "143088.64");

			break;

		case 100001:
			interestCredit.tapBtnCalculate();

			assertEquals(interestCredit.getErrorMessageText(), "El importe debe ser menor que $100000.00 CUP");
			break;
		}
	}

	@DataProvider(name = "dataPro")
	public String[] getData() {

		String[] data = new String[6];

		data[0] = "999";
		data[1] = "1000";
		data[2] = "2000";
		data[3] = "99500";
		data[4] = "100000";
		data[5] = "100001";

		return data;
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
