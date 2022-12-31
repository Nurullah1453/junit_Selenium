package day11_seleniumWaits_cookies;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ImplicitlWait{

    @Test
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();

        //Selenium 4'e kadar 15 saniyeyi belirtmek için
        //Timeouts class'ından 15 saniye tanımlanıyordu.
        //Selenium 4 ile birlikte zaman belirleme class'ı Duration oldu.


    }
}
