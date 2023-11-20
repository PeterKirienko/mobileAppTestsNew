package appElements;

import config.DefaultTimeouts;
import core.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Buttons {
    private final AndroidDriver driver = EmulatorDriver.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, DefaultTimeouts.PRESENCE_TIMEOUT_SECONDS);

    public void clickElement(WebElement webElement) {
        WebElement clickableElement = wait.until(ExpectedConditions.elementToBeClickable(webElement));
        clickableElement.click();
    }

}
