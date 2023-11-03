/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Order;

/**
 *
 * @author NGMINHAT
 */
public class OrderDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public OrderDAO() {
        try {
            this.conn = dal.DBContext.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(OrderDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addToCart(Order o) {
        String query = "insert into [order] values(?,?,?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, o.getUser());
            ps.setInt(2, o.getProID());
            ps.setInt(3, o.getQuantity());
            ps.setDouble(4, o.getTotal());
            ps.setString(5, o.getAddress());
            ps.setString(6, o.getStatus());
            ps.setString(7, o.getOrderDate());
            ps.setString(8, o.getPhonenumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<Order> getTotalAmountMothAndYear(String year) {
        List<Order> monthlyOrders = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();

            String sql = "SELECT  SUM(total) AS monthlyTotal, "
                    + "DATEPART(YEAR, Orderdate) AS year, DATEPART(MONTH, Orderdate) AS month "
                    + "FROM [dbo].[Order] where DATEPART(YEAR, Orderdate)=" + "'" + year + "'"
                    + "GROUP BY  DATEPART(YEAR, Orderdate), DATEPART(MONTH, Orderdate)";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

                double monthlyTotal = resultSet.getDouble("monthlyTotal");
                int month = resultSet.getInt("month");

                Order order = new Order(1, "", 0, monthlyTotal, "", "", String.valueOf(month), "");
                monthlyOrders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monthlyOrders;
    }
    public List<Order> getTotalQuantityMothAndYear(String year) {
        List<Order> monthlyOrders = new ArrayList<>();

        try {

            Statement statement = conn.createStatement();

            String sql = "SELECT  SUM(quantity) AS quantityTotal, "
                    + "DATEPART(YEAR, Orderdate) AS year, DATEPART(MONTH, Orderdate) AS month "
                    + "FROM [dbo].[Order] where DATEPART(YEAR, Orderdate)=" + "'" + year + "'"
                    + "GROUP BY  DATEPART(YEAR, Orderdate), DATEPART(MONTH, Orderdate)";
            ResultSet resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {

               int quantotal = resultSet.getInt("quantityTotal");
                int month = resultSet.getInt("month");

                Order order = new Order(1, "", quantotal, 0, "", "", String.valueOf(month), "");
                monthlyOrders.add(order);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return monthlyOrders;
    }
}
