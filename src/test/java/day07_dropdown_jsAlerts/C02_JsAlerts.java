package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {

    //Gerekli ayarlamaları yapıp
    //https://the-internet.herokuapp.com/javascript_alerts adresine gidip
    //3 test methodu oluşturup her method'da bir JsAlert'e basın
    //İlgili methodları kullanalım

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
    public void test01(){

        driver.navigate().to("https://the-internet.herokuapp.com/javascript_alerts");
        //1.Alert'e tıklayalım
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        //Alert'deki yazının "I am a JS Alert" oldugunu test edelim
        String actualAlertYazı=driver.switchTo().alert().getText();
        String expectedAlertYazısı="I am a JS Alert";
        Assert.assertEquals(expectedAlertYazısı,actualAlertYazı);

        //OK tusuna basıp kapatalım.

        driver.switchTo().alert().accept();
    }

    @Test
    public void test02(){
        //2. Alert'e tıklayalım cancel'a basıp cıkan sonuc yazsının
        //"You clicked: Cancel" oldugunu test edelim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        driver.switchTo().alert().dismiss();

        String actualYazı=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedYazı="You clicked: Cancel";
        Assert.assertEquals(actualYazı,expectedYazı);

    }

    @Test
    public void test03(){

        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        //Çıkan promp yazısına "Nurullah" yazdıralım ve OK tusuna basarak alert'i kapatalım.
        driver.switchTo().alert().sendKeys("Nurullah");
        driver.switchTo().alert().accept();

        //Cıkan sonuc yazısının "Nurullah" içerdiğini test edelim.
        String actualSonucYazısıı=driver.findElement(By.xpath("//*[@id='result']")).getText();
        String expectedKelimee="Nurullah";
        Assert.assertTrue(actualSonucYazısıı.contains(expectedKelimee));
    }
}
