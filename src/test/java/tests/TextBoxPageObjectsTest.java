package tests;

import org.junit.jupiter.api.Test;
import pages.TextBoxPage;

public class TextBoxPageObjectsTest extends TestBase {
    TextBoxPage textBoxPage = new TextBoxPage();

    @Test
    void textBoxPage() {
        textBoxPage.openPage()
                .setuserName("Alex")
                .setuserEmail("my@yandex.ru")
                .setcurrentAddress("Moscow")
                .setpermanentAddress("Moscow 2")
                .clickSubmit();
        textBoxPage.checkResult("Name:Alex")
                .checkResult("Email:my@yandex.ru")
                .checkResult("Current Address :Moscow")
                .checkResult("Permananet Address :Moscow 2");
    }
}
