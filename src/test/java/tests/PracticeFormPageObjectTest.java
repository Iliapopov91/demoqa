package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;
import utils.TestData;

import java.util.Map;

import static enums.ResultTableEnums.*;

public class PracticeFormPageObjectTest extends TestBase {
    TestData testData = new TestData();

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("negative")
    @DisplayName("Заполнение не всех обязательных полей")
    void invalidPhoneRegistrationTest() {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserNumber(testData.invalidPhoneNumber + testData.randomString)
                .clickSubmitButton()

                .checkTitleMissing();
    }


    @Test
    @Tag("smoke")
    @DisplayName("Заполнение только обязательных полей")
    void shortRegistrationTest (){
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setGender(testData.gender)
                .setDateOfBirth(testData.day, testData.month, testData.year)
                .setUserNumber(testData.phoneNumber)
                .clickSubmitButton()

                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, testData.firstName + " " + testData.lastName,
                        GENDER, testData.gender,
                        MOBILE, testData.phoneNumber,
                        DATE_OF_BIRTH, testData.day + " " + testData.month + "," + testData.year));
    }


    @Test
    @Tag("regress")
    @DisplayName("Заполнение всех полей")
    void registrationUsingAllFieldsTest () {
        registrationPage.openPage()
                .setFirstName(testData.firstName)
                .setLastName(testData.lastName)
                .setUserEmail(testData.userEmail)
                .setGender(testData.gender)
                .setUserNumber(testData.phoneNumber)
                .setCurrentAddress(testData.streetAddress)
                .setDateOfBirth(testData.day, testData.month, testData.year)
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
                        STATE_AND_CITY, testData.state + " " + testData.city));

    }
}