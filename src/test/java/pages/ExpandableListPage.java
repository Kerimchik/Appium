package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class ExpandableListPage {


    AndroidDriver<AndroidElement> driver;

    public ExpandableListPage(AndroidDriver<AndroidElement> driver){
        this.driver =driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }


//    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc='1. Custom Adapter']")
//    public AndroidElement customAdapter;


    @AndroidFindBy(accessibility = "1. Custom Adapter")
    public AndroidElement customAdapter;

}
