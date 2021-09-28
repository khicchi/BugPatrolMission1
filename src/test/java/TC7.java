
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TC7 {

    /*
    1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
    2. Click "Submit" button
    3. Verify "No car selected" text is displayed
    4. Click "Fiat" from the dropdown list
    5. Click "Submit" button
    6. Verify "Fiat selected" text is displayed
    */

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1500);
        driver.quit();
    }

    @Test
    public void testCase7(){
        //2. Click "Submit" button
        driver.findElement(By.cssSelector("*[type='submit']")).click();

        //3. Verify "No car selected" text is displayed
        Assert.assertEquals(driver.findElement(By.id("pCarMessage")).getText(), "No car selected", " Text 'No car selected' not shown");

        //4. Click "Fiat" from the dropdown list
        Select carsDropdown = new Select(driver.findElement(By.id("cars")));
        carsDropdown.selectByVisibleText("Fiat");

        //5. Click "Submit" button
        driver.findElement(By.cssSelector("*[type='submit']")).click();

        //6. Verify "Fiat selected" text is displayed
        Assert.assertEquals(driver.findElement(By.id("pCarMessage")).getText(), "Fiat selected", " Text 'Fiat selected' not shown");




    }

}
