import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC7 {

    /*
    1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
    2. Click "Submit" button
    3. Verify "No car selected" text is displayed
    4. Click "Fiat" from the dropdown list
    5. Click "Submit" button
    6. Verify "Fiat selected" text is displayed
    */

    WebElement[][] labels = null;
    WebDriver driver;

    @BeforeClass
    void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupMethod() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
    }

    @AfterMethod
    void tearDown(){
        driver.quit();
    }

    @Test
    public void testCase7(){
        //2. Click "Submit" button
        driver.findElement(By.cssSelector("*[type='submit']")).click();



    }

}
