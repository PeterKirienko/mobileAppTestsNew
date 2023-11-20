package tests;

import core.EmulatorDriver;
import io.qameta.allure.Description;
import org.testng.annotations.Test;
import pageObjects.HomePage;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckCutLoginTest extends Base {


    @Test
    @Description("Tест проверяющий обрезку больше 50 лишних символов")
    public void cutTest() {
        String longLogin = "aaaaaaaaaabbbbbbbbbbccccccccccddddddddddeeeeeeeeeeffffffffff";
        HomePage homePage = new HomePage(EmulatorDriver.getDriver());
        homePage.fillLoginFields(longLogin);
        assertThat(homePage.getLoginFieldText().length()).isEqualTo(50);
    }

}

