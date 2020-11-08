package utilities;

import java.time.Duration;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class BasePage {
	public int IMPLICIT_WAIT;
	protected AppiumDriver<IOSElement> driver;
	public static MobileElement mobileElement;
	WebDriverWait wait;

	public BasePage(IOSDriver<IOSElement> driver2) {
		this.driver = driver2;
		initElements();
	}

	public void waitElementToBeVisible(MobileElement elmenet, int time) {

		wait = new WebDriverWait(driver, time);
		wait.until(ExpectedConditions.visibilityOf(elmenet));
	}

	private void initElements() {
		PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(IMPLICIT_WAIT)), this);
	}

}
