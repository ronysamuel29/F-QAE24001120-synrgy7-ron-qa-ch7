import Pages.HomePage;
import Pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SortingTest {
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
    public void sortHilo(){
        HomePage homePage = new HomePage(driver);

        homePage.clickSortButton();
        homePage.clickHiloSorting();

        //assertion1

        Assert.assertEquals(homePage.CurrentUrl(), "https://www.saucedemo.com/inventory.html");
        Assert.assertEquals(homePage.getSortOption(), "Price (high to low)");
        //assertion2 cek harga
        Assert.assertTrue(homePage.firstPrice() > homePage.secondPrice(), "Test failed: First price is not higher than the last price");
        //assertion3 cek condisi

        }

    @AfterTest
    public void closedBrowser(){
        driver.quit();
    }

}
