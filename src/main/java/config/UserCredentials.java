package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.ConfigFactory;

@Config.Sources("classpath:login.properties")
public interface UserCredentials extends Config {

    UserCredentials loginCap = ConfigFactory.create(UserCredentials.class);

    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("allCharacterLogin")
    String allCharacterLogin();
    @Key("incorrectCyrillicLogin")
    String incorrectCyrillicLogin();
    @Key("incorrectDigitsLogin")
    String incorrectDigitsLogin();
    @Key("incorrectSpecialCharacters")
    String incorrectSpecialCharacters();
    @Key("incorrectMaxLengthLogin")
    String incorrectMaxLengthLogin();

}
