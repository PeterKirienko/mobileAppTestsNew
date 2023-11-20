package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SuccessPage extends BasePage {
    private AndroidDriver driver;
    @AndroidFindBy(className = "android.widget.TextView")
    private WebElement welcomeText;

    public String getTitleSuccessPage() {
        return elements.getTextFromElement(welcomeText);
    }

    public SuccessPage(AndroidDriver driver) {
        super(driver);
    }
}
