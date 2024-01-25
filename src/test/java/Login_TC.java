import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Login_TC extends Test_Base{
    @BeforeMethod
    public void loginSetup(){
        driver.get("https://www.saucedemo.com/");
    }



    @Test(priority = 1)
    public void test_Login_As_standard_User() {
        //Login with username "standard_user" and Password "secret_sauce"
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        // Verify that the user is logged in by checking for a relevant URL
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        softAssert.assertAll();
    }

    @Test(priority = 2)
    public void test_Login_As_problem_User(){
        loginPage.userName().sendKeys(getProblemUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        // Verify that the user is logged in by checking for a relevant URL
        softAssert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html");
        softAssert.assertAll();
    }

    @Test(priority = 3)
    public void test_LockOutUser_Cannot_login(){
        loginPage.userName().sendKeys(getLockedOutUsername());
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        //Verify that te user cannot log in by checking the error msg displayed
        String actual_errorMsg=loginPage.errorMsg().getText();
        String exp_errorMsg="Epic sadface: Sorry, this user has been locked out.";
        softAssert.assertTrue(actual_errorMsg.contains(exp_errorMsg));
        softAssert.assertAll();
    }

    @Test(priority = 4)
    public void test_Cannot_Login_with_Incorrect_UserName(){
        loginPage.userName().sendKeys("Mohamed Ahmed");
        loginPage.passWord().sendKeys(getPassword());
        loginPage.loginButton().click();

        softAssert.assertTrue(loginPage.errorMsg().isDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 5)
    public void test_Cannot_Login_with_Incorrect_Password(){
        loginPage.userName().sendKeys(getStandardUsername());
        loginPage.passWord().sendKeys("Mohamed Ahmed");
        loginPage.loginButton().click();

        softAssert.assertTrue(loginPage.errorMsg().isDisplayed());
        softAssert.assertAll();
    }

    @Test(priority = 6)
    public void test_Cannot_Login_with_Blank_fields(){
        loginPage.userName().sendKeys("");
        loginPage.passWord().sendKeys("");
        loginPage.loginButton().click();

        softAssert.assertTrue(loginPage.errorMsg().isDisplayed());
        softAssert.assertAll();
    }

}

