/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import com.mysql.cj.xdevapi.PreparableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seat;
import model.Show;

/**
 *
 * @author int.thong.nk
 */
public class SlotDao extends DBcontext {
    
    public List<Show> getAllShow() {
        List<Show> shows = new ArrayList<>();
        try {
            String sql = "select * from `show`";
            PreparedStatement stm = connection.prepareCall(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Show sh = new Show();
                sh.setShowId(rs.getInt("showId"));
                
                shows.add(sh);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SlotDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return shows;
    }
    
    public List<Seat> getSeatIsBooking(int showid) {
        List<Seat> seats = new ArrayList<>();
        try {
            String sql = "select s.seatId, s.seatName from seat s right join booking_detail bd on s.seatId = bd.seatId\n"
                    + "right join booking b on bd.bookingId = b.bookingId \n"
                    + "right join `show` sh on b.showId = sh.showId\n"
                    + "where b.showId = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, showid);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Seat s = new Seat();
                s.setSeatId(rs.getInt("seatId"));
                s.setSeatName(rs.getString("seatName"));
                seats.add(s);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SlotDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        return seats;
    }
    
    public static void main(String[] args) {
        SlotDao db = new SlotDao();
        List<Seat> seat = db.getSeatIsBooking(1);
        for (Seat se: seat) {
            System.out.println(se.getSeatId());
        }
   
    }
}
