package utility;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;

import java.time.Duration;

public class AppiumUtility {


    @Test
    public static void longPressTest(AndroidDriver<AndroidElement> driver, AndroidElement nameOfElement){
        TouchAction touchAction= new TouchAction(driver);  //similar to actionClassin Selenium  AND IT WORKS ALWAYS WITH .perform()
        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(nameOfElement))).perform();

    }









}
