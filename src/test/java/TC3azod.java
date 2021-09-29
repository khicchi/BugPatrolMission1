import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TC3azod {


@Test
public void test3(){
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
    driver.findElement(By.xpath("//input[@value='Generate random number']")).click();

}
}
