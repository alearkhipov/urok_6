package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultComponent {
    private SelenideElement tableResults = $(".table-responsive");

    public void checkResults(String key, String value) {
        tableResults.$(byText(key)).parent().shouldHave(text(value));
    }

    public void tableResultsIsNotVisible() {
        $(".table").shouldNotBe(visible);

    }
}
