package day10_fileTest;

import org.junit.Test;
import utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInpuStream extends TestBase {

    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="C:\\Users\\nurul\\Desktop\\MerhabaJava.docx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        //File testlerinde genellikle downloads'a indirilecek bir dosyanın indirildiğini test etmek
        //veya masaüstündeki bir dosyanın web'e yüklenildiğini test etmek isteriz.
        //Ancak herkesin bilgisayarının ismi kullanıcı isimleri gibi farklılıklar olacagından testler
        //tek bir bilgisayarda calısacak gibi yazılmak zorunda kalınır.

        //Bu karısıklıgın önüne geceblimek için java 2 basit kod blogu sunmustur.

        System.out.println(System.getProperty("user.dir"));
        //O anda calısan dosyanın (C01_FileInputStream) dosyanın yolunu verir
        //C:\Users\nurul\IdeaProjects\junit_Selenium

        System.out.println(System.getProperty("user.home"));
        //Kullanıcının temel path'ini verir.
        //C:\Users\nurul

        //Masaüstüne gitmek istersek
        // /C:\Users\nurul + /Dekstop eklememiz yeterlidir.

        //Download'a gitmek istersek
        // C:\Users\nurul + /Downloads eklememiz yeterli olacaktır.

        //Kodlarımızın dinamik olması yani kişinin bilgisayarındaki kullanıcı adı gibi detaylara takılmaması
        //için file testlerinde kullanıclacak dosya yolunu user.home temel path'ini calıstıgı bilgisayardan
        //alacak şekilde oluştururuz.

        String dinamikDosyaYolu= System.getProperty("user.home") + "\\Desktop\\MerhabaJava.docx";
    }
}
