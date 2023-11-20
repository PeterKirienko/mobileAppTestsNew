package tests;

import core.EmulatorDriver;
import pageObjects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static config.UserCredentials.loginCap;
import static org.assertj.core.api.Assertions.assertThat;


public class ValidationErrorTest extends Base {

    private final String SUCCESS_TEXT = "Вход в Alfa-Test выполнен";

    @DataProvider
    public Object[][] loginPasswordData() {
        return new Object[][]{
                {loginCap.incorrectDigitsLogin(), "password"},
                {loginCap.incorrectMaxLengthLogin(), "password"},
                {loginCap.incorrectCyrillicLogin(), "password"},
                {loginCap.incorrectSpecialCharacters(), "password"}
        };
    }

    @Description("Tест кейс валидация логина и пароля")
    @Test(dataProvider = "loginPasswordData")
    public void errorTest(String login, String password) {
        String substringRegex = "Введены неверные данные";

        HomePage homePage = new HomePage(EmulatorDriver.getDriver()).fillLoginFields(login).fillPasswordFields(password).clickLogin().waitLoaderInvisible();
        assertThat(homePage.getErrorText().matches(substringRegex)).isTrue();
        assertThat(homePage.getPageTitle()).isNotEqualTo(SUCCESS_TEXT);

    }
}

