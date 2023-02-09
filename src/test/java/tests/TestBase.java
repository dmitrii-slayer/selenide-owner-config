package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import config.WebConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TestBase {

    protected static ProjectConfiguration projectConfig;
    protected static WebConfig config;

    @BeforeAll
    static void beforeAll() {
        config = ConfigFactory.create(WebConfig.class, System.getProperties());
        projectConfig = new ProjectConfiguration();
        projectConfig.setConfig(config);

        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.attachHtml("HTML");
        Attach.addVideo();
        Selenide.closeWebDriver();
    }
}
