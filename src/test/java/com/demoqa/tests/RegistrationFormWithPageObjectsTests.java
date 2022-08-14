package com.demoqa.tests;

import com.codeborne.selenide.Configuration;
import com.demoqa.pages.RegistrationFormPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class RegistrationFormWithPageObjectsTests {
    RegistrationFormPage registrationFormPage = new RegistrationFormPage();

    @BeforeAll
    static void configure() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
    }

    @Test
    void fillFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserEmail("AlexEgorov@mail.com")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .setBirthDate("30", "December", "2000")
                .setUserSubject("Math")
                .setUserHobbies("Sports")
                .uploadUserPicture("img/1.png")
                .setUserCurrentAddress("Some address 1")
                .setUserState("NCR")
                .setUserCity("Delhi")
                .submitForm();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"),
                text("AlexEgorov@mail.com"), text("1234567890"));
    }

    @Test
    void fillFormWithMinimumDataFormTest() {
        registrationFormPage.openPage()
                .setFirstName("Alex")
                .setLastName("Egorov")
                .setUserGender("Other")
                .setUserNumber("1234567890")
                .submitForm();

        $(".modal-dialog").should(appear);
        $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));

        $(".table-responsive table").shouldHave(text("Alex"), text("Egorov"), text("1234567890"));
    }

}
