package day12_webtables_excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ReadExcel {

    @Test
    public void test01() throws IOException {

        //Dosya yolunu oluşturalım
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";

        //FileInputStream objesi olusturup parametre olarak dosya yolunu yazalım
        FileInputStream fis=new FileInputStream(dosyaYolu);

        //Kod alanımızda excel'in bir kopyasını oluşturup tüm bilgleri ona kopyalayalım
        Workbook workbook= WorkbookFactory.create(fis);

        //workbook içerisinde 1 den fazla sayfa olabilir istedigimiz sayfaya gidelim
        Sheet sheet= workbook.getSheet("Sayfa1");

        //Angola yazdırmak istedigimiz için 5. satıra gidelim
        Row row= sheet.getRow(5);

        //5. satırda 2. indexteki datayı alalım
        Cell cell= row.getCell(2);

        System.out.println(cell);

    }
}
