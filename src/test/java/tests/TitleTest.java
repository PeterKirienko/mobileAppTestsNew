package tests;

import static org.assertj.core.api.Assertions.assertThat;
import core.EmulatorDriver;
import pageObjects.HomePage;
import io.qameta.allure.Description;
import org.testng.annotations.Test;

public class TitleTest extends Base {

    private final String WELCOME_TITLE = "Вход в Alfa-Test";

    @Test
    @Description("Tест проверки наименования кнопоки")
    public void titleTest()  {

        HomePage homePage = new HomePage(EmulatorDriver.getDriver());
        assertThat(homePage.getPageTitle()).isEqualTo(WELCOME_TITLE);

    }
}

