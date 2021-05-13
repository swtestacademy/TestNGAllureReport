package pages;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.excelutils.ExcelUtil;
import utils.logs.JSErrorLogs;
import utils.logs.Log;


public class LoginPage extends BasePage {
    /**
     * Constructor
     */
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    /**
     * Web Elements
     */
    By userNameIdBy                = By.id("email");
    By passwordIdBy                = By.id("password");
    By loginButtonIdBy             = By.id("loginButton");
    By errorMessageUsernameXpathBy = By.xpath("//*[@id=\"loginForm\"]/div[1]/div/div");
    By errorMessagePasswordXpathBy = By.xpath("//*[@id=\"loginForm\"]/div[2]/div/div ");

    /**
     * Page Methods
     */
    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public LoginPage loginToN11(String username, String password) {
        Log.info("Trying to login the N11.");
        writeText(userNameIdBy, username);
        writeText(passwordIdBy, password);
        click(loginButtonIdBy);
        return this;
    }

    @Step("Login Step with username: {0}, password: {1}, for method: {method} step...")
    public LoginPage loginToN11WithExcelData(XSSFRow row) {
        Log.info("Trying to login the N11 with Excel data.");
        writeText(userNameIdBy, row.getCell(1).toString());
        writeText(passwordIdBy, row.getCell(2).toString());
        click(loginButtonIdBy);
        return this;
    }

    //Verify Username Condition
    @Step("Verify username: {0} step...")
    public LoginPage verifyLoginUserName(String expectedText) {
        Log.info("Verifying login username.");
        waitVisibility(errorMessageUsernameXpathBy);
        assertEquals(readText(errorMessageUsernameXpathBy), expectedText);
        return this;
    }

    //Verify Password Condition
    @Step("Verify verifyLoginPassword: {0} step...")
    public LoginPage verifyLoginPassword(String expectedText) {
        Log.info("Verifying login password.");
        waitVisibility(errorMessagePasswordXpathBy);
        assertEquals(readText(errorMessagePasswordXpathBy), expectedText);
        return this;
    }

    //Verify Password Condition
    @Step("Verify logError: {0} step...")
    public LoginPage verifyLogError() {
        Log.info("Verifying javascript login errors.");
        assertTrue(JSErrorLogs.isLoginErrorLog(driver));
        return this;
    }

    @Step("Writing test status to excel file.")
    public LoginPage saveTestResults(int row, int column) {
        Log.info("Saving test results.");
        ExcelUtil.rowNumber = row ;
        ExcelUtil.columnNumber = column;
        return this;
    }
}