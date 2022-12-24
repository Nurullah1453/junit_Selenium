package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {
    //Junit framework'u calıstırılan testlerin passed veya failed olmasını raporlar ancak
    //raporlamanın dogru sonuc vermesi için testlerin assert class'ındaki hazır methodlarla
    //yapılması gerekir. Eğer assert class'ı kullanılmazsa junit kodların sorunsuz olarak
    //çalısıp bittiğini raporlar. C01'de testleri if else ile yaptıgımız için testler failed olsada
    //kodlar sorunsuz çalıştıgı için testlerler yeşil tik olarak işaretlendi.

    int p1=60;
    int p2=66;
    int p3=70;

    @Test
    public void test01(){
        //emekli yaşı 65 olduguna göre
        //p2 2'nin emekli olabileceğini test edin
        Assert.assertTrue(p2>65);

    }
    @Test
    public void test02(){
        //p1'in emekli olamayacagını test edelim
        Assert.assertFalse(p1>65);
    }
    @Test
    public void test03(){
        //p3'ün emekli olamayacagını test edelim
        Assert.assertFalse("Girilen Yas 65'den küçük olmadıgından emekli olabilir",p3>65);
    }
}
