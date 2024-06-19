import Pages.CartPage;
import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CheckoutTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");

        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();
    }

    @Test
    public void checkout(){
        HomePage homePage = new HomePage(driver);
        CartPage cartPage = new CartPage(driver);

        //masukkan barang ke keranjang
        homePage.clickGoCart1();
        homePage.clickGoCart2();
        //assertion1 ada barang dikeranjang
        Assert.assertEquals(homePage.setCountProduct(),"2");

        // ke halaman keranjang
        homePage.clickCartButton();
        //assertion2 memastikan barang masuk keranjang
        Assert.assertEquals(cartPage.product1isDisplayed(),"Sauce Labs Backpack");
        Assert.assertEquals(cartPage.product2isDisplayed(),"Sauce Labs Bike Light");

        cartPage.clickCheckoutButton();

        //isi informasi
        cartPage.typeFirstName("rony");
        cartPage.typeLastName("skywalker");
        cartPage.typePostalCode("290802");
        //click continue
        cartPage.clickContinueButton();
        //assertion3 memastikan barang tetap di keranjang
        Assert.assertEquals(cartPage.product1isDisplayed(),"Sauce Labs Backpack");
        Assert.assertEquals(cartPage.product2isDisplayed(),"Sauce Labs Bike Light");

        //click finish button
        cartPage.clickFinishButton();
        //assetion4 memastikan sudah selesai dengan menampilkangambar
        cartPage.CompletedIMGisDisplayed();
    }

    @AfterTest
    public void closedBrowser(){
        driver.quit();
    }

}
