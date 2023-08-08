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
public class Film {
    private int filmId;
    private String filmName;

    public Film() {
    }

    public Film(int filmId, String filmName) {
        this.filmId = filmId;
        this.filmName = filmName;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getFilmName() {
        return filmName;
    }

    public void setFilmName(String filmName) {
        this.filmName = filmName;
    }

    @Override
    public String toString() {
        return "film{" + "filmId=" + filmId + ", filmName=" + filmName + '}';
    }    
    
}
