package tests;

import org.testng.annotations.AfterTest;

import static core.EmulatorDriver.getAndroidDriver;

public class Base {

    @AfterTest
    public void afterTests() {
        getAndroidDriver().resetApp();
    }
}
