package com.example.supermarket_kdxfproject2.controller;

import com.example.supermarket_kdxfproject2.entity.Logs;
import com.example.supermarket_kdxfproject2.servers.logsServers;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.List;

@Api(value = "日志记录操作")
@Controller
public class LogsController {

    @ApiOperation(value = "显示所有日志记录")
    @RequestMapping("/logs/showAllLogs")
    @ResponseBody
    public List<Logs> getAllLogs(){
        return logsServers.getAllLogs();
    }

    @ApiOperation(value = "显示指定年份日志记录")
    @RequestMapping("/logs/showLogsByYear")
    @ResponseBody
    public List<Logs> getLogsByYear(@ApiParam(value = "查询年份",required = true) @RequestParam String year){
        return logsServers.getLogsByYear(year);
    }



}
