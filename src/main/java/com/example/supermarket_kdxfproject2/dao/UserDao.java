package com.example.supermarket_kdxfproject2.dao;



import com.example.supermarket_kdxfproject2.entity.User;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
    //数据库添加用户     ----插入测试通过
    public void insertUser(User user) {
        Connection connection = SQLTool.conn();
        String sql = "insert Into user (userName,passWord,role) values (?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, user.getUserName());
            ps.setString(2, user.getPassWord());
            ps.setString(3, user.getRole());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
    }

    //在数据库中查找用户（登陆功能，展示功能）  --登陆测试通过
    public User selectUser(User user) {
        Connection connection = SQLTool.conn();
        String sql = "select userName,passWord,role FROM user WHERE userName='" + user.getUserName() + "'";
        try {
            Statement ct = connection.createStatement();
            try {
                ResultSet resultSet = ct.executeQuery(sql);
                if (!resultSet.next()) {
                    return new User();
                }
                String username = resultSet.getString("userName");
                String password = resultSet.getString("passWord");
                String role = resultSet.getString("role");
//                System.out.println("userdao层"+username + password + role);//测试log
                return new User(username, password);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
        return new User();
    }


    public ArrayList<User> selectAllUser() {
        Connection connection = SQLTool.conn();
        String sql = "SELECT userName,passWord,role FROM user";
        ArrayList<User> userList = new ArrayList<>();
        try {
            Statement ct = connection.createStatement();
            ResultSet resultSet = ct.executeQuery(sql);
            while (resultSet.next()) {
                String username = resultSet.getString("userName");
                String password = resultSet.getString("passWord");
                String role = resultSet.getString("role");
                userList.add(new User(username, password));
            }
            return userList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }


    //修改用户密码
    public void updatePassword(User user) {
        Connection connection = SQLTool.conn();
        String sql = "UPDATE user SET password='" + user.getPassWord() + "'WHERE username='" + user.getUserName() + "'";

        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //删除用户
    public void deleteUser(User user){
        Connection connection = SQLTool.conn();
        String sql = "DELETE FROM user WHERE userName='"+user.getUserName()+"'";
        try {
            Statement statement = connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
