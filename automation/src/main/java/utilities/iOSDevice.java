package utilities;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class iOSDevice {
	IOSDriver<IOSElement> driver;

	public IOSDriver<IOSElement> setUp() throws MalformedURLException {
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
		capabilities.setCapability("useNewWDA", "false");

		driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"), capabilities);
		return driver;
		// wait = new WebDriverWait(driver, 30);
	}

}