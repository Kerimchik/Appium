import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Gestures {

    AndroidDriver<AndroidElement> driver;

    @Before
    public void setup() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel 2 API 28");
        desiredCapabilities.setCapability("platformName", "android");
        desiredCapabilities.setCapability("app", apkFile.getAbsolutePath());
        URL serverUrl = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

    }

    @Test
    public void tapTest(){

       AndroidElement animationButton = driver.findElementByAccessibilityId("Animation");
        TouchAction touchAction= new TouchAction(driver);  //similar to actionClassin Selenium  AND IT WORKS ALWAYS WITH .perform()
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(animationButton))).perform();

    }


    @Test
    public void longPressTest(){

        AndroidElement viewsButton = driver.findElementByAccessibilityId("Views");
        TouchAction touchAction= new TouchAction(driver);  //similar to actionClassin Selenium  AND IT WORKS ALWAYS WITH .perform()
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(viewsButton))).perform();

AndroidElement expandableLists =
        driver.findElement(By.xpath("//android.widget.TextView[@text='Expandable Lists']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(expandableLists))).perform();


//        AndroidElement customAdopterButton =
//        driver.findElement(By.xpath("//android.widget.TextView[@text='1. Custom Adapter']"));
      // touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdopterButton)));


        AndroidElement customAdopterButton = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']"));
        touchAction.tap(TapOptions.tapOptions().withElement(ElementOption.element(customAdopterButton))).perform();

        AndroidElement peopleNamesButton=
        driver.findElementByXPath("//*[@text='People Names']");

        touchAction.longPress(LongPressOptions.longPressOptions().withDuration(Duration.ofSeconds(2)).withElement(ElementOption.element(peopleNamesButton))).perform();



    }











}
