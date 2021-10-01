import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TC10 {

@Test
    public void TCHun10() throws InterruptedException {

    WebDriver driver = WebDriverFactory.getDriver("chrome");

    driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
    WebElement optionButton= driver.findElement(By.id("radio9_24"));
    optionButton.click();
    Thread.sleep(2000);
    optionButton.click();

    System.out.println("hello");
    System.out.println("helloaa");
    System.out.println("fadfaf");

    System.out.println("helloaa");




  }
}
