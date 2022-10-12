package _JDBC.Gun2;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

import static _JDBC.Gun2._05_Soru.connection;

public class _05_Soru_V2 {

    String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/safak_komurlu_db";
    String username = "root";
    String password = "'\"-LhCB'.%k[4S]z";

    @Test
    public void test1() throws SQLException {

        Workbook workbook;

        try {
            FileInputStream inputStream = new FileInputStream("src/test/java/_JDBC/Gun2/student.xlsx");
            workbook = WorkbookFactory.create(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheet = workbook.getSheet("Sayfa1");

        ArrayList<String> data = new ArrayList<>();

        String veri = "";
        int columCount = 0;
        for (int i = 1,z=0; i < sheet.getPhysicalNumberOfRows(); i++,z++) {

            Row row = sheet.getRow(i);
            int cellCount = row.getPhysicalNumberOfCells();
            for (int j = 0; j < cellCount; j++) {

                Cell cell = row.getCell(j);
                veri += cell.toString() + " ";
            }
            data.add(veri);
            veri = "";

            columCount = cellCount;
        }

        String[] split = new String[columCount];

        for (int i = 0; i < data.size(); i++) {

            split = data.get(i).split(" ");
            String query = ("INSERT INTO student (ogrID,ad,soyad,bolumID) VALUES (?,?,?,?)");
            PreparedStatement ps = connection.prepareStatement(query);

            ps.setString(1,split[0]);
            ps.setString(2,split[1]);
            ps.setString(3,split[2]);
            ps.setString(4,split[3]);
            ps.addBatch();

            ps.executeBatch();

        }

    }

}
