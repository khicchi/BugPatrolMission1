import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC3azod {


@Test
public void test3() throws InterruptedException {
/*1. Go to "http://cyberkings.kicchi.net/AutomizationPortal.html"
2. Click on the "Generate random number" button
3. Type a different number from the generated number into the textbox below the
number
4. Click on the "Verify number" button
5. Verify that a red cross image is displayed
 */
    WebDriverManager.chromedriver().setup();
    WebDriver driver = new ChromeDriver();
    driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");

    //Click on the "Generate random number" button
    driver.findElement(By.xpath("//input[@value='Generate random number']")).click();

    //check generated number
    String generatedNumber = driver.findElement(By.cssSelector("input[class]~p")).getText();
    System.out.println("generatedNumber = " + generatedNumber);

    //Type different number from generated number
    driver.findElement(By.cssSelector("input[name='verifyText']")).sendKeys(generatedNumber+1);
    driver.findElement(By.cssSelector("#btnVerifyNumber")).click();

    //Check the redFlag
    WebElement redFlag = driver.findElement(By.cssSelector("img[src='cyberKingsImages/failure.png']"));
    Assert.assertTrue(redFlag.isDisplayed(),"check again");


}
}
