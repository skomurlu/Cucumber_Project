package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {

    @Test
    public void test() throws SQLException, IOException {
        // 1 - sorgu lazım.
        ResultSet rs=statement.executeQuery("select * from actor");
        ResultSetMetaData rsmd=rs.getMetaData();

        // 2 - Excel oluşturma.
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("ACTOR");
        Row row=sheet.createRow(0);

        int count=0;
        for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
            //System.out.printf("%-20s", rsmd.getColumnName(i));
            row.createCell(count).setCellValue(rsmd.getColumnName(i));
            count++;
        }

        count=1;
        int countCell=0;
        while (rs.next())
        {
            row=sheet.createRow(count); // her for kırıldığında alt satıra geçmiş gibi iş görüyor.
            for (int i = 1; i <=rsmd.getColumnCount() ; i++) {
                System.out.printf("%-20s", rs.getString(i));
                Cell cell=row.createCell(countCell);
                cell.setCellValue(rs.getString(i));
                countCell++;
            }
            countCell=0; // 0123 - 0 lanıyor.
            count++;    // 200 e kadar gidecek.

        }

        String path="src/test/java/_JDBC/SORU5.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("Table created...");





    }

}
