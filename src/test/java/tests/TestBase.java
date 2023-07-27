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
    public static String deviceHost = System.getProperty("deviceHost");


    @BeforeAll
    static void beforeAll() {
        if (deviceHost == null) {
            deviceHost = "android";
        }

        switch (deviceHost) {
            case "browser":
                Configuration.browser = BrowserstackDriver.class.getName();
                break;
            case "android":
                Configuration.browser = AppiumDriver.class.getName();
                break;
        }
        Configuration.browserSize = null;
        Configuration.browserBinary = "/Applications/Google Chrome.app/Contents/MacOS/Google Chrome";

    }
    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
    }

//    @AfterEach
//    void afterEach() {
//        String sessionId = sessionId().toString();
//        Attach.pageSource();
//        closeWebDriver();
//        if (!deviceHost.equals("android")) {
//            Attach.addVideo(sessionId);
//        }
//    }
}