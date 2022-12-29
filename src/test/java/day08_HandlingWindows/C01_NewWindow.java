package day08_HandlingWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {
    /*
    Selenium 4 ile windows konusunda yeni bir özellik geldi

    İstersek driver için yeni bir window veya tab oluşturabiliriz bu durumda driver'imizde
    otomatik olarak yeni sayfaya geçmiş olur.

    Testin ilerleyen aşamalarında yeniden eski sayfalara dönüş görevi varsa o sayfayken o sayfanın
    window handle değeri alınıp kaydedilir o sayfaya geçmek istendiğinde
     driver.switchTo().window(sayfanın handle değeri yazılır);

     */

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();

    }

    @Test
    public void test01() throws InterruptedException {

        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        //Testin ilerleyen aşamalarında yeniden amazon sayfasına geri dönmek gerekiyorsa
        //amazon sayfasındayken bu windowun windowHandle degerini alıp kaydetmeliyiz.
        String ilkSayfaHandleDegeri= driver.getWindowHandle();

        //yeni bir TAB'da wiseQuarter.com'a gidin ve gittiğimizi test edelim.

        driver.switchTo().newWindow(WindowType.WINDOW.TAB);
        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String expectedKelime="wisequarter";

        Assert.assertTrue(actualUrl.contains(expectedKelime));

        Thread.sleep(3000);

        //Testi yaptıktan sonra yeniden amazonun oldugu taba geçin
        //ve amazon sayfasının açık oldugunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);

    }
}
