package ApachePOI;

 /* Soru 1:
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 satır boşluk bırakarak alt alta
         */

/* Soru 2:
         *  Çarpım tablosunu excele yazdırınız.
         *  1 x 1 = 1 şeklinde işaretleri de yazdırınız.
         *  sıfırdan excel oluşturarak.
         *  her bir onluktan sonra 1 kolon boşluk bırakarak yan yana
         */

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class _10_Tasks {
    public static void main(String[] args) {

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("Table");
        Row row=sheet.createRow(0);
        Cell cell=row.createCell(0);
        cell.setCellValue("Multiplication Table");

        int count=1;
        for (int i = 1; i < 10; i++) { // i ve j yi tablodaki değerleri için kullanacağım.
            for (int j = 1; j <= 10; j++) {
                row=sheet.createRow(count); // 81 tane satır oluşturmak gerek.
                cell=row.createCell(0);
                cell.setCellValue(i + "*" + j + "=" + (i*j));
                count++;
            }
            sheet.createRow(count);
            row.createCell(0);
            cell.setCellValue(" --- ");
        }

        String newPath="src/test/java/ApachePOI/resource/Multitable.xlsx";

        try {
            FileOutputStream outputStream= new FileOutputStream(newPath);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Excel file is ready");


    }
}
