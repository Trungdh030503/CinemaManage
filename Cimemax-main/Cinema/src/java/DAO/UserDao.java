/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.User;

/**
 *
 * @author Admin
 */
public class UserDao extends DBContext {

    MD5 md5 = new MD5();

    public User findUser(String email) {
        try {
            String sql = "select * from [User] where [Email] = ? ";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("user_id"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("Email"));
                s.setPassword(rs.getString("Password"));
                s.setGender(rs.getBoolean("Gender"));
                s.setPhone(rs.getString("Phone"));
                s.setAddress(rs.getString("Address"));
                s.setRole(rs.getInt("role"));
                s.setDOB(rs.getDate("DOB"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(String email, String password) {
        try {
            String sql = "select * from [User] where [Email] = ? and [Password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, email);
            stm.setString(2, md5.getMd5(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("user_id"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("Email"));
                s.setPassword(rs.getString("Password"));
                s.setGender(rs.getBoolean("Gender"));
                s.setPhone(rs.getString("Phone"));
                s.setAddress(rs.getString("Address"));
                s.setRole(rs.getInt("role"));
                s.setDOB(rs.getDate("DOB"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int userId, String password) {
        try {
            String sql = "select * from [User] where [user_id] = ? and [Password] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            stm.setString(2, md5.getMd5(password));
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("user_id"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("Email"));
                s.setPassword(rs.getString("Password"));
                s.setGender(rs.getBoolean("Gender"));
                s.setPhone(rs.getString("Phone"));
                s.setAddress(rs.getString("Address"));
                s.setRole(rs.getInt("role"));
                s.setDOB(rs.getDate("DOB"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public User findUser(int userId) {
        try {
            String sql = "select * from [User] where [user_id] = ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, userId);
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                User s = new User();
                s.setId(rs.getInt("user_id"));
                s.setFullname(rs.getString("fullName"));
                s.setEmail(rs.getString("Email"));
                s.setPassword(rs.getString("Password"));
                s.setGender(rs.getBoolean("Gender"));
                s.setPhone(rs.getString("Phone"));
                s.setAddress(rs.getString("Address"));
                s.setRole(rs.getInt("role"));
                s.setDOB(rs.getDate("DOB"));
                return s;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public int register(String fullname, String email, String password,
            boolean gender, String phone, String address, int role,Date DOB) {
        String pass = md5.getMd5(password);
        try {
            String sql = "INSERT INTO [dbo].[user]\n"
                    + "           ([fullname]\n"
                    + "           ,[email]\n"
                    + "           ,[password]\n"
                    + "           ,[gender]\n"
                    + "           ,[phone]\n"
                    + "           ,[address]\n"
                    + "           ,[role]\n"         
                    + "           ,[DOB])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setString(1, fullname);
            stm.setString(2, email);
            stm.setString(3, pass);
            stm.setBoolean(4, gender);
            stm.setString(5, phone);
            stm.setString(6, address);
            stm.setInt(7, 1);
            stm.setDate(8, DOB);
            stm.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int updateUser(String password, int uid) {
        String pass = md5.getMd5(password);
        try {
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [password] = ?\n"
                    + "WHERE [User].User_id =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, pass);
            stm.setInt(2, uid);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int updateUser(String name, boolean gender, String phone, String address, Date dob, int userId) {
        try {
            String sql = "UPDATE [dbo].[User]\n"
                    + "   SET [fullname] = ?\n"
                    + "      ,[gender] = ?\n"
                    + "      ,[phone] = ?\n"
                    + "      ,[address] = ?\n"
                    + "      ,[DOB] = ?\n"
                    + "WHERE [User].User_id =?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setString(1, name);
            stm.setBoolean(2, gender);
            stm.setString(3, phone);
            stm.setString(4, address);
            stm.setDate(5, dob);
            stm.setInt(6, userId);
            stm.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
        return 1;
    }

    public int totalUser() {
        try {
            String sql = "select count([user_id]) as count from [user] ";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            if(rs.next()){
              int count = rs.getInt("count");
              return count;
            }
            return 0;
        } catch (SQLException ex) {
            Logger.getLogger(UserDao.class.getName()).log(Level.SEVERE, null, ex);
            return 0;
        }
    }

    public static void main(String[] args) {
        UserDao us = new UserDao();
        System.out.println(us.register("123", "thong20@gmail.com", "1", true, "1233333333", "13", 0 , Date.valueOf("2001-01-01")));
    }
}
