package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver driver;
    WebDriverWait wait;

    By usernameField = By.id("user-name");
    @FindBy(id = "password")
    WebElement passwordField;
    @FindBy(name = "login-button")
    WebElement loginButton;
    @FindBy(xpath = "//*[contains(text(), 'password do not match')]")
    WebElement errorMsg;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));

    }
    public void inputUsername(String username){
        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        driver.findElement(usernameField).sendKeys(username);
    }
    public String CurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void inputPassword (String password) {
        passwordField.sendKeys(password);
    }
    public void clickLoginButton(){
        loginButton.click();
    }
    public String setErrorMsg(){
        return errorMsg.getText();
    }
    public void stayInTheLoginPage(){
        loginButton.isDisplayed();
    }
}
