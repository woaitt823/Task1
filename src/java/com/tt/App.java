package com.tt;


import java.sql.*;

public class App {
    public static void main(String[] args) {
// TODO Auto-generated method stub
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try {
                Connection connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/mybatis?serverTimezone=UTC&characterEncoding=utf-8", "root", "123456");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery("select * from user");
                while (rs.next()) {
                    System.out.println(rs.getString(2));
                    System.out.println("-------------------------");
                    System.out.println(rs.getString(4));
                }
            } catch (SQLException e) {
// TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
// TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
