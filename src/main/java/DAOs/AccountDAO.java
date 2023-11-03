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
import model.Account;

/**
 *
 * @author NGMINHAT
 */
public class AccountDAO {

    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    public AccountDAO() {
        try {
            this.conn = dal.DBContext.connect();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Account> getAllAccount(String user) {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account where [user]=?";
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                list.add(new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8)));
            }
        } catch (Exception e) {
        }
        return list;
    }

    public Account checkAccountExist(String user) {
        String query = "select * from account\n"
                + "where [user] = ?\n";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void singup(String user, String pass) {
        String query = "insert into account\n"
                + "values(?,?,0,0)";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Account login(String user, String pass) {
        String query = "select * from Account\n"
                + "where [user] = ?\n"
                + "and pass = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void addToAcc(Account acc) {
        String query = "insert into Account values(?,?,?,?,?,?,?,?)";
        try {

            ps = conn.prepareStatement(query);
            ps.setString(1, acc.getAvarta());
            ps.setString(2, acc.getUser());
            ps.setString(3, acc.getPass());
            ps.setString(4, acc.getFullName());

            ps.setInt(5, 1);
            ps.setInt(6, 0);
            ps.setString(7, acc.getGender());
            ps.setString(8, acc.getBD());
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Account getAccByUS(String user) {
        String query = "select * from account\n"
                + "where [user] = ?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                return new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Account update(String user, Account acc) {
        int count = 0;
        try {
            PreparedStatement ps = conn.prepareStatement("Update Account set [avarta]=?, [pass]=?, [fullname]=?, [birthday]=?, [gender]=? where [user]=?");
            ps.setString(1, acc.getAvarta());
            ps.setString(2, acc.getPass());
            ps.setString(3, acc.getFullName());
            ps.setString(4, acc.getBD());
            ps.setString(5, acc.getGender());
            ps.setString(6, user);
            count = ps.executeUpdate();
        } catch (SQLException ex) {

        }
        return (count == 0) ? null : acc;
    }

    public void deleteAcc(String user) {
        String query = "delete from Account where [user]=?";
        try {
            ps = conn.prepareStatement(query);
            ps.setString(1, user);
            ps.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<Account> getAllAcc() {
        List<Account> list = new ArrayList<>();
        String query = "select * from Account";
        try {
            ps = conn.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                Account account = new Account(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(7), rs.getString(8));
                list.add(account);
            }
        } catch (Exception e) {
        }
        return list;
    }
}
