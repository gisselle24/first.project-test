package tests;

import static org.testng.Assert.assertTrue;

import java.net.MalformedURLException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import pages.BancaMobile_Page;
import pdfReporter.JyperionListener;

//Add listener for pdf report generation
@Listeners(JyperionListener.class)
public class BancaMobile_Test {
	private AndroidDriver driver;
	BancaMobile_Page banca_movil;

	@BeforeMethod
	public void beforeClassBancaMobile() throws MalformedURLException {
		banca_movil = new BancaMobile_Page(driver);
		driver = (AndroidDriver) banca_movil.banMetDriverConnection();
		banca_movil.allowAccess();
		banca_movil.allowAccess();
		banca_movil.tapOnNext();
		banca_movil.tapOnNext();
		banca_movil.tapOnNext();
		banca_movil.tapOnNext();
	}

	@Test
	private void testingPDF() {
		banca_movil.tapOnBancaMobile();
		banca_movil.tapOnPDF();
		assertTrue(banca_movil.isPDF_ExitVisible(), "Error al abrir el PDF");
		banca_movil.tapOnPDF_Exit();
		System.out.println("Se abrió y se cerró bien la ventana de descargar PDF");
	}

	@Test
	private void testingTransermovil() {
		banca_movil.tapOnBancaMobile();
		banca_movil.tapTransfermovil_Start();
		banca_movil.tapTransfermovil_Exit();
		// assertTrue(condition);
		System.out.println("Se abrió y se cerro bien la ventana de descargar Transfermovil");
	}

	@AfterMethod
	public void afterTestBancaMobile() {
		driver.quit();
	}
}
