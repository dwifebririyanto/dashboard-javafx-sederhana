package com.aplikasi.sederhana.projectuas;

import java.sql.*;

public class koneksiDb {

    static String driver = "com.mysql.jdbc.Driver";
    static String url = "jdbc:mariadb://localhost/uas";
    static String username = "root";
    static String pasword = "";


    public static Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(driver);
            try {
                connection = DriverManager.getConnection(url,username,pasword);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } catch (ClassNotFoundException e){
            throw new RuntimeException(e);
        }
        return connection;
    }


}
