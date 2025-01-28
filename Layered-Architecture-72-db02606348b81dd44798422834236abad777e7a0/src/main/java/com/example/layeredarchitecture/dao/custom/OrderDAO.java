package com.example.layeredarchitecture.dao.custom;

import java.sql.SQLException;
import java.time.LocalDate;

public interface OrderDAO {
    public String generateNewId() throws SQLException, ClassNotFoundException;
    public boolean existOrderId(String orderId) throws SQLException, ClassNotFoundException;
    public boolean addOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException;

}
