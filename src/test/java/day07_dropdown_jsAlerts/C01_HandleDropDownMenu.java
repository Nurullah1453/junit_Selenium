package day07_dropdown_jsAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_HandleDropDownMenu {
    //ilgili ayarları yapıp amazon ana sayfaya gidin sonra arama kutusu yanındaki
    //DropDown menüden book seçin arama kutusuna java yazdırıp aramayı yapın
    //title'nin java içerdiğini test edelim
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
        //DropDown menüden Books seçin arama kutusuna java yazdırıp aramayı yapın
        //title'nin book ve java içerdiğini test edelim
        driver.navigate().to("https://www.amazon.com/");
        //Dropdown menüden istediğimiz opsion'u seçebilmek için öncelikle
        //select class'ından bir obje oluşturmalıyız. Ancak select objesi oluşturmak için select
        //class'ının constructor'ı handle edecegimiz webelemeni istediğinden select objesi oluşturmadan

        //1-önce dropDown webElementini locate etmeliyiz.
        WebElement dropDownWebElemeni= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        //2-Select class'ından obje oluşturmak
        Select select=new Select(dropDownWebElemeni);
        //3-Select objesini kullanarak istediğimiz method veya methodları çalıştırırız.
        //select.selectByValue("search-alias=stripbooks-intl-ship");
        //select.selectByIndex(5);
        select.selectByVisibleText("Books");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        String expectedKelime="Java";
        String actualTitle= driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedKelime));

        //DropDown menüden Books seçeneğinin seçildiğini test edelim.
        dropDownWebElemeni= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select=new Select(dropDownWebElemeni);
        select.selectByVisibleText("Books");
        String actualSecilenObtion =select.getFirstSelectedOption().getText();
        String expectedSecilecekObtion="Books";
        Assert.assertTrue(actualSecilenObtion.equals(expectedSecilecekObtion));
        Thread.sleep(3000);

        //DropDown menüdeki seçenek sayısının 28 oldugunu test edelim
            List <WebElement> optionsWebElementListesi=select.getOptions();
            int actualOptionSayısı=optionsWebElementListesi.size();
            int expectedOptionSayısı=28;
        Assert.assertEquals(expectedOptionSayısı,actualOptionSayısı);
    }
}
