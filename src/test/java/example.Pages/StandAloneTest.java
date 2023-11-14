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


public class StandAloneTest {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String productName = "Sauce Labs Bike Light";
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

//        String HomeMessage = driver.findElement(By.cssSelector(".item")).getText();
//        String expectedMessage ="Products";
//        Assert.assertEquals(HomeMessage,expectedMessage);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".item")));
//        boolean Display = driver.findElement(By.cssSelector(".item")).isDisplayed();
//        System.out.println("Element displayed is :"+Display);


        List<WebElement> products = driver.findElements(By.cssSelector(".inventory_item"));
        WebElement prod =products.stream().filter(product->product.findElement(By.cssSelector(".inventory_item_name ")).getText().equals(productName)).findFirst().orElse(null);
        prod.findElement(By.cssSelector(".btn")).click();

        driver.findElement(By.cssSelector(".shopping_cart_link")).click();

        List <WebElement> cartProducts = driver.findElements(By.cssSelector(".inventory_item_name"));
        Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
        Assert.assertTrue(match);
        driver.findElement(By.id("checkout")).click();

        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.id("first-name")),"athul").build().perform();
        a.sendKeys(driver.findElement(By.id("last-name")),"edacheri").build().perform();
        a.sendKeys(driver.findElement(By.id("postal-code")),"670102").build().perform();
        driver.findElement(By.id("continue")).click();
        driver.findElement(By.id("finish")).click();

        String confirmMessage = driver.findElement(By.cssSelector(".complete-header")).getText();
        Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thank you for your order!"));
        driver.close();

    }
}


