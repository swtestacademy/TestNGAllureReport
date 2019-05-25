package tests;

import io.qameta.allure.*;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.Listeners.TestListener;

//In order to eliminate attachment problem for Allure, you should add @Listener line.
//link: https://github.com/allure-framework/allure1/issues/730
@Listeners({ TestListener.class })
@Epic("Regression Tests")
@Feature("Login Tests")
public class LoginTests extends BaseTest {

    //Test Data
    String wrongUsername = "onur@swtestacademy.com";
    String wrongPassword = "11122233444";

    @Test (priority = 0, description="Invalid Login Scenario with wrong username and password.")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Story("Invalid username and password login test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword () {
        homePage
            .goToN11()
            .goToLoginPage()
            .loginToN11(wrongUsername, wrongPassword)
            .verifyLoginPassword("E-posta adresiniz veya şifreniz hatalı");
    }

    @Test (priority = 1, description="Invalid Login Scenario with empty username and password.")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login test with empty username and empty password.")
    @Story("Empty username and password login test")
    public void invalidLoginTest_EmptyUserEmptyPassword () {
        homePage
            .goToN11()
            .goToLoginPage()
            .loginToN11("", "")
            .verifyLoginUserName("Lütfen e-posta adresinizi girin.")
            .verifyLoginPassword("WRONG MESSAGE FOR FAILURE!");
    }
}