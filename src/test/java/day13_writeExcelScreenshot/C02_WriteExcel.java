package day13_writeExcelScreenshot;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C02_WriteExcel {

    @Test
    public void test() throws IOException {
        //excel dosyasından kopyaladıgımız workbook objesi üzerinde degisiklik
        //yapabilirz bunun icin excel'in kopyası olan exceli olusturalım
        String dosyaYolu="src/test/java/day12_webtables_excel/ulkeler.xlsx";
        FileInputStream fis=new FileInputStream(dosyaYolu);
        Workbook workbook= WorkbookFactory.create(fis);

        //5. sutun olarak nufüs baslıgı ile bir sutun olusturalım
        workbook.getSheet("Sayfa1").getRow(0).createCell(4).setCellValue("Nufus");

        //3. satırdaki nufus bilgisini 1500000 yapalım
        workbook.getSheet("Sayfa1").getRow(2).createCell(4).setCellValue("1500000");

        //7. satırdaki nufus bilgisini 3 milyon yapalım
        workbook.getSheet("Sayfa1").getRow(6).createCell(4).setCellValue("3000000");

        //yaptıgımız degisiklikler kopya workbook üzerinde bu değisiklikleri excel dosyasına
        //kaydetmek için FileOutputStream class'ını kullanmalıyız
        FileOutputStream fos=new FileOutputStream(dosyaYolu);
        workbook.write(fos);

        workbook.close();
        fis.close();    
        fos.close();
    }
}
