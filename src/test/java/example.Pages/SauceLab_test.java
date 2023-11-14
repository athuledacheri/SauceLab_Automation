//package example.Pages;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.annotations.AfterTest;
//import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.Test;
//
//public class SauceLab_test {
//
//    WebDriver driver = new ChromeDriver();
//   Login_page hp = new Login_page(driver);
//   Home_Pge   hpp = new Home_Pge(driver);
//
//
//    @BeforeMethod
//    public void initiateSession() {
//        driver.get("https://www.saucedemo.com/");
//        driver.manage().window().maximize();
//    }
//
//    @AfterTest
//    public void terminateSession() {
//        driver.quit();
//    }

    //****************************************************************\\
    //*************Login Data Provider & Test Method*****************\\
    //****************************************************************\\
//    @DataProvider
//    public Object[][] signInDataProvider() {
//        return new Object[][] {
//                new Object[] { "standard_user", "secret_sauce"},
////                new Object[] { "locked_out_user", "secret_sauce"},
////                new Object[] { "problem_user", "secret_sauce"},
////                new Object[] { "performance_glitch_user", "secret_sauce"},
//        };
//    }

////    @Test(dataProvider ="signInDataProvider", priority=1)
//@Test(priority=1)
//    public void signInMethod () throws InterruptedException {
//        hp.setUsername("standard_user");
//        hp.setPassword("secret_sauce");
//        hp.clickRegister();
//    }

//    @Test(priority=2)
//    public void cart() throws InterruptedException {
//
//        hpp.clickAddCart();
//        hpp.clickshoppingCart();
//    }
//
//}

