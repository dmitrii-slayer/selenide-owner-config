package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class ProjectConfiguration {

    public static void setConfig() {
        WebConfig config = ConfigFactory.create(WebConfig.class, System.getProperties());
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.pageLoadTimeout = config.getPageLoadTimeout();
        Configuration.timeout = config.getTimeout();

        if ((config.getEnv()).equals("remote")) {
            Configuration.browserVersion = config.getBrowserVersion();
            Configuration.remote = config.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
