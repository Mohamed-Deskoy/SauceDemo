import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Checkout_Page extends Page_Base{
    public Checkout_Page(WebDriver driver) {
        super(driver);
    }

    private By title_Page=By.xpath("//span[@class=\"title\"]");


    private By firstName=By.id("first-name");

    private By lastName=By.id("last-name");

    private By postalCode=By.id("postal-code");

    private By continueButton=By.id("continue");

    private By finish_Button=By.id("finish");

    private By successMsg=By.xpath("//h2[@class=\"complete-header\"]");



    public WebElement title_Page(){
        return driver.findElement(title_Page);
    }

    public WebElement firstName(){
      return driver.findElement(firstName);
    }

    public WebElement lastName(){
        return driver.findElement(lastName);
    }

    public WebElement postalCode(){
        return driver.findElement(postalCode);
    }

    public WebElement continueButton(){
        return driver.findElement(continueButton);
    }

    public WebElement finishButton(){
        return driver.findElement(finish_Button);
    }

    public WebElement successMsg(){
        return driver.findElement(successMsg);
    }

}
