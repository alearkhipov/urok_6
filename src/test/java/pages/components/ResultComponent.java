package pages.components;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {

    private final SelenideElement tableResults = $(".table-responsive");

    public void tableResultsIsNotVisible() {
        $(".table").shouldNotBe(visible);
    }
}
