package example.Pages;

import org.example.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;

public class Cart_Page  extends AbstractComponent {
    WebDriver driver;

    public Cart_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".inventory_item_name")
    List<WebElement> cartProducts;

    @FindBy(id ="checkout")
    WebElement checkout;



    public Boolean cartValidation(String productName) {
        Boolean match = cartProducts.stream().anyMatch(cartProduct -> cartProduct.getText().equalsIgnoreCase(productName));
       return match;

    }

    public CheckOut_Page goTOCheckOut()
    {
        checkout.click();
        CheckOut_Page cop = new CheckOut_Page(driver);
        return cop;
    }
}

