package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {
    /*
    1- Bir class olusturun : BasicAuthentication
    2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
    Html komutu : https://username:password@URL
    Username    : admin
     password     : admin
    4- Basarili sekilde sayfaya girildigini dogrulayin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

    }

    @AfterClass
    public static void tearDown(){
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(3000);

        //3- asagidaki yontem ve test datalarini kullanarak authentication’i yapin
        //Html komutu : https://username:password@URL
        //Username    : admin
        //password     : admin

        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth");
        //4- Basarili sekilde sayfaya girildigini dogrulayin

        String actualSonucYazısı=driver.findElement(By.tagName("p")).getText();
        String expectedYazı="Congratulations!";

        Assert.assertTrue(actualSonucYazısı.contains(expectedYazı));
    }
}
