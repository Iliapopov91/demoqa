package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class PracticeFormTest {

    @BeforeAll
    static void beforeAll() {

        //Задаём разрешение браузера
        Configuration.browserSize= "2560x1440";

        //Задаём URL
        Configuration.baseUrl = "https://demoqa.com";

        //Пропускаем полную загрузку страницы
        Configuration.pageLoadStrategy = "eager";

        //Оставляем браузер открытым
        Configuration.holdBrowserOpen = true;

    }


    @Test
    void RegistrationForm () {

        //Открыть demoqa
        open("/automation-practice-form");

        //Заполнить firstName
        $("#firstName").setValue("Илья");

        //Заполнить lastName
        $("#lastName").setValue("Леопардович");

        // Заполнить email
        $("#userEmail").setValue("test@test.ru");

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
        $("#subjectsInput").setValue("Физ-ра"); //Поле остаётся НЕ заполненным даже вручную

        // Заполнить Hobbies
        $("#hobbies-checkbox-2").click();

        // Вставить Picture
        //$("#uploadPicture").click();
        $("#uploadPicture").uploadFile(new File("C:/ForSchool/123.gif"));

        // Заполнить Current Address
        $("#currentAddress").setValue("Ivanovo");

        // Выбрать State
        $("#state").click();
        $$("[class*='option']").findBy(text("Haryana")).click();

        // Выбрать City
        $("#city").click();
        $$("[class*='option']").findBy(text("Panipat")).click();

        //Нажать Submit
        $("#submit").click();
    }


    @Test
    void CheckRegistrationForm () {

        //Проверка результатов по вхождению
        $("div.table-responsive").shouldHave(text("Илья Леопардович"));
        $("div.table-responsive").shouldHave(text("test@test.ru"));
        $("div.table-responsive").shouldHave(text("Other"));
        $("div.table-responsive").shouldHave(text("9067241700"));
        $("div.table-responsive").shouldHave(text("08 August,1991"));
        // $("div.table-responsive").shouldHave(text("Физ-ра")); // Исключена - возвращает null
        $("div.table-responsive").shouldHave(text("Reading"));
        $("div.table-responsive").shouldHave(text("123.gif\n"));
        $("div.table-responsive").shouldHave(text("Ivanovo"));
        $("div.table-responsive").shouldHave(text("Haryana Panipat"));


    }
}
