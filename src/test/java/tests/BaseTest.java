package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import pages.HomePage;
import utils.Log;

public class BaseTest {
    protected WebDriver driver;
    protected HomePage  homePage;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void classLevelSetup() {
        Log.startLog("Tests is starting!");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void methodLevelSetup() {
        homePage = new HomePage(driver);
    }

    @AfterClass
    public void teardown() {
        Log.endLog("Tests are ending!");
        driver.quit();
    }
}