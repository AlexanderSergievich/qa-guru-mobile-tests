package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.Allure.step;
import static org.codehaus.groovy.runtime.DefaultGroovyMethods.step;

public class GettingStartedTest {
    @Test
    @Tag("android_local")
    public void TestOnboarding(){
        step("Check language", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/option_label"))
                    .shouldHave(Condition.text("1. English"));
        });
        step("Click continue", ()-> {
            $(AppiumBy.id("org.wikipedia.alpha:id/option_label")).click();
        });
//        step("", ()-> {
//
//        });
    }
}
