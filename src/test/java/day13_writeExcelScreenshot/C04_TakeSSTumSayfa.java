package day13_writeExcelScreenshot;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TakeSSTumSayfa extends TestBase {

    @Test
    public void test(){

        //wiseQuarter anasayaya gidin anasayfaya gittiginizi test edip
        driver.get("https://www.wisequarter.com");
        String expectedUrl="wisequarter";
        String actualUrl= driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //tüm sayfanın screenShot alın.
        ReusableMethods.tumSayfaScreenshotCek(driver);

    }
}
