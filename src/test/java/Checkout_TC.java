import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Checkout_TC extends Test_Base {

    @DataProvider(name = "your_Valid_Information")
    public Object[][] dataprovidermethod() {
        return new Object[][]{
                {"Mohamed", "Ahmed", "123456"},
                {"mahmoud", "Desouki", "456789"},
                {"Hossam", "Ahmed", "456123"}

        };
    }

    @DataProvider(name = "your_Invalid_Information")
    public Object[][] dataprovidermethod2() {
        return new Object[][]{
                {"", "Ahmed", "123456"},
                {"mahmoud", "Desouki",""},
                {"Hossam", "", "456123"}

        };
    }

    @BeforeMethod
    public void checkout() {

        driver.get("https://www.saucedemo.com/");
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();
        for (WebElement item : productsPage.AllItems()) {
            item.click();
        }
        productsPage.shopping_Cart().click();
        cartPage.checkout_Button().click();
    }

    @Test(dataProvider = "your_Valid_Information")
    public void Verify_user_Can_checkout_With_valid_data(String firstName, String lastName, String postalCode) {
        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        softAssert.assertAll();
    }

    @Test(dataProvider = "your_Invalid_Information")
    public void Verify_user_Can_checkout_With_Invalid_data(String firstName, String lastName, String postalCode) {
        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-one.html");
        softAssert.assertAll();
    }

    @Test(priority = 2,dataProvider = "your_Valid_Information")
    public void verify_Functionality_Of_ContinueButton(String firstName, String lastName, String postalCode){
        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        softAssert.assertAll();
    }

    @Test(priority = 3,dataProvider = "your_Valid_Information")
    public void verify_The_FunctionalityOf_FinishButton(String firstName, String lastName, String postalCode){
        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        checkoutPage.finishButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html");
        softAssert.assertAll();
    }

    @Test(priority = 4,dataProvider = "your_Valid_Information")
    public void verify_The_checkout_is_completed_correctly(String firstName, String lastName, String postalCode){
        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        checkoutPage.finishButton().click();
        softAssert.assertTrue(checkoutPage.successMsg().getText().contains("Thank you for your order!"));
    }
}
