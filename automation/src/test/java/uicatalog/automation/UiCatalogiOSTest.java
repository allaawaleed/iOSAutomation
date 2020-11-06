package uicatalog.automation;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import utilities.AppiumServer;
import utilities.Log;

public class UiCatalogiOSTest {
	IOSDriver<IOSElement> driver;
	// public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	@BeforeClass
	public IOSDriver<IOSElement> setUp() throws IOException {
		// Start appium server
		AppiumServer.start();
		Log.startLog("Test is Starting");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platformName", "iOS");
		capabilities.setCapability("platformVersion", "12.4");
		capabilities.setCapability("deviceName", "iPhone Simulator");
		capabilities.setCapability("deviceVersion", "iPhone 6 Plus");
		capabilities.setCapability("appName", "UICatalog");
		capabilities.setCapability("bundleId", "com.example.apple-samplecode.UICatalog");
		capabilities.setCapability("app", "/App/UICatalog-iphonesimulator.app");
		capabilities.setCapability("AUTOMATION_NAME", "XCUITest");
		capabilities.setCapability("useNewWDA", "true");

		driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		return driver;

	}

	@Test
	public void testiOS() throws InterruptedException {
		// XCUIElementTypeApplication[@name="UICatalog"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]
		driver.findElement(
				By.xpath("//UIAApplication[1]/UIAWindow[2]/UIATableView[1]/UIATableCell[1]/UIAStaticText[1]")).click();
		driver.findElement(By.name("Back")).click();
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
