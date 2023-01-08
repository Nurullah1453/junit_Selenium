package day10_fileTest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {

    @Test
    public void test(){

        /*
        1-https://the-internet.herokuapp.com/download adresine gidelim
        2-luminoslogo.png dosasını indirelim
        3-Dosyanın başarıyla indirilip indirilmediğini test edelim
         */

        //1-https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //2-luminoslogo.png dosasını indirelim
        driver.findElement(By.xpath("//a[text()='luminoslogo.png']")).click();

        ReusableMethods.bekle(5);

        //3-Dosyanın başarıyla indirilip indirilmediğini test edelim

        //Test için öncelikle dosyanın indirildiğinde dosya yolu ne olacak bunu oluşturmalıyız.

        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\luminoslogo.png";

        //Bir dosyanın bilgisayarımızda var oldugunu test etmek için Java'daki Files class'ından yardım alıcaz
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

    }

    @Test
    public void test02(){
        //Masaüstünde MerhabaJava.docx dosyası oldugunu test edelim
        //dinamik dosya yolu oluşturalım

        String dosyaYolu2=("user.home")+ "\\Desktop\\MerhabaJava.docx";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }

}
