import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Defect_Page extends Page_Base{
    public Defect_Page(WebDriver driver) {
        super(driver);
    }

    private By sauce_BackPack=By.xpath("(//div[@class=\"inventory_item_desc\"])[1]");

    private By sacue_T_Shirt=By.xpath("(//div[@class=\"inventory_item_name \"])[6]");

    private By sauce_List_Imgs_URLS=By.xpath("//img[@class=\"inventory_item_img\"]");

    public WebElement sauce_Backpack(){
        return driver.findElement(sauce_BackPack);
    }

    public WebElement sauce_T_Shirt(){
        return driver.findElement(sacue_T_Shirt);
    }

    public List<WebElement>List_Images_URL(){
        return driver.findElements(sauce_List_Imgs_URLS);
    }
}
