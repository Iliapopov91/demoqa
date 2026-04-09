package tests;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Locale;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomEmail;
import static utils.RandomUtils.getRandomString;

public class PracticeFormWithRandomUtilsTest extends TestBase {



    @Test
    public void successfullRegistrationTest () {
        //Faker faker = new Faker(new Locale("en-GB"));

        String firstName = getRandomString(10);
        String lastName = getRandomString(10);
//        String lastName = faker.name().lastName(); // Barton
//        String userEmail = faker.internet().emailAddress();
//         String streetAddress = faker.address().streetAddress(); // 60018 Sawayn Brooks Suite 449
        String userEmail = getRandomEmail();
       String streetAddress = "";
        //Открыть demoqa
        open("/automation-practice-form");

        //Заполнить firstName
        $("#firstName").setValue(firstName);

        //Заполнить lastName
        $("#lastName").setValue(lastName);

        // Заполнить email
        $("#userEmail").setValue(userEmail);

        // Заполнить Gender
        $("#gender-radio-3").click();

        // Заполнить Mobile
        $("#userNumber").setValue("9067241700");

        // Заполнить DateofBirth
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOption("1991");
        $(".react-datepicker__month-select").selectOption("August");
        $(".react-datepicker__day.react-datepicker__day--008").click();

        // Заполнить Subjects
        $("#subjectsInput").setValue("Maths").pressEnter();

        // Заполнить Hobbies
        $("#hobbies-checkbox-2").click();

        // Вставить Picture
        $("#uploadPicture").uploadFile(new File("C:/ForSchool/123.gif"));

        // Заполнить Current Address
        $("#currentAddress").setValue(streetAddress);

        // Выбрать State
        $("#state").click();
        $$("[class*='option']").findBy(text("Haryana")).click();

        // Выбрать City
        $("#city").click();
        $$("[class*='option']").findBy(text("Panipat")).click();

        //Нажать Submit
        $("#submit").click();

        //Проверка результатов по вхождению
        $(".table-responsive").$(byText("Student Name")).parent()
                .shouldHave(text("Илья Леопардович"));
        $(".table-responsive").$(byText("Student Email")).parent()
                .shouldHave(text(userEmail));
        $(".table-responsive").$(byText("Gender")).parent()
                .shouldHave(text("Other"));
        $(".table-responsive").$(byText("Mobile")).parent()
                .shouldHave(text("9067241700"));
        $(".table-responsive").$(byText("Date of Birth")).parent()
                .shouldHave(text("08 August,1991"));
        $(".table-responsive").$(byText("Subjects")).parent()
                .shouldHave(text("Maths"));
        $(".table-responsive").$(byText("Hobbies")).parent()
                .shouldHave(text("Reading"));
        $(".table-responsive").$(byText("Picture")).parent()
                .shouldHave(text("123.gif"));
        $(".table-responsive").$(byText("Address")).parent()
                .shouldHave(text(streetAddress));
        $(".table-responsive").$(byText("State and City")).parent()
                .shouldHave(text("Haryana Panipat"));


    }
}
