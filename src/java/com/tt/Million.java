package com.tt;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Million{
    private long begin = 1001;
    private long end = begin+100000;
    private String url = "jdbc:mysql://127.0.0.1:3306/mybatis?serverTimezone=UTC&characterEncoding=utf-8";
    private String username = "root";
    private String password = "19951130";
    @org.junit.Test
    public void insertUser(){
        //定义连接、statement对象
        Connection conn = null;
        PreparedStatement pstm = null;
        try {//加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //连接mysql
            conn = DriverManager.getConnection(url,username,password);
            //关闭自动提交
            conn.setAutoCommit(false);
            //编写sql
            String sql = "INSERT INTO user (username, birthday, sex, address) VALUES (?,?,?,?)";
            //预编译SQL
            pstm = conn.prepareStatement(sql);
            //开始总计时
            long bTime1 = System.currentTimeMillis();
            //循环10次，每次十万数据，一共1000万
            for (int i=0;i<10;i++){
                User user = new User();
                //开启分端计时，计算1W数据耗时
                long bTime = System.currentTimeMillis();
                //开始循环
                while (begin<end){
                    //赋值
                    pstm.setString(1,"123");
                    pstm.setString(2,"123");
                    pstm.setString(3,"123");
                    pstm.setString(4,"123");
                    //添加到同一个批处理中
                    pstm.addBatch();
                    begin++;
                }
                //执行批处理
                pstm.executeBatch();
                //提交事务
                conn.commit();
                //边界值自增10W
                end +=100000;
                //关闭分段计时
                long eTime = System.currentTimeMillis();
                //输出
                System.out.println("成功插入10W条数据耗时："+(eTime-bTime));
            }
            //关闭总计时
            long eTime1 = System.currentTimeMillis();
            //输出
            System.out.println("插入100W数据共耗时："+(eTime1-bTime1));
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e1){
            e1.printStackTrace();
        }
    }
}


