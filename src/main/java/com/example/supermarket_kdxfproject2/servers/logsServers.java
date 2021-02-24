package com.example.supermarket_kdxfproject2.servers;

import com.example.supermarket_kdxfproject2.dao.LogsDao;
import com.example.supermarket_kdxfproject2.entity.Logs;

import java.util.ArrayList;
import java.util.List;

public class logsServers {
    //获取所有记录
    public static List<Logs> getAllLogs(){
        return LogsDao.selectAllLogs();
    }

    //获取指定年份记录
    public static List<Logs> getLogsByYear(String year){
        return LogsDao.selectLogByYear(year);
    }
}
