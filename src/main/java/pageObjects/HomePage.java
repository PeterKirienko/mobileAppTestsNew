package pageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;

public class HomePage extends BasePage {

    @AndroidFindBy(id = "com.alfabank.qapp:id/tvTitle")
    private WebElement titleTxt;
    @AndroidFindBy(id = "com.alfabank.qapp:id/etUsername")
    private WebElement loginField;
    @AndroidFindBy(id = "com.alfabank.qapp:id/etPassword")
    private WebElement passwordField;
    @AndroidFindBy(id = "com.alfabank.qapp:id/btnConfirm")
    private WebElement loginBtn;
    @AndroidFindBy(id = "com.alfabank.qapp:id/text_input_end_icon")
    private WebElement visiblePassword;
    @AndroidFindBy(id = "com.alfabank.qapp:id/tvError")
    private WebElement errorMessage;
    @AndroidFindBy(id = "com.alfabank.qapp:id/loader")
    private WebElement loader;


    public HomePage(AndroidDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        return elements.getTextFromElement(titleTxt);
    }

    public String getButtonText() {
        return elements.getTextFromElement(loginBtn);
    }

    public String getErrorText() {
        return elements.getTextFromElement(errorMessage);
    }

    public String getLoginFieldText() {
        return elements.getTextFromElement(loginField);
    }

    @Step("Fill in password input")
    public HomePage fillPasswordFields(String field) {
        elements.searchFieldAndSendKey(passwordField, field);
        return this;
    }

    @Step("Fill in login input")
    public HomePage fillLoginFields(String field) {
        elements.searchFieldAndSendKey(loginField, field);
        return this;
    }

    @Step("Click login button")
    public HomePage clickLogin() {
        buttons.clickElement(loginBtn);
        return this;
    }

    @Step("Click password field")
    public HomePage clickPasswordField() {
        buttons.clickElement(passwordField);
        return this;
    }

    @Step("Wait until Loader is Invisible")
    public HomePage waitLoaderInvisible() {
        elements.isInVisibleElement(loader);
        return this;
    }

    @Step("Click show password")
    public HomePage maskVisibilityBtnClick() {
        visiblePassword.click();
        return this;
    }

    @Step("Check unmasked password")
    public boolean checkVisibilityPassword(String expectedPasswordInput) {
        return passwordField.getText().equals(expectedPasswordInput);
    }

}
