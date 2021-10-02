import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

import java.util.List;

public class TC10 {

    WebDriver driver;

    @BeforeMethod
        public void setup(){
         driver = WebDriverFactory.getDriver("chrome");
        }
    @AfterMethod
        public void close() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }

    @Test
    public void TCHun10() throws InterruptedException {

    driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
    WebElement optionButton= driver.findElement(By.id("radio9_24"));
    optionButton.click();
    Thread.sleep(2000);
    optionButton.click();

    List<WebElement> Texts = driver.findElements(By.xpath("//label[.='Gen Z']"));
    Assert.assertEquals(Texts.size(),2);

        System.out.println("There are "+Texts.size() +" \"Gen Z\" texts at the page");


    }
}
