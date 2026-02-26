package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TextBoxTests {


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

        // Чтобы браузер НЕ перезапускался, если тест упал
        Configuration.reopenBrowserOnFail = false;

        //Конфигурация таймаута (default 4000)
        Configuration.timeout = 5000;
    }


    @Test
    void fillFormTest () {

        //Открыть demoqa
        open("/text-box");

        //Заполнить full name
        $("#userName").setValue("Генри");

        // Заполнить email
        $("#userEmail").setValue("test@test.ru");

        // Заполнить Current Address
        $("#currentAddress").setValue("Ivanovo");

        // Заполнить Permanent Address
        $("#permanentAddress").setValue("Moscow");

        //Нажать Submit
        $("#submit").click();


        //Проверка результатов по вхождению
        $("#output #name").shouldHave(text("Генри"));
        $("#output #email").shouldHave(text("test@test.ru"));
        $("#output #currentAddress").shouldHave(text("Ivanovo"));
        $("#output #permanentAddress").shouldHave(text("Moscow"));

    }
}



