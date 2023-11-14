package example.Pages;

import org.example.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class Home_Pge extends AbstractComponent {

    WebDriver driver;

    public Home_Pge(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //    List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
    @FindBy(css = ".inventory_item")
    List<WebElement> products;
//    @FindBy(css =".shopping_cart_link")
//    WebElement shoppingcart;

    By productsBy = By.cssSelector(".inventory_item");
    By addTocart = By.cssSelector(".btn");

    public List<WebElement> getProductsList() {
        waitForElementToAppear(productsBy);
        return products;
    }



    public WebElement getProductByName(String productName) {
        WebElement prod = getProductsList().stream().filter(product -> product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productName)).findFirst().orElse(null);
        return prod;

    }

    public void addProductToCart(String productName)
    {
        WebElement prod = getProductByName(productName);
        prod.findElement(addTocart).click();
    }

}