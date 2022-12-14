package com.example.commodity_system.Dao;

import com.example.commodity_system.Model.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GoodsDao {

    //查找是否存在
    public Goods findIfHave(Connection con,String name,int fa_id,int fr_id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_name = '"+name+"' and Goods_father='"+
                fa_id+"' and Goods_from = '"+fr_id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Goods goods = null;

        if(rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);

            goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
        }
        return goods;
    }

    public Goods findByGoodsid(Connection con,int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_id='"+ id+"'";
        ResultSet rs = con.createStatement().executeQuery(sql);
        Goods goods = null;

        if(rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);

            goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
        }
        return goods;
    }

    public boolean insert(Connection con, Goods goods) throws SQLException {
        int Goods_now = goods.getGoods_now();
        String Goods_name = goods.getGoods_name();
        String Goods_type = goods.getGoods_type();
        int Goods_father = goods.getGoods_father();
        int Goods_price = goods.getGoods_price();
        int Goods_number = goods.getGoods_number();
        int Goods_from = goods.getGoods_from();
        String Goods_from2 = goods.getGoods_from2();
        String sql = "insert into Shop_goods values('"+Goods_name+"','"+Goods_type+"','"
                +Goods_number+"','"+Goods_price+"','"+Goods_father+"','"+Goods_now+"','"
                +Goods_from+"','"+Goods_from2+"')";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNumber(Connection con,int sum,int id) throws SQLException {
        String sql = "update Shop_goods set Goods_number='"+sum+"' where Goods_id='"+ id+"'";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updatePrice(Connection con,String sum,String id) throws SQLException {
        String sql = "update Shop_goods set Goods_Price='"+sum+"' where Goods_id='"+ id+"'";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateNow(Connection con,int sum,int id) throws SQLException {
        String sql = "update Shop_goods set Goods_now='"+sum+"' where Goods_id='"+ id+"'";
        try {
            PreparedStatement ps = null;
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        }catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    //通过名称寻找全部
    public List<Goods> findAllByName(Connection con, String search,int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_father = '"+id+"' and Goods_name like '%"
        +search+"%' order by Goods_now desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Goods> list =  new ArrayList<>();
        while (rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);
            Goods goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
            list.add(goods);
        }
        return list;
    }
    //通过名称寻找全部
    public List<Goods> findAllByType(Connection con, String search,int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_father = '"+id+"' and Goods_type like '%"
                +search+"%' order by Goods_now desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Goods> list =  new ArrayList<>();
        while (rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);
            Goods goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
            list.add(goods);
        }
        return list;
    }
    //通过名称寻找全部
    public List<Goods> findAllByPrice(Connection con, String search,int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_father = '"+id+"' and Goods_price = '"
                +search+"' order by Goods_now desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Goods> list =  new ArrayList<>();
        while (rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);
            Goods goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
            list.add(goods);
        }
        return list;
    }
    //通过名称寻找全部
    public List<Goods> findAllByFrom2(Connection con, String search,int id) throws SQLException {
        String sql = "select * from Shop_goods where Goods_father = '"+id+"' and Goods_from2 like '%"
                +search+"%' order by Goods_now desc";
        ResultSet rs = con.createStatement().executeQuery(sql);
        List<Goods> list =  new ArrayList<>();
        while (rs.next()){
            int Goods_id = rs.getInt(1);
            String Goods_name = rs.getString(2);
            String Goods_type = rs.getString(3);
            int Goods_number = rs.getInt(4);
            int Goods_price = rs.getInt(5);
            int Goods_father = rs.getInt(6);
            int Goods_now = rs.getInt(7);
            int Goods_from = rs.getInt(8);
            String Goods_from2 = rs.getString(9);
            Goods goods = new Goods(Goods_id,Goods_name,Goods_type,Goods_number,Goods_price,
                    Goods_father,Goods_now,Goods_from,Goods_from2);
            list.add(goods);
        }
        return list;
    }
}
