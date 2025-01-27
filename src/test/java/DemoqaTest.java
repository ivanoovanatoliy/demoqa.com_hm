import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class DemoqaTest {
    @BeforeAll
    static void DemoqaTest() {
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
        Configuration.baseUrl = "https://demoqa.com";
    }
        @Test
        void DemoqaTest1() {
        open("/automation-practice-form");
        executeJavaScript("$('#fixedban').remove()");
        executeJavaScript("$('footer').remove()");
        $("[id=firstName]").setValue("Ivanov");
        $("[id=lastName]").setValue("Anatoliy");
        $("[id=userEmail").setValue("ivanoov.anatoly@gmail.com");
        $("[id=genterWrapper").$(byText("Male")).click();
        $("[id=userNumber]").setValue("89993332222");
        $("[id=dateOfBirthInput]").setValue("25 Sep 1997");

    }
}