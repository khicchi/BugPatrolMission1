import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC1 {


/*
1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
2. Click on the "Generate random number" button
3. Verify that the element below the "Generate random number" button has a random, 3-digit, positive number.
Note: check 5 times one after another, and check if each number is different from others.

 */
@BeforeClass
public void test3()  {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");


        //Click on the "Generate random number" button
        WebElement generateNumber = driver.findElement(By.xpath("//input[@value='Generate random number']"));
        generateNumber.click();

        ArrayList<String> GeneralNumber=new ArrayList<>();
        GeneralNumber.add(generateNumber.getText());




    }
}

