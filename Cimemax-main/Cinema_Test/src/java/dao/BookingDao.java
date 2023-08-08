/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import ViewMode.HistoryBooking;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Seat;

/**
 *
 * @author int.thong.nk
 */
public class BookingDao extends DBcontext {

//    public List<HistoryBooking> getHistoryBooking(int id) {
//        List<HistoryBooking> hs = new ArrayList<>();
//        try {
//            String sql = "select * from booking where user = ?";
//            PreparedStatement stm = connection.prepareCall(sql);
//            stm.setInt(1, id);
//            ResultSet rs = stm.executeQuery();
//            while (rs.next()) {
//                HistoryBooking h = new HistoryBooking();
//                h.setBookingId(rs.getInt("bookingId"));
//                h.setShow(rs.getInt("show"));
//                h.setUser(rs.getInt("user"));
//                List<Seat> seat = new ArrayList<>();
//                String sqlSeat = "select b.seatId, s.seatName from bookingdetail b left join seat s on b.seatId = s.seatId where bookingId = ?";
//                PreparedStatement stm2 = connection.prepareCall(sqlSeat);
//                stm2.setInt(1, h.getBookingId());
//                ResultSet rs2 = stm2.executeQuery();
//                while (rs2.next()) {
//                    Seat s = new Seat();
//                    s.setSeatId(rs2.getInt("seatId"));
//                    s.setSeatName(rs2.getString("seatName"));
//                    seat.add(s);
//                }
//                h.setSeat(seat);
//                hs.add(h);
//            }
//            return hs;
//        } catch (Exception e) {
//            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, e);
//            return null;
//        }
//    }
    public List<HistoryBooking> getHistoryBooking(int id) {
        List<HistoryBooking> hs = new ArrayList<>();
        BookingDao dao = new BookingDao();
        try {
            String sql = "select * from booking where user = ?";
            PreparedStatement stm = connection.prepareCall(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HistoryBooking h = new HistoryBooking();
                h.setBookingId(rs.getInt("bookingId"));
                h.setShow(rs.getInt("show"));
                h.setUser(rs.getInt("user"));
                List<Seat> seat = dao.getSeatByBooking(h.getBookingId());
                h.setSeat(seat);
                hs.add(h);
            }
            return hs;
        } catch (Exception e) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public List<Seat> getSeatByBooking(int id) {
        List<Seat> seat = new ArrayList<>();
        try {
            String sqlSeat = "select b.seatId, s.seatName from bookingdetail b left join seat s on b.seatId = s.seatId where bookingId = ?";
            PreparedStatement stm2 = connection.prepareCall(sqlSeat);
            stm2.setInt(1, id);
            ResultSet rs2 = stm2.executeQuery();
            while (rs2.next()) {
                Seat s = new Seat();
                s.setSeatId(rs2.getInt("seatId"));
                s.setSeatName(rs2.getString("seatName"));
                seat.add(s);
            }
            return seat;
        } catch (SQLException ex) {
            Logger.getLogger(BookingDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public static void main(String[] args) {
        BookingDao dao = new BookingDao();
        List<HistoryBooking> hs = dao.getHistoryBooking(1);
        for (HistoryBooking h : hs) {
            System.out.println(h.getBookingId());
            System.out.println(h.getShow());
            System.out.println(h.getUser());
            for (Seat s : h.getSeat()) {
                System.out.print(s.getSeatName()  + ", ");
            }
            System.out.println("");
        }
        System.out.println(hs.size());
    }

}
