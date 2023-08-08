/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import model.Seat;

/**
 *
 * @author Admin
 */
public class HistoryBooking {

    private int bookingId;
    private int user;
    private int show;
    private List<Seat> seat;

    public HistoryBooking() {
    }

    public HistoryBooking(int bookingId, int user, int show, List<Seat> seat) {
        this.bookingId = bookingId;
        this.user = user;
        this.show = show;
        this.seat = seat;
    }

    public int getUser() {
        return user;
    }

    public void setUser(int user) {
        this.user = user;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public List<Seat> getSeat() {
        return seat;
    }

    public void setSeat(List<Seat> seat) {
        this.seat = seat;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

}
