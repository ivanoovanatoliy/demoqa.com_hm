import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest1 {
    @BeforeAll
    static void setupConfig() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }

    @Test
    void succesfullFillRegistrationForm() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Ivanov");
        $("[id=lastName]").setValue("Anatoliy");
        $("[id=userEmail").setValue("ivanoov.anatoly@gmail.com");
        $("[id=genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("89993332222");
        $("[id=dateOfBirthInput]").click();
        $(".react-datepicker__month-select").selectOption("September");
        $(".react-datepicker__year-select").selectOption("1997");
        $(by("aria-label", "Choose Thursday, September 25th, 1997")).click();
        $(by("for", "hobbies-checkbox-1")).click();
        $("[id=subjectsInput]").setValue("History").pressEnter();
        $("#uploadPicture").uploadFromClasspath("1.jpg");
        $("[id=currentAddress]").setValue("Ufa,Ayskaya 16");
        $("[id=state]").click();
        $("[id=react-select-3-input]").setValue("Haryana").pressEnter();
        $("[id=city").click();
        $("[id=react-select-4-input]").setValue("Karnal").pressEnter();
        $("[id=submit]").click();
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Ivanov Anatoliy"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("ivanoov.anatoly@gmail.com"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Male"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("8999333222"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("25 September,1997"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("History"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Ufa,Ayskaya 16"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("History"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("1.jpg"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Haryana Karnal"));
        $(".table.table-dark.table-striped.table-bordered.table-hover").shouldHave(text("Sports"));
    }
}