package baseClass;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidTouchAction;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.offset.PointOption;

public class BaseClass {
	public static AndroidDriver driver;

	public BaseClass(AndroidDriver driver) {
		this.driver = driver;
	}

	public WebDriver banMetDriverConnection() throws MalformedURLException {

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "");
		capabilities.setCapability(MobileCapabilityType.UDID, "");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "9");
		capabilities.setCapability("appPackage", "cu.cesol.bancometropolitano");
		capabilities.setCapability("appActivity", "cu.cesol.bancometropolitano.Activities.SplashActivity");
		capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");

		URL url = new URL("http://127.0.0.1:4723/wd/hub");
		driver = new AndroidDriver<MobileElement>(url, capabilities);
		return driver;
	}

	public MobileElement findElement(By locator) {
		return (MobileElement) driver.findElement(locator);
	}

	public List<MobileElement> findElementsByClassName(MobileElement element, String className) {
		List<MobileElement> elements = element.findElementsByClassName(className);
		return elements;
	}

	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public String getText(MobileElement element) {
		return element.getText();
	}

	public void type(String inputText, By locator) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(inputText);
	}

	public void tap(By locator) {
		driver.findElement(locator).click();
	}

	public void tap(WebElement element) {
		element.click();
	}

	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public Boolean isDisplayed(MobileElement element) {
		try {
			return element.isDisplayed();
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;
		}
	}

	public void visit(String url) {
		driver.get(url);
	}

	public void wait(By locator) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	public boolean textToBePresentInElement(MobileElement element, String text) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		return wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public void wait(MobileElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public MobileElement convertToWebElement(By locator) {
		MobileElement element = (MobileElement) driver.findElement(locator);
		return element;
	}

	public void scroll() {
		int pressX = driver.manage().window().getSize().width / 2;
		int bottomY = driver.manage().window().getSize().height * 4 / 5;
		int topY = driver.manage().window().getSize().height / 8;
		scrollDown(pressX, bottomY, pressX, topY);
	}

	private void scrollDown(int fromX, int fromY, int toX, int toY) {
		AndroidTouchAction touchAction = new AndroidTouchAction((PerformsTouchActions) driver);
		touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release().perform();
	}

	public static void screenShot(String path_screenshot) throws IOException {
		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String filename = UUID.randomUUID().toString();
		File targetFile = new File(path_screenshot + filename + ".png");
		FileUtils.copyFile(srcFile, targetFile);
	}
}
