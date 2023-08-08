/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewMode;

import java.sql.Date;
import java.util.List;
import model.BookingDetail;
import model.Seat;

/**
 *
 * @author Admin
 */
public class HistoryBooking {
    private int bookingId;
    private List<Seat> seat;
    private String film;
    private String time;
    private Date date;

    public HistoryBooking() {
    }

    public HistoryBooking(int bookingId, List<Seat> seat, String film, String time, Date date) {
        this.bookingId = bookingId;
        this.seat = seat;
        this.film = film;
        this.time = time;
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getFilm() {
        return film;
    }

    public void setFilm(String film) {
        this.film = film;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "HistoryBooking{" + "bookingId=" + bookingId + ", seat=" + seat + ", film=" + film + ", date=" + date + '}';
    }   
    
}
