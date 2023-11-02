import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class GithubSolutionsTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.browserSize = "1500x1000";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void githubSolutionsTest() {
        open("https://github.com/");
        $(byText("Solutions")).hover();
        $("[href=\"/enterprise\"]").click();
        webdriver().shouldHave(url("https://github.com/enterprise"));
        $("#hero-section-brand-heading").shouldHave(Condition.text("The AI-powered developer platform."));
    }
}
