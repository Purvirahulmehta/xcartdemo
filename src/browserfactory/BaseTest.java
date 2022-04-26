package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {
    public static WebDriver driver;
    public void openBrowser(String baseUrl){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        driver=new ChromeDriver();
        //Launch the Url
        driver.get(baseUrl);
        //maximise the window
        driver.manage().window().maximize();
        //implict time to the browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
    public void closeBrowser(){
        driver.quit();
    }

}
