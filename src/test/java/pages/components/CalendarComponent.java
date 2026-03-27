package pages.components;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

    public void setDate(String day, String month, String year) {
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day.react-datepicker__day--008").click();
    }
}
