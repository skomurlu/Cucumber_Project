package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _03_Soru extends JDBCParent {

    @Parameters("query")
    @Test // parametreli olduğu için class'tan test çalışmaz. Parametre çalışır aktifse.
    public void test(String query) throws SQLException {
        //String queryT="select * from actor"; //  XML parametreden çalıştıracağımız için gerek kalmadı.

        ResultSet rs=statement.executeQuery(query);
        ResultSetMetaData rsmd=rs.getMetaData();

        for (int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.printf("%-20s", rsmd.getColumnName(i));
        }

        System.out.println();

        while (rs.next())
        {
            for (int i=1; i<=rsmd.getColumnCount() ; i++)
                //System.out.print(rs.getString(i)+ " ");
            System.out.printf("%-20s",rs.getString(i));

            System.out.println();
        }

    }


}
