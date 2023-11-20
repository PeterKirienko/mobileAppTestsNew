package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:conf.properties")
public interface AppConfiguration extends Config {

    AppConfiguration CAP = ConfigFactory.create(AppConfiguration.class);

    @Key("deviceName")
    String deviceName();

    @Key("platformName")
    String platformName();

    @Key("platformVersion")
    String platformVersion();

    @Key("myAppPackage")
    String myAppPackage();

    @Key("myAppActivity")
    String myAppActivity();

}
