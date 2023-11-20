package pageObjects;

import appElements.Buttons;
import appElements.Elements;
import appElements.Screen;
import appElements.Waiters;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import static appElements.Waiters.getWaiters;

public class BasePage {
    private final AndroidDriver driver;
    protected final Buttons buttons;
    protected final Screen screen;
    protected final Elements elements;
    protected final Waiters waiters;
    public Logger log = Logger.getLogger(BasePage.class);

    public BasePage(AndroidDriver driver) {
        buttons = new Buttons();
        screen = new Screen();
        elements = new Elements();
        waiters = getWaiters();
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

}
