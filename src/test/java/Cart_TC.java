import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Cart_TC extends Test_Base {
    @BeforeMethod
    public void cart_SetUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();
        for (WebElement item : productsPage.AllItems()) {
            item.click();
        }
        productsPage.shopping_Cart().click();
    }

    @Test(priority = 1)
    public void verify_all_added_items_showIn_cart() {
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/cart.html");

        for (WebElement item : cartPage.Items_Cart()) {
            softAssert.assertTrue(item.isDisplayed());
        }
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void verify_functionality_Of_CheckoutButton() {
        cartPage.checkout_Button().click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void verify_all_Items_CanBeRemoved_From_Cart() {

        for (WebElement remove : cartPage.removeItems()) {
            remove.click();
        }
        softAssert.assertEquals(cartPage.removeItems().size(), 0);
        softAssert.assertAll();
    }


}
