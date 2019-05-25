package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage extends BasePage {

    /**Constructor*/
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**Web Elements*/
    By userNameId = By.id("email");
    By passwordId = By.id("password");
    By loginButtonId = By.id("loginButton");
    By errorMessageUsernameXpath = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpath = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    /**Page Methods*/
    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public LoginPage loginToN11(String username, String password) {
        writeText(userNameId, username);
        writeText(passwordId, password);
        click(loginButtonId);
        return this;
    }

    //Verify Username Condition
    @Step("Verify username: {0} step...")
    public LoginPage verifyLoginUserName(String expectedText) {
        waitVisibility(errorMessageUsernameXpath);
        Assert.assertEquals(readText(errorMessageUsernameXpath), expectedText);
        return this;
    }

    //Verify Password Condition
    @Step("Verify verifyLoginPassword: {0} step...")
    public LoginPage verifyLoginPassword(String expectedText) {
        waitVisibility(errorMessagePasswordXpath);
        Assert.assertEquals(readText(errorMessagePasswordXpath), expectedText);
        return this;
    }
}