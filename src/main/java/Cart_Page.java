import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Cart_Page extends Page_Base{

    public Cart_Page(WebDriver driver) {
        super(driver);
    }

    private By itemsInCartPage=By.xpath("//div[@class=\"inventory_item_name\"]");
    private By checkout_Button=By.id("checkout");

    private By removeItemList=By.xpath("//button[@class=\"btn btn_secondary btn_small cart_button\"]");

    public List<WebElement>Items_Cart(){
        return driver.findElements(itemsInCartPage);
    }

    public WebElement checkout_Button(){
        return driver.findElement(checkout_Button);
    }
    public List<WebElement>removeItems(){
        return driver.findElements(removeItemList);
    }
}
