package com.example.supermarket_kdxfproject2.dao;

import com.example.supermarket_kdxfproject2.entity.Logs;
import com.example.supermarket_kdxfproject2.entity.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class LogsDao {

    //数据库添加操作日志
    public static void insertLogs(Logs logs){
        Connection connection=SQLTool.conn();
        String sql="INSERT INTO logs(year,month,day,time,operationCargoName,OperationCargoNumber) values(?,?,?,?,?,?)";
        try {
            PreparedStatement ps=connection.prepareStatement(sql);
            ps.setString(1,logs.getYear());
            ps.setString(2,logs.getMonth());
            ps.setString(3,logs.getDay());
            ps.setString(4,logs.getTime());
            ps.setString(5,logs.getOperationCargoName());
            ps.setInt(6,logs.getOperationCargoNumber());
            ps.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            SQLTool.close();
        }
    }

    public static List<Logs> selectLogByYear(String selectYear){
        ArrayList<Logs> logList = new ArrayList<>();
        Connection connection=SQLTool.conn();
        String sql="SELECT year,month,day,time,operationCargoName,operationCargoNumber FROM logs WHERE year ='" + selectYear + "'";
        try {
            Statement ct = connection.createStatement();
            ResultSet resultSet = ct.executeQuery(sql);
            while (resultSet.next()){
                String year = resultSet.getString("year");
                String month = resultSet.getString("month");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                String operationCargoName = resultSet.getString("operationCargoName");
                int operationCargoNumber = resultSet.getInt("operationCargoNumber");
                logList.add(new Logs(year,month,day,time,operationCargoName,operationCargoNumber));
            }
            return logList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
        return null;
    }

    public static List<Logs> selectAllLogs(){
        ArrayList<Logs> logList = new ArrayList<>();
        Connection connection=SQLTool.conn();
        String sql="SELECT year,month,day,time,operationCargoName,operationCargoNumber FROM logs";
        try {
            Statement ct = connection.createStatement();
            ResultSet resultSet = ct.executeQuery(sql);
            while (resultSet.next()){
                String year = resultSet.getString("year");
                String month = resultSet.getString("month");
                String day = resultSet.getString("day");
                String time = resultSet.getString("time");
                String operationCargoName = resultSet.getString("operationCargoName");
                int operationCargoNumber = resultSet.getInt("operationCargoNumber");
                logList.add(new Logs(year,month,day,time,operationCargoName,operationCargoNumber));
            }
            return logList;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
        return logList;
    }

}
