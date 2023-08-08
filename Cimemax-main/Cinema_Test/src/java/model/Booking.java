/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author int.thong.nk
 */
public class Booking {
    private int bookingId;
    
    private Show show;

    public Booking() {
    }

    public Booking(int bookingId, Show show) {
        this.bookingId = bookingId;
        this.show = show;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show = show;
    }

    @Override
    public String toString() {
        return "Booking{" + "bookingId=" + bookingId + ", show=" + show + '}';
    }

   
    
    
}
