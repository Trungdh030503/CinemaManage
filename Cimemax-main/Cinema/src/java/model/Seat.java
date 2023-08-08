/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Time;
import java.time.LocalTime;

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
        return "Seat{" + "seatId=" + seatId + ", seatName=" + seatName + '}';
    }
    
//    public static void main(String[] args) {
//        LocalTime time = LocalTime.of(6, 30);
//        time = time.plusMinutes(120);
//        System.out.println(time.compareTo(LocalTime.of(8, 00)));
//    }
}
