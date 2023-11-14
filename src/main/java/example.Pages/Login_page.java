package example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login_page {
    WebDriver driver;

    public Login_page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    // Elements
    @FindBy(id = "user-name")
    WebElement TxtUserName;

    @FindBy(id = "password")
    WebElement TxtPassword ;

    @FindBy(id = "login-button")
    WebElement login ;


  public Home_Pge loginApplication(String uname, String password)
  {
      TxtUserName.sendKeys(uname);
      TxtPassword.sendKeys(password);
      login.click();
      Home_Pge hp = new Home_Pge(driver);
      return hp;

  }


  public void goTo()
    {
        driver.get("https://www.saucedemo.com/");
    }



}
