package Pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.iOSFindBy;
import utilities.BasePage;
import utilities.Log;

public class SteppersPage extends BasePage {

	public SteppersPage(IOSDriver<IOSElement> driver) {
		super(driver);
	}

	@iOSFindBy(xpath = "//XCUIElementTypeButton[@name=\"UICatalog\"]")
	private MobileElement backToMainScreen;

	@iOSFindBy(xpath = "//XCUIElementTypeApplication[@name=\"UICatalog\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeOther/XCUIElementTypeTable/XCUIElementTypeCell[12]")
	private MobileElement stepperPage;

	@iOSFindBy(xpath = "//XCUIElementTypeOther[@name=\"Steppers\"]")
	private MobileElement stepperTitle;

	@iOSFindBy(xpath = "(//XCUIElementTypeStaticText[@name=\"0\"])[2]")
	private MobileElement tintedNumber;

	@iOSFindBy(xpath = "(//XCUIElementTypeButton[@name=\"Increment\"])[2]")
	private MobileElement increaseTented;

	public void increaseTentedFromStepperPage() {
		backToMainScreen.click();
		waitElementToBeVisible(stepperPage, 3);
		stepperPage.click();
		Log.info("System opens Stepper page sucessfully and title is " + stepperTitle.getText());
		if (tintedNumber.getText() != "10") {
			for (int numberOfTinde = 0; numberOfTinde < 10; numberOfTinde++) {
				increaseTented.click();
			}
		}

	}

	public String getTintedNumber() {
		Log.info(tintedNumber.getText());
		return tintedNumber.getText();

	}

}
