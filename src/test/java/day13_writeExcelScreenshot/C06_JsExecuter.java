package day13_writeExcelScreenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C06_JsExecuter extends TestBase {

    @Test
    public void test(){

        //Amazon anasayfaya gidin
        driver.get("https://www.amazon.com");

        //Git Cards linkine JS executor kullanarak click yapın
        WebElement gitCards= driver.findElement(By.xpath("//a[text()='Gift Cards']"));

        JavascriptExecutor jse= (JavascriptExecutor) driver;

        jse.executeScript("arguments[0].click();",gitCards);

        jse.executeScript("alert('nurullah');");

        ReusableMethods.bekle(3);

    }
}
