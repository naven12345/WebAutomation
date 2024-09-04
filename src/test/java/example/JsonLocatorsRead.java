package example;

import base.BaseTest;
import driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.FormAPage;
import pages.formBPage;

import java.time.Duration;

public class JsonLocatorsRead extends BaseTest {

    FormAPage formA = new FormAPage();
    formBPage formB = new formBPage();

    @Test
    public void fillForm() {
        formA.scrollToPageForm();
        formA.EnterfirstName();
        formA.EnterlastName();
        formA.EnterEmail();
        //formA.SelectGender();
        formA.EnterNumber();
        /*formB.EnterSubject();
        formB.EnterHobbies();*/
    }

    @Test
    public void fill1Form() {
        formA.scrollToPageForm();
        formA.EnterfirstName();
    }
}
