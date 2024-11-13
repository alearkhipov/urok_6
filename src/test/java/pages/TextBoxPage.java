package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxPage {


    private final SelenideElement userNameInput = $("[id=userName"),
            userEmailInput = $("#userEmail"),
            currentAddressInput = $("#currentAddress"),
            permanentAddressInput = $("#permanentAddress"),
            submitInput = $("#submit"),
            outputName = $("#output #name");

    public TextBoxPage openPage()
    {
        open("/text-box");
        return this;
    }

    public TextBoxPage setuserName(String value)
    {
        userNameInput.setValue(value);
        return this;
    }

    public TextBoxPage setuserEmail(String value)
    {
        userEmailInput.setValue(value);
        return this;
    }

    public TextBoxPage setcurrentAddress(String value)
    {
        currentAddressInput.setValue(value);
        return this;
    }

    public TextBoxPage setpermanentAddress(String value)
    {
        permanentAddressInput.setValue(value).scrollTo();
        return this;
    }

    public TextBoxPage clickSubmit()
    {
        submitInput.click();
        return this;
    }

    public TextBoxPage checkResult(String value)
    {
        outputName.$(byText(value));
        return this;
    }

}