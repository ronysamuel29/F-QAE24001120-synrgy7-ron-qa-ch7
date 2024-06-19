package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CartPage {
    WebDriver driver;
    WebDriverWait wait;

    //temukan yang mau ditemukan
    By checkoutButton = By.id("checkout");
    @FindBy(id = "first-name")
    WebElement addFirstName;
    @FindBy(id = "last-name")
    WebElement addLastName;
    @FindBy(id = "postal-code")
    WebElement addPostalCode;
    @FindBy(id = "continue")
    WebElement continueButton;
    @FindBy(id = "finish")
    WebElement finishButton;
    @FindBy(xpath = "//img[contains(@class, 'pony_express')]")
    WebElement completedIMG;
    @FindBy(xpath = "(//*[@class = 'inventory_item_name'])[1]")
    WebElement product1;
    @FindBy(xpath = "(//*[@class = 'inventory_item_name'])[2]")
    WebElement product2;



    public CartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }
    public void clickCheckoutButton() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(checkoutButton));
        driver.findElement(checkoutButton).click();
    }
    public void typeFirstName(String firstName) {
        addFirstName.sendKeys(firstName);
    }
    public void typeLastName(String lastName) {
        addLastName.sendKeys(lastName);
    }
    public void typePostalCode(String postalCode) {
        addPostalCode.sendKeys(postalCode);
    }
    public void clickContinueButton(){
        continueButton.click();
    }
    public void clickFinishButton(){
        finishButton.click();
    }
    public void CompletedIMGisDisplayed(){
        completedIMG.isDisplayed();
    }
    public String product1isDisplayed(){
        return product1.getText();
    }
    public String product2isDisplayed(){
        return product2.getText();
    }

}
