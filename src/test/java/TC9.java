import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import utilities.WebDriverFactory;

public class TC9 {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://cyberkings.kicchi.net/AutomizationPortal.html");
    }
}
