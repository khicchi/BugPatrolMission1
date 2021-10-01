import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TC4 {
    /*
    1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
    2. Click on the "Verify number" button
    3. Verify a JS alert message is displayed.
    4. Verify the alert message is "Generate random number first!"
    */

    WebDriver driver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        //1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void TC4_Orhi() {

        //2. Click on the "Verify number" button
        driver.findElement(By.id("btnVerifyNumber")).click();

        //3. Verify a JS alert message is displayed
        Alert alert = driver.switchTo().alert();
        String actualAlertMsg = alert.getText();
        boolean alertVerifier = !(actualAlertMsg==null);
        Assert.assertTrue(alertVerifier, "Verify alert message is displayed");

        //4. Verify the alert message is "Generate random number first!"
        String expectedAlertMsg = "Generate random number first!";
        Assert.assertEquals(actualAlertMsg, expectedAlertMsg, "Verify the alert message");

    }

}
