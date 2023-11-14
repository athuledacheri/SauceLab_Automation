package example.Pages;

import org.example.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Confirmation_Page extends AbstractComponent {

    WebDriver driver;

    public Confirmation_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".complete-header")
    WebElement confirmMsg;

    public String getConfirmationMessage()
    {
        Confirmation_Page cpp = new Confirmation_Page(driver);
        return confirmMsg.getText();
    }
}
