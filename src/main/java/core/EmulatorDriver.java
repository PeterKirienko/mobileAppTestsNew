package core;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

import static config.AppConfiguration.CAP;

public class EmulatorDriver {

    private static AndroidDriver<MobileElement> driver;
    private static final Logger log = Logger.getLogger(EmulatorDriver.class);

    private static  DesiredCapabilities cap;

    private EmulatorDriver() {

    }

    public static AndroidDriver<MobileElement> getDriver() {
        if (driver == null) {
            try {
                initializeDriver();
                log.info("Driver is started");
            } catch (MalformedURLException e) {
                log.error("Error initializing driver: " + e.getMessage());
            }
        }
        return driver;
    }

    private static void initializeDriver() throws MalformedURLException {
        setCapabilities();
        driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
    }

    private static void setCapabilities() {
        cap = new DesiredCapabilities();
        cap.setCapability(MobileCapabilityType.PLATFORM_NAME, CAP.platformName());
        cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator2");
        cap.setCapability("appPackage", CAP.myAppPackage());
        cap.setCapability("appActivity", CAP.myAppActivity());
        cap.setCapability(MobileCapabilityType.DEVICE_NAME, CAP.deviceName());
    }

    public static AndroidDriver<MobileElement> getAndroidDriver() {
        setCapabilities();
        try {
            if (cap.getPlatform().equals(Platform.ANDROID)) {
                return getDriver();
            } else {
                throw new RuntimeException("Invalid platform in caps: " + cap.getPlatform().name());
            }
        } catch (Exception e) {
            log.error("Error getting Android driver: " + e.getMessage());
            throw new RuntimeException("Failed to get Android driver", e);
        }
    }
}
