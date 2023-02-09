package config;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;


public class ProjectConfiguration {

    public void setConfig(WebConfig webConfig) {
        Configuration.baseUrl = webConfig.getBaseUrl();
        Configuration.browser = webConfig.getBrowserName();
        Configuration.browserSize = webConfig.getBrowserSize();
//        Configuration.pageLoadTimeout = webConfig.getPageLoadTimeout();
//        Configuration.timeout = webConfig.getTimeout();
//        Configuration.headless = webConfig.isHeadless();

        if (webConfig.isRemote()) {
            Configuration.browserVersion = webConfig.getBrowserVersion();
            Configuration.remote = webConfig.getRemoteUrl();
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
