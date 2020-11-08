package Pages;

import java.util.HashMap;
import java.util.Map;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import utilities.BasePage;
import utilities.Log;

public class SwitchesPage extends BasePage {

	public SwitchesPage(IOSDriver<IOSElement> driver) {
		super(driver);
	}

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]")
	private MobileElement uiCatalogitle;
	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[13]")
	private MobileElement switchesPage;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Switches\"]")
	private MobileElement switchesTitle;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name='UICatalog']/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[1]/XCUIElementTypeSwitch")
	private MobileElement tintedFlage;

	public void verifyUiCatalog() {
		waitElementToBeVisible(uiCatalogitle, 3);
		if (uiCatalogitle.isDisplayed()) {
			Log.info("System opens app correctly");
		} else {
			Log.info("Coudln't open UICatalog please check logs");
		}

	}

	public void changeTined() {
		waitElementToBeVisible(switchesPage, 3);

		switchesPage.click();
		waitElementToBeVisible(switchesTitle, 5);
		Log.info("title is displays   " + switchesTitle.getText());
		if (tintedFlage.getAttribute("value") == "1") {
			Log.info("The value for the tinted flage is On " + tintedFlage.getAttribute("value"));
			if (tintedFlage.isSelected()) {
				tintedFlage.setValue("0");
//				Actions moveSlider = new Actions(driver);
//				Action action = moveSlider.sendKeys("0").build();
//				action.perform();
				// tintedFlage.click();
				// tintedFlage.sendKeys("0");
				;
			}

		} else {
			Log.info("TINTED flage already Off");
		}

	}

	public String getPageTitle() {
		return uiCatalogitle.getText();
	}

	public String getTentedToggleValue() {
		return tintedFlage.getAttribute("value");

	}

	public void swipeDown() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("direction", "down");
		driver.executeScript("mobile: scroll", params);
	}

}
