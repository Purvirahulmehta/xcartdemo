package shopping;

import com.google.common.base.Verify;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Mouse;
import utilities.Utility;

public class ShoppingTest extends Utility {
    String baseUrl = "https://mobile.x-cart.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @After
    public void teardown() {
        closeBrowser();
    }

    //  @Test
    public void verifyThatUserShouldPlaceOrderSuccessfullyForOllieTheAppControlledRobot() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        Thread.sleep(2000);
//        1.2 Mouse hover on the “Bestsellers”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//        1.3 Verify the text “Bestsellers”
        verifyText("Sale", By.xpath("//h1[@id='page-title']"), "Not in a right Page");
        //  1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.partialLinkText("Name A -"));
//        1.5 Click on “Add to cart” button of the product “Ollie - The App Controlled Robot”
        clickOnElement(By.xpath("//button[@class='btn  regular-button add-to-cart product-add2cart productid-42']"));
//        1.6 Verify the message “Product has been added to your cart” display in  green bar
        verifyText("Product has been added to your cart", By.xpath(""), "Your cart is empty");
//        1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
//        1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[@xpath='1' and contains(text(),'View cart')]"));
//        1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 item", By.xpath("//h1[@xpath='1' and contains(text(),'Your shopping cart ')]"), "Your shopping cart - 1 item");
//        1.10 Verify the Subtotal $99.00
        verifyText("Total $99.00", By.xpath("//span[@class='cart-subtotal']/parent::li/ancestor::ul"), "Total is not matched");
//        1.11 Verify the total $106.23//li[contains(text(),'Product has been added to your cart')]
        verifyText("Total $106.23", By.xpath("//li[@class='total']"), "Total is not matched");
//        1.12 Click on “Go to checkout” button
        clickOnElement(By.cssSelector("body.area-c.skin-customer.skin-crisp_white-customer.skin-theme_tweaker-customer.unauthorized.target-cart.no-sidebars.responsive-desktop:nth-child(2) div.mm-page.mm-slideout:nth-child(4) div.clearfix div.flex-container div.column:nth-child(2) div.section div.list-container:nth-child(2) div.block.block-block:nth-child(3) div.content div.clearfix div:nth-child(2) ul.totals li.button.main-button button.btn.regular-button.regular-main-button.checkout > span:nth-child(1)"));
//        1.13 Verify the text “Log in to your account”
        verifyText("Log in to your account", By.xpath("//h3[@class='heading' and contains(text(),'Log in to your account')]"), "Page is not displayed");
////        1.14 Enter Email address
        sendTextToElement(By.xpath("//input[@name='email']"), "Poojashah@gmail.com");
////        1.15 Click on “Continue” Button
        clickOnElement(By.xpath("//button[@class='btn  regular-button anonymous-continue-button submit']"));
////        1.16 Verify the text “Secure Checkout”
        verifyText("secure checkout", By.xpath("//h1[@class='title']"), "Page is not in displayed");
////        1.17 Fill all the mandatory fields
        sendTextToElement(By.xpath("//input[@class='field-firstname field-required validate[required,maxSize[255]] form-control']"), "Pooja");
        sendTextToElement(By.xpath("//input[@name='shippingAddress[lastname]']"), "Shah");
        sendTextToElement(By.xpath("//input[@name='shippingAddress[street]']"), "Laxmi Nivas");
        sendTextToElement(By.xpath("//input[@name='shippingAddress[city]']"), "Harrow");
        clickOnElement(By.xpath("//select[@id='shippingaddress-country-code']"));
        sendTextToElement(By.xpath("//input[@id='shippingaddress-custom-state']"), "London");
        sendTextToElement(By.xpath("//input[@id='shippingaddress-zipcode']"), "364001");
        sendTextToElement(By.xpath("//input[@id='email']"), "Poojashah@gmail.com");
////        1.18 Check the check box “Create an account for later use”
        clickOnElement(By.xpath("//input[@type='checkbox']"));
////        1.19 Enter the password
        clickOnElement(By.xpath("//input[@name='password']"));
////        1.20 Select the Delivery Method to “Local Shipping”
        clickOnElement(By.xpath("//input[@id='method128']"));
////        1.21 Select Payment Method “COD”
        clickOnElement(By.xpath("//input[@value='6']"));
////        1.22 Verify the total $99.00
        verifyText("$99.00", By.xpath("//div[@class='total clearfix']"), "Total is not correct");
////        1.23 Click on “Place Order” Button
        clickOnElement(By.xpath("//span[text()='Place order: $311.03']"));
////        1.24 Verify the text “Thank you for your order”
        verifyText("Thank you for your order", By.xpath("//h1[text()='Thank you for your order']"), "Page is not displayed");


    }

    @Test
    public void verifyThatUserShouldClearShoppingCartSuccessfully() throws InterruptedException {
//        1.1 Mouse hover on the “Hot deals” link
        mouseHooverToElement(By.xpath("//ul[@class='nav navbar-nav top-main-menu']//span[@class='primary-title']"));
        Thread.sleep(2000);
//        1.2 Mouse hover on the “Bestseller”  link and click
        clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[4]/div[1]/ul[1]/li[2]/ul[1]/li[1]/a[1]/span[1]"));
//        1.3 Verify the text “Bestsellers”
        verifyText("Sale", By.xpath("//h1[@id='page-title']"), "Not in a right Page");
        Thread.sleep(2000);
//        1.4 Mouse hover on “Sort By” and select “Name A-Z”
        mouseHooverToElement(By.xpath("//span[@class='sort-by-label']"));
        clickOnElement(By.partialLinkText("Name A -"));
        Thread.sleep(2000);
//        1.5 Click on “Add to cart” button of the product “Vinyl Idolz: Ghostbusters”

        //clickOnElement(By.xpath("//img[@alt='Vinyl Idolz: Ghostbusters']"));
        //clickOnElement(By.xpath("//body[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/div[3]/ul[1]/li[8]/div[1]/div[2]/div[4]/div[1]/button[1]"));
//        1.6 Verify the message “Product has been added to your cart” display in  green bar
        verifyText("Product has been added to your cart", By.xpath("//li[contains(text(),'Product has been added to your cart')]"), "cart is empty");
//        1.7 Click on X sign to close the message
        clickOnElement(By.xpath("//a[@class='close']"));
//        1.8 Click on “Your cart” icon and Click on “View cart” button
        clickOnElement(By.xpath("//div[@title='Your cart']"));
        clickOnElement(By.xpath("//span[@xpath='1' and contains(text(),'View cart')]"));
//        1.9 Verify the text “Your shopping cart - 1 item”
        verifyText("Your shopping cart - 1 item", By.xpath("//h1[@xpath='1' and contains(text(),'Your shopping cart ')]"), "Your shopping cart - 1 item");
//        1.10 Click on “Empty your cart” link
        clickOnElement(By.xpath("//a[@class='clear-bag']"));
//        1.11 Verify the text “Are you sure you want to clear your cart?” on alert
        String expectedMessage = "Are you sure you want to clear your cart?";
        String actualMessage = switchToAlert();//switch to Alert method calling
        Assert.assertEquals("Your Cart Is Empty", expectedMessage, actualMessage);
        // 1.12 Click “Ok” on alert
        acceptAlert();
        // clickOnElement(acceptAlert();
        Thread.sleep(2000);
//        1.13 Verify the message “Item(s) deleted from your cart”
        verifyText("Item(s) deleted from your cart", By.xpath("//li[text()='Item(s) deleted from your cart']"), "No alert displayed");
//        1.15 Verify the text “Your cart is empty”
        verifyText("Your cart is empty", By.cssSelector("#page-title"), "No message on displayed");


    }
}

