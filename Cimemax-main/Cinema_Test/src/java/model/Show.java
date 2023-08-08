/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Date;

/**
 *
 * @author int.thong.nk
 */
public class Show {
    private int showId;
    private Date showDate;
    private Slot slot;
    private Film film;
    private Room room;

    public Show() {
    }

    public Show(int showId, Date showDate, Slot slot, Film film, Room room) {
        this.showId = showId;
        this.showDate = showDate;
        this.slot = slot;
        this.film = film;
        this.room = room;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public String toString() {
        return "Show{" + "showId=" + showId + ", showDate=" + showDate + ", slot=" + slot + ", film=" + film + ", room=" + room + '}';
    }
    
    
}
