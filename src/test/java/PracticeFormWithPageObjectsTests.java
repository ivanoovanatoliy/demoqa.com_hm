import org.junit.jupiter.api.Test;
import pages.CalendarComponent;
import pages.PracticeFormPage;
import pages.TableResponseComponent;

public class PracticeFormWithPageObjectsTests extends TestBase {
    PracticeFormPage practiceFormPage = new PracticeFormPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponseComponent tableResponseComponent = new TableResponseComponent();


    @Test
    void fillPracticeFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Anatoliy")
                .setLastName("Ivanov")
                .setUserEmail("ivanoov.anatoly@gmail.com")
                .setGender("Male")
                .setPhoneNumber("1238761212")
                .setSubjects("English")
                .setHobbies("Sports")
                .uploadFile("1.jpg")
                .setCurrentAddress("Russia,123456,Ufa,ul.Ayskaya,d.22,kv.342")
                .setState("Uttar Pradesh")
                .setCity("Merrut");
        calendarComponent.setDate("25", "September", "2000");
        practiceFormPage.clickSubmit();

        tableResponseComponent.checkResult("Anatoliy Ivanov")
                .checkResult("ivanoov.anatoly@gmail.com")
                .checkResult("Male")
                .checkResult("1238761212")
                .checkResult("25 September,2000")
                .checkResult("English")
                .checkResult("Sports")
                .checkResult("1.jpg")
                .checkResult("Russia,123456,Ufa,ul.Ayskaya,d.22,kv.342")
                .checkResult("Uttar Pradesh Merrut");

    }

    @Test
    void fillPracticeMandatoryFormTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Anatoliy")
                .setLastName("Ivanov")
                .setGender("Male")
                .setPhoneNumber("9001234567")
                .clickSubmit();
        tableResponseComponent.checkResult("Anatoliy Ivanov")
                .checkResult("Male")
                .checkResult("9001234567");
    }

    @Test
    void fillPracticeFormNegativeTest() {
        practiceFormPage.openPage()
                .removeBanners()
                .setFirstName("Anatoliy")
                .clickSubmit()
                .modalWithResultNotExist();

    }

}