package pages;

import io.qameta.allure.Step;
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

    @Step("Открыть страницу регистрации")
    public RegistrationPage openPage() {
        open("/automation-practice-form");
        return this;
    }

    @Step("Заполнить имя: {value}")
    public RegistrationPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить фамилию: {value}")
    public RegistrationPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    @Step("Заполнить email: {value}")
    public RegistrationPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    @Step("Указать пол: {value}")
    public RegistrationPage setGender(String value) {
        genderWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Указать дату рождения: {day} {month} {year}")
    public RegistrationPage setDateOfBirth(String day, String month, String year) {
        calendarInput.click();
        new CalendarComponent().setDate(day, month, year);
        return this;
    }

    @Step("Заполнить номер телефона: {value}")
    public RegistrationPage setUserNumber(String value) {
        userNumberInput.setValue(value);
        return this;
    }

    @Step("Заполнить текущий адрес: {value}")
    public RegistrationPage setCurrentAddress(String value) {
        currentAddressInput.setValue(value);
        return this;
    }

    @Step("Указать хобби: {value}")
    public RegistrationPage setHobbies(String value) {
        hobbiesWrapper.$(byText(value)).click();
        return this;
    }

    @Step("Указать предмет: {value}")
    public RegistrationPage setSubjects(String value) {
        subjectsInput.setValue(value).pressEnter();
        return this;
    }

    @Step("Указать штат: {value}")
    public RegistrationPage setState(String value) {
        stateList.setValue(value).pressEnter();
        return this;
    }

    @Step("Указать город: {value}")
    public RegistrationPage setCity(String value) {
        cityList.setValue(value).pressEnter();
        return this;
    }

    @Step("Загрузить фотографию: {fileName}")
    public RegistrationPage uploadPicture(String fileName) {
        File file = new File("C:/ForSchool/" + fileName);
        uploadPicture.uploadFile(file);
        return this;
    }

    @Step("Нажать кнопку Submit")
    public RegistrationPage clickSubmitButton() {
        submitButton.click();
        return this;
    }

    @Step("Проверить заголовок таблицы результатов")
    public RegistrationPage checkResultTitle() {
        resultTableComponent.checkTitle();
        return this;
    }

    @Step("Проверить данные в таблице результатов")
    public RegistrationPage checkResultTable(Map<ResultTableEnums, String> results) {
        results.forEach((key, value) -> resultTableComponent.checkTable(key, value));
        return this;
    }
}
