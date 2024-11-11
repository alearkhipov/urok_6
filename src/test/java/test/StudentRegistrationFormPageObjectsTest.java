package test;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import pages.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class StudentRegistrationFormPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void StudentRegistrationFormFullDate() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setdateOfBirth("day:22", "month:5", "year:2000")
                .subjectsInput("a")
                .hobbiesInput("Music")
                .uploadPictureInput("img.png")
                .currentAddressInput("Moscow")
                .stateInput("Haryana")
                .cityInput("Panipat")
                .clickSubmit();

        registrationPage.tableResults("Student Name", "Alex Arkhipov")
                .tableResults("Student Email", "my@yandex.ru")
                .tableResults("Gender", "Male")
                .tableResults("Mobile", "1234567890")
                .tableResults("Date of Birth", "22 May,2000")
                .tableResults("Subjects", "Maths")
                .tableResults("Hobbies", "Music")
                .tableResults("Picture", "img.png")
                .tableResults("Address", "Moscow")
                .tableResults("State and City", "Haryana Panipat");
    }

    @Test
    void StudentRegistrationFormMinimumDate() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setdateOfBirth("day:22", "month:5", "year:2000")
                .clickSubmit();

        registrationPage.tableResults("Student Name", "Alex Arkhipov")
                .tableResults("Student Email", "my@yandex.ru")
                .tableResults("Gender", "Male")
                .tableResults("Mobile", "1234567890")
                .tableResults("Date of Birth", "22 May,2000");
    }

    @Test
    void StudentRegistrationFormIncorrectEmail() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.r")
                .setGender("Male")
                .setNumber("1234567890")
                .setdateOfBirth("day:22", "month:5", "year:2000")
                .clickSubmit();

        registrationPage.tableResultsIsNotVisible();
    }
}