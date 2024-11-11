package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year)
    {
        $("#dateOfBirthInput").click();

        $(".react-datepicker__year-select").selectOption("2000");
        $(".react-datepicker__month-select").selectOption("May");
        $(".react-datepicker__day--022"). click();
    }
}
