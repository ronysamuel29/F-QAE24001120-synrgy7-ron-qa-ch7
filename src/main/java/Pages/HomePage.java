package Pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {
    WebDriver driver;
    WebDriverWait wait;

//    @FindBy(xpath = "//*[@class = \"title\"]")
//    WebElement productTitle;

    By productTitle = By.xpath("//*[@id='header_container']/div[2]/span");
    @FindBy(xpath = "//*[@class='shopping_cart_link']")
    WebElement cardLogo;

    //sorting elements
    @FindBy(xpath = "//*[@class='product_sort_container']"  )
    WebElement sortButton;
    @FindBy(xpath = "//*[@value='hilo']")
    WebElement sortingHiloButton;
    By selectedSort = By.xpath("//*[@class='active_option']");
    @FindBy(xpath = "//img[contains(@alt, 'Sauce Labs Fleece Jacket')]")
    WebElement firstProduct;
    By firstPrice = By.xpath("//*[@class='inventory_item_price'][1]");
    By secondPrice = By.xpath("(//*[@class='inventory_item_price'])[2]");
    @FindBy(xpath = "//*[@id = 'item_4_title_link']")
    WebElement secondProduct;
    @FindBy(xpath = "//*[@class = 'shopping_cart_container']")
    WebElement shoppingCart;

    //adding to cart element
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    WebElement goCart1;
    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    WebElement goCart2;
    @FindBy(id="shopping_cart_container")
    WebElement cartButton;

    @FindBy(xpath = "//*[@class = 'shopping_cart_badge']")
    WebElement countProduct;

    public HomePage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));

    }
    public String productPageTitle(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(productTitle));
        return driver.findElement(productTitle).getText();
    }
    public String CurrentUrl(){
        return driver.getCurrentUrl();
    }
    public void clickSortButton(){
        sortButton.click();
    }
    public void clickHiloSorting(){
        sortingHiloButton.click();
    }
    public double firstPrice(){
        String firstPriceString = driver.findElement(firstPrice).getText().replace("$", "");
        return Double.parseDouble(firstPriceString);
        }
    public double secondPrice(){
        String secondPriceString = driver.findElement(secondPrice).getText().replace("$", "");
        return Double.parseDouble(secondPriceString);
    }
    public void shoppingCartIsDisplayed(){
        shoppingCart.isDisplayed();
    }
    public String getSortOption(){
        return driver.findElement(selectedSort).getText();
    }
        public void clickGoCart1(){
        goCart1.click();
    }
    public void clickGoCart2(){
        goCart2.click();
    }
    public void clickCartButton(){
        cartButton.click();
    }
    public String setCountProduct(){
        return countProduct.getText();
    }


}





