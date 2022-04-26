package hotdeals;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;
public class HotDealsTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";
    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }
    @After
    public void teardown() {
        closeBrowser();
    }
    @Test
    public void verifySaleProductsArrangeAlphabetically() throws InterruptedException {
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[text()='Hot deals']"));
        Thread.sleep(2000);
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-main.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.desktop-header.affix-top div.container div.navbar.navbar-inverse.mobile-hidden:nth-child(4) div.collapse.navbar-collapse ul.nav.navbar-nav.top-main-menu li.leaf.has-sub:nth-child(2) ul:nth-child(2) li.leaf:nth-child(1) a:nth-child(1) > span:nth-child(1)"));
        verifyText("Sale",By.cssSelector("#page-title"),"Sale");
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//*[@id=\"XLite-Module-CDev-Sale-View-SalePage-sortby-1\"]/li[5]/a"));
       // public void verifyText(String expectedMessage,By by,String displayMessage){
       // verifyText("Name A-Z",By.xpath("//span[contains(text(),'Name A - Z')]"),"A-Z");
        verifyText("Name A - Z",By.xpath("//span[contains(text(),'Name A - Z')]"),"Not Sorted");
//		1.4 Mouse hover on “Sort By” and select “Name A-Z”
//		1.5 Verify that the product arrange alphabetically


    }

    @Test
    public void verifySaleProductsPriceArrangeLowToHigh() throws InterruptedException {

//       2.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        Thread.sleep(2000);
//      2.2 Mouse hover on the “Sale”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
       // mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
       // clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//      2.3 Verify the text “Sale”
        verifyText("Sale",By.cssSelector("#page-title"),"Sale");
//      2.4 Mouse hover on “Sort By” and select “Price Low-High”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        Thread.sleep(1000);
        clickOnElement(By.xpath("//li[@class='list-type-grid ']//a[@data-sort-by='translations.name' and @data-sort-order='asc']"));
        Thread.sleep(1000);
//     2.5 Verify that the product’s price arrange Low to High
        verifyText("Low to High",By.xpath("//span[contains(text(),'Price Low - High')]"),"Low to High");


    }

    @Test
    public void verifySaleProductsArrangeByRates() {
//        3.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
//        		3.2 Mouse hover on the “Sale”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//        		3.3 Verify the text “Sale”
        verifyText("Sale",By.cssSelector("#page-title"),"Sale");
//        	3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[@data-sort-by='r.rating']"));
//        	3.5 Verify that the product’s arrange Rates
        verifyText("Recommended",By.xpath("//span[@class='sort-by-value']"),"Not Sorted");

    }

    @Test
    public void verifyBestSellersProductsArrangeByZToA() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
//        		1.2 Mouse hover on the “Bestsellers”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//        	1.3 Verify the text “Bestsellers"
        verifyText("Sale",By.xpath("//h1[@id='page-title']"),"Not in a right page");
        //verifyText("Bestsellers",By.xpath("//h1[@class='title' and contains(text(),'Bestsellers')]"),"Bestsellers");
//        	1.4 Mouse hover on “Sort By” and select “Name Z-A”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/ul[1]/li[5]/a[1]"));
//        	1.5 Verify that the product arrange by Z to A
        Thread.sleep(1000);
        verifyText("Z TO A",By.xpath("//span[@class='sort-by-value' and contains(text(),'Name Z - A')]"),"Not Sorted");
    }

    @Test
    public void verifyBestSellersProductsPriceArrangeHighToLow() {
//        2.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
//        2.2 Mouse hover on the “Bestsellers” link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//		2.3 Verify the text “Bestsellers”
        verifyText("Sale",By.xpath("//h1[@id='page-title']"),"Not in a right Page");
//		2.4 Mouse hover on “Sort By” and select “Price High-Low”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.partialLinkText("Price High - L"));
//		2.5 Verify that the product’s price arrange High to Low
        verifyText("Recommended",By.xpath("//span[@class='sort-by-value']"),"High to Low");

    }

    @Test
    public void verifyBestSellersProductsArrangeByRates() {
//        3.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
//		3.2 Mouse hover on the “Bestsellers”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
       // clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//		3.3 Verify the text “Bestsellers”
        verifyText("Sale",By.xpath("//h1[@id='page-title']"),"Not in a right Page");
//		3.4 Mouse hover on “Sort By” and select “Rates”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.xpath("//a[@data-sort-by='r.rating']"));
//		3.5 Verify that the product’s arrange Rates
        verifyText("Recommended",By.xpath("//span[@class='sort-by-value']"),"arrange Rates");
    }
}






