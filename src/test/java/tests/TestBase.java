package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.AppiumDriver;
import drivers.BrowserstackDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {


    @BeforeAll
    static void beforeAll() {
        switch (System.getProperty("deviceHost")) {
            case "mobile" -> Configuration.browser = BrowserstackDriver.class.getName();
            case "android" -> Configuration.browser = AppiumDriver.class.getName();
        }
        Configuration.browserSize = null;
        //Configuration.browserBinary = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";

    }

    @BeforeEach
    void addListener() {
        open();
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
        Attach.pageSource();
        closeWebDriver();
        Attach.addVideo(sessionId);
    }
}