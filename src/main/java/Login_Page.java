import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Login_Page extends Page_Base {
    public Login_Page(WebDriver driver) {
        super(driver);
    }


    //Alocate the Elements
    private By userName = By.id("user-name");
    private By passWord = By.id("password");
    private By loginButton = By.id("login-button");

    private By errorMsg = By.xpath("//h3[@data-test=\"error\"]");

    //Return WebElements
    public WebElement userName() {
        return driver.findElement(userName);
    }

    public WebElement passWord() {
        return driver.findElement(passWord);
    }

    public WebElement loginButton() {
        return driver.findElement(loginButton);
    }

    public WebElement errorMsg(){
        return driver.findElement(errorMsg);
    }
}

