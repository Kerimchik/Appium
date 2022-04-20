package stepdefs;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.hu.De;
import org.junit.Assert;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.CustomAdapterPage;
import pages.ExpandableListPage;
import pages.HomePage;
import pages.ViewsPage;
import utility.AppiumUtility;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class ApiDemosStepDefs {

    AndroidDriver<AndroidElement> driver;



    @Given("I have APIDemos application launched")
    public void i_have_api_demos_application_launched() throws MalformedURLException {

        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("deviceName", "Pixel 2 API 28");
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, apkFile.getAbsolutePath());

        URL serverUrl = new URL("http://localhost:4723/wd/hub");

        driver = new AndroidDriver<AndroidElement>(serverUrl,desiredCapabilities);



    }
    @When("I navigate to {string} page")
    public void i_navigate_to_views_expandable_list_custom_adapter_page(String path) {

        HomePage homePage = new HomePage(driver);
        homePage.viewsButton.click();

        ViewsPage viewsPage = new ViewsPage(driver);
        viewsPage.expandableLists.click();

        ExpandableListPage expandableListPage= new ExpandableListPage(driver);
        expandableListPage.customAdapter.click();



    }


    @When("I long press on Dog Names button for {int} seconds")
    public void i_long_press_on_dog_names_button_for_seconds(Integer int1) {

        CustomAdapterPage customAdapterPage = new CustomAdapterPage(driver);
        AppiumUtility.longPressTest(driver,customAdapterPage.dogNamesButton);



    }
    @Then("new menu with {string} option should pop up")
    public void new_menu_with_option_should_pop_up(String string) {


        CustomAdapterPage customAdapterPage = new CustomAdapterPage(driver);

        String actualText = customAdapterPage.sampleMenuButton.getText();

        Assert.assertEquals(string,actualText);





    }





    @Then("new menu with {string} and {string} option should pop up")
    public void newMenuWithAndOptionShouldPopUp(String string, String string2) {


        CustomAdapterPage customAdapterPage = new CustomAdapterPage(driver);

        String actualSampleMenuText = customAdapterPage.sampleMenuButton.getText();
        String actualSampleActionText = customAdapterPage.sampleActionButton.getText();


        Assert.assertEquals(string,actualSampleMenuText);
        Assert.assertEquals(string2,actualSampleActionText);






    }









}
