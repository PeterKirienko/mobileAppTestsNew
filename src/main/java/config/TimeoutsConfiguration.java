package config;
import com.google.common.base.Preconditions;
import lombok.Getter;

import java.util.concurrent.TimeUnit;

@Getter
public final class TimeoutsConfiguration {

    private final int clickTimeoutSeconds;
    private final int webElementPresenceTimeoutSeconds;
    private final int pollingWithRefreshTimeoutSeconds;
    private final int pageRefreshTimeoutSeconds;
    private final int shortTimeoutSeconds;
    private final int mediumTimeoutSeconds;
    private final int longTimeoutSeconds;
    private final int pauseBetweenKeysMillis;
    private final int pauseBetweenTriesMillis;
    private final int pauseBetweenRefreshSeconds;
    private final int pageLoadTimeoutSeconds;
    private final int implicitWaitTimeoutMillis;

    private TimeoutsConfiguration(int clickTimeoutSeconds, int webElementPresenceTimeoutSeconds, int pollingWithRefreshTimeoutSeconds,
                                  int pageRefreshTimeoutSeconds, int shortTimeoutSeconds, int mediumTimeoutSeconds, int longTimeoutSeconds,
                                  int pauseBetweenKeysMillis, int pauseBetweenTriesMillis, int pauseBetweenRefreshSeconds,
                                  int pageLoadTimeoutSeconds, int implicitWaitTimeoutMillis) {
        this.clickTimeoutSeconds = clickTimeoutSeconds;
        this.webElementPresenceTimeoutSeconds = webElementPresenceTimeoutSeconds;
        this.pollingWithRefreshTimeoutSeconds = pollingWithRefreshTimeoutSeconds;
        this.pageRefreshTimeoutSeconds = pageRefreshTimeoutSeconds;
        this.shortTimeoutSeconds = shortTimeoutSeconds;
        this.mediumTimeoutSeconds = mediumTimeoutSeconds;
        this.longTimeoutSeconds = longTimeoutSeconds;
        this.pauseBetweenKeysMillis = pauseBetweenKeysMillis;
        this.pauseBetweenTriesMillis = pauseBetweenTriesMillis;
        this.pauseBetweenRefreshSeconds = pauseBetweenRefreshSeconds;
        this.pageLoadTimeoutSeconds = pageLoadTimeoutSeconds;
        this.implicitWaitTimeoutMillis = implicitWaitTimeoutMillis;
    }
}
