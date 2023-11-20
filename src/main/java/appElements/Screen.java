package appElements;

import core.EmulatorDriver;
import io.appium.java_client.android.AndroidDriver;

import org.apache.log4j.Logger;


public class Screen {
    private final AndroidDriver driver = EmulatorDriver.getDriver();
    private static final Logger log = Logger.getLogger(Screen.class);
}
