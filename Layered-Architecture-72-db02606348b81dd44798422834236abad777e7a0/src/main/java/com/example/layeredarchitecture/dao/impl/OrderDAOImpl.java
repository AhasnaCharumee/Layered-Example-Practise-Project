package com.example.layeredarchitecture.dao.impl;

import com.example.layeredarchitecture.dao.SQLUtil;
import com.example.layeredarchitecture.dao.custom.OrderDAO;
import com.example.layeredarchitecture.db.DBConnection;

import java.sql.*;
import java.time.LocalDate;

public class OrderDAOImpl implements OrderDAO {
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        Statement stm = connection.createStatement();
        ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` ORDER BY oid DESC LIMIT 1;");

        return rst.next() ? String.format("OID-%03d", (Integer.parseInt(rst.getString("oid").replace("OID-", "")) + 1)) : "OID-001";
    }
@Override
public boolean existOrderId(String orderId) throws SQLException, ClassNotFoundException {
    ResultSet rst = SQLUtil.execute("SELECT oid FROM `Orders` WHERE oid=?", orderId);
    if (rst.next()){
        return true;
    }
    return false;
}
    @Override
    public boolean addOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//
//        PreparedStatement stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
//
//        stm.setString(1, orderId);
//        stm.setDate(2, Date.valueOf(orderDate));
//        stm.setString(3, customerId);
//        return stm.executeUpdate();
return SQLUtil.execute("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)",orderId,Date.valueOf(orderDate),customerId);
    }
}
