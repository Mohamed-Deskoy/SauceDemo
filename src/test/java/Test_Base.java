import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test_Base {
    public WebDriver driver;
    public WebDriverWait wait;

    public SoftAssert softAssert;


    public Login_Page loginPage;
    public Products_Page productsPage;
    public Checkout_Page checkoutPage;

    public Cart_Page cartPage;

    public Defect_Page defectPage;

    public String standardUsername = "standard_user";
    public String problemUsername = "problem_user";
    public String lockedOutUsername = "locked_out_user";
    public String password = "secret_sauce";

    public String getStandardUsername() {
        return standardUsername;
    }


    public String getProblemUsername() {
        return problemUsername;
    }

    public String getLockedOutUsername() {
        return lockedOutUsername;
    }


    public String getPassword() {
        return password;
    }


    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        softAssert = new SoftAssert();
        loginPage = new Login_Page(driver);
        checkoutPage = new Checkout_Page(driver);
        productsPage = new Products_Page(driver);
        cartPage = new Cart_Page(driver);
        defectPage = new Defect_Page(driver);

        driver.manage().window().maximize();
    }

    @AfterTest
    public void close() {
        driver.quit();
    }

    @AfterClass
    public void close_class() {
        driver.quit();
    }
}
