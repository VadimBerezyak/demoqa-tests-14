package com.demoqa.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class RegistrationFormPage {

    private SelenideElement firstNameInput = $("#firstName"),
            lastNameInput = $("#lastName"),
            userEmailInput = $("#firstName"),
            userGenderInput = $("#genterWrapper"),
            userNumberInput = $("#userNumber");


    public RegistrationFormPage openPage() {
        open("/automation-practice-form");
        $(".practice-form-wrapper").shouldHave(text("Student Registration Form"));
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
        return this;
    }

    public RegistrationFormPage setFirstName(String value) {
        firstNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage clearFirstName() {
        firstNameInput.clear();
        return this;
    }

    public RegistrationFormPage setLastName(String value) {
        lastNameInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserEmail(String value) {
        userEmailInput.setValue(value);
        return this;
    }

    public RegistrationFormPage setUserGender(String value) {
        userGenderInput.$(byText(value)).click();
        return this;
    }

    public RegistrationFormPage setUserNumber(String value) {
        $("#userNumber").setValue(value);
        return this;
    }
 public RegistrationFormPage setBirthDate(String day,String month, String year ) {
     $("#dateOfBirthInput").click();
     $(".react-datepicker__month-select").selectOption(month);
     $(".react-datepicker__year-select").selectOption(year);
     $(".react-datepicker__day--0" + day+ ":not(.react-datepicker__day--outside-month)").click();
     return this;
    }


}

