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
public class BookingDetail {
    private int bookingId;
    private Seat seat;

    public BookingDetail() {
    }

    public BookingDetail(int bookingId, Seat seat) {
        this.bookingId = bookingId;
        this.seat = seat;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
}
