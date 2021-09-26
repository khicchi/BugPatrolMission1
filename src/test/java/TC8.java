import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TC8 {
    WebElement[][] labels = null;

    WebDriver driver;
    WebElement cbTV, cbConsole, cbSmartPhone, labelTV, labelConsole, labelSmartPhone, messageElement;

    @BeforeClass
    void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeMethod
    void setupMethod(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");

        cbTV = driver.findElement(By.id("cbTV"));
        cbConsole = driver.findElement(By.id("cbConsole"));
        cbSmartPhone = driver.findElement(By.id("cbSmartPhone"));
        labelTV =driver.findElement(By.xpath("//label[.='TV']"));
        labelConsole = driver.findElement(By.xpath("//label[.='Console']"));
        labelSmartPhone = driver.findElement(By.xpath("//label[.='Smart Phone']"));
        messageElement = driver.findElement(By.tagName("h5"));

        labels = new WebElement[][]{ {labelTV,cbTV}, {labelConsole,cbConsole}, {labelSmartPhone,cbSmartPhone} };
    }

    @AfterMethod
    void tearDownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }


}
