/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOs;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cart;

/**
 *
 * @author NGMINHAT
 */
public class CartDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public CartDAO() {
        try {
            this.conn = dal.DBContext.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CartDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Cart> getCart(String user) {
        List<Cart> list = new ArrayList<>();
        String query = "select c.CartID,p.title,p.image, c.Quantity,c.Size,c.Total,p.id from Cart c \n"
                + "join product p on c.ProductID=p.id where c.[user]=?";
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Cart(
                        rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getString(5),
                        rs.getDouble(6),
                        rs.getInt(7)
                ));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public void deleteCart(int id) {
        String query = "delete  from Cart where cartID=" + id;
        try {

            ps = conn.prepareStatement(query);

            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteCartByUser(String user) {
        String query = "delete  from Cart where [user]=?";
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Cart getCartByID(int id) {
        Cart c = null;
        try {

            String query = "select * from Cart where ProductID=" + id;
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {

                return new Cart(rs.getInt(2), rs.getString(1), rs.getInt(4), rs.getString(3), 0);
            }

        } catch (SQLException e) {

        }
        return null;

    }

    public void addToCart(Cart c) {
        String query = "insert into Cart values(?,?,?,?,?)";
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, c.getUserName());
            ps.setInt(2, c.getProID());
            ps.setString(3, c.getSize());
            ps.setInt(4, c.getQuantity());
            ps.setDouble(5, c.getPrice());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateQuantityCart(int id, int quan, String user) {

        String query = "update   Cart set quantity=quantity +? where ProductID=" + id + " and [user] =?";
        try {

            ps = conn.prepareStatement(query);
            ps.setInt(1, quan);
            ps.setString(2, user);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    

}
