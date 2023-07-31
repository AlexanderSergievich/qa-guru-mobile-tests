package tests;

import com.codeborne.selenide.Condition;
import io.appium.java_client.AppiumBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class SearchTest extends TestBase {

    @Test
    @Tag("android_local")
    @DisplayName("Successful search")
    void successfulSearchTest() {
        step("Check 1st onboarding page title and click continue", () -> {
            $(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(Condition.text("The Free Encyclopedia …in over 300 languages"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 2nd onboarding page title and click continue", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(texts("New ways to explore"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 3rd onboarding page title and click continue", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(texts("Reading lists with sync"));
            $(AppiumBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click();
        });
        step("Check 4th onboarding page title and click continue", () -> {
            $$(AppiumBy.id("org.wikipedia.alpha:id/primaryTextView")).shouldHave(texts("Send anonymous data"));
            $(AppiumBy.id("org.wikipedia.alpha:id/acceptButton")).click();
        });
    }
}