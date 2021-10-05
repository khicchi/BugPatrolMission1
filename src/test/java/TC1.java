import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

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

        List<String> GeneralNumber = new ArrayList<>();
        WebElement generateNumber = driver.findElement(By.xpath("//input[@value='Generate random number']"));
        generateNumber.click();
        GeneralNumber.add(generateNumber.getText());
        String number=GeneralNumber.get(0);

        for (int i = 0; i < 4; i++) {

                //Click on the "Generate random number" button
                generateNumber = driver.findElement(By.xpath("//input[@value='Generate random number']"));
                generateNumber.click();

                GeneralNumber.add(generateNumber.getText());
                for (int j = 0; j < GeneralNumber.size(); j++) {
                        if (number==GeneralNumber.get(j)){
                                System.out.println("Random numbers is the same");
                        }
                        number=GeneralNumber.get(i);
        }



        }

        //



    }


    @AfterClass
        public void test()
    {
           try {
                   Thread.sleep(3000);
           }catch (Exception a){
                   System.out.println(a.getMessage());
           }

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            driver.quit();
    }
}

