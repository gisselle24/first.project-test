package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;
import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import pages.ATMs_Page;
import pages.ContactInformation_Page;
import pdfReporter.JyperionListener;

@Listeners(JyperionListener.class)
public class ContactInformation_Test {
	private AndroidDriver<MobileElement> driver;
	ContactInformation_Page contactInformation;

	@BeforeMethod
	public void beforeMethodATMs() throws MalformedURLException {
		contactInformation = new ContactInformation_Page(driver);
		driver = (AndroidDriver) contactInformation.banMetDriverConnection();
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), contactInformation);
		contactInformation.allowAccess();
		contactInformation.allowAccess();
		contactInformation.TapOnNext();
		contactInformation.TapOnNext();
		contactInformation.TapOnNext();
		contactInformation.TapOnNext();
	}

	@Test(enabled = true)
	private void testPhone1() {
		contactInformation.goToContactInformation();
		Boolean isOpeningWell = contactInformation.testPhone1();
		assertTrue(isOpeningWell, "Phone 1 is'nt opening well");
	}

	@Test(enabled = true)
	private void testPhone2() {
		contactInformation.goToContactInformation();
		Boolean isOpeningWell = contactInformation.testPhone2();
		assertTrue(isOpeningWell, "Phone 2 is'nt opening well");
	}

	@Test(enabled = true)
	private void testClientAtention() {
		contactInformation.goToContactInformation();
		Boolean isOpeningWell = contactInformation.testClientsAtention();
		assertTrue(isOpeningWell, "Clients Atention info is'nt opening well");
	}

	@Test(enabled = true)
	private void testEmail() {
		contactInformation.goToContactInformation();
		String email = contactInformation.testEmail();
		assertEquals(email, "<clientes@banmet.cu>, ");
	}

	@Test(enabled = true)
	private void testLinkedIn() {
		contactInformation.goToContactInformation();
		Boolean linkedIn = contactInformation.testLinkedIn();
		assertTrue(linkedIn,"LinkedIn is'nt opening well");
	}
	
	@Test(enabled = true)
	private void testYoutube() {
		contactInformation.goToContactInformation();
		String youtube = contactInformation.testYoutube();
		assertEquals(youtube, "YouTube");
	}
	
	@Test(enabled = true)
	private void testTwitter() {
		contactInformation.goToContactInformation();
		String twitter = contactInformation.testTwitter();
		assertEquals(twitter, "mobile.twitter.com/BanmetCuba");
	}
	
	@Test(enabled = true)
	private void testFacebook() {
		contactInformation.goToContactInformation();
		String face = contactInformation.testFacebook();
		assertEquals(face, "m.facebook.com/BanmetCuba/");
	}

	@AfterMethod
	private void afterMethod() {
		driver.quit();
	}
}
