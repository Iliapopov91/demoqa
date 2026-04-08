package pages;


import com.codeborne.selenide.SelenideElement;
import enums.ResultTableEnums;
import pages.components.CalendarComponent;
import pages.components.ResultTableComponent;

import java.io.File;
import java.util.Map;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class RegistrationPage {
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
    submitButton = $("#submit"),
    visibleWindow = $(".modal-dialog"),
    visibleHeader = $("#example-modal-sizes-title-lg"),
    resultTable = $(".table-responsive");

    CalendarComponent calendarComponent = new CalendarComponent();
    ResultTableComponent resultTableComponent = new ResultTableComponent();

    //Открыть страницу "/automation-practice-form"
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    //Ввести имя
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
            return this;
    }
    //Ввести фамилию
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
             return this;
    }
    //Ввести eMail
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }
    //Ввести номер телефрна
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }
    //Ввести адрес
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }
    //Указать пол
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }
    //Указать дату рождения
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }
    //Выбрать хобби
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }
    //Выбрать предметы
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }
    //Выбрать штат
    public RegistrationPage setState(String value) {
        stateList.setValue(value).pressEnter();
        return this;
    }
    //Выбрать город
    public RegistrationPage setCity(String value) {
        cityList.setValue(value).pressEnter();
        return this;
    }
    //Загрузить картинку
    public RegistrationPage uploadPicture(String fileName) {
        File file = new File("C:/ForSchool/" + fileName);
        uploadPicture.uploadFile(file);
        return this;
    }
    //Нажать Submit
    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    public RegistrationPage checkResultTitle() {
        resultTableComponent.checkTitle();
        return this;
    }

    public RegistrationPage checkResultTable(Map<ResultTableEnums, String> results) {
        results.forEach((key, value) -> resultTableComponent.checkTable(key, value));
        return this;
    }

    public RegistrationPage checkTitleMissing() {
        resultTableComponent.checkTitleMissing() ;
        return this;
    }
}
