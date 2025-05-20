import org.junit.jupiter.api.Test;
import pages.CalendarComponent;
import pages.PracticeFormPage;
import pages.TableResponseComponent;
import utils.FakePersonMethods;
import utils.StudentData;
import utils.StudentDataFactory;

import static com.codeborne.selenide.logevents.SelenideLogger.step;

public class PracticeFormWithFakerTests extends TestBase {
    pages.PracticeFormPage practiceFormPage = new pages.PracticeFormPage();
    CalendarComponent calendarComponent = new CalendarComponent();
    TableResponseComponent tableResponseComponent = new TableResponseComponent();
    StudentDataFactory studentDataFactory = new StudentDataFactory();
    FakePersonMethods fakePerson = new FakePersonMethods();


    @Test
    void fillPracticeFormTest() {
        StudentData student = studentDataFactory.generateStudentModelFull();
        step("Open form", () -> {
            practiceFormPage.openPage();
        });
        step("Remove banners", () -> {
            practiceFormPage.removeBanners();
        });
        step("Fill form", () -> {
            practiceFormPage.setFirstName(student.getFirstName())
                    .setLastName(student.getLastName())
                    .setUserEmail(student.getEmail())
                    .setGender(student.getGender())
                    .setPhoneNumber(student.getPhoneNumber())
                    .setSubjects(student.getSubject())
                    .setHobbies(student.getHobbies())
                    .uploadFile(student.getFileName())
                    .setCurrentAddress(student.getAddress())
                    .setState(student.getState())
                    .setCity(student.getCity());

            calendarComponent.setDate(student.getDay(), student.getMonth(), student.getYear());
        });
        step("Click submit", () -> {
            practiceFormPage.clickSubmit();
        });

        step("Check result", () -> {
            tableResponseComponent.checkResult(student.getFirstName())
                    .checkResult(student.getLastName())
                    .checkResult(student.getEmail())
                    .checkResult(student.getGender())
                    .checkResult(student.getPhoneNumber())
                    .checkResult(student.getDay())
                    .checkResult(student.getMonth())
                    .checkResult(student.getYear())
                    .checkResult(student.getSubject())
                    .checkResult(student.getHobbies())
                    .checkResult(student.getFileName())
                    .checkResult(student.getAddress())
                    .checkResult(student.getState())
                    .checkResult(student.getCity());

        });
    }

    @Test
    void fillPracticeMandatoryFormTest() {
        StudentData studentMandatoru = studentDataFactory.generateStudentModelMandatory();
        step("Open form", () -> {
            practiceFormPage.openPage();
        });
        step("Remove banners", () -> {
            practiceFormPage.removeBanners();
        });
        step("Fill form", () -> {
            practiceFormPage.setFirstName(studentMandatoru.getFirstName())
                    .setLastName(studentMandatoru.getLastName())
                    .setGender(studentMandatoru.getGender())
                    .setPhoneNumber(studentMandatoru.getPhoneNumber());
            calendarComponent.setDate(studentMandatoru.getDay(), studentMandatoru.getMonth(), studentMandatoru.getYear());
        });
        step("Click submit", () -> {
            practiceFormPage.clickSubmit();
        });
        step("Check result", () -> {
            tableResponseComponent.checkResult(studentMandatoru.getFirstName())
                    .checkResult(studentMandatoru.getLastName())
                    .checkResult(studentMandatoru.getGender())
                    .checkResult(studentMandatoru.getPhoneNumber())
                    .checkResult(studentMandatoru.getDay())
                    .checkResult(studentMandatoru.getMonth())
                    .checkResult(studentMandatoru.getYear());
        });
    }

    @Test
    void fillPracticeFormNegativeTest() {
        step("Open form", () -> {
            practiceFormPage.openPage();
        });
        step("Remove banners", () -> {
            practiceFormPage.removeBanners();
        });
        step("Fill form", () -> {
            practiceFormPage.setFirstName(fakePerson.getFirstName());
        });
        step("Click submit", () -> {
            practiceFormPage.clickSubmit();
        });
        step("Check result", () -> {
            practiceFormPage.modalWithResultNotExist();
        });
    }

}