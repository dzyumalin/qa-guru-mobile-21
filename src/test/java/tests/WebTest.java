package tests;

import annotations.Layer;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static tests.TestData.ARTIST;
import static tests.TestData.BASE_URL;

@Owner("dzyumalin")
@Layer("web")
@Feature("wiki search")
public class WebTest extends TestBase {

    @Test
    @Tag("web")
    @DisplayName("Searching for a music artist")
    void searchTest() {
        step("Open url " + BASE_URL, () -> {
            open(BASE_URL);
        });

        step("Choose 'English'", () -> {
            $(byXpath("//*[@id='searchLanguage']")).click();
            $(byXpath("//*[@id='searchLanguage']/option[17]")).click();
        });

        step("Verify language", () ->
                $(byXpath("//*[@id='jsLangLabel']")).shouldHave(text("en")));

        step("Search " + ARTIST, () ->
                $("#searchInput").val(ARTIST).click());

        step("Find text about artist", () -> {
            $$("#typeahead-suggestions").findBy(visible)
                    .shouldHave(text("American guitarist, singer and songwriter"));
        });

        step("Click on first artist");
        $$(".suggestion-link").first().click();

        step("Date of birth check", () -> {
            $(byXpath("//*[@id='mw-content-text']/div[1]/table[1]")).shouldHave(text("November 27, 1942"));
        });

    }
}
