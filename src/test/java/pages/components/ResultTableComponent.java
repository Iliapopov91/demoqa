package pages.components;

import com.codeborne.selenide.SelenideElement;
import enums.ResultTableEnums;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

//public class ResultTableComponent {

//    public void checkResult(String value, String key) {
//        $(".table-responsive").$(byText("Student Name")).parent()
//                .shouldHave(text("Илья Леопардович"));
//        $(".table-responsive").$(byText("Student Email")).parent()
//                .shouldHave(text("test@test.ru"));
//        $(".table-responsive").$(byText("Gender")).parent()
//                .shouldHave(text("Other"));
//        $(".table-responsive").$(byText("Mobile")).parent()
//                .shouldHave(text("9067241700"));
//        $(".table-responsive").$(byText("Date of Birth")).parent()
//                .shouldHave(text("08 August,1991"));
//        $(".table-responsive").$(byText("Subjects")).parent()
//                .shouldHave(text("Maths"));
//        $(".table-responsive").$(byText("Hobbies")).parent()
//                .shouldHave(text("Reading"));
//        $(".table-responsive").$(byText("Picture")).parent()
//                .shouldHave(text("123.gif"));
//        $(".table-responsive").$(byText("Address")).parent()
//                .shouldHave(text("Ivanovo"));
//        $(".table-responsive").$(byText("State and City")).parent()
//                .shouldHave(text("Haryana Panipat"));





public class ResultTableComponent {

    private final SelenideElement
            resultTitle = $("#example-modal-sizes-title-lg"),
            resultTable = $(".table-responsive");

    public ResultTableComponent checkTitle() {
        resultTitle.shouldHave(exactText("Thanks for submitting the form"));
        return this;
    }

    public ResultTableComponent checkTable(ResultTableEnums key, String value) {
        System.out.println(key + " " + value);
        resultTable.$(byText(key.toString())).parent()
                .shouldHave(text(value));
        return this;
    }

    public ResultTableComponent checkTitleMissing() {
        resultTitle.shouldNotBe(visible);
        return this;
    }
}
