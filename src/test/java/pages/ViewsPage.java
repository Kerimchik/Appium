package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ViewsPage {

    AndroidDriver<AndroidElement> driver;

    public ViewsPage(AndroidDriver<AndroidElement> driver){
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


    @AndroidFindBy(xpath = "//*[@text='Expandable Lists']")
    public AndroidElement expandableLists;







}
