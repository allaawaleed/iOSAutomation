package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import utilities.BasePage;
import utilities.Log;

public class PickerView extends BasePage {

	public PickerView(IOSDriver<IOSElement> driver) {
		super(driver);
	}

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"UICatalog\"]")
	private MobileElement backToMainScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[8]")
	private MobileElement pickerViewPage;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Picker View\"]")
	private MobileElement pickerTitle;

	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[@name=\"Red color component value\"]")
	private MobileElement redPicker;

	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[@name=\"Green color component value\"]")
	private MobileElement greenPicker;

	@iOSFindBy(xpath = "//XCUIElementTypePickerWheel[@name=\"Blue color component value\"]")
	private MobileElement bluePicker;

	public void changePickerView() {
		backToMainScreen.click();
		waitElementToBeVisible(pickerViewPage, 3);
		pickerViewPage.click();
		Log.info("System clicks on picker view tab");
		waitElementToBeVisible(pickerTitle, 3);
		Log.info("System opens picer view correctly and title is " + pickerTitle.getText());
		if (redPicker.getText() != "80") {
			redPicker.click();
			redPicker.sendKeys("80");
		}

		if (greenPicker.getText() != "200") {
			greenPicker.sendKeys("200");

		}
		if (bluePicker.getText() != "100") {
			bluePicker.sendKeys("100");

		}
	}

	public String getRedPickerValue() {
		return redPicker.getText();
	}

	public String getGreenPickerValue() {
		return greenPicker.getText();
	}

	public String getBluePickerValue() {
		return bluePicker.getText();
	}

}
