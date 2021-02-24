package com.example.supermarket_kdxfproject2.dao;


import com.example.supermarket_kdxfproject2.entity.Cargo;

import java.sql.*;
import java.util.ArrayList;

public class CargoDao {

    //插入到数据库
    public void EntrantCargo(Cargo cargo) {
        Connection connection = SQLTool.conn();
        String sql = "insert Into cargo (id,classification,Brand,name,price,number) values (?,?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1,cargo.getId());
            ps.setString(2, cargo.getClassification());
            ps.setString(3, cargo.getBrand());
            ps.setString(4,cargo.getName());
            ps.setDouble(5,cargo.getPrice());
            ps.setInt(6,cargo.getNumber());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
    }

    //在数据库中查找库存
    public Cargo selectCargo(Cargo cargo){
        Connection connection=SQLTool.conn();
        String sql="select id,classification,Brand,name,price,number FROM cargo WHERE id='"+cargo.getId()+"'";
        try {
            Statement ct = connection.createStatement();
            try {
                ResultSet resultSet = ct.executeQuery(sql);
                if (!resultSet.next()) {
                    return new Cargo();
                }
                int id = resultSet.getInt("id");
                String classification = resultSet.getString("classification");
                String Brand = resultSet.getString("Brand");
                String name = resultSet.getString("name");
                double price=resultSet.getDouble("price");
                int number=resultSet.getInt("number");

                return new Cargo(id,classification,Brand,name,price,number);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            SQLTool.close();
        }
        return new Cargo();
    }

    //选择所有库存
    public ArrayList<Cargo> selectAllCargo(){
        Connection connection = SQLTool.conn();
        String sql = "SELECT id,classification,Brand,name,price,number FROM cargo";
        ArrayList<Cargo> cargoList = new ArrayList<>();
        try {
            Statement ct = connection.createStatement();
            ResultSet resultSet = ct.executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String classification = resultSet.getString("classification");
                String Brand = resultSet.getString("Brand");
                String name = resultSet.getString("name");
                double price=resultSet.getDouble("price");
                int number=resultSet.getInt("number");
                cargoList.add(new Cargo(id,classification,Brand,name,price,number));
            }
            return cargoList;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cargoList;
    }

    //修改库存
    public void updateNumber(Cargo cargo){
        Connection conn = SQLTool.conn();
        String sql="UPDATE cargo SET number='"+cargo.getNumber()+"'WHERE id='"+cargo.getId()+"'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    //删除商品
    public void deleteCargo(Cargo cargo){
        Connection conn = SQLTool.conn();
        String sql="DELETE FROM cargo WHERE id='"+cargo.getId()+"'";
        try {
            Statement statement = conn.createStatement();
            statement.execute(sql);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
