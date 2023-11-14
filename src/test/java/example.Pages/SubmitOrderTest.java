package example.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;


public class SubmitOrderTest {

    public static void main(String[] args) {
        String productName = "Sauce Labs Bike Light";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        Login_page lp = new Login_page(driver);
        lp.goTo();
        Home_Pge hp = lp.loginApplication("standard_user", "secret_sauce");
//        Home_Pge hp = new Home_Pge(driver);
        List<WebElement> products = hp.getProductsList();
        hp.addProductToCart(productName);
        Cart_Page cp =   hp.goToCartPage();
//        Cart_Page cp = new Cart_Page(driver);
        Boolean match =  cp.cartValidation(productName);
        Assert.assertTrue(match);
        CheckOut_Page cop = cp.goTOCheckOut();
//        CheckOut_Page cop = new CheckOut_Page(driver);
        cop.EnterPersonalDetails("Athul","Ashok","67032");
        cop.clickContinue();
        Confirmation_Page cpp =  cop.clickFinish();
//        Confirmation_Page cpp = new Confirmation_Page(driver);
        String confirmMessage = cpp.getConfirmationMessage();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
        driver.close();



    }
}


