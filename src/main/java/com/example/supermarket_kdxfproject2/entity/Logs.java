package com.example.supermarket_kdxfproject2.entity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Logs {
    private String year;
    private String month;
    private String day;
    private String time;
    private String operationCargoName;//被操作货物名称
    private int operationCargoNumber;//被操作货物数量

    public Logs() {
        this.year=null;
        this.month=null;
        this.day=null;
        this.time=null;
        this.operationCargoName=null;
        this.operationCargoNumber=0;
    }

    public Logs(String year, String month, String day, String time, String operationCargoName, int operationCargoNumber) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.time = time;
        this.operationCargoName = operationCargoName;
        this.operationCargoNumber = operationCargoNumber;
    }

    public Logs(String operationCargoName, int operationCargoNumber) {
        Date date=new Date();
        this.year=new SimpleDateFormat("yyyy").format(date);
        this.month=new SimpleDateFormat("MM").format(date);
        this.day=new SimpleDateFormat("dd").format(date);
        this.time=new SimpleDateFormat("HH:mm:ss").format(date);
        this.operationCargoName = operationCargoName;
        this.operationCargoNumber=operationCargoNumber;
    }


    public String getDate(){
        return year+"-"+month+"-"+day+"-"+time;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getOperationCargoName() {
        return operationCargoName;
    }

    public void setOperationCargoName(String operationCargoName) {
        this.operationCargoName = operationCargoName;
    }

    public int getOperationCargoNumber() {
        return operationCargoNumber;
    }

    public void setOperationCargoNumber(int operationCargoNumber) {
        this.operationCargoNumber = operationCargoNumber;
    }

    @Override
    public String toString() {
        return "{" +
                "year='" + year + '\'' +
                ", month='" + month + '\'' +
                ", day='" + day + '\'' +
                ", time='" + time + '\'' +
                ", operationCargoName='" + operationCargoName + '\'' +
                ", operationCargoNumber=" + operationCargoNumber +
                '}';
    }
}
