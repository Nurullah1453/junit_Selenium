package day05_junitFrameWork;

import org.junit.Ignore;
import org.junit.Test;

public class C01_ByeByeMainMethod {

    @Test
    public void test01(){
        System.out.println("test01 çalıştı");
        //@Test notasyonu sayesinde her bir test methodu bağımsız olarak çalışabilir.
        //Eğer testin içerisinde eğer bir assertion yoksa kod problem yaşamadan
        //çalışıp bittiğinde junit test passed olarak raporlar.
    }

    @Test @Ignore
    public void test02(){
        System.out.println("test02 çalıştı");
        //@Ignore notasyonu yazıldıgı test methodunun çalıştırılmamasını sağlar
    }
    @Test
    public void test03(){
        System.out.println("test03 çalıştı");
    }
}
