package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static io.appium.java_client.MobileBy.AccessibilityId;
import static io.qameta.allure.Allure.step;

public class WikiTests extends TestBase {

    @Test
    @DisplayName("Getting started page test")
    void checkContentTest() {
        step("Open app", () -> {
            open();
        });

        step("Main content verification", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("The Free Encyclopedia …in over 300 languages"));
        });

        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("New ways to explore", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/primaryTextView"))
                    .shouldHave(text("New ways to explore"));
        });

        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Reading lists with sync", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/secondaryTextView"))
                    .shouldHave(text("Join Wikipedia"));
        });

        step("Click continue", () ->
                $(MobileBy.id("org.wikipedia.alpha:id/fragment_onboarding_forward_button")).click());

        step("Send anonymous data. Checkbox check", () -> {
                $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                        .shouldHave(text("ON")).click();
                $(MobileBy.id("org.wikipedia.alpha:id/switchView"))
                        .shouldHave(text("OFF"));
        });
    }
}
