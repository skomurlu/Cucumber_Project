package _JDBC.Gun2;

import _JDBC.JDBCParent;
import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

public class _05_Soru {
    public static Connection connection;
    public static Statement statement;
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://db-technostudy.ckr1jisflxpv.us-east-1.rds.amazonaws.com:3306/safak_komurlu_db";
        String username = "root";
        String password = "'\"-LhCB'.%k[4S]z";
        connection = DriverManager.getConnection(url, username, password);
        statement = connection.createStatement();
        try {
            String sqlInsert=("INSERT INTO student (ogrID,ad,soyad,bolumID) VALUES (?,?,?,?)");
            PreparedStatement st=connection.prepareStatement(sqlInsert);
            st.setInt(1,123);
            st.setString(2,"ad");
            st.setString(3,"soyad");
            st.setInt(4,111);
            st.addBatch();
            st.executeBatch();
        }

        catch (Exception e)
        {
            e.printStackTrace();
            System.out.println(e.getMessage());
        }

    }
}
