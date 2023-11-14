package org.example;

import example.Pages.Cart_Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
public class AbstractComponent
{
    WebDriver driver;

    public AbstractComponent(WebDriver driver) {

        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(css =".shopping_cart_link")
    WebElement shoppingcart;



    public void waitForElementToAppear(By findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));

    }

    public void waitForWebElementToAppear(WebElement findBy) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(findBy));

    }

    public Cart_Page goToCartPage()
    {
        shoppingcart.click();
        Cart_Page cp = new Cart_Page(driver);
        return cp;
    }
//
//    public OrderPage goToOrdersPage()
//    {
//        orderHeader.click();
//        OrderPage orderPage = new OrderPage(driver);
//        return orderPage;
//    }
    public void waitForElementToDisappear(WebElement ele) throws InterruptedException
    {
        Thread.sleep(1000);
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//		wait.until(ExpectedConditions.invisibilityOf(ele));

    }
}
