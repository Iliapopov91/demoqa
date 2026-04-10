package pages.components;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {

public void setDate(String day, String month, String year) {
    $(".react-datepicker__year-select").selectOptionByValue(year);
    $(".react-datepicker__month-select").selectOption(month);
    $("#dateOfBirth").$(".react-datepicker__month").find(byText(day)).click();
    }
}
