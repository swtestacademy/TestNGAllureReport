package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    //*********Page Variables*********
    String baseURL = "http://www.n11.com/";

    //*********Web Elements*********
    String signInButtonClass = "btnSignIn";


    //*********Page Methods*********

    //Go to Homepage
    @Step("Open N11 Step...")
    public void goToN11 (){
        driver.get(baseURL);
        //driver.navigate().to(baseURL)
    }

    //Go to LoginPage
    @Step("Go to Login Page Step...")
    public void goToLoginPage (){
        click(By.className(signInButtonClass));
    }

}
