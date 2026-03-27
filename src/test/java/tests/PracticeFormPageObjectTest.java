package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.PracticePage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormPageObjectTest extends TestBase {

    PracticePage practicePage = new PracticePage();


    @Test
    void practiceForm () {
        practicePage.openPage()
                .setFirstName("Илья")
                .setLastName("Леопардович")
                .setUserEmail("test@test.ru")
                .setGender("Other")
                .setUserNumber("9067241700")
                .setCurrentAddress("Ivanovo")
                .setDateOfBirth("08", "August", "1991");

        // Заполнить Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();

        // Заполнить Hobbies
        $("#hobbies-checkbox-2").click();

        // Вставить Picture
        $("#uploadPicture").uploadFile(new File("C:/ForSchool/123.gif"));

        // Выбрать State
        $("#state").click();
        $$("[class*='option']").findBy(text("Haryana")).click();

        // Выбрать City
        $("#city").click();
        $$("[class*='option']").findBy(text("Panipat")).click();

        //Нажать Submit
        $("#submit").click();

        //Проверка результатов по вхождению
        practicePage.checkResult("Student Name", "Илья Леопардович")
                .checkResult("Student Email", "test@test.ru")
                .checkResult("Gender", "Other")
                .checkResult("Mobile", "9067241700")
                .checkResult("Date of Birth", "08 August,1991")
                .checkResult("Subjects", "Maths")
                .checkResult("Hobbies", "Reading")
                .checkResult("Picture", "123.gif")
                .checkResult("Address", "Ivanovo")
                .checkResult("State and City", "Haryana Panipat");


    }
}