package example.Pages;

import org.example.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckOut_Page  extends AbstractComponent {
    WebDriver driver;

    public CheckOut_Page(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement btn_continue;

    @FindBy(id = "finish")
    WebElement btn_finish;

//    public void enterFirstname(String fName) {
//        Actions a = new Actions(driver);
//        a.sendKeys(firstName, fName);
//
//    }
//    public void enterLastname( String lName) {
//        Actions a = new Actions(driver);
//        a.sendKeys(lastName, lName);
//
//
//    }
//    public void enterPinCode( String pin) {
//        Actions a = new Actions(driver);
//        a.sendKeys(postalCode, pin);
//
//    }


    public void EnterPersonalDetails(String fname, String lname,String pin)
    {
        firstName.sendKeys(fname);
        lastName.sendKeys(lname);
        postalCode.sendKeys(pin);

    }
    public void clickContinue()
    {
        btn_continue.click();
    }

    public Confirmation_Page clickFinish()
    {
        btn_finish.click();
        return new Confirmation_Page(driver);


    }

//    public String getConfirmationMessage()
//    {
//       Confirmation_Page cpp = new Confirmation_Page(driver);
//       return cpp.toString();
//    }



}

