package com.example.supermarket_kdxfproject2.controller;

import com.example.supermarket_kdxfproject2.common.ResultBean;
import com.example.supermarket_kdxfproject2.entity.Cargo;
import com.example.supermarket_kdxfproject2.servers.cargoServers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Api(value = "货物库存相关操作")
@Controller
public class cargoController {

    @ApiOperation(value = "货物入库",notes = "货物入库操作")
    @RequestMapping("/cargo/entrant")
    @ResponseBody
    public ResultBean entrant(@ApiParam(value = "id") String id,
                          @ApiParam(value = "分类") String classification,
                          @ApiParam(value = "品牌") String brand,
                          @ApiParam(value = "名称",required = true) String name,
                          @ApiParam(value = "价格") String price,
                          @ApiParam(value = "数量",required = true) String number
                          ){
        return cargoServers.Entrant(new Cargo(Integer.parseInt(id),classification,brand,name,Double.parseDouble(price),Integer.parseInt(number)));
    }

    @ApiOperation(value = "货物出库",notes = "货物出库操作")
    @RequestMapping("/cargo/delivery")
    @ResponseBody
    public ResultBean delivery(
            HttpServletRequest request,
            @ApiParam(value = "id") String id,
                           @ApiParam(value = "分类") String classification,
                           @ApiParam(value = "品牌") String brand,
                           @ApiParam(value = "名称",required = true) String name,
                           @ApiParam(value = "价格") String price,
                           @ApiParam(value = "数量",required = true) String number
                            ){

        HttpSession session = request.getSession();
        session.setAttribute("yzm",1234);
//        session.removeAttribute("yzm");
        return cargoServers.delivery(new Cargo(Integer.parseInt(id), classification, brand, name, Double.parseDouble(price), Integer.parseInt(number)));
    }

    @ApiOperation(value = "查看所有库存",notes = "查看库存操作")
    @RequestMapping("/cargo/showAllCargo")
    @ResponseBody
    public List<Cargo> showAllCargo(){
        return cargoServers.showAllCargo();
    }

}