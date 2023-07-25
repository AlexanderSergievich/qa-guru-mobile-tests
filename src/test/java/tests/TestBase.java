package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import drivers.AppiumDriver;
import drivers.BrowserstackDriver;
import helpers.Attach;
import helpers.Browserstack;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {
    public static String deviceHost = System.getProperty("deviceHost");

    @BeforeAll
    static void beforeAll() {

//        if (deviceHost == null) {
//            deviceHost = "mobile";
//        }
//
//        switch (deviceHost) {
//            case "browser":
//                Configuration.browser = BrowserstackDriver.class.getName();
//                break;
//            case "mobile":
                Configuration.browser = AppiumDriver.class.getName();
//                break;
//        }

        Configuration.timeout = 15000;
        Configuration.pageLoadTimeout = 15000;
        Configuration.browserSize = null;

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
        if (!deviceHost.equals("mobile")) {
            Attach.addVideo(sessionId);
        }
    }
}