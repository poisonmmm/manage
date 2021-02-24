package com.example.supermarket_kdxfproject2.servers;



import com.example.supermarket_kdxfproject2.common.ResultBean;
import com.example.supermarket_kdxfproject2.dao.UserDao;
import com.example.supermarket_kdxfproject2.entity.User;

import java.util.ArrayList;
import java.util.Objects;

public  class userServers {

    //登陆 测试通过
    public static ResultBean login(User user){
        ResultBean resultBean = new ResultBean();
        UserDao userDao = new UserDao();
        User getUser = userDao.selectUser(user);
        if (user.getUserName()==null||user.getPassWord()==null){
            resultBean.setCode("0");
            resultBean.setMsg("账号或密码为空");
            return resultBean;
        }
        if (Objects.equals(getUser.getUserName(), user.getUserName())&& Objects.equals(getUser.getPassWord(), user.getPassWord()))
        {
            resultBean.setCode("1");
            resultBean.setMsg("登陆成功");
            return resultBean;
        }
        resultBean.setCode("0");
        resultBean.setMsg("账号或密码错误");
        return resultBean;
    }

    //添加用户    测试通过
    public static ResultBean addUser(User user){
        ResultBean resultBean=new ResultBean();
        UserDao userDao = new UserDao();

        User getUser = userDao.selectUser(user);
        if (Objects.equals(getUser.getUserName(), user.getUserName()))
        {
            resultBean.setCode("0");
            resultBean.setMsg("添加失败，已存在该用户名");
            return resultBean;
        }
        userDao.insertUser(user);
        resultBean.setCode("1");
        resultBean.setMsg("添加成功");
        return resultBean;
    }

    //删除用户 测试通过 user里面可以只传username，其他参数为null即可
    public static void delUser(User user){
        UserDao userDao = new UserDao();
        userDao.deleteUser(user);
    }

    //修改用户密码 测试通过
    public static ResultBean modifyUserPassword(User oldUser,User newUser){
        UserDao userDao = new UserDao();
        ResultBean resultBean = new ResultBean();
        User user = userDao.selectUser(oldUser);
        if (Objects.equals(oldUser.getUserName(), user.getUserName()) && Objects.equals(oldUser.getPassWord(), user.getPassWord())){
            userDao.updatePassword(newUser);
            resultBean.setCode("1");
            resultBean.setMsg("修改密码成功");
        }else {
            resultBean.setCode("0");
            resultBean.setMsg("原密码或账号错误");
        }
        return resultBean;
    }

    //查看用户 测试通过
    public static ArrayList<User> ShowUser(){
        UserDao userDao = new UserDao();
        ArrayList<User> userList = userDao.selectAllUser();
        return userList;
    }
}
