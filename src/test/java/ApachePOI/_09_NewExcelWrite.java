package ApachePOI;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_NewExcelWrite {
    public static void main(String[] args) throws IOException {

        // hafızada yeni workbook oluştur, sonra sheet oluştur, sonra row oluştur, sonra cell oluştur.
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Sheet1");
        // HAFIZADA oluşturma ve yazma işlemleri yapılıyor.
        Row newRow=sheet.createRow(0); // satır oluşturuldu 0. yerde
        Cell newCell=newRow.createCell(0); // yeni satırda ilk hucre oluşturuldu
        newCell.setCellValue("Hello World"); // bilgi yazıldı.

        for (int i = 1; i < 10; i++) {
            newRow.createCell(i).setCellValue(i);
        }

        // Yazma işlemini YAZMA modunda açıp öyle yapacağız.
        String newExcelPath="src/test/java/ApachePOI/resource/NewExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(newExcelPath);
        workbook.write(outputStream);
        workbook.close();   // hafıza boşaltıldı
        outputStream.close();
        System.out.println("islem tamamlandi");

    }
}
