package tests;

import core.EmulatorDriver;
import pageObjects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.SuccessPage;

import static config.UserCredentials.loginCap;
import static core.EmulatorDriver.getAndroidDriver;
import static org.assertj.core.api.Assertions.assertThat;

public class SuccessLoginTest extends Base {


    private final String SUCCESS_TEXT = "Вход в Alfa-Test выполнен";

    @DataProvider
    public Object[][] loginPasswordData() {
        return new Object[][]{
                {loginCap.login(), loginCap.password()},
        };
    }

    @Test(dataProvider = "loginPasswordData")
    @Description("Tест успешной авторизации в системе")
    public void succesLoginTest(String login, String password) {
        HomePage homePage = new HomePage(EmulatorDriver.getDriver());
        homePage.fillLoginFields(login).fillPasswordFields(password).clickLogin().waitLoaderInvisible();
        SuccessPage succesPage = new SuccessPage(EmulatorDriver.getDriver());
        assertThat(succesPage.getTitleSuccessPage()).as("Вход выполнен успешно").isEqualTo(SUCCESS_TEXT);
        getAndroidDriver().resetApp();
    }

}

