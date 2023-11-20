package tests;

import core.EmulatorDriver;
import pageObjects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PasswordMaskingTest extends Base {

    @Test
    @Description("Tест маскирования введённого пароля")
    public void maskTest() {
        String passwordInput = "123456789";
        boolean passwordText = new HomePage(EmulatorDriver.getDriver())
                .fillLoginFields("Login")
                .fillPasswordFields(passwordInput)
                .maskVisibilityBtnClick()
                .checkVisibilityPassword(passwordInput);

        assertThat(passwordText).as("Вход выполнен успешно").isTrue();
    }

}

