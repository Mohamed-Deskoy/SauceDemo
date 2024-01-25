import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Defects_TC extends Test_Base{
    @BeforeMethod
    public void Defect_Setup(){
        driver.get("https://www.saucedemo.com/");
    }

    String [] expected_Images_URL={
      "https://www.saucedemo.com/static/media/sauce-backpack-1200x1500.0a0b85a3.jpg",
      "https://www.saucedemo.com/static/media/bike-light-1200x1500.37c843b0.jpg",
      "https://www.saucedemo.com/static/media/bolt-shirt-1200x1500.c2599ac5.jpg",
      "https://www.saucedemo.com/static/media/sauce-pullover-1200x1500.51d7ffaf.jpg",
      "https://www.saucedemo.com/static/media/red-onesie-1200x1500.2ec615b2.jpg",
      "https://www.saucedemo.com/static/media/red-tatt-1200x1500.30dadef4.jpg"
    };


    @DataProvider(name = "Verify_Your_information")
    public Object[][] dataprovidermethod() {
        return new Object[][]{
                {"Mohamed", "Ahmed", "123456"},
                {"mahmoud", "Desouki", "456789"},
                {"Hossam", "Ahmed", "456123"}

        };
    }

    //Defects for Standard_User
    //BUG_01 The description is wrong for Product one(should not be contains the Carry.all the thing())
    @Test
    public void verify_That_Description_Of_productOne(){
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        String actual_Description=defectPage.sauce_Backpack().getText();
        String exp_Description="with the sleek, streamlined Sly Pack that melds uncompromising style with unequaled laptop and tablet protection.";

        softAssert.assertEquals(actual_Description,exp_Description);
        softAssert.assertAll();
    }

    //BuG_02 The title of the product 6 is Wrong (Should be sauce labs T-Shirt(Red))

    @Test
    public void verify_That_Title_Of_productSix(){
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        String actual_Title=defectPage.sauce_T_Shirt().getText();
        String exp_Title="sauce labs T-Shirt(Red)";
        softAssert.assertEquals(actual_Title,exp_Title);
        softAssert.assertAll();
    }

    //Defects for Problem_user
    //BUG_01 incorrect products images
    @Test
    public void verify_That_Images_Of_products(){
        loginPage.userName().sendKeys(getProblemUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        for (int i=0;i<6;i++){
            WebElement image=defectPage.List_Images_URL().get(i);
            String expectedImage=expected_Images_URL[i];
            String actualImage=image.getAttribute("src");
            softAssert.assertEquals(actualImage,expectedImage);
        }
        softAssert.assertAll();
    }

//    //BUG_02 The Add To cart button not working for the 3 ,4,6 products
//    @Test
//    public void verify_The_Add_To_Cart(){
//        loginPage.userName().sendKeys(getProblemUsername());
//        loginPage.passWord().sendKeys(getPassword());
//        loginPage.loginButton().click();
//
//        for (WebElement item : productsPage.AllItems()) {
//            item.click();
//        }
//
//        for (WebElement remove:productsPage.removebutton()){
//            remove.click();
//        }
//
//        for (WebElement item : productsPage.AllItems()) {
//            softAssert.assertTrue(item.isDisplayed());
//        }
//
//        softAssert.assertAll();
//
//    }

    //Bug_03 The Last name not accept any value
    @Test(dataProvider = "Verify_Your_information")
    public void Verify_Your_information(String firstName, String lastName, String postalCode) {
        loginPage.userName().sendKeys(getProblemUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        for (WebElement item : productsPage.AllItems()) {
            item.click();
        }
        productsPage.shopping_Cart().click();
        cartPage.checkout_Button().click();

        checkoutPage.firstName().sendKeys(firstName);
        checkoutPage.lastName().sendKeys(lastName);
        checkoutPage.postalCode().sendKeys(postalCode);
        checkoutPage.continueButton().click();
        softAssert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html");
        softAssert.assertAll();
    }

}
