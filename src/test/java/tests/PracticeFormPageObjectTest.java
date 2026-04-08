package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.util.Map;

import static enums.ResultTableEnums.*;

public class PracticeFormPageObjectTest extends TestBase {

    RegistrationPage registrationPage = new RegistrationPage();

    @Test
    @Tag("negative")
    void negativeRegistrationTest (){
        registrationPage.openPage()
                .setFirstName("Илья")
                .setLastName("Леопардович")
                .setGender("Other")
                .setDateOfBirth("08", "August", "1991")
                .setUserNumber("90672417")
                .clickSubmitButton()

                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, "Илья" + " " + "Леопардович",
                        GENDER, "Other",
                        MOBILE, "9067241700",
                        DATE_OF_BIRTH, "08" + " " + "August" + "," + "1991"));
    }


    @Test
    @Tag("smoke")
    void shortRegistrationTest (){
        registrationPage.openPage()
                .setFirstName("Илья")
                .setLastName("Леопардович")
                .setGender("Other")
                .setDateOfBirth("08", "August", "1991")
                .setUserNumber("9067241700")
                .clickSubmitButton()

                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, "Илья" + " " + "Леопардович",
                        GENDER, "Other",
                        MOBILE, "9067241700",
                        DATE_OF_BIRTH, "08" + " " + "August" + "," + "1991"));
    }


    @Test
    @Tag("regress")
    void registrationUsingAllFieldsTest () {
        registrationPage.openPage()
                .setFirstName("Илья")
                .setLastName("Леопардович")
                .setUserEmail("test@test.ru")
                .setGender("Other")
                .setUserNumber("9067241700")
                .setCurrentAddress("Ivanovo")
                .setDateOfBirth("08", "August", "1991")
                .setHobbies("Reading")
                .setSubjects("Maths")
                .setState("Haryana")
                .setCity("Panipat")
                .uploadPicture("123.gif")
                .clickSubmitButton()

                .checkResultTitle()
                .checkResultTable(Map.of(
                        STUDENT_NAME, "Илья" + " " + "Леопардович",
                        STUDENT_EMAIL, "test@test.ru",
                        GENDER, "Other",
                        MOBILE, "9067241700",
                        DATE_OF_BIRTH, "08" + " " + "August" + "," + "1991",
                        SUBJECTS, "Maths",
                        HOBBIES, "Reading",
                        PICTURE, "123.gif",
                        ADDRESS, "Ivanovo",
                        STATE_AND_CITY, "Haryana" + " " + "Panipat"));

    }
}