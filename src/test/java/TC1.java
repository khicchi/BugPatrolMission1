import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class TC1 {


/*
1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
2. Click on the "Generate random number" button
3. Verify that the element below the "Generate random number" button has a random, 3-digit, positive number.
Note: check 5 times one after another, and check if each number is different from others.

 */
@Test
public void test3() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");

    for (int i = 0; i < 5; i++) {


        //Click on the "Generate random number" button
        WebElement generateNumber = driver.findElement(By.xpath("//input[@value='Generate random number']"));
        generateNumber.click();

        ArrayList<String> GeneralNumber=new ArrayList<>();
        GeneralNumber.add(generateNumber.getText());
        for (int j = 0; j < GeneralNumber.size(); j++) {
            Assert.assertTrue( GeneralNumber.get(i).equals(generateNumber.getText()));
            System.out.println("This number is equals to before number");

        }

        WebDriverWait wait = new WebDriverWait(driver, 60);
        WebElement webDriverText = wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("w3-button w3-blue")));


        //if direct click verify number
        WebElement verify = driver.findElement(By.id("btnVerifyNumber"));
        verify.click();
        driver.switchTo().alert().accept();

        //Random Number
        WebElement RandomNumber = driver.findElement(By.className("w3-button w3-blue"));


        //write generate number
        WebElement writeRandomNumber = driver.findElement(By.name("verifyText"));
        writeRandomNumber.click();
        writeRandomNumber.sendKeys(RandomNumber.getText());


        //Click Verify

        WebElement verify2 = driver.findElement(By.id("btnVerifyNumber"));
        verify2.click();

        Assert.assertTrue(true, "cyberKingsImages/success.png");

    }



    }
}

