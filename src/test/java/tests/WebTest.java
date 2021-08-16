package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

public class WebTest extends TestBase{

    @Test
    void searchTest() {
        open("https://www.wikipedia.org/");
        $(byXpath("//*[@id='searchLanguage']")).click();
        $(byXpath("//*[@id='searchLanguage']/option[17]")).click();
        $(byXpath("//*[@id='jsLangLabel']")).shouldHave(text("en"));
        $("#searchInput").val("Jimi Hendrix").click();
        $$("#typeahead-suggestions").findBy(visible)
                .shouldHave(text("American guitarist, singer and songwriter"));
        $$(".suggestion-link").first().click();
        $(byXpath("//*[@id='mw-content-text']/div[1]/table[1]")).shouldHave(text("November 27, 1942"));
    }

}
