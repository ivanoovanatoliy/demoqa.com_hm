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

        practiceFormPage.openPage();
        practiceFormPage.removeBanners();

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
        practiceFormPage.clickSubmit();

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
    }

    @Test
    void fillPracticeMandatoryFormTest() {
        StudentData studentMandatory = studentDataFactory.generateStudentModelMandatory();

        practiceFormPage.openPage();
        practiceFormPage.removeBanners();

        practiceFormPage.setFirstName(studentMandatory.getFirstName())
                .setLastName(studentMandatory.getLastName())
                .setGender(studentMandatory.getGender())
                .setPhoneNumber(studentMandatory.getPhoneNumber());

        calendarComponent.setDate(studentMandatory.getDay(), studentMandatory.getMonth(), studentMandatory.getYear());
        practiceFormPage.clickSubmit();

        tableResponseComponent.checkResult(studentMandatory.getFirstName())
                .checkResult(studentMandatory.getLastName())
                .checkResult(studentMandatory.getGender())
                .checkResult(studentMandatory.getPhoneNumber())
                .checkResult(studentMandatory.getDay())
                .checkResult(studentMandatory.getMonth())
                .checkResult(studentMandatory.getYear());
    }

    @Test
    void fillPracticeFormNegativeTest() {
        practiceFormPage.openPage();
        practiceFormPage.removeBanners();
        practiceFormPage.setFirstName(fakePerson.getFirstName());
        practiceFormPage.clickSubmit();
        practiceFormPage.modalWithResultNotExist();
    }
}