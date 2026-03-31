package pages;


import com.codeborne.selenide.SelenideElement;
import pages.components.CalendarComponent;
import pages.components.CheckResultComponent;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class PracticePage {
    private SelenideElement firstNameInput = $("#firstName"),
    lastNameInput = $("#lastName"),
    userEmailInput = $("#userEmail"),
    userNumberInput = $("#userNumber"),
    currentAddressInput = $("#currentAddress"),
    genderWrapper = $("#genterWrapper"),
    calendarInput = $("#dateOfBirthInput"),
    hobbiesWrapper = $("#hobbiesWrapper"),
    subjectsInput = $("#subjectsInput"),
    stateList = $("#react-select-3-input"),
    stateWrapper = $("#stateCity-wrapper"),
    cityList = $("#react-select-4-input"),
    cityWrapper = $("#stateCity-wrapper"),
    uploadPicture = $("#uploadPicture"),
    submitButton = $("#submit");


    CalendarComponent calendarComponent = new CalendarComponent();
    CheckResultComponent checkResultComponent = new CheckResultComponent();

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
    public PracticePage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    public PracticePage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    public PracticePage setState(String value) {
        stateList.setValue(value).pressEnter();
        return this;
    }
    public PracticePage setCity(String value) {
        cityList.setValue(value).pressEnter();
        return this;
    }
    public PracticePage uploadPicture(String fileName) {
        File file = new File("C:/ForSchool/" + fileName);
        uploadPicture.uploadFile(file);
        return this;
    }
    public PracticePage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    //Проверка - вынести в отдельный java class (пересмотреть где озвучивают дз)
    public PracticePage checkResult (String key, String value) {
        $(".table-responsive").$(byText(key)).parent()
                .shouldHave(text(value));
        return this;

    }
}
