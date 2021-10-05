import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

public class TC1 {


/*
1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
2. Click on the "Generate random number" button
3. Verify that the element below the "Generate random number" button has a random, 3-digit, positive number.
Note: check 5 times one after another, and check if each number is different from others.

 */
WebDriver driver;

    @BeforeMethod
    void setupMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @AfterMethod
    void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    void testCase1(){
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
        WebElement buttonGenerate = driver.findElement(By.cssSelector("[onclick='generateRandomNumber()']"));
        ArrayList<Integer> generatedNumbers = new ArrayList<>();
        WebElement labelNumber = driver.findElement(By.cssSelector("[onclick='generateRandomNumber()']~p"));

        for (int i = 0; i < 5; i++) {
            buttonGenerate.click();
            int currentNumber = Integer.parseInt(labelNumber.getText());
            Assert.assertTrue(currentNumber >= 100 && currentNumber <=999);
            generatedNumbers.add(currentNumber);
        }

        for (int i = 0; i < 5; i++) {
            int occurrences = Collections.frequency(generatedNumbers, generatedNumbers.get(i));
            Assert.assertEquals(occurrences, 1);
        }

        System.out.println(generatedNumbers.toString());
    }


}

