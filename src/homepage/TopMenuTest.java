package homepage;


import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class TopMenuTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void teardown() {
        closeBrowser();
    }
    //Kalpeshbhai shipping code
    //div[@class='collapse navbar-collapse']//ul/li[3]/a

    @Test
    public void verifyUserShouldNavigateToShippingPageSuccessfully() throws InterruptedException {
        //clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[3]/a[1]/span[1]"));
       clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Shipping']"));
        Thread.sleep(3000);
        verifyText("Shipping", By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/h1[1]"), "Shipping");
        //verifyText("Shipping", By.xpath("//h1[@xpath='1' and contains(.,'Shipping')]"), "Shipping");
    }


    @Test
    public void verifyUserShouldNavigateToNewPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='New!']"));
        Thread.sleep(1000);
        verifyText("New", By.xpath("//h1[@xpath='1' and contains(.,'New arrivals')]"), " New arrivals");
    }

    @Test
    public void verifyUserShouldNavigateToComingsoonPageSuccessfully() throws InterruptedException {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Coming soon']"));
        Thread.sleep(1000);
        verifyText("Comingsoon", By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/h1[1]"), "Coming soon");
    }

    @Test
    public void verifyUserShouldNavigateToContactUsPageSuccessfully() {
        clickOnElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Contact us']"));
        verifyText("Contact us",By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/h1[1]"),"Contact us");
    }
}
