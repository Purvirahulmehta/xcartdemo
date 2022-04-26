package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by){
        WebElement element=driver.findElement(by);
        element.click();
    }
    //This method will get text from element
    public String getTextFromElement(By by) {
        return driver.findElement(by).getText();
    }
    //This method will send text on element
    public void sendTextToElement(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

       //this mentod is for switch to alert
    public String switchToAlert(){
        Alert alert=driver.switchTo().alert();
        return  alert.getText();
    }
    //This method will accept the alret
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }
    //This method will select the option by visible text
    public void selectByVisibleTextFromDropDown(By by,String text){
        Select select=new Select(driver.findElement(by));
        select.selectByValue(text);
        }
    //ArrayList method
    public List<WebElement> listOfWebElementList(By by){
        return driver.findElements(by);
    }
    //mouse hoover
    public void mouseHooverToElement(By by) {
           Actions actions = new Actions(driver);
         actions.moveToElement(driver.findElement(by)).perform();
        }

        //verify Method/Assert
    public void verifyText(String expectedMessage,By by,String displayMessage){
        String actualMessage=getTextFromElement(by);
        Assert.assertEquals(displayMessage,expectedMessage,actualMessage);

    }
}


