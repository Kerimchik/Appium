package stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.HomePage;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class POMTest {


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
    public void pomTest(){

        HomePage homePage = new HomePage(driver);
        homePage.appButtonTap();


    }




}
