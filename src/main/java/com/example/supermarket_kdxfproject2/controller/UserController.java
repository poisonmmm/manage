package com.example.supermarket_kdxfproject2.controller;


import com.example.supermarket_kdxfproject2.common.ResultBean;
import com.example.supermarket_kdxfproject2.entity.User;
import com.example.supermarket_kdxfproject2.servers.userServers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Api(value = "用户相关操作")
@Controller
public class UserController {

    @ApiOperation(value = "登陆", notes = "登陆操作")
    @RequestMapping("/user/login")
    @ResponseBody
    public ResultBean login(HttpServletRequest request,
                            @ApiParam(value = "用户名", required = true) @RequestParam String username,
                            @ApiParam(value = "密码", required = true) @RequestParam String password) {
        User user = new User(username, password);
        ResultBean bean = userServers.login(user);
        if (bean.getCode().equals("1")) {
            request.getSession().setAttribute("user", user); //设置session
        }
        return bean;
    }

    @ApiOperation(value = "添加用户", notes = "添加用户的操作")
    @RequestMapping("/user/addUser")
    @ResponseBody
    public ResultBean addUser(@ApiParam(value = "用户名", required = true) @RequestParam String username, @ApiParam(value = "密码", required = true) @RequestParam String password) {
        System.out.println("添加用户操作====:" + username + password);
        return userServers.addUser(new User(username, password));
    }

    @ApiOperation(value = "删除用户", notes = "删除用户的操作，可以只传username")
    @RequestMapping("/user/delUser")
    @ResponseBody
    public String delUser(@ApiParam(value = "用户名", required = true) @RequestParam String username) {
        userServers.delUser(new User(username, null));
        return "del" + username + "user";
    }

    @ApiOperation(value = "修改用户密码", notes = "修改用户密码的操作，需要传username，原密码，新密码")
    @RequestMapping("/user/modifyUserPassword")
    @ResponseBody
    public ResultBean modifyUserPassword(@ApiParam(value = "用户名", required = true) @RequestParam String username,
                                         @ApiParam(value = "原密码", required = true) @RequestParam String oldPassword,
                                         @ApiParam(value = "新密码", required = true) @RequestParam String newPassword) {
        return userServers.modifyUserPassword(new User(username, oldPassword), new User(username, newPassword));
    }

    @ApiOperation(value = "显示所有用户", notes = "显示所有用户的操作,不需要参数")
    @RequestMapping("/user/showUser")
    @ResponseBody
    public List<User> showUser(HttpServletRequest request) {
        Object user = request.getSession().getAttribute("user"); //获取参数
        System.out.println("========="+user);
        return userServers.ShowUser();
    }

}
