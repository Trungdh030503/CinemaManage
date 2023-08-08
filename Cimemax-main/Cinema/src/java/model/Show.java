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
    private Room room;
    private Film film;
    private Slot slot;
    private Date showDate;
    private int status;

    public Show() {
    }

    public Show(int showId, Room room, Film film, Slot slot, Date showDate, int status) {
        this.showId = showId;
        this.room = room;
        this.film = film;
        this.slot = slot;
        this.showDate = showDate;
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getShowId() {
        return showId;
    }

    public void setShowId(int showId) {
        this.showId = showId;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public Date getShowDate() {
        return showDate;
    }

    public void setShowDate(Date showDate) {
        this.showDate = showDate;
    }

    @Override
    public String toString() {
        return "Show{" + "showId=" + showId + ", room=" + room + ", film=" + film + ", slot=" + slot + ", showDate=" + showDate + ", status=" + status + '}';
    }

}
