package tests;

import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

public class StudentRegistrationFormPageObjectsTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    void studentRegistrationFormFullDate() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("2000", "May", "22")
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
    void studentRegistrationFormMinimumDate() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.ru")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("2000", "May", "22")
                .clickSubmit();

        registrationPage.tableResults("Student Name", "Alex Arkhipov")
                .tableResults("Student Email", "my@yandex.ru")
                .tableResults("Gender", "Male")
                .tableResults("Mobile", "1234567890")
                .tableResults("Date of Birth", "22 May,2000");
    }

    @Test
    void studentRegistrationFormIncorrectEmail() {
        registrationPage.openPage()
                .setfirstName("Alex")
                .setLastName("Arkhipov")
                .setEmail("my@yandex.r")
                .setGender("Male")
                .setNumber("1234567890")
                .setDateOfBirth("2000", "May", "22")
                .clickSubmit();

        registrationPage.tableResultsIsNotVisible();
    }
}