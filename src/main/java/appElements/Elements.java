package appElements;

import core.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static com.sun.webkit.CursorManager.WAIT;
import static org.openqa.selenium.remote.ErrorCodes.TIMEOUT;


public class Elements {

    private final AndroidDriver driver = EmulatorDriver.getDriver();
    private static final Logger log = Logger.getLogger(Elements.class);


    public String getTextFromElement(WebElement webElement) {
        new WebDriverWait(driver, 10)
                .until(ExpectedConditions.visibilityOf(webElement));
        return webElement.getText();
    }

    public boolean isSelectedElement(WebElement element) {
        try {
            element.isSelected();
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public boolean isVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.visibilityOf(webElement));
            log.info("Checking Element");
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public boolean isInVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, 15)
                    .until(ExpectedConditions.invisibilityOf(webElement));
            log.info("Checking Element");
            return true;
        } catch (Exception ElementNotVisible) {
            return false;
        }
    }

    public boolean isNotVisibleElement(WebElement webElement) {
        try {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOf(webElement));
            log.info("Checking Element");
            return false;
        } catch (Exception ElementNotVisible) {
            return true;
        }
    }

    public void searchFieldAndSendKey(WebElement webElement, String key) {
        WebElement searchField = new WebDriverWait(driver, 10)
                .until(ExpectedConditions.elementToBeClickable(webElement));
        searchField.sendKeys(key);
    }

    public void WaitVisibilityOfElement(AndroidElement element) {
        driver.manage().timeouts().implicitlyWait(WAIT, TimeUnit.SECONDS);
        FluentWait wait = new FluentWait(driver);
        wait.withTimeout(Duration.ofSeconds(TIMEOUT));
        wait.pollingEvery(Duration.ofMillis(30));
        wait.ignoring(NoSuchElementException.class);
        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void sendKeyFromAction(String key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).perform();
    }

}
