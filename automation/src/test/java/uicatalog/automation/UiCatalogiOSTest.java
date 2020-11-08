package uicatalog.automation;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Pages.PickerView;
import Pages.SliderPage;
import Pages.SteppersPage;
import Pages.SwitchesPage;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
//	import utilities.AppiumServer;
import utilities.Log;

public class UiCatalogiOSTest {
	IOSDriver<IOSElement> driver;
	// public AppiumDriver<MobileElement> driver;
	public WebDriverWait wait;

	@BeforeClass
	public IOSDriver<IOSElement> setUp() throws IOException {
		// Start appium server
		// AppiumServer.start();
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

	@Test(priority = 1, enabled = true, description = "Verify that system opens UICatalog app correctly")
	public void testUiCatalog() throws Exception {
		SwitchesPage uiCatalogVerification = new SwitchesPage(driver);
		uiCatalogVerification.verifyUiCatalog();
		assertThat(uiCatalogVerification.getPageTitle(), containsString("UICatalog"));
	}

	@Test(priority = 2, enabled = true, description = "Verify that 'TINTED' flag is OFF")
	public void changeTinted() throws Exception {
		SwitchesPage changeTinted = new SwitchesPage(driver);
		changeTinted.swipeDown();
		changeTinted.changeTined();

		assertEquals(changeTinted.getTentedToggleValue(), "0");

	}

	@Test(priority = 3, enabled = true, description = "Verify increase number of tintend to 10 from Stepper page")
	public void increaseTint() throws Exception {
		SteppersPage stepper = new SteppersPage(driver);
		stepper.increaseTentedFromStepperPage();
		assertEquals(stepper.getTintedNumber(), "10");

	}

	@Test(priority = 4, enabled = true, description = "Verify increase the tented slider to the maximum")
	public void increaseTentedSlider() throws Exception {
		SliderPage slider = new SliderPage(driver);
		slider.increaseSlider();
		assertEquals(slider.getTendtSliderValue(), "100%");

	}

	@Test(priority = 5, enabled = true, description = "Verify change picker views")
	public void changePickerViews() throws Exception {
		PickerView pickerChange = new PickerView(driver);
		pickerChange.changePickerView();
		assertEquals(pickerChange.getRedPickerValue(), "80");
		assertEquals(pickerChange.getGreenPickerValue(), "200");
		assertEquals(pickerChange.getBluePickerValue(), "100");

	}

	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
