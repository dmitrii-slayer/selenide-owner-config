package config;

import org.aeonbits.owner.Config;


@Config.Sources({
        "system:properties",
        "classpath:${env}.properties"})
public interface WebConfig extends Config {

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserSize")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    String getRemoteUrl();

//    @Key("pageLoadTimeout")
//    Long getPageLoadTimeout();
//
//    @Key("timeout")
//    Long getTimeout();
//
//    @Key("headless")
//    Boolean isHeadless();
}