import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.DragAndDropOptions.to;
import static com.codeborne.selenide.Selenide.*;


public class DragAndDropTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://the-internet.herokuapp.com/";
        Configuration.browserSize = "1500x1000";
    }

    @Test
    void dragAndDropWithMoveToElementTest() {
        open("drag_and_drop");
        actions().moveToElement($("#column-a")).clickAndHold().moveByOffset(150, 0).release().perform();
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }

    @Test
    void dragAndDropTest() {
        open("drag_and_drop");
        $("#column-a").dragAndDrop(to($("#column-b")));
        $("#column-a").shouldHave(text("B"));
        $("#column-b").shouldHave(text("A"));
    }
}


