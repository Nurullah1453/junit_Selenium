package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
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

       // 1 ) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
       // 2 ) Bir metod olusturun: iframeTest
       // - “An IFrame containing….” textinin erisilebilir oldugunu test edin ve  konsolda yazdirin.

        WebElement actualSayfaYazısıElementi=driver.findElement(By.tagName("h3"));

        Assert.assertTrue(actualSayfaYazısıElementi.isEnabled());
        Thread.sleep(3000);
       //- Text Box’a “Merhaba Dunya!” yazin.

        //Normal locate yapıp yazdırmayı denediğimizde NoSuchElementExeption verdi
        //Yani elementi bulamadı.
        //Kontrol ederken istediğimiz web elementin bir IFrame içinde oldugunu gördük.
        //Bu durumda önce o IFrame'ye switchTo yapmalıyız.
        WebElement iFrameWebElementi= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameWebElementi);
        WebElement textBox= driver.findElement(By.xpath("//body[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya");
        Thread.sleep(3000);
       // - TextBox’in altinda bulunan “Elemental Selenium” linkini textinin gorunur oldugunu dogrulayin
       // ve  konsolda yazdirin.

        //IFrame'nin içene girdikten sonra oradan çık denilinceye kadar
        //drive iframe'nin içinde kalır
        //eğer dısına cıkmak istersek

        //driver.switchTo().parentFrame();Bulundugu iframeden'bir üst sayfaya geçis için kullanılır

        driver.switchTo().defaultContent();//Ana sayfaya geçer

        WebElement actualElemantalSelenium=driver.findElement(By.xpath("//div[text()='Powered by ']"));

        Assert.assertTrue(actualElemantalSelenium.isDisplayed());

        System.out.println(actualElemantalSelenium.getText());




    }
}
