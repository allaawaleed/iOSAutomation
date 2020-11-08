package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import utilities.BasePage;
import utilities.Log;

public class SliderPage extends BasePage {

	public SliderPage(IOSDriver<IOSElement> driver) {
		super(driver);
	}

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"UICatalog\"]")
	private MobileElement backToMainScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[11]")
	private MobileElement sliderPage;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Sliders\"]")
	private MobileElement sliderTitle;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[2]/XCUIElementTypeSlider")
	private MobileElement moveTentedSlider;

	public void increaseSlider() {
		backToMainScreen.click();
		waitElementToBeVisible(sliderPage, 3);
		sliderPage.click();
		waitElementToBeVisible(sliderTitle, 3);
		// moveTentedSlider.sendKeys("1");
		moveTentedSlider.setValue("100");
		Log.info(moveTentedSlider.getText());

	}

	public String getTendtSliderValue() {
		return moveTentedSlider.getText();
	}

}
