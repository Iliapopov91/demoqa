package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class PracticePage {
    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    currentAddressInput = $("#currentAddress"),
    genderWrapper = $("#genterWrapper"),
    calendarInput = $("#dateOfBirthInput");


    CalendarComponent calendarComponent = new CalendarComponent();

    public PracticePage openPage() {
        open("/automation-practice-form");

        return this;
    }



    public PracticePage setFirstName(String value) {
        firstNameInput.setValue(value);

        return this;
    }
    public PracticePage setLastName(String value) {
        lastNameInput.setValue(value);

        return this;
    }
    public PracticePage setUserEmail(String value) {
        userEmailInput.setValue(value);

        return this;
    }
    public PracticePage setUserNumber(String value) {
        userNumberInput.setValue(value);

        return this;
    }
    public PracticePage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);

        return this;
    }
    public PracticePage setGender(String value) {
        genderWrapper.$(byText(value)).click();

        return this;
    }
    public PracticePage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);

        return this;
    }



    //Проверка
    public PracticePage checkResult (String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));


        return this;
    }
}
