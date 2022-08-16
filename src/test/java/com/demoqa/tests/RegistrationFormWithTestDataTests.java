package com.demoqa.tests;

import com.demoqa.pages.RegistrationFormPage;
import com.demoqa.pages.components.ResultsTableComponent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.String.format;

public class RegistrationFormWithTestDataTests extends TestBase {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();
    ResultsTableComponent resultsTableComponent = new ResultsTableComponent();

    String firstName,
            lastName,
            expectedFullName,
            email,
            gender,
            mobile,
            subject,
            hobbies,
            picturePath,
            currentAddress,
            state,
            city,
            expectedStateCityAddress,
            day,
            month,
            year,
            expectedDateOfBirth;

    @BeforeEach
    void prepareTestData(){
                firstName = "Alex";
                lastName = "Egorov";
                expectedFullName = format("%s %s", firstName, lastName);
                email = "AlexEgorov@mail.com";
                gender = "Male";
                mobile = "1234567890";
                subject = "Math";
                hobbies = "Sport";
                picturePath = "img/1.png";
                currentAddress = "Some address 1";
                state = "NCR";
                city = "Delhi";
                expectedStateCityAddress = format("%s %s", state, city);
                day = "30";
                month = "January";
                year = "2000";
                expectedDateOfBirth = format("%s %s,%s", day, month, year);
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(email)
                .setUserGender(gender)
                .setUserNumber(mobile)
                .setBirthDate(day, month, year)
                .setUserSubject(subject)
                .setUserHobbies(hobbies)
                .uploadUserPicture(picturePath)
                .setUserCurrentAddress(currentAddress)
                .setStateAndCity(state, city)
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("State and City", expectedStateCityAddress)
                .checkResultsInTable("Student Name", expectedFullName)
                .checkResultsInTable("Gender", gender)
                .checkResultsInTable("Mobile", mobile)
                .checkResultsInTable("Date of Birth", expectedDateOfBirth)
                .checkResultsInTable("Subjects", subject)
                .checkResultsInTable("Hobbies", hobbies)
                .checkResultsInTable("Picture", picturePath)
                .checkResultsInTable("Address", currentAddress);
    }

    @Test
    void fillFormWithMinimumDataFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .submitForm()
                .checkResultsTableIsVisible()
                .checkResultsInTable("Student Name", expectedFullName)
                .checkResultsInTable("Gender", "Other")
                .checkResultsInTable("Mobile", "1234567890");
    }

}
