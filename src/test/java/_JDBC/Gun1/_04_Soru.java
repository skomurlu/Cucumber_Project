package _JDBC.Gun1;

import _JDBC.JDBCParent;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _04_Soru extends JDBCParent {
    // city tablosundaki tüm kayıtları next ile yazdırınız
    // city tablosundaki tüm kayıtları absolute ile yazdırınız
    // city tablosundaki tüm kayıtları relative ile yazdırınız.

    @Test
    private void test1() throws SQLException {
        // next(): bir sonraki row
        // previous() : bir önceki row
        // absolute(4) : baştan itibaren 4.ROW a gider, direkt verine ROW a gider
        // relative(4) : bulunduğu noktadan 4 sonraki ROW a gider.

        ResultSet rs= statement.executeQuery("select * from city");

        int cnt=0;
        while (rs.next()) {
            System.out.println(rs.getString(2));
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }

    @Test
    private void test2() throws SQLException {

        ResultSet rs= statement.executeQuery("select * from city");

        int cnt=1;
        while (rs.absolute(cnt)) {
            System.out.println(rs.getString(2));
            cnt++;
        }
        System.out.println("cnt = " + (cnt-1));
    }

    @Test
    private void test3() throws SQLException {

        ResultSet rs= statement.executeQuery("select * from city");

        int cnt=0;
        while (rs.relative(1)) {
            System.out.println(rs.getString(2));
            cnt++;
        }
        System.out.println("cnt = " + cnt);
    }
}