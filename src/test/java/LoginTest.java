import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {
    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverManager.chromedriver().create();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test(priority = 2)
    //Failed login Test
    public void loginUsingInvalidCredentials(){
        LoginPage loginPage = new LoginPage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("tryWrongPassword");
        loginPage.clickLoginButton();

        //assertion1 get url
        Assert.assertEquals(loginPage.CurrentUrl(), "https://www.saucedemo.com/");
        //assertion2 error msg
        Assert.assertEquals(loginPage.setErrorMsg(), "Epic sadface: Username and password do not match any user in this service");
        //cross icon
        loginPage.stayInTheLoginPage();
    }

    @Test(priority = 1)
    public void loginUsingValidCredentials(){
        LoginPage loginPage = new LoginPage(driver);
        HomePage homePage = new HomePage(driver);

        loginPage.inputUsername("standard_user");
        loginPage.inputPassword("secret_sauce");
        loginPage.clickLoginButton();

        //assertion1 get url
        Assert.assertEquals(homePage.CurrentUrl(), "https://www.saucedemo.com/inventory.html");
        //assertion2
        Assert.assertEquals(homePage.productPageTitle(), "Products");
        //sort
        homePage.shoppingCartIsDisplayed();

    }

    @AfterTest
    public void closedBrowser(){
        driver.quit();
    }
}
