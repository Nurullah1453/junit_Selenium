package day13_writeExcelScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void test01() throws IOException {

        //excel dosyaları bilgisayarımızda oldugu için
        //java'dan FileInputStream class'ı yardımıyla ulasacagız.

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(3).getCell(1));

       //satır ve sutun bilgisini parametre olarak alıp o hücredeki
        //bilgiyi yazdıran bir method oluşturalım

        dataYazdır(25,2);
        dataYazdır(14,4);

    }

    private void dataYazdır(int satır, int sutun) throws IOException {

        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        FileInputStream fis=new FileInputStream(dosyaYolu);

        Workbook workbook = WorkbookFactory.create(fis);

        System.out.println(workbook.getSheet("Sayfa1").getRow(satır).getCell(sutun));


    }
}
