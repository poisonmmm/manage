package com.example.supermarket_kdxfproject2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


//工具类 SQL数据库连接
public class SQLTool {
    static final String jdbcDriver="com.mysql.jdbc.Driver";
    static final String dbUrl="jdbc:mysql://localhost:3306/kdxf_project?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=GMT%2B8";
    static final String USER="root";
    static final String PASSWORD="LM13568935977";

    //连接数据库
    public static Connection conn(){
        Connection conn=null;
        try {
            Class.forName(jdbcDriver);
            try {
                conn= DriverManager.getConnection(dbUrl,USER,PASSWORD);
            }catch (SQLException e){
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }

    //关闭数据库连接
    public static void close(){
        if (conn()!=null){
            try {
                conn().close();
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
    }
}
