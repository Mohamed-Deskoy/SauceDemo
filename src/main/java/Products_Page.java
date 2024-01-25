import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.PrimitiveIterator;

public class Products_Page extends Page_Base {
    public Products_Page(WebDriver driver) {

        super(driver);
    }

    //Alocate the Elements
    private By titlePage = By.xpath("//span[@class=\"title\"]");

    private By shopping_Cart=By.xpath("//a[@class=\"shopping_cart_link\"]");

    private By items=By.xpath("//button[@class=\"btn btn_primary btn_small btn_inventory \"]");

    private By removeButton=By.xpath("//button[@class=\"btn btn_secondary btn_small btn_inventory \"]");

    private By numberOfItems_In_Cart=By.xpath("//span[@class=\"shopping_cart_badge\"]");

    private By nameOfItem=By.id("item_4_title_link");

    //Return WebElements
    public WebElement titlePage() {
        return driver.findElement(titlePage);
    }


    public WebElement shopping_Cart(){
        return driver.findElement(shopping_Cart);
    }

    public List<WebElement>AllItems(){

        return driver.findElements(items);
    }

    public WebElement Num_Of_Item_In_Cart(){
        return driver.findElement(numberOfItems_In_Cart);
    }

    public List<WebElement>removebutton(){

        return driver.findElements(removeButton);
    }

    public WebElement nameOfItem(){
        return driver.findElement(nameOfItem);
    }
}
