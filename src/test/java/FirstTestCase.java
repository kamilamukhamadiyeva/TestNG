import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import java.time.Duration;

public class FirstTestCase  {

    WebDriver driver;
    @BeforeSuite
    public void setup(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
    @Test()
    public void websiteTest(){
        driver.get("https://www.saucedemo.com/");
    }
/*
    @Test(priority = 1)
    public void cartTest(){
        WebElement product1 = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-backpack']"));
        WebElement product2 = driver.findElement(By.xpath("//*[@id='add-to-cart-sauce-labs-bolt-t-shirt']"));
        product1.click();
        product2.click();

        WebElement cart = driver.findElement(By.className("shopping_cart_link"));
        cart.click();

        WebElement item1 = driver.findElement(By.id("item_4_title_link"));
        WebElement item2 = driver.findElement(By.id("item_1_title_link"));
        Assert.assertEquals(item1.getText(), "Sauce Labs Backpack");
        Assert.assertEquals(item2.getText(), "Sauce Labs Bolt T-Shirt");
    }

    @Test(dataProvider = "checkoutData", priority = 2)
    public void checkoutTest(String firstname, String lastname, String zipcode,String expectedUrl){
        WebElement checkoutBtn = driver.findElement(By.id("checkout"));
        checkoutBtn.click();

        WebElement fname = driver.findElement(By.name("firstName"));
        WebElement lname = driver.findElement(By.name("lastName"));
        WebElement code = driver.findElement(By.name("postalCode"));
        WebElement continuebtn = driver.findElement(By.name("continue"));

        fname.sendKeys(firstname);
        lname.sendKeys(lastname);
        code.sendKeys(zipcode);
        continuebtn.click();

        WebElement finishbtn = driver.findElement(By.name("finish"));
        finishbtn.click();

        Assert.assertEquals(driver.getCurrentUrl(), expectedUrl);
    }
    @DataProvider(name = "checkoutData")
    public Object[][] checkoutData(){
        return new Object[][]{
                {"Kamila", "M", "000000", "https://www.saucedemo.com/checkout-complete.html"}
        };
    };
    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce", "https://www.saucedemo.com/inventory.html"}
        };
    }*/

    @AfterSuite

    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }

}


