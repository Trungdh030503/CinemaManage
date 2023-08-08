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
public class Seat {
    private int seatId;
    private String seatName;

    public Seat() {
    }

    public Seat(int seatId, String seatName) {
        this.seatId = seatId;
        this.seatName = seatName;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }

    public String getSeatName() {
        return seatName;
    }

    public void setSeatName(String seatName) {
        this.seatName = seatName;
    }

    @Override
    public String toString() {
        return "seat{" + "seatId=" + seatId + ", seatName=" + seatName + '}';
    }
    
}
