import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Products_TC extends Test_Base {
    @BeforeMethod
    public void productSetUp() {
        driver.get("https://www.saucedemo.com/");
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();
    }


    @Test
    public void verify_all_items_in_screen_canBeAdded_To_cart() {
        for (WebElement item : productsPage.AllItems()) {
            item.click();
        }
        softAssert.assertEquals("6", productsPage.Num_Of_Item_In_Cart().getText());
        softAssert.assertAll();
    }


    @Test
    public void Verify_all_items_in_Cart_CanBeRemoved(){
        for (WebElement item : productsPage.AllItems()) {
            item.click();
        }

        for (WebElement remove:productsPage.removebutton()){
            remove.click();
        }

        for (WebElement item : productsPage.AllItems()) {
            softAssert.assertTrue(item.isDisplayed());
        }

        softAssert.assertAll();

    }

    @Test
    public void Verify_That_User_Can_Open_the_Specific_item(){
        productsPage.nameOfItem().click();
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory-item.html?id=4");
        softAssert.assertAll();
    }


}
