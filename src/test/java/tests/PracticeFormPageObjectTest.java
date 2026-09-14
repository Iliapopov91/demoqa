package tests;

import static io.qameta.allure.Allure.step;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

import java.util.Map;

import static enums.ResultTableEnums.*;

@DisplayName("Тесты формы регистрации")
public class PracticeFormPageObjectTest extends TestBase {
    TestData testData = new TestData();

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tags({
            @Tag("negative"),
            @Tag("smoke")
    })
    @DisplayName("Заполнение не всех обязательных полей")
    void invalidPhoneRegistrationTest() {
        open("/automation-practice-form");

        $("#firstName").setValue(testData.firstName);
        $("#lastName").setValue(testData.lastName);
        $("#userNumber").setValue(
                testData.invalidPhoneNumber + testData.randomString
        );

        $("#submit").click();

        $("#example-modal-sizes-title-lg").shouldNotBe(visible);
    }


    @Test
    @Tag("smoke")
    @DisplayName("Заполнение только обязательных полей")
    void shortRegistrationTest() {

        step("Открыть страницу регистрации", () ->
                registrationPage.openPage());

        step("Заполнить имя", () ->
                registrationPage.setFirstName(testData.firstName));

        step("Заполнить фамилию", () ->
                registrationPage.setLastName(testData.lastName));

        step("Указать пол", () ->
                registrationPage.setGender(testData.gender));

        step("Указать дату рождения", () ->
                registrationPage.setDateOfBirth(
                        testData.day,
                        testData.month,
                        testData.year
                ));

        step("Заполнить номер телефона", () ->
                registrationPage.setUserNumber(testData.phoneNumber));

        step("Нажать кнопку Submit", () ->
                registrationPage.clickSubmitButton());

        step("Проверить заголовок таблицы результатов", () ->
                registrationPage.checkResultTitle());

        step("Проверить данные в таблице результатов", () ->
                registrationPage.checkResultTable(Map.of(
                        STUDENT_NAME, testData.firstName + " " + testData.lastName,
                        GENDER, testData.gender,
                        MOBILE, testData.phoneNumber,
                        DATE_OF_BIRTH,
                        testData.day + " " + testData.month + "," + testData.year
                )));
    }


    @Test
    @Tag("regress")
    @DisplayName("Заполнение всех полей")
    void registrationUsingAllFieldsTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setCurrentAddress(testData.streetAddress)
                .setDateOfBirth(
                        testData.day,
                        testData.month,
                        testData.year
                )
                .setHobbies(testData.hobbies)
                .setSubjects(testData.subjects)
                .setState(testData.state)
                .setCity(testData.city)
                .uploadPicture(testData.uploadFile)
                .clickSubmitButton()
                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, testData.firstName + " " + testData.lastName,
                        STUDENT_EMAIL, testData.userEmail,
                        GENDER, testData.gender,
                        MOBILE, testData.phoneNumber,
                        DATE_OF_BIRTH, testData.day + " " + testData.month + "," + testData.year,
                        SUBJECTS, testData.subjects,
                        HOBBIES, testData.hobbies,
                        PICTURE, testData.uploadFile,
                        ADDRESS, testData.streetAddress,
                        STATE_AND_CITY, testData.state + " " + testData.city
                ));
    }
}