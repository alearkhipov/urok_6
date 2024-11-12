package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import pages.components.CalendarComponent;
import pages.components.ResultComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    EmailInput = $("#userEmail"),
    GenterInput = $("#genterWrapper"),
    NumberInput = $("#userNumber"),
    calendarInput = $("#dateOfBirthInput"),
    subjectsInput = $("#subjectsInput"),
    hobbiesInput = $("#hobbiesWrapper"),
    uploadPictureInput = $("#uploadPicture"),
    currentAddressInput = $("#currentAddress"),
    stateInput = $("#state"),
    cityInput = $("#city"),
    submitInput = $("#submit");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultComponent resultComponent = new ResultComponent();

    public RegistrationPage openPage()
    {
        open("/automation-practice-form");
        return this;
    }
    public RegistrationPage setfirstName(String value)
    {
        firstNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setLastName(String value)
    {
        lastNameInput.setValue(value);
        return this;
    }
    public RegistrationPage setEmail(String value)
    {
        EmailInput.setValue(value);
        return this;
    }
    public RegistrationPage setGender(String value)
    {
        GenterInput.$(byText(value)).click();
        return this;
    }
    public RegistrationPage setNumber(String value)
    {
        NumberInput.setValue(value).scrollTo();
        return this;
    }
    public RegistrationPage setdateOfBirth(String day, String month, String year)
    {
        new CalendarComponent().setDate(day,month,year);
        calendarInput.click();
        calendarComponent.setDate(day, month, year);
        return this;
    }

    public RegistrationPage subjectsInput(String value)
    {
        subjectsInput.setValue(value).sendKeys(Keys.ENTER);
        return this;
    }

    public RegistrationPage hobbiesInput(String value)
    {
        hobbiesInput.$(byText(value)).click();
        return this;
    }

    public RegistrationPage uploadPictureInput(String path)
    {
        uploadPictureInput.uploadFromClasspath(path);
        return this;
    }

    public RegistrationPage currentAddressInput(String value)
    {
        currentAddressInput.setValue(value);
        return this;
    }

    public RegistrationPage stateInput(String state)
    {
        stateInput.click();
        stateInput.$(byText(state)).click();
        return this;
    }

    public RegistrationPage cityInput(String city)
    {
        cityInput.click();
        cityInput.$(byText(city)).click();
        return this;
    }

    public RegistrationPage clickSubmit()
    {
        submitInput.click();
        return this;
    }

    public RegistrationPage tableResults(String key, String value)
    {
        $(".table-responsive").$(byText(key)).parent().shouldHave(text(value));
        return this;
    }

    public RegistrationPage tableResultsIsNotVisible()
    {
        resultComponent.tableResultsIsNotVisible();
        return this;
    }
}
