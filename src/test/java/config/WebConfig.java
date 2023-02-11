package config;

import org.aeonbits.owner.Config;


@Config.LoadPolicy(Config.LoadType.FIRST)
@Config.Sources({
        "classpath:${env}.properties",
        "classpath:local.properties"})
public interface WebConfig extends Config {

    @Key("env")
    @DefaultValue("local")
    String getEnv();

    @Key("browserName")
    String getBrowserName();

    @Key("browserVersion")
    String getBrowserVersion();

    @Key("baseUrl")
    String getBaseUrl();

    @Key("browserSize")
    String getBrowserSize();

    @Key("remoteUrl")
    String getRemoteUrl();

    @Key("pageLoadTimeout")
    Long getPageLoadTimeout();

    @Key("timeout")
    Long getTimeout();

}